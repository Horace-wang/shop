package com.wsh.clothesshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wsh.clothesshop.entity.SuperUser;
import com.wsh.clothesshop.mapper.SuperUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class SuperUserController {
    @Autowired
    SuperUserMapper superUserMapper;
    //来到管理员页面
    @GetMapping("/superLogin")
    public String superLogin(){
        return "superlogin";
    }

    //管理员登陆
    @PostMapping("/superInLogin")
    public String superUserLogin(SuperUser loginUser, Map<String,Object> map, HttpSession session){
        QueryWrapper<SuperUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("superuser",loginUser.getSuperuser());
        SuperUser superuser = superUserMapper.selectOne(queryWrapper);
        if (superuser==null){
            map.put("mess","用户不存在");
            return "superlogin";
        }else if (loginUser.getPassword().equals(superuser.getPassword())){
            session.setAttribute("superuser",superuser);
            return "dashboard";
        }
        map.put("mess","密码不正确");
        return "superlogin";
    }

    //后台首页访问
    @GetMapping("/main")
    public String main(){
        return "dashboard";
    }

    //管理员退出登录
    //安全退出
    @RequestMapping("/out")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/superlogin";
    }
}
