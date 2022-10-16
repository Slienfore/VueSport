package com.sport.vuesport.controller;

import com.sport.vuesport.mapper.UserMapper;
import com.sport.vuesport.pojo.QueryInfo;
import com.sport.vuesport.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/allUser")
    public Map<String, Object> getUserList(QueryInfo queryInfo) {
        // 根据名称查询总人数
        int num = userMapper.getUserCounts(queryInfo.getQuery());

        // 当前页数 * 请求数量 => 查询开始数量
        int pageStart = (queryInfo.getPageStart() - 1) * queryInfo.getPageSize();

        List<User> users = userMapper.getAllUser(queryInfo.getQuery(), pageStart, queryInfo.getPageSize());

        return Map.of("num", num, "users", users);
    }

    @PutMapping("/updateUserState")
    public String updateUserState(@RequestParam("id") int id,
                                  @RequestParam("state") boolean state) {

        return userMapper.updateState(id, state) > 0 ? "success" : "error";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        // 权限 还有 状态 留给超级管理员进行审核
        user.setRole("普通用户");
        user.setState(false);

        return userMapper.addUser(user) > 0 ? "success" : "error";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(int id) {
        return userMapper.deleteUser(id) > 0 ? "success" : "error";
    }

    @GetMapping("/getUpdateUser")
    public User getUpdateUser(int id) {
        return userMapper.getUpdateUser(id);
    }

    @PutMapping("/editUser")
    public String editUser(@RequestBody User user) {
        return userMapper.editUser(user) > 0 ? "success" : "error";
    }

}