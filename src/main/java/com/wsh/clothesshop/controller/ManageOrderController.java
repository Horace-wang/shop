package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.Order;
import com.wsh.clothesshop.entity.OrderItem;
import com.wsh.clothesshop.mapper.OrderItemMapper;
import com.wsh.clothesshop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class ManageOrderController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    //查看订单
    @GetMapping("/manageOrders")
    public String toOrderPage(Model model){
        List<Order> orders =orderMapper.selectList(null);
        model.addAttribute("orders",orders);
        return "order/list";
    }
    //查看订单详情
    @GetMapping("/manageOrderItem")
    public String toOrderItemPage(Model model){
        List<OrderItem> orderItems =orderItemMapper.selectList(null);
        model.addAttribute("orderItems",orderItems);
        return "order/itemList";
    }

    //删除订单
    @DeleteMapping("/manageOrders/{id}")
    public String toDeleteOrder(@PathVariable("id")Integer id){
        orderMapper.deleteById(id);
        return "redirect:/manageOrders";
    }

    //订单详情页面回显
    @GetMapping("/manageUpdateItem/{id}")
    public String toChangeOrdersItem(@PathVariable("id")Integer id,Model model){
        OrderItem orderItem = orderItemMapper.selectById(id);
        model.addAttribute("orderItem",orderItem);
        return "order/itemAdd";
    }

    //订单详情更改
    @PutMapping("/manageUpdateItem")
    public String updateOrdersItem(OrderItem orderItem){
        orderItemMapper.updateOrderItem(orderItem);
        return "redirect:/manageOrderItem";
    }
}
