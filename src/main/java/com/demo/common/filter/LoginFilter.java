package com.demo.common.filter;

import com.demo.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jie_r on 2016/9/22.
 */
public class LoginFilter implements Filter {
    private static final String LOGIN = "/Demo/view/login.jsp";
    private static final String INDEX = "/Demo/view/index.jsp";

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        User user = (User) httpServletRequest.getSession().getAttribute("currentUser");
        String uri = httpServletRequest.getRequestURI();
        if (uri.contains("index.jsp")) {
            if (user == null) {
                httpServletResponse.sendRedirect(LOGIN);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
