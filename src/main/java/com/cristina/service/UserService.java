package com.cristina.service;

import com.cristina.model.entity.User;

/**
 * @description 用户相关service
 * @author: Yu.Guo
 * @create: 2020-07-25 18:47
 **/
public interface UserService {

    User getUserById(Long id);

    int addUser(User user);

    User getUserBy(Long id);
}
