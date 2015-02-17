package jkor.testing_knowledge.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jkor.testing_knowledge.services.TopicService;
import jkor.testing_knowledge.model.InfoTestingModel;

@Controller
public class IndexController
{
    @Autowired
    TopicService sTopic;

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
        InfoTestingModel info = (InfoTestingModel) session.getAttribute("infoTesting");
        if(info == null)
            return new ModelAndView("redirect:/");
        session.removeAttribute("infoTesting");

        ModelAndView mv = new ModelAndView("result");
        mv.addObject("info", info);

        return mv;
    }

    @ExceptionHandler (Exception.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody String handleDBConnectException(Exception ex)
    {
        return "Connection database exception";
    }
}