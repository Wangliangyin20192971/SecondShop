package com.yin.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yin.domain.Collection;
import com.yin.domain.Goods;
import com.yin.domain.User;
import com.yin.entity.PageResult;
import com.yin.entity.Result;
import com.yin.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname ShowController
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/18 12:27
 * @Version 1.0
 **/
@Controller
public class ShowController {

    @Autowired
    private ShowService showService;

    @RequestMapping("/main")
    public String main(Model model){
        List<Goods> list=showService.showSpecGoods();
        list=list.subList(0,4);
        model.addAttribute("SpecGoods",list);

        List<Goods> list1=showService.showBookGoods();
        model.addAttribute("BookGoods",list1);

        List<Goods> list2=showService.showElecGoods();
        model.addAttribute("ElecGoods",list2);

        List<Goods> list3=showService.showRideGoods();
        model.addAttribute("RideGoods",list3);

        List<Goods> list4=showService.showDailGoods();
        model.addAttribute("DailGoods",list4);

        List<Goods> list5=showService.showBagsGoods();
        model.addAttribute("BagsGoods",list5);

        return "main";
    }


    @RequestMapping("/detail")
    public String detail(@RequestParam("id") Integer goodsId, Model model,HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("USER_SESSION");
        Integer userId=user.getUserId();
        Goods goods=showService.detail(goodsId);
        model.addAttribute("list",goods);
        model.addAttribute("userId",userId);
        return "detail";
    }

    @ResponseBody
    @RequestMapping("/collGoods")
    public Result collGoods(Integer goodsId,HttpServletRequest request){
        try {
            User user=(User) request.getSession().getAttribute("USER_SESSION");
            Integer userId=user.getUserId();
            Goods goods=showService.detail(goodsId);
            Collection collection = new Collection();
            collection.setUserId(userId);
            collection.setGoodsId(goods.getGoodsId());
            collection.setGoodsName(goods.getGoodsName());
            collection.setGoodsUrl(goods.getGoodsUrl());
            collection.setGoodsMessage(goods.getGoodsMessage());
            collection.setGoodsPrice(goods.getGoodsPrice());
            collection.setGoodsType(goods.getGoodsType());
            Integer count= showService.collGoods(collection);
            if(count != 1){
                return new Result(false,"确认失败");
            }
            return new Result(true,"确认成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"确认失败");
        }
    }

    @ResponseBody
    @RequestMapping("/buyGoods")
    public Result buyGoods(Integer goodsId,HttpServletRequest request){
        try {
            User user=(User) request.getSession().getAttribute("USER_SESSION");
            Integer buyId=user.getUserId();
            Integer count= showService.buyGoods(goodsId,buyId);
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
