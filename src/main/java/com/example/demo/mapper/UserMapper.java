package com.example.demo.mapper;

import com.example.demo.domain.User;

import java.util.List;

/**
 * @author 代洪涛
 * @description
 * @create 2018-05-06 下午7:47
 **/
public interface UserMapper {

    User findByName(String name);

    int insert(User user);

    void update(User user);

    void delete(String ids);

    List<User> findAll();
}
