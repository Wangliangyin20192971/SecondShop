package com.yin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yin.domain.Goods;
import com.yin.domain.User;
import com.yin.entity.PageResult;
import com.yin.mapper.UserMapper;
import com.yin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname BookServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/14 13:59
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public Integer addUser(User user) { return userMapper.addUser(user); }

    @Override
    public PageResult selectNewUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<User> page=userMapper.selectNewUsers();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Integer editUser(User user) {
        return userMapper.editUser(user);
    }

    @Override
    public Integer searchUser(String userName) {
        return userMapper.searchUser(userName);
    }

}
