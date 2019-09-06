package com.rgy.shopp.service.login;

import com.rgy.shopp.util.JsonResponse;
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

    public String queryUser(HttpServletRequest request) {
        String usertype = request.getParameter("usertype");
        List<Map<String, Object>> user = this.secondJdbcTemplate.queryForList(
                "SELECT * FROM portal_user T WHERE T.USERNAME=? and t.PASSWORD=? and T.USERTYPE=?",
                request.getParameter("username"),request.getParameter("password"),usertype);
        if(user.size()>0){
            //管理员
            if("0".equals(usertype)){
                request.getSession().setAttribute("admin",request.getParameter("username"));//用户名存入该用户的session 中

            }
            if("1".equals(usertype)){
                request.getSession().setAttribute("user",request.getParameter("username"));//用户名存入该用户的session 中
            }
            return usertype;
        }else{
            return "-1";
        }

    }
}