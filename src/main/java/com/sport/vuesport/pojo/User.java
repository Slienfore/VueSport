package com.sport.vuesport.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;
    // tinyint 为 boolean 类型数据
    private boolean state;
}