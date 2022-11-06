package com.yin.service;

import com.yin.domain.Collection;
import com.yin.domain.Goods;

import java.util.List;

/**
 * @Classname ShowService
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/18 12:26
 * @Version 1.0
 **/
public interface ShowService {

    List<Goods> showSpecGoods();

    List<Goods> showBookGoods();

    List<Goods> showElecGoods();

    List<Goods> showRideGoods();

    List<Goods> showDailGoods();

    List<Goods> showBagsGoods();

    Goods detail(Integer goodsId);

    Integer collGoods(Collection collection);

    Integer buyGoods(Integer goodsId,Integer buyId);

}
