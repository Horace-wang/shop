package com.wsh.clothesshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.clothesshop.entity.CartVo;
import com.wsh.clothesshop.entity.Order;
import com.wsh.clothesshop.entity.OrderItem;
import com.wsh.clothesshop.entity.User;
import com.wsh.clothesshop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private CartService cartService;
    //购买
    public String buy(List<CartVo> cartVos,Integer addrId, HttpSession session){
        //1、生成订单表记录
        Order order = new Order();
        order.setAddressId(addrId);
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getId());
        order.setCreateDate(new Date());
        order.setOrderNum(UUID.randomUUID().toString());
        order.setOrderStatus("1");
        orderMapper.insert(order);
        //2、生成订单明细表记录
        List<OrderItem> orderItems =new ArrayList<>();
        List<Integer> cartIds = new ArrayList<>();
        for (CartVo cart: cartVos){
            OrderItem orderItem =new OrderItem();
            orderItem.setClothesId(cart.getClothesId());
            orderItem.setCount(cart.getCount());
            orderItem.setOrderId(order.getId());
            orderItems.add(orderItem);
            cartIds.add(cart.getId());
        }
        orderItemService.saveBatch(orderItems);
        //3、删除购物车表中记录
        cartService.removeByIds(cartIds);


        return "success";
    }

    //查询用户订单
    public List<Order> findUserOrder(Integer userId){
        return orderMapper.findOrderAndOrderDetailListByUser(userId);
    }
}
