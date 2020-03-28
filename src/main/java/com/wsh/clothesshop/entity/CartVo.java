package com.wsh.clothesshop.entity;

import lombok.Data;

@Data
public class CartVo {
    private Integer id;
    private Integer userId;
    private Integer clothesId;
    private String clothesName;
    private String imgUrl;
    private double newPrice;
    private String color;
    private Integer count;
}
