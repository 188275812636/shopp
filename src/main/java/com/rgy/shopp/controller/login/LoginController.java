package com.rgy.shopp.controller.login;

import com.rgy.shopp.service.login.LoginService;
import com.rgy.shopp.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /**
     *@描述 简单的登录拦截
     *@user rgy
     *@date 2019/8/27
     */
    @RequestMapping(value = {"/", "/login.do"})
    public ModelAndView login(HttpServletRequest request) {
        Object object = request.getSession().getAttribute("user");
        if(object!=null){
            Map map = new HashMap();
            map.put("user",object);
            return new ModelAndView("redirect:/home.do",map);
        }
        return new ModelAndView("login/login");
    }

    /**
     *@描述 登录
     *@user rgy
     *@date 2019/8/27
     */
    @ResponseBody
    @RequestMapping(value = {"/loginIn.do"})
    public JsonResponse loginIn(HttpServletRequest request){
        JsonResponse jsonResponse = new JsonResponse();
        Map<String, Object> map = new HashMap<>();
        Boolean flag = loginService.queryUser(request);
        map.put("flag",flag);
        jsonResponse.getRepData().put("data",map);
        return jsonResponse;
    }

    /**
     *@描述 登出
     *@user rgy
     *@date 2019/8/27
     */
    @RequestMapping(value = {"/logOut.do"})
    public ModelAndView logOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return new ModelAndView("redirect:/home.do");
    }

}