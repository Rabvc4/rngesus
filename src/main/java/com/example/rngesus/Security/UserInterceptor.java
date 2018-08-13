package com.example.rngesus.Security;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();
        if(cookies == null) {
            request.setAttribute("message", "You need to login to continue");
            response.sendRedirect(request.getContextPath() + "/user/login");

            return false;
        }

        return true;
    }
}