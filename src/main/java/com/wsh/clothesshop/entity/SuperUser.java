package com.wsh.clothesshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "superuser")
public class SuperUser {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String superuser;
    private String password;
}
