package jkor.testing_knowledge.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Set;

import jkor.testing_knowledge.entities.Question;
import jkor.testing_knowledge.entities.dao.QuestionDAO;

@Controller
public class IndexController
{
    @Autowired
    QuestionDAO questionDAO;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String printWelcome(ModelMap model)
    {
        List<Question> t = questionDAO.listQuestion();
        Set<Integer> s = t.get(0).getCorrectAnswerIds();
        model.addAttribute("message", "Wiiii!");
        return "hello";
    }
}