package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ximoyiren on 2018/5/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void findByName() throws Exception {

        final User user = userMapper.findByName("BBB");
        System.out.println(user);
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }
}