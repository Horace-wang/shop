package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.Clothes;
import com.wsh.clothesshop.mapper.ClothesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManageClothesController {
    @Autowired
    ClothesMapper clothesMapper;
    //来到服装管理页面
    @GetMapping("/manageClothes")
    public String toManageClothesPage(Model model){
        List<Clothes> clothes =clothesMapper.selectList(null);
        model.addAttribute("clothesList",clothes);
        return "cloth/list";
    }

    //来到服装添加页面
    @GetMapping("/manageAddClothes")
    public String toAddClothesPage(){
        return"cloth/add";
    }

    //添加服装
    @PostMapping("/manageAddClothes")
    public String addClothes(Clothes clothes){
        clothesMapper.insert(clothes);
        return "redirect:/manageClothes";
    }

    //来到修改页面，查出当前服装并在页面回显
    @GetMapping("/manageAddClothes/{id}")
    public String findClothesPage(@PathVariable("id")Integer id, Model model){
        Clothes clothes =clothesMapper.selectById(id);
        model.addAttribute("clothes",clothes);
        return "cloth/add";

    }
    //更新商品信息
    @PutMapping("/manageAddClothes")
    public String updateClothes(Clothes clothes){
        clothesMapper.updateClothes(clothes);
        return"redirect:/manageClothes";
    }

    //删除商品信息
    @DeleteMapping("/manageAddClothes/{id}")
    public String deleteClothes(@PathVariable("id")Integer id){
        clothesMapper.deleteById(id);
        return "redirect:/manageClothes";
    }

}
