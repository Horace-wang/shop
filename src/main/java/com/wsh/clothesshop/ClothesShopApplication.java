package com.wsh.clothesshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wsh.clothesshop.mapper")
public class ClothesShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothesShopApplication.class, args);
    }

}
