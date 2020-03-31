package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.Address;
import com.wsh.clothesshop.entity.User;
import com.wsh.clothesshop.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AddressController {
    @Autowired
    private AddressMapper addressMapper;
    @GetMapping("/toAddress")
    public String toAddressPage(){
        return "address";
    }

    @PostMapping("/addAddress")
    public String addAddress(HttpSession session, Address address){
        User user = (User) session.getAttribute("user");
        address.setUserId(user.getId());
        addressMapper.insert(address);
        return "redirect:/index";
    }
}
