package com.sport.vuesport;

import com.sport.vuesport.mapper.MenuMapper;
import com.sport.vuesport.mapper.UserMapper;
import com.sport.vuesport.pojo.MainMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VueSportApplicationTests {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        List<MainMenu> menus = menuMapper.getMainMenus();
        menus.forEach(System.out::println);

    }

    @Test
    void likeSearch() {
        System.out.println("获取到的人数有多少 => " + userMapper.getAllUser("", 1, 2));
    }

    @Test
    void insertUser() {
    }

}
