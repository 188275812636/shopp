package com.rgy.shopp.controller.login;

import com.rgy.shopp.service.login.LoginService;
import com.rgy.shopp.service.login.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * \* User: rgy
 * \* Date: 2019/8/19 10:20
 * \
 */
@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = {"/register.do"})
    public ModelAndView register(HttpServletRequest request) {
        return new ModelAndView("login/register");
    }
    @RequestMapping(value = {"/to_register.do"})
    public ModelAndView to_register(HttpServletRequest request) {

        registerService.addUser(request);
        return new ModelAndView("login/login");
    }

}