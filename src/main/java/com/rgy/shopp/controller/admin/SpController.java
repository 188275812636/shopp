package com.rgy.shopp.controller.admin;

import com.rgy.shopp.service.admin.SpService;
import com.rgy.shopp.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * \* User: rgy
 * \* Date: 2019/8/27 16:37
 * \
 */
@Controller
public class SpController {

    @Autowired
    SpService spService;

    /**
     *@描述 新增商品
     *@user rgy
     *@date 2019/8/27 17:24
     */
    @ResponseBody
    @RequestMapping(value = {"/addSp.do"})
    public JsonResponse addSp(HttpServletRequest request) {
        JsonResponse jsonResponse = spService.addSp(request);
        return jsonResponse;
    }
}