package com.sport.vuesport.mapper;

import com.sport.vuesport.pojo.MainMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    // 获取主菜单
    List<MainMenu> getMainMenus();
}