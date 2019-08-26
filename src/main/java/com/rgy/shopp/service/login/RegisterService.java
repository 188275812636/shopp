package com.rgy.shopp.service.login;

import com.rgy.shopp.entity.UserEntity;
import com.rgy.shopp.entity.UserRepository;
import com.rgy.shopp.util.JsonResponse;
import com.rgy.shopp.util.UuidUtil;
import net.sf.cglib.asm.$AnnotationVisitor;
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
public class RegisterService {
    @Autowired
    private JdbcTemplate secondJdbcTemplate;
    @Autowired
    private UserRepository userRepository;

    public JsonResponse addUser(HttpServletRequest request) {
        JsonResponse jsonResponse = new JsonResponse();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String truename = request.getParameter("truename");
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity==null){
            userEntity = new UserEntity();
        }else{
            jsonResponse.setMsg("用户名已存在！");
            jsonResponse.setCode("-1");
            return jsonResponse;
        }
        userEntity.setId(UuidUtil.getUUID());
        userEntity.setUsername(request.getParameter("username"));
        userEntity.setPassword(request.getParameter("password"));
        userEntity.setUsertype("1");
        userEntity.setTruename(request.getParameter("truename"));
        userRepository.save(userEntity);
        System.out.println("注册成功！");
        jsonResponse.setMsg("注册成功！");
        return jsonResponse;
    }
}