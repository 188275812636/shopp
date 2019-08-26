package com.rgy.shopp.service.home;

import com.rgy.shopp.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * \* User: rgy
 * \* Date: 2019/8/19 15:38
 * \
 */
@Service
public class HomeService {
    @Autowired
    private JdbcTemplate secondJdbcTemplate;
    public JsonResponse queryGnmk(HttpServletRequest request) {
        JsonResponse jsonResponse = new JsonResponse();
        List<Map<String, Object>> gnmk = this.secondJdbcTemplate.queryForList(
                "SELECT * FROM gnmk T WHERE T.yxbz='Y'");
        List<Map<String, Object>> gncd = this.secondJdbcTemplate.queryForList(
                "SELECT * FROM gncd T WHERE T.yxbz='Y'");
        jsonResponse.getRepData().put("gnmk",gnmk);
        jsonResponse.getRepData().put("gncd",gncd);
        return jsonResponse;
    }
}