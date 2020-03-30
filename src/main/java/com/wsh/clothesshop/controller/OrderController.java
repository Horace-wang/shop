package com.wsh.clothesshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wsh.clothesshop.entity.Address;
import com.wsh.clothesshop.entity.CartVo;
import com.wsh.clothesshop.entity.Order;
import com.wsh.clothesshop.entity.User;
import com.wsh.clothesshop.service.AddressService;
import com.wsh.clothesshop.service.CartService;
import com.wsh.clothesshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

//订单控制器
@Controller
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;
    //确认订单
    @RequestMapping("/orderConfirm")
    public String confirm(String ids, HttpSession session, Model model){
        List<CartVo> cartVos = cartService.findCartByIds(ids);
        //获取当前用户的收货地址
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        User user = (User) session.getAttribute("user");
        addressQueryWrapper.eq("user_id",user.getId());
        List<Address> addressList =addressService.list(addressQueryWrapper);

        //将购买的商品信息添加到session中
        session.setAttribute("cartVos",cartVos);

        model.addAttribute("list",cartVos);
        model.addAttribute("addressList",addressList);
        return "confirmOrder";
    }


    //提交订单
    @RequestMapping("/commitOrder")
    public String commitOrder(Integer addrId,HttpSession session){
        List<CartVo> cartVos= (List<CartVo>) session.getAttribute("cartVos");
        String flag=orderService.buy(cartVos,addrId,session);
        if(flag.equals("success")){
            //跳转至订单列表页
            return "redirect:/orderList";

        }
        return "redirect:/index";
    }

    //显示用户订单列表
    @RequestMapping("/orderList")
    public String list(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        List<Order> orders =orderService.findUserOrder(user.getId());
        model.addAttribute("orders",orders);
        return "orderList";
    }
}
