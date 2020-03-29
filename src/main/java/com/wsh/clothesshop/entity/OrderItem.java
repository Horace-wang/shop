package com.wsh.clothesshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName(value = "order_item")
public class OrderItem extends Model<OrderItem> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer orderId;
    private Integer clothesId;
    private Integer count;
}
