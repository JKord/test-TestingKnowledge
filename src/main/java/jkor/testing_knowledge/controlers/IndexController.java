package jkor.testing_knowledge.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model)
    {

        return "index";
    }

    @RequestMapping(value = "/testing/{id}", method = RequestMethod.GET)
    public String testing(ModelMap model, @PathVariable int id)
    {

        return "testing";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(ModelMap model)
    {
        List<Question> t = questionDAO.listQuestion();

        return "result";
    }
}