package com.wsh.clothesshop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.clothesshop.entity.User;
import com.wsh.clothesshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;
    //验证用户是否存在
    public String checkUser(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if (user==null){
            return "101";//用户不存在
        }else {
            return "102";//用户已存在
        }
    }

}
