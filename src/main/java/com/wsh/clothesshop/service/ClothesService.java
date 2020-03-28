package com.wsh.clothesshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.clothesshop.entity.Clothes;
import com.wsh.clothesshop.mapper.ClothesMapper;
import org.springframework.stereotype.Service;

//服装业务层
@Service
public class ClothesService extends ServiceImpl<ClothesMapper, Clothes> {
}
