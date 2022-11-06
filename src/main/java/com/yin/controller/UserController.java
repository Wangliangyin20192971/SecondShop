package com.yin.controller;
import com.yin.domain.Goods;
import com.yin.domain.User;
import com.yin.entity.PageResult;
import com.yin.entity.Result;
import com.yin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Classname BookController
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/14 13:52
 * @Version 1.0
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    User u=new User();
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        try {
            //从数据库中查询的账号信息
            u=userService.login(user);
            if(u != null){
                request.getSession().setAttribute("USER_SESSION",u);
                return "redirect:/main";
            }
            request.setAttribute("msg","用户名或密码错误");
            return "forward:/admin/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg","系统错误");
            return "forward:/admin/login.jsp";
        }
    }

    //注册
    @RequestMapping("/register")
    public String register(){
        return "forward:/admin/register.jsp";
    }

    //新增用户
    @ResponseBody
    @RequestMapping("/addUser")
    public void addUser(User user, HttpServletResponse response,HttpServletRequest request){
        /*String userName=user.getUserName();
        Integer i=userService.searchUser(userName);
        if(i == 1){
            try {
                request.setAttribute("msg","用户名已存在");
                response.sendRedirect("admin/register.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        Integer i = userService.searchUser(user.getUserName());
        System.out.println(i);
        if (i == null) {
            try {
                Integer count = userService.addUser(user);
                if (count != 1) {
                    System.out.println("失败");
                    response.sendRedirect("admin/register.jsp");
                }
                System.out.println("成功");
                response.sendRedirect("admin/login.jsp");
            } catch(Exception e){
                e.printStackTrace();
            }
        }else{
            request.setAttribute("msg","用户名已存在");
            try {
                response.sendRedirect("admin/register.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //注销
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        try {
            HttpSession session=request.getSession();
            session.invalidate();
            return "forward:/admin/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg","系统错误");
            return "forward:/admin/login.jsp";
        }
    }

    //个人中心
    @RequestMapping("/toMessage")
    public String toMessage(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            session.invalidate();
            return "forward:/admin/message.jsp";
        }catch (Exception e){
            request.setAttribute("msg","系统错误");
            return "forward:/admin/main.jsp";
        }
    }

    //返回首页
    @RequestMapping("/toMain")
    public String toMain(){
        try {
            return "forward:/main";
        }catch (Exception e){
            e.printStackTrace();
            return "forward:/admin/message.jsp";
        }
    }

    //个人信息
    @RequestMapping("/selectNewUsers")
    public ModelAndView selectNewUsers(HttpServletRequest request){
        request.getSession().setAttribute("USER_SESSION",u);
        PageResult pageResult=userService.selectNewUsers(1,10);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("per_information");
        modelAndView.addObject("pageResult",pageResult);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/editUser")
    public Result<User> editUser(User user,HttpServletRequest request){
        try{
            request.getSession().setAttribute("USER_SESSION",user);
            u=user;
            Integer count = userService.editUser(user);
            if(count != 1){
                return new Result(false,"修改用户信息失败AAA");
            }
            return new Result(true,"修改用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改用户信息失败BBB");
        }
    }

}
