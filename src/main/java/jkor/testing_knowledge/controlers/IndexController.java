package jkor.testing_knowledge.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jkor.testing_knowledge.entities.Topic;
import jkor.testing_knowledge.entities.dao.TopicDAO;

import java.util.List;

@Controller
public class IndexController
{
    @Autowired
    TopicDAO topicDAO;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String printWelcome(ModelMap model)
    {
        List<Topic> t = topicDAO.listTopic();
        model.addAttribute("message", "Wiiii!");
        return "hello";
    }
}