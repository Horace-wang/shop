package com.wsh.clothesshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wsh.clothesshop.entity.enums.Category;
import lombok.Data;

import java.util.Date;
//服装实体类
@Data
@TableName(value = "clothes")
public class Clothes extends Model<Clothes> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String color;
    private Date addTime;
    private String size;
    private String imgUrl;
    private Category category;
    private Integer number;
    private double newPrice;
}
