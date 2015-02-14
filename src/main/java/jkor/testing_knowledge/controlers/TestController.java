package jkor.testing_knowledge.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import jkor.testing_knowledge.exception.ResourceNotFoundException;
import jkor.testing_knowledge.model.ResponseModel;
import jkor.testing_knowledge.entities.*;
import jkor.testing_knowledge.services.*;

@Controller
@RequestMapping("/testing")
public class TestController
{
    @Autowired STopic sTopic;
    @Autowired STesting sTesting;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView testing(HttpServletRequest request, @PathVariable long id)
    {
        Topic topic = sTopic.getById(id);
        if(topic == null)
            throw new ResourceNotFoundException();
        HttpSession session = request.getSession();

        Map<String, Integer> info = (HashMap<String, Integer>) session.getAttribute("infoTesting");
        if(info == null)
            session.setAttribute("infoTesting", sTesting.getStartInfo());
        else
            info.put("questionNumber", info.get("questionNumber") + 1);

        ModelAndView mv = new ModelAndView("testing");
        mv.addObject("topic", topic);
        mv.addObject("infoTesting", info);

        return mv;
    }

    @RequestMapping(value = "/{topicId}/question/{questionNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseModel testing(@PathVariable long topicId, @PathVariable int questionNumber)
    {
        Topic topic = sTopic.getById(topicId);
        if(topic == null)
            throw new ResourceNotFoundException();
        List<Question> questions = topic.getQuestions();

        questionNumber--;
        if(questions.size() < questionNumber || questionNumber < 0)
            return ResponseModel.create(0);
        if(questions.size() == questionNumber)
            return ResponseModel.create(2);

        return ResponseModel.create(1, "question", questions.get(questionNumber));
    }

    @RequestMapping(value = "/{topicId}/question/{questionNumber}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody ResponseModel checkingAnswer(HttpServletRequest request,
                                                      @PathVariable long topicId, @PathVariable int questionNumber,
                                                      @RequestParam("answerId") int answerId)
    {
        Topic topic = sTopic.getById(topicId);
        if(topic == null)
            throw new ResourceNotFoundException();
        List<Question> questions = topic.getQuestions();
        HttpSession session = request.getSession();

        questionNumber--;
        if(questions.size() < questionNumber || questionNumber < 0)
            return ResponseModel.create(0);
        if(questions.size() == questionNumber)
            return ResponseModel.create(2);

        Map<String, Integer> info = (HashMap<String, Integer>) session.getAttribute("infoTesting");
        sTesting.check(questions.get(questionNumber), answerId, questionNumber, info);

        return ResponseModel.create(1, info);
    }   
}
