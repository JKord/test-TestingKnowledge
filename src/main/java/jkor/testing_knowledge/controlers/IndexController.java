package jkor.testing_knowledge.controlers;

import jkor.testing_knowledge.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import jkor.testing_knowledge.entities.*;
import jkor.testing_knowledge.entities.dao.*;
import jkor.testing_knowledge.model.ResponseModel;

@Controller
public class IndexController
{
    @Autowired
    TopicDAO topicDAO;
    
    @Autowired
    QuestionDAO questionDAO;  
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model)
    {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("topics", topicDAO.listTopic());
        
        return mv;
    }

    @RequestMapping(value = "/testing/{id}", method = RequestMethod.GET)
    public ModelAndView testing(ModelMap model, @PathVariable long id)
    {
        Topic topic = topicDAO.getById(id);
        if(topic == null)
            throw new ResourceNotFoundException();

        ModelAndView mv = new ModelAndView("testing");
        mv.addObject("topic", topic);

        return mv;
    }

    @RequestMapping(value = "/testing/{topicId}/question/{questionId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseModel getTesting(ModelMap model, @PathVariable long topicId, @PathVariable long questionId)
    {
        Question question = questionDAO.getById(questionId);
        if(question == null)
            return ResponseModel.create(0);

        return ResponseModel.create(1, "question", question);
    }

    @RequestMapping(value = "/testing/{topicId}/question/{questionId}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody ResponseModel testing(ModelMap model, @PathVariable long topicId, @PathVariable long questionId)
    {
        Question question = questionDAO.getById(questionId);

        return ResponseModel.create(1, "question", question);
    }


    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(ModelMap model)
    {
        List<Question> t = questionDAO.listQuestion();

        return "result";
    }
}