package com.cristina.mapper;

import com.cristina.model.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description 用户相关mapper
 * @author: Yu.Guo
 * @create: 2020-07-25 18:50
 **/

public interface UserMapper {

    @Select("select * from users where id=#{id}")
    User getUserById(Long id);

    /*插入输入返回id*/
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into users(username) values(#{userName})")
    int addUser(User user);

    List<User> selectUserById();

    User getUser(Long id);
}
