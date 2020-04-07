package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.Address;
import com.wsh.clothesshop.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class manageAddressController {

    @Autowired
    private AddressMapper addressMapper;
    //查看地址
    @GetMapping("/toAddressPage")
    public String toAddressPage(Model model){
        List<Address> addressList=addressMapper.selectList(null);
        model.addAttribute("addressList",addressList);
        return "address/list";
    }
}
