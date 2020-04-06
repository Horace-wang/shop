package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.Order;
import com.wsh.clothesshop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ManageOrderController {
    @Autowired
    private OrderMapper orderMapper;
    //查看订单
    @GetMapping("/manageOrders")
    public String toOrderPage(Model model){
        List<Order> orders =orderMapper.selectList(null);
        model.addAttribute("orders",orders);
        return "order/list";
    }
}
