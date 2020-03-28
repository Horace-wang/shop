package com.wsh.clothesshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wsh.clothesshop.entity.Cart;
import com.wsh.clothesshop.entity.CartVo;
import com.wsh.clothesshop.entity.User;
import com.wsh.clothesshop.entity.UserCartVo;
import com.wsh.clothesshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

//购物车控制器
@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    //加入购物车
    @RequestMapping("/addCart")
    @ResponseBody
    public String addCart(Cart cart, HttpSession session){
        User user = (User) session.getAttribute("user");
        cart.setUserId(user.getId());
        //判断是否已经在购物车中存在该记录
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("user_id",user.getId());
        cartQueryWrapper.eq("clothes_id",cart.getClothesId());
        Cart queryCart = cartService.getOne(cartQueryWrapper);
        if (queryCart == null){
            cartService.save(cart);
        }else {
            queryCart.setCount(queryCart.getCount() + cart.getCount());
            cartService.updateById(queryCart);
        }
        return "success";
    }

    //查询当前用户的购物车
    @RequestMapping("/cartList")
    public String cartList(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        List<CartVo> cartVos = cartService.findCartByUser(user.getId());

        //将用户的购物车信息存放到session中
        UserCartVo userCartVo =new UserCartVo();
        userCartVo.setNum(cartVos.size());
        userCartVo.setTotalPrice(cartService.getCartItemTotal(cartVos));
        session.setAttribute("userCartInfo",userCartVo);
        model.addAttribute("cartList",cartVos);

        return "cart";
    }

    //删除购物车
    @ResponseBody
    @RequestMapping("/deleteCart")
    public String delete(String ids){
        return cartService.batchDelete(ids);
    }
}
