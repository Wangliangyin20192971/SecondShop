package com.yin.service;
import com.yin.domain.Goods;
import com.yin.domain.User;
import com.yin.entity.PageResult;

import java.util.List;

/**
 * @Classname BookService
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/14 13:59
 * @Version 1.0
 **/
public interface UserService {
    User login(User user);
    Integer addUser(User user);
    PageResult selectNewUsers(Integer pageNum,Integer pageSize);
    Integer editUser(User user);
    Integer searchUser(String userName);
}
