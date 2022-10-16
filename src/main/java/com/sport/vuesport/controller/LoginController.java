package com.sport.vuesport.controller;

import com.sport.vuesport.mapper.UserMapper;
import com.sport.vuesport.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        boolean flag = false;

        User res = userMapper.getUserByMessage(user.getUsername(), user.getPassword());

        if (res != null) flag = true;

        return Map.of("flag", flag, "user", res);
    }

}