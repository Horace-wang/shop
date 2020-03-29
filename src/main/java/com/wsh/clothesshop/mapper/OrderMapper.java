package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
    //根据用户id查询用户订单以及明细
    List<Order> findOrderAndOrderDetailListByUser(Integer id);

}
