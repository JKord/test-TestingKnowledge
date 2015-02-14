package jkor.testing_knowledge.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;

@Controller
public class ExceptionHandlingController
{
//    @ExceptionHandler(ConnectException.class; GenericJDBCException.class CannotCreateTransactionException.class)
//    public ModelAndView handleException(ConnectException ex, HttpServletRequest request)
//    {
//        ModelAndView mv = new ModelAndView("result");
//
//        return mv;
//    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView result(HttpServletRequest request)
    {

        ModelAndView mv = new ModelAndView("result");


        return mv;
    }
}