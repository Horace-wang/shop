package com.wsh.clothesshop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wsh.clothesshop.entity.SuperUser;
import com.wsh.clothesshop.service.SuperUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith( SpringRunner.class )
@SpringBootTest
class ClothesShopApplicationTests {
    @Autowired
    private SuperUserService superUserService;
    @Test
    public void findCartList(SuperUser loginUser,String username){
        QueryWrapper<SuperUser> queryWrapper = new QueryWrapper<>();
        List<SuperUser> list = superUserService.list(queryWrapper);
    }
}
