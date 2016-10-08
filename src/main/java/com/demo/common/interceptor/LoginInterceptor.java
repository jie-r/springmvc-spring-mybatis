package com.demo.common.interceptor;

import com.demo.entities.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by jie_r on 2016/9/22.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String LOGIN = "/Demo/view/login.jsp";
    private static final String[] EXCLUDE = {"/Demo/user/client/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        if (!Arrays.asList(EXCLUDE).contains(uri)) {
            User user = (User) session.getAttribute("currentUser");
            if (user == null) {
                response.sendRedirect(LOGIN);
                flag = false;
            }
        }
        return flag;
    }
}
