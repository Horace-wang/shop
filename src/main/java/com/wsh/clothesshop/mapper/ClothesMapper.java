package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.Clothes;
import org.springframework.stereotype.Repository;

//服装接口
@Repository
public interface ClothesMapper extends BaseMapper<Clothes> {
}
