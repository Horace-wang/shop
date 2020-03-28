package com.wsh.clothesshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wsh.clothesshop.entity.Clothes;
import com.wsh.clothesshop.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//服装控制器
@Controller
public class ClothesController {
    @Autowired
    private ClothesService clothesService;
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //获取服装信息
    @RequestMapping("/getClothesData")
    public String getClothesData(Model model,Integer category){
        QueryWrapper<Clothes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category", category);
        List<Clothes> list = clothesService.list(queryWrapper);
        model.addAttribute("clothesList",list);
        model.addAttribute("category",category);
        return "clothesdata";
    }

    //服装列表页
    @RequestMapping("/clothesList")
    public String clothesList(String category,Model model){
        model.addAttribute("category",category);
        return "clotheslist";
    }

    //获取服装列表数据
    @RequestMapping("/getClothesListData")
    public String getClothesListData(String category,Model model,Integer page){
        QueryWrapper<Clothes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category", category);
        IPage<Clothes> iPage=clothesService.page(new Page<Clothes>(page,4),queryWrapper);
        model.addAttribute("clothesList",iPage.getRecords());
        model.addAttribute("pre",iPage.getCurrent()-1);
        model.addAttribute("next",iPage.getCurrent()+1);
        model.addAttribute("cur",iPage.getCurrent());
        model.addAttribute("pages",iPage.getPages());
        model.addAttribute("category",category);
        return "clotheslistdata";
    }

    //服装详情页
    @RequestMapping("detail")
    public String detail(Integer id,Model model){
        Clothes clothes = clothesService.getById(id);
        model.addAttribute("clothes",clothes);
        return "detail";
    }


}
