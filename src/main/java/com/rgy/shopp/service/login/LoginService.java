package com.rgy.shopp.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * \* User: rgy
 * \* Date: 2019/8/19 13:42
 * \
 */
@Service
public class LoginService {
    @Autowired
    private JdbcTemplate secondJdbcTemplate;

    public Boolean queryTipsForCore(HttpServletRequest request) {
        List<Map<String, Object>> user = this.secondJdbcTemplate.queryForList(
                "SELECT * FROM portal_user T WHERE T.\"USERNAME\"=? and t.\"PASSWORD\"=?",
                request.getParameter("username"),request.getParameter("password"));
        if(user.size()>0){
            request.getSession().setAttribute("user",request.getParameter("username"));//用户名存入该用户的session 中
            System.out.println("进入首页！");
            return true;
        }else{
            return false;
        }

    }
}