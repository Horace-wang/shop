package com.wsh.clothesshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.clothesshop.entity.Cart;
import com.wsh.clothesshop.entity.CartVo;
import com.wsh.clothesshop.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
    @Autowired
    private CartMapper cartMapper;

    public List<CartVo> findCartByUser(Integer userId){
        return cartMapper.findCartListByUserId(userId);
    }

    //统计当前用户购物车的总计
    public double getCartItemTotal(List<CartVo> list){
        double sum = 0.0;
        for (CartVo cart: list){
            sum+= cart.getCount() * cart.getNewPrice();
        }
        return sum;
    }

    //批量删除
    public String batchDelete(String ids){
        if(ids!=null){
            String[] idArray=ids.split(",");
            cartMapper.deleteBatchIds(Arrays.asList(idArray));
        }
        return "success";
    }
}
