package com.yin.controller;

import com.yin.domain.User;
import com.yin.entity.PageResult;
import com.yin.entity.Result;
import com.yin.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname CollectionController
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/17 19:19
 * @Version 1.0
 **/
@Controller
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @RequestMapping("/showCollection")
    public ModelAndView showCollection(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        PageResult pageResult = collectionService.showCollection(1, 10);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("coll_information");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("USER", user);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/deleteCollection")
    public Result deleteCollection(Integer collId) {
        try {
            Integer count = collectionService.deleteCollection(collId);
            if (count != 1) {
                return new Result(false, "删除失败");
            }
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /*@ResponseBody
    @RequestMapping("/addImg")
    public Result addImg(Integer collId) {
        try {
            Integer count = collectionService.addImg(collId);
            if (count != 1) {
                return new Result(false, "添加失败");
            }
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }*/
}
