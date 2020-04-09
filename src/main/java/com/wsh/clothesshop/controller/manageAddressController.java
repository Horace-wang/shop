package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.Address;
import com.wsh.clothesshop.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    //来到修改地址页面,并在页面回显
    @GetMapping("/changeAddress/{id}")
    public String toChangeAddressPage(@PathVariable("id")Integer id,Model model){
        Address address = addressMapper.selectById(id);
        model.addAttribute("address",address);
        return "address/add";
    }

    //地址的修改
    @PutMapping("/changeAddress")
    public String updateAddressPage(Address address){
        addressMapper.updateAddress(address);
        return "redirect:/toAddressPage";
    }

    //地址的删除
    @DeleteMapping("/changeAddress/{id}")
    public String deleteAddress(@PathVariable("id")Integer id){
        addressMapper.deleteById(id);
        return "redirect:/toAddressPage";
    }

    //来到地址增加页面
    @GetMapping("/changeAddress")
    public String toAddAddressPage(){
        return "address/add";
    }

    //添加地址
    @PostMapping("changeAddress")
    public String toAddAddress(Address address){
        addressMapper.insert(address);
        return "redirect:/toAddressPage";
    }
}
