package com.yin.interceptor;

import com.yin.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Classname ResourcesInterceptor
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/21 14:44
 * @Version 1.0
 **/
public class ResourcesInterceptor extends HandlerInterceptorAdapter {

    private List<String> ignoreUrl;

    public ResourcesInterceptor(List<String> ignoreUrl) {
        this.ignoreUrl=ignoreUrl;
    }

    /*@Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        //表示登录操作
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        //表示登录操作
        if (request.getRequestURI().contains("register")) {
            return true;
        }
        if (request.getRequestURI().contains("addUser")) {
            return true;
        }
        if (request.getRequestURI().contains("toMessage")) {
            return true;
        }
        if (request.getRequestURI().contains("toMain")) {
            return true;
        }
        if (request.getRequestURI().contains("selectNewUsers")) {
            return true;
        }
        if (request.getRequestURI().contains("findById")) {
            return true;
        }
        if (request.getRequestURI().contains("showGoods")) {
            return true;
        }
        //表示已登录
        if (user != null) {
            return true;
        }
        request.setAttribute("msg","请先登录");
        request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
        return false;
    }*/
}