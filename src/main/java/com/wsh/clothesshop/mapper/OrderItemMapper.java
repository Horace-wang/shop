package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.OrderItem;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    @Update("update order_item set order_id=#{orderId},clothes_id=#{clothesId},count=#{count} where id=#{id}")
    void updateOrderItem(OrderItem orderItem);
}
