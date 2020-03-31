package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.SuperUser;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperUserMapper extends BaseMapper<SuperUser> {
    @Update("update superuser set superuser=#{superuser},password=#{password} where id=#{id}")
    void updateSuperUser(SuperUser superUser);
}
