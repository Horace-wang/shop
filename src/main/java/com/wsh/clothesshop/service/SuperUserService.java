package com.wsh.clothesshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.clothesshop.entity.SuperUser;
import com.wsh.clothesshop.mapper.SuperUserMapper;
import org.springframework.stereotype.Service;

@Service
public class SuperUserService extends ServiceImpl<SuperUserMapper, SuperUser> {
}
