package com.sport.vuesport.mapper;

import com.sport.vuesport.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // 根据用户 姓名 密码 进行查询用户
    User getUserByMessage(@Param("username") String username, @Param("password") String password);

    // 获取所有用户
    List<User> getAllUser(@Param("username") String username, @Param("pageStart") Integer pageStart, @Param("pageSize") Integer pageSize);

    // 获取用户个数
    int getUserCounts(@Param("username") String username);

    // 更新用户状态
    int updateState(@Param("id") Integer id, @Param("state") Boolean state);

    // 添加用户
    int addUser(User user);

    // 删除用户信息
    int deleteUser(Integer id);

    // 获取修改的用户信息
    User getUpdateUser(int id);

    // 修改用户信息
    int editUser(User user);
}