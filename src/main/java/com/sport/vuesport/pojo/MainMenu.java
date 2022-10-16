package com.sport.vuesport.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

// 主分支菜单
@Data
public class MainMenu {
    private Integer id;
    private String title;
    private String path;

    @JsonProperty("sList")
    private List<SubMenu> sList;
}