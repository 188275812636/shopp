package com.rgy.shopp.controller.home;

import com.rgy.shopp.service.home.HomeService;
import com.rgy.shopp.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


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
        Object user = request.getSession().getAttribute("user");
        Object admin = request.getSession().getAttribute("admin");

        if(user!=null){
            ModelAndView modelAndView = new ModelAndView("home/home");
            modelAndView = setGn(modelAndView,request,"1");
            return modelAndView;
        }
        if(admin!=null){
            ModelAndView modelAndView = new ModelAndView("admin/home");
            modelAndView = setGn(modelAndView,request,"0");
            return modelAndView;
        }
        return new ModelAndView("redirect:/login.do");
    }

    /**
     *@描述 根据模块查询商品分类
     *@user rgy
     *@date 2019/8/28 9:37
     */
    @ResponseBody
    @RequestMapping(value = {"/tognmk.do"})
    public JsonResponse tognmk(HttpServletRequest request) {
        JsonResponse jsonResponse = homeService.queryGncdByMkid(request);
        return jsonResponse;
    }

    public ModelAndView setGn(ModelAndView modelAndView,HttpServletRequest request,String usertype){
        JsonResponse jsonResponse = homeService.queryGnmk(request);
        modelAndView.getModelMap().addAttribute("gnmk", jsonResponse.getRepData().get("gnmk"));
        jsonResponse = homeService.queryGncdByMkid(request);
        modelAndView.getModelMap().addAttribute("gncd", jsonResponse.getRepData().get("gncd"));
        jsonResponse = homeService.querySpBygnid(request);
        modelAndView.getModelMap().addAttribute("sp", jsonResponse.getRepData().get("sp"));

        modelAndView.getModelMap().addAttribute("usertype", usertype);
        return modelAndView;
    }
}