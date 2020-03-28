package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.CartVo;
import com.wsh.clothesshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//订单控制器
@Controller
public class OrderController {
    @Autowired
    private CartService cartService;
    //确认订单
    @RequestMapping("/orderConfirm")
    public String confirm(String ids, Model model){
        List<CartVo> cartVos = cartService.findCartByIds(ids);
        model.addAttribute("list",cartVos);
        return "confirmOrder";
    }
}
