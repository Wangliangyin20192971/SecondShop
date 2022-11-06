package com.yin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yin.domain.Collection;
import com.yin.domain.Goods;
import com.yin.entity.PageResult;
import com.yin.mapper.ShowMapper;
import com.yin.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ShowServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/18 12:26
 * @Version 1.0
 **/
@Service
public class ShowServiceImpl implements ShowService{

    @Autowired
    private ShowMapper showMapper;

    @Override
    public List<Goods> showSpecGoods() {
        return showMapper.showSpecGoods();
    }

    @Override
    public List<Goods> showBookGoods() {
        return showMapper.showBookGoods();
    }

    @Override
    public List<Goods> showElecGoods() {
        return showMapper.showElecGoods();
    }

    @Override
    public List<Goods> showRideGoods() {
        return showMapper.showRideGoods();
    }

    @Override
    public List<Goods> showDailGoods() {
        return showMapper.showDailGoods();
    }

    @Override
    public List<Goods> showBagsGoods() {
        return showMapper.showBagsGoods();
    }

    @Override
    public Goods detail(Integer goodsId) {
        return showMapper.detail(goodsId);
    }

    @Override
    public Integer collGoods(Collection collection) {
        return showMapper.collGoods(collection);
    }

    @Override
    public Integer buyGoods(Integer goodsId,Integer buyId) {
        return showMapper.buyGoods(goodsId,buyId);
    }
}
