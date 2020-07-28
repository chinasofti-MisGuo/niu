package com.cristina.service.impl;

import com.cristina.mapper.UserMapper;
import com.cristina.model.entity.User;
import com.cristina.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description 用户相关service实现
 * @author: Yu.Guo
 * @create: 2020-07-25 18:49
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getUserBy(Long id) {
        return userMapper.getUser(id);
    }
}
