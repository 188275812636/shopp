package com.rgy.shopp.controller.login;

import com.rgy.shopp.service.login.LoginService;
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
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"/", "/login.do"})
    public ModelAndView login() {
        return new ModelAndView("login/login");
    }

    @RequestMapping(value = {"/loginIn.do"})
    public ModelAndView loginIn(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        loginService.queryTipsForCore(request);

        return new ModelAndView("redirect:/home.do",map);
    }

}