package jkor.testing_knowledge.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import jkor.testing_knowledge.services.STopic;

@Controller
public class IndexController extends BaseController
{
    @Autowired
    STopic sTopic;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request)
    {
        request.getSession().removeAttribute("infoTesting");
        
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("topics", sTopic.listTopic());
        
        return mv;
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