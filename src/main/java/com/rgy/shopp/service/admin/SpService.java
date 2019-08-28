package com.rgy.shopp.service.admin;

import com.rgy.shopp.entity.SpEntity;
import com.rgy.shopp.entity.SpRepository;
import com.rgy.shopp.util.JsonResponse;
import com.rgy.shopp.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * \* User: rgy
 * \* Date: 2019/8/27 16:42
 * \
 */
@Service
public class SpService {

    @Autowired
    private SpRepository spRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *@描述 添加商品
     *@user rgy
     *@date 2019/8/28 9:36
     */
    public JsonResponse addSp(HttpServletRequest request) {
        JsonResponse jsonResponse = new JsonResponse();
        SpEntity spEntity = new SpEntity();
        spEntity.setId(UuidUtil.getUUID());
        spEntity.setSpfl(request.getParameter("spfl"));
        spEntity.setSpmc(request.getParameter("spmc"));
        spEntity.setSpmk(request.getParameter("spmk"));
        spEntity.setSpms(request.getParameter("spms"));
        spEntity.setTjsj(new Date());
        spEntity.setYxbz(request.getParameter("yxbz"));
        spRepository.save(spEntity);
        jsonResponse.setMsg("添加成功！");
        return jsonResponse;
    }
}