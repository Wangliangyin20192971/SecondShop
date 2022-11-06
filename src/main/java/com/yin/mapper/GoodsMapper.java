package com.yin.mapper;

import com.github.pagehelper.Page;
import com.yin.domain.Collection;
import com.yin.domain.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname SellOrderMapper
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/13 16:17
 * @Version 1.0
 **/
@Repository
public interface GoodsMapper {

    @Select("select * from sc_goods")
    @Results(id="goodsMap",value={
            //id 字段默认为 false，表示不是主键
            // column 表示数据库表字段，property 表示实体类属性名。
            @Result(id = true, column = "goods_id", property = "goodsId"),
            @Result(column = "goods_name", property = "goodsName"),
            @Result(column = "goods_url", property = "goodsUrl"),
            @Result(column = "goods_message", property = "goodsMessage"),
            @Result(column = "goods_price", property = "goodsPrice"),
            @Result(column = "goods_type", property = "goodsType"),
            @Result(column = "goods_createtime", property = "goodsCreateTime"),
            @Result(column = "goods_state", property = "goodsState"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "buy_id", property = "buyId")
    })
    Page<Goods> showSellGoods();

    @Select("select * from sc_goods")
    @ResultMap("goodsMap")
    Page<Goods> showBuyGoods();

    Integer addSellGoods(Goods goods);

    Integer deleteSellGoods(Integer goodsId);

    @Update("update sc_goods set goods_state = '2' where goods_id = #{goodsId}")
    Integer confirm(Integer goodsId);

    List<Goods> list();

    @Update("update sc_goods set goods_url = #{goodsUrl} where goods_id = #{goodsId}")
    Integer addImg(@Param("goodsUrl") String goodsUrl, @Param("goodsId") Integer goodsId);

}