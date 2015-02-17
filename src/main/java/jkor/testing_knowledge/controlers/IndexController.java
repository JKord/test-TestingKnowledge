package jkor.testing_knowledge.controlers;

import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import jkor.testing_knowledge.services.TopicService;
import jkor.testing_knowledge.model.InfoTestingModel;
import jkor.testing_knowledge.entities.Topic;


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
        List<Topic> topics = sTopic.listTopic();
        mv.addObject("topics", topics);
        
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

    @ExceptionHandler({JDBCConnectionException.class, GenericJDBCException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody String handleDBConnectException(Exception ex)
    {
        return "Connection database exception";
    }
}