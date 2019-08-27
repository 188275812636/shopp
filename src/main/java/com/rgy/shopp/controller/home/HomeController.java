package com.rgy.shopp.controller.home;

import com.rgy.shopp.service.home.HomeService;
import com.rgy.shopp.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    HomeService homeService;

    /**
     *@描述 跳转首页
     *@user rgy
     *@date 2019/8/27
     */
    @RequestMapping(value = {"/home.do"})
    public ModelAndView goHome(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        Object object = request.getSession().getAttribute("user");
        if(object!=null){
            JsonResponse jsonResponse = homeService.queryGnmk(request);
            modelAndView.getModelMap().addAttribute("gnmk", jsonResponse.getRepData().get("gnmk"));
            modelAndView.getModelMap().addAttribute("gncd", jsonResponse.getRepData().get("gncd"));
            return modelAndView;
        }
        return new ModelAndView("redirect:/login.do");
    }
}