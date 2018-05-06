package com.ticketsystem.service;

import com.ticketsystem.dao.UserMapper;
import com.ticketsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService {

    @Autowired
    private UserMapper userMapper;

    public String getToken(User user){
        if(userMapper.getByName(user.getUsername().toString()) != null){
            if(userMapper.getByUser(user) != null)
                //这里要写一个获取token的方法
                return "token";//TODO
            else
                return null;
        }else {
            return null;
        }
    }
}
