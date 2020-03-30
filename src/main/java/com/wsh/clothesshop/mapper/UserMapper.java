package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Update("update user set username=#{username},password=#{password},phone=#{phone} where id=#{id}")
    void updateUser(User user);
}
