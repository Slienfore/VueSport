package com.sport.vuesport.pojo;

import lombok.Data;

@Data
public class QueryInfo {

    private String query;
    private Integer pageStart;
    private Integer pageSize;

}