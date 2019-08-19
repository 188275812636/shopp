package com.rgy.shopp.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * \* User: rgy
 * \* Date: 2019/8/19 10:21
 * \
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/home.do"})
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        Object object = request.getSession().getAttribute("users");
        if(object!=null){
            return modelAndView;
        }
        return new ModelAndView("redirect:/login.c");
    }
}