package com.wsh.clothesshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.clothesshop.entity.Cart;
import com.wsh.clothesshop.entity.CartVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper extends BaseMapper<Cart> {

    //根据用户查询购物车
    @Select("SELECT\n" +
            "\tcsc.*,\n" +
            "\tcsb.NAME AS clothesName,\n" +
            "\tcsb.img_url AS imgUrl,\n" +
            "\tcsb.new_price AS new_price,\n" +
            "\tcsb.color AS color\n" +
            "\t\n" +
            "FROM\n" +
            "\tcart csc\n" +
            "LEFT JOIN clothes csb ON csc.clothes_id = csb.id \n" +
            "WHERE\n" +
            "\tcsc.user_id = #{userId};")
    List<CartVo> findCartListByUserId(Integer userId);

    //根据购物车的ids查询购物车的记录
    @Select({
            "<script>" +
                "SELECT\n" +
                "\tcsc.*,\n" +
                "\tcsb.NAME AS clothesName,\n" +
                "\tcsb.img_url AS imgUrl,\n" +
                "\tcsb.new_price AS new_price,\n" +
                "\tcsb.color AS color\n" +
                "\t\n" +
                "FROM\n" +
                "\tcart csc\n" +
                "LEFT JOIN clothes csb ON csc.clothes_id = csb.id \n" +
                "WHERE csc.id in\n" +
                "<foreach item='item' collection='ids' open='(' separator=',' close=')' >" +
                "#{item}" +
                "</foreach>" +
            "</script>"})
    List<CartVo> findCartListByIds(@Param("ids") List<String> ids);
}
