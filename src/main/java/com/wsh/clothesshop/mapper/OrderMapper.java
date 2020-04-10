package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.Order;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
    //根据用户id查询用户订单以及明细
    List<Order> findOrderAndOrderDetailListByUser(Integer id);


    //更新订单信息
    @Update("update orders set order_num=#{orderNum},create_date=#{createDate},user_id=#{userId},address_id=#{addressId},order_status=#{orderStatus} where id=#{id}")
    void updateOrders(Order order);
}
