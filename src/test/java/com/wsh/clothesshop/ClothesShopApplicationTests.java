package com.wsh.clothesshop;

import com.wsh.clothesshop.entity.Order;
import com.wsh.clothesshop.mapper.OrderMapper;
import com.wsh.clothesshop.service.SuperUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith( SpringRunner.class )
@SpringBootTest
class ClothesShopApplicationTests {
    @Autowired
    private SuperUserService superUserService;
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void findCartList(){
        //1、生成订单表记录
        Order order = new Order();
        order.setAddressId(1);
        order.setUserId(1);
        order.setCreateDate(new Date());
        order.setOrderNum(UUID.randomUUID().toString());
        order.setOrderStatus("1");
        orderMapper.insert(order);
    }
}
