package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 代洪涛
 * @description
 * @create 2018-05-06 下午3:02
 **/
public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);


    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

}
