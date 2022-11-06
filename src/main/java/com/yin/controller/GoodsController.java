package com.yin.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yin.domain.Goods;
import com.yin.domain.User;
import com.yin.entity.PageResult;
import com.yin.entity.Result;
import com.yin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Classname SellOrderController
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/13 16:18
 * @Version 1.0
 **/
@Controller
public class GoodsController {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/showSellGoods")
    public ModelAndView showSellGoods(HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("USER_SESSION");
        PageResult pageResult= goodsService.showSellGoods(1,20);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("sell_information");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("USER",user);
        return modelAndView;
    }

    @RequestMapping("/showBuyGoods")
    public ModelAndView showBuyGoods(HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("USER_SESSION");
        PageResult pageResult= goodsService.showBuyGoods(1,20);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("buy_information");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("USER",user);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/addSellGoods",method = RequestMethod.POST)
    public Result addSellGoods(Goods goods, HttpServletRequest request,MultipartFile file) {
        User user=(User) request.getSession().getAttribute("USER_SESSION");

        goods.setGoodsState("0");
        goods.setUserId(user.getUserId());
        try {
            System.out.println(goods.getGoodsName());
            Integer count= goodsService.addSellGoods(goods);
            if(count != 1){
                return new Result(false,"新增失败");
            }
            return new Result(true,"新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"新增失败");
        }
    }

    @ResponseBody
    @RequestMapping("/deleteSellGoods")
    public Result deleteSellGoods(Integer goodsId){
        try {
            Integer count= goodsService.deleteSellGoods(goodsId);
            if(count != 1){
                return new Result(false,"删除失败");
            }
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @ResponseBody
    @RequestMapping("/confirm")
    public Result confirm(Integer goodsId){
        try {
            Integer count= goodsService.confirm(goodsId);
            if(count != 1){
                return new Result(false,"确认失败");
            }
            return new Result(true,"确认成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"确认失败");
        }
    }
}
