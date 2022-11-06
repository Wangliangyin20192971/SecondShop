package com.yin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yin.domain.Collection;
import com.yin.domain.Goods;
import com.yin.entity.PageResult;
import com.yin.mapper.GoodsMapper;
import com.yin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname SellOrderServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/13 16:17
 * @Version 1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageResult showSellGoods(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Goods> page= goodsMapper.showSellGoods();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult showBuyGoods(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Goods> page= goodsMapper.showBuyGoods();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Integer addSellGoods(Goods goods)  {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        goods.setGoodsCreateTime(dateFormat.format(date));
        return goodsMapper.addSellGoods(goods);
    }

    @Override
    public Integer deleteSellGoods(Integer goodsId) {
        return goodsMapper.deleteSellGoods(goodsId);
    }

    @Override
    public Integer confirm(Integer goodsId) {
        return goodsMapper.confirm(goodsId);
    }


    @Override
    public Integer addImg(String goodsUrl,Integer goodsId) {
        return goodsMapper.addImg(goodsUrl,goodsId);
    }
}
