package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.Clothes;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

//服装接口
@Repository
public interface ClothesMapper extends BaseMapper<Clothes> {

    @Update("update clothes set name=#{name},color=#{color},size=#{size},add_time=#{addTime},number=#{number},new_price=#{newPrice},category=#{category},img_url=#{imgUrl} where id=#{id}")
    void updateClothes(Clothes clothes);
}
