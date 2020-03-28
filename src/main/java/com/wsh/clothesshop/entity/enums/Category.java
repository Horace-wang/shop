package com.wsh.clothesshop.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

//服装类别枚举类
@Getter
public enum Category {
    MAN(1,"男装"),WOMAN(2,"女装");

    Category(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    @EnumValue
    private final int code;
    private final String desc;
}
