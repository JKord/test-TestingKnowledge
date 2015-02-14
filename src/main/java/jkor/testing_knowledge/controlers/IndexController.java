package jkor.testing_knowledge.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import jkor.testing_knowledge.entities.*;
import jkor.testing_knowledge.entities.dao.*;
import jkor.testing_knowledge.model.ResponseModel;
import jkor.testing_knowledge.exception.ResourceNotFoundException;
import jkor.testing_knowledge.services.STesting;

@Controller
public class IndexController
{
    @Autowired
    TopicDAO topicDAO;
    
    @Autowired
    QuestionDAO questionDAO;

    @Autowired
    STesting sTesting;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("topics", topicDAO.listTopic());
        
        return mv;
    }

    @RequestMapping(value = "/testing/{id}", method = RequestMethod.GET)
    public ModelAndView testing(HttpServletRequest request, @PathVariable long id)
    {
        Topic topic = topicDAO.getById(id);
        if(topic == null)
            throw new ResourceNotFoundException();

        request.getSession().setAttribute("infoTesting", sTesting.getStarInfo());
        ModelAndView mv = new ModelAndView("testing");
        mv.addObject("topic", topic);

        return mv;
    }

    @RequestMapping(value = "/testing/{topicId}/question/{questionNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseModel testing(@PathVariable long topicId, @PathVariable int questionNumber)
    {
        Topic topic = topicDAO.getById(topicId);       
        if(topic == null)
            throw new ResourceNotFoundException();
        List<Question> questions = topic.getQuestions();
        
        if(questions.size() < questionNumber || questionNumber < 1)
            return ResponseModel.create(0);
        if(questions.size() == questionNumber)
            return ResponseModel.create(2);
        questionNumber--;

        return ResponseModel.create(1, "question", questions.get(questionNumber));
    }

    @RequestMapping(value = "/testing/{topicId}/question/{questionNumber}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody ResponseModel checkingAnswer(HttpServletRequest request,
            @PathVariable long topicId, @PathVariable int questionNumber,
            @RequestParam("answerId") int answerId)
    {
        Topic topic = topicDAO.getById(topicId);
        if(topic == null)
            throw new ResourceNotFoundException();
        List<Question> questions = topic.getQuestions();
        HttpSession session = request.getSession();

        if(questions.size() < questionNumber || questionNumber < 1)
            return ResponseModel.create(0);
        if(questions.size() == questionNumber) {           
            return ResponseModel.create(2);
        }
        questionNumber--;
        Map<String, Integer> info = (HashMap<String, Integer>) session.getAttribute("infoTesting");
        sTesting.checking(questions.get(questionNumber), answerId, info);

        return ResponseModel.create(1, info);
    }


    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView result(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Map<String, Integer> info = (HashMap<String, Integer>) session.getAttribute("infoTesting");
        if(info == null)
            return new ModelAndView("redirect:/");
        session.removeAttribute("infoTesting");
        
        ModelAndView mv = new ModelAndView("result");
        mv.addObject("info", info);

        return mv;
    }
}