package com.wsh.clothesshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wsh.clothesshop.entity.User;
import com.wsh.clothesshop.mapper.UserMapper;
import com.wsh.clothesshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

//用户控制器
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    //来到登陆页面
    @GetMapping("/login")
    public String toUserLogin(){
        return "login";
    }

    //验证用户是否存在
    @ResponseBody
    @RequestMapping("/checkUserName")
    public String checkUserName(String username){
        return userService.checkUser(username);
    }

    //用户注册
    @ResponseBody
    @RequestMapping("/register")
    public String register(User user){
        userService.save(user);
        return "success";

    }

    //用户登录

    @PostMapping("/inlogin")
    public String userLogin(User loginUser, Map<String,Object> map, HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",loginUser.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if (user==null){
            map.put("message","用户不存在");
            return "login";
        }else if (loginUser.getPassword().equals(user.getPassword())){
            session.setAttribute("user",user);
            return "index";
        }
        map.put("message","密码不正确");
        return "login";
    }
    //安全退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }


    //来到用户修改页面
    @GetMapping("/toSetUser/{id}")
    public String toChangeUserPage(@PathVariable("id")Integer id, Model model){
        User user =userMapper.selectById(id);
        model.addAttribute("user",user);
        return "userSet";

    }

    //更新用户信息
    @PutMapping("/toSetUser")
    public String updateUser(User user){
        userMapper.updateUser(user);
        return"redirect:/index";
    }
}
