package com.wsh.clothesshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName(value = "cart")
public class Cart extends Model<Cart> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer clothesId;
    private Integer count;

    //屏蔽clothes属性和数据库表中的字段的映射
    @TableField(exist = false)
    private Clothes clothes;
}
