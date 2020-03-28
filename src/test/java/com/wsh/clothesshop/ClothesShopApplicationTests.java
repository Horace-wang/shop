package com.wsh.clothesshop;

import com.wsh.clothesshop.mapper.CartMapper;
import com.wsh.clothesshop.service.ClothesService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest
class ClothesShopApplicationTests {
    @Autowired
    private ClothesService clothesService;
    @Autowired
    private CartMapper cartMapper;
    @Test
    public void findCartList(){
        cartMapper.findCartListByUserId(1).forEach(System.out::println);
    }
}
