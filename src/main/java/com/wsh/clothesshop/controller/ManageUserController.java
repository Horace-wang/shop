package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.User;
import com.wsh.clothesshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManageUserController {

    @Autowired
    UserMapper userMapper;

    //来到用户管理页面
    @GetMapping("/manageUser")
    public String toManageUserPage(Model model){
        List<User> users =userMapper.selectList(null);
        model.addAttribute("userList",users);
        return "user/list";
    }

    //来到用户添加页面
    @GetMapping("/manageAddUser")
    public String toAddUserPage(){
        return"user/add";
    }

    //添加用户
    @PostMapping("/manageAddUser")
    public String addUser(User user){
        userMapper.insert(user);
        return "redirect:/manageUser";
    }

    //来到修改页面，查出当前用户并在页面回显
    @GetMapping("/manageAddUser/{id}")
    public String findUserPage(@PathVariable("id")Integer id,Model model){
        User user =userMapper.selectById(id);
        model.addAttribute("user",user);
        return "user/add";

    }
    //更新用户信息
    @PutMapping("/manageAddUser")
    public String updateUser(User user){
        userMapper.updateUser(user);
        return"redirect:/manageUser";
    }

    //删除用户信息
    @DeleteMapping("/manageAddUser/{id}")
    public String deleteUser(@PathVariable("id")Integer id){
        userMapper.deleteById(id);
        return "redirect:/manageUser";
    }

}
