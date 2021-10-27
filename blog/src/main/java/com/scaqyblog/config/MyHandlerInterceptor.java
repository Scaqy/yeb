package com.scaqyblog.config;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object adminname = request.getSession().getAttribute("adminname");
        if (adminname == null){
            request.setAttribute("msg","没有权限,请先登陆");
            request.getRequestDispatcher("/admin").forward(request,response);
            return false;
        }else {
            //登录，放行
            return true;
        }
    }
}