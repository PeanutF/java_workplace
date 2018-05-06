package com.ticketsystem.dao;

import com.ticketsystem.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM user WHERE user_name = #{username}")
    @Results({
            @Result(property = "username", column = "user_name"),
            @Result(property = "password", column = "user_password")
    })
    User getByName(String username);

    @Select("SELECT * FROM user WHERE user_name = #{username} AND user_password = #{password}")
    @Results({
            @Result(property = "username", column = "user_name"),
            @Result(property = "password", column = "user_password")
    })
    User getByUser( User user);


}
