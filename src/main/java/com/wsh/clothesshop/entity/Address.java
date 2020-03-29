package com.wsh.clothesshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

//地址实体类
@Data
@TableName(value = "address")
public class Address extends Model<Address> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String detailAddress;
    private String tel;


}
