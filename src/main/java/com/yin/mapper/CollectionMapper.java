package com.yin.mapper;

import com.github.pagehelper.Page;
import com.yin.domain.Collection;
import com.yin.domain.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Classname CollectionMapper
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/17 19:18
 * @Version 1.0
 **/
@Repository
public interface CollectionMapper {

    @Select("select * from sc_collection")
    @Results(id="collectionMap",value={
            //id 字段默认为 false，表示不是主键
            // column 表示数据库表字段，property 表示实体类属性名。
            @Result(id = true, column = "coll_id", property = "collId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "goods_id", property = "goodsId"),
            @Result(column = "goods_name", property = "goodsName"),
            @Result(column = "goods_url", property = "goodsUrl"),
            @Result(column = "goods_message", property = "goodsMessage"),
            @Result(column = "goods_price", property = "goodsPrice"),
            @Result(column = "goods_type", property = "goodsType")
    })
    Page<Collection> showCollection();
    @Delete("delete from sc_collection where coll_id = #{collId}")
    Integer deleteCollection(Integer collId);


}