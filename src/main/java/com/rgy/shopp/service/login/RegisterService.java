package com.rgy.shopp.service.login;

import com.rgy.shopp.entity.UserEntity;
import com.rgy.shopp.entity.UserRepository;
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

    public void addUser(HttpServletRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UuidUtil.getUUID());
        userEntity.setUsername(request.getParameter("username"));
        userEntity.setPassword(request.getParameter("password"));
        userEntity.setUsertype("1");
        userEntity.setTruename(request.getParameter("truename"));
        userRepository.save(userEntity);
        System.out.println("注册成功！");
    }
}