package com.cristina.controller;

import com.cristina.model.entity.User;
import com.cristina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description jdbctemplate测试
 * @author: Yu.Guo
 * @create: 2020-07-25 16:12
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @Description("根据用户id查询用户")
    @GetMapping("/api/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUserBy(id);
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from users");
        return maps.get(0);
    }

    @GetMapping("/add")
    public int add(User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

}
