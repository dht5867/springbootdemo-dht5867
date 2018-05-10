package com.example.demo.mapper;

import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 代洪涛
 * @description
 * @create 2018-05-06 下午4:11
 **/

@Mapper
//@Component("studentMapper")
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE NAME = #{name}")
    @Results(id = "studentResult",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age")
    })
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO student(NAME, AGE) VALUES(#{name}, #{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(Student student);

    @Update("UPDATE student SET name = #{name}, age = #{age} WHERE id = #{id}")
    void update(Student student);

    @Delete("DELETE FROM student WHERE ID = #{id}")
    void delete(Integer id);

    @ResultMap("studentResult")
    @Select("SELECT * FROM student")
    List<Student> findAll();
}
