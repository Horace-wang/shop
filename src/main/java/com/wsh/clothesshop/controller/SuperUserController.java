package com.wsh.clothesshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuperUserController {
    //来到管理员页面
    @GetMapping("/superLogin")
    public String superLogin(){
        return "superlogin";
    }
}
