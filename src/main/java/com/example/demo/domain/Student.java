package com.example.demo.domain;

/**
 * @author 代洪涛
 * @description
 * @create 2018-05-06 下午4:23
 **/
public class Student {
    private Long id;
    private String name;
    private Integer age;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
