package com.wsh.clothesshop.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

//服装位置枚举类
@Getter
public enum Suit {
    UP(1,"上衣"),DOWN(2,"裤子"),ALL(3,"套装");

    Suit(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    @EnumValue
    private final int code;
    private final String desc;
}
