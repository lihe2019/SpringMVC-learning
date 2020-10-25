package com.lihe.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    // return true 执行下一个拦截器，也就是放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().contains("goLogin")){
            return true;
        }
        if (request.getRequestURI().contains("login")){
            return true;
        }
        HttpSession session = request.getSession();

        // 第一次登录，也是没哟session的


        // 放行：判断什么情况下登录了
        if (session.getAttribute("userLoginInfo") != null){
            return true;
        }


        // 判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
