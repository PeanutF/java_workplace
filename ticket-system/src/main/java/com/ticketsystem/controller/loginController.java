package com.ticketsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ticketsystem.entity.User;
import com.ticketsystem.service.CheckService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@MapperScan("com.ticketsystem.dao")
public class loginController {

    @Autowired
    private CheckService checkService;

    @RequestMapping("/user")
    public String token(@RequestParam Map param){
        Object jsonObject = JSONObject.toJSON(param);
        User user = JSON.parseObject(jsonObject.toString(), new TypeReference<User>(){});
        return checkService.getToken(user);
    }

}
