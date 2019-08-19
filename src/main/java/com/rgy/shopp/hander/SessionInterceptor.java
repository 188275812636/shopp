package com.rgy.shopp.hander;

/**
 * \* User: rgy
 * \* Date: 2019/8/19 15:41
 * \
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对某些接口进行放行
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        //首页路径以及登录放行
        if ("/login".equals(arg0.getRequestURI())) {
            return true;
        }
        //重定向
        Object object = arg0.getSession().getAttribute("user");
        if (null == object) {
            arg1.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
