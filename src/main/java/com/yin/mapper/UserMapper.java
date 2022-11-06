package com.yin.mapper;
import com.github.pagehelper.Page;
import com.yin.domain.Goods;
import com.yin.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname BookMapper
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/14 13:53
 * @Version 1.0
 **/
@Repository
public interface UserMapper {
    @Select("select * from sc_user where user_name=#{userName} " +
            "AND user_password=#{userPassword}")
    @Results(id="userMap",value={
            //id 字段默认为 false，表示不是主键
            // column 表示数据库表字段，property 表示实体类属性名。
            @Result(id = true, column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_password", property = "userPassword"),
            @Result(column = "user_sex", property = "userSex"),
            @Result(column = "user_building", property = "userBuilding"),
            @Result(column = "user_room", property = "userRoom")
    })
    User login(User user);

    Integer addUser(User user);

    Integer editUser(User user);

    @Select("select * from sc_user")
    @ResultMap("userMap")
    Page<User> selectNewUsers();

    @Select("select * from sc_user where user_name=#{userName}")
    Integer searchUser(String userName);
}
