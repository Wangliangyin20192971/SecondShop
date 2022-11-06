package com.yin.mapper;


import com.yin.domain.Collection;
import com.yin.domain.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname ShowMapper
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/18 12:25
 * @Version 1.0
 **/
@Repository
public interface ShowMapper {

    @Select("select * from sc_goods where goods_state=0")
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
    List<Goods> showSpecGoods();

    @Select("select * from sc_goods where goods_type=1 and goods_state=0")
    @ResultMap("goodsMap")
    List<Goods> showBookGoods();

    @Select("select * from sc_goods where goods_type=2 and goods_state=0")
    @ResultMap("goodsMap")
    List<Goods> showElecGoods();

    @Select("select * from sc_goods where goods_type=3 and goods_state=0")
    @ResultMap("goodsMap")
    List<Goods> showRideGoods();

    @Select("select * from sc_goods where goods_type=4 and goods_state=0")
    @ResultMap("goodsMap")
    List<Goods> showDailGoods();

    @Select("select * from sc_goods where goods_type=5 and goods_state=0")
    @ResultMap("goodsMap")
    List<Goods> showBagsGoods();

    @Select("select * from sc_goods where goods_id = #{goodsId}")
    @ResultMap("goodsMap")
    Goods detail(Integer goodsId);

    @Insert("insert into sc_collection(user_id,goods_id,goods_name, " +
            "goods_message,goods_url,goods_price,goods_type) " +
            "values (#{userId},#{goodsId},#{goodsName}, " +
            "#{goodsMessage},#{goodsUrl},#{goodsPrice},#{goodsType})")
    Integer collGoods(Collection collection);

    @Update("update sc_goods set goods_state = '1' , buy_id = #{buyId} where goods_id = #{goodsId}")
    Integer buyGoods(@Param("goodsId") Integer goodsId, @Param("buyId") Integer buyId);

}
