package com.yin.service;

import com.yin.domain.Goods;
import com.yin.entity.PageResult;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Classname SellOrderService
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/13 16:17
 * @Version 1.0
 **/
public interface GoodsService {
    PageResult showSellGoods(Integer pageNum, Integer pageSize);

    PageResult showBuyGoods(Integer pageNum, Integer pageSize);

    Integer addSellGoods(Goods goods);

    Integer deleteSellGoods(Integer goodsId);

    Integer confirm(Integer goodsId);

    Integer addImg(String goodsUrl,Integer goodsId);
}