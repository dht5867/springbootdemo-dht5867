package com.example.demo.mapper;

import com.example.demo.domain.Student;
import org.junit.Assert;
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
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void findByName() throws Exception {
        studentMapper.insert(new Student("AAA",20));
        Student u = studentMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
    }
}