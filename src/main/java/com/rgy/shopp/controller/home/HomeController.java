package com.rgy.shopp.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
        Object object = request.getSession().getAttribute("user");
        if(object!=null){
            Map map = new HashMap();
            map.put("user",object);
            return modelAndView;
        }
        return new ModelAndView("redirect:/login.do");
    }
}