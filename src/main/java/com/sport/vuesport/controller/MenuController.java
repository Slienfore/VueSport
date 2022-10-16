package com.sport.vuesport.controller;

import com.sport.vuesport.mapper.MenuMapper;
import com.sport.vuesport.pojo.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MenuController {

    @Autowired
    MenuMapper menuMapper;

    @GetMapping("/menus")
    public Map<String, Object> getAllMenu() {
        boolean flag = false;

        List<MainMenu> menus = menuMapper.getMainMenus();

        if (menus != null) flag = true;

        return Map.of("flag", flag, "menus", menus);
    }

}