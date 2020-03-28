package com.wsh.clothesshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.clothesshop.entity.OrderItem;
import com.wsh.clothesshop.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends ServiceImpl<OrderItemMapper,OrderItem> {
}
