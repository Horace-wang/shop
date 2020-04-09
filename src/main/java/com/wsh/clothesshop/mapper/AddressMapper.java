package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.Address;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressMapper extends BaseMapper<Address> {
    @Update("update address set user_id=#{userId},detail_address=#{detailAddress},tel=#{tel} where id=#{id}")
    void updateAddress(Address address);
}
