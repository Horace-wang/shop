package com.wsh.clothesshop.controller;

import com.wsh.clothesshop.entity.SuperUser;
import com.wsh.clothesshop.mapper.SuperUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManageSuController {
    @Autowired
    private SuperUserMapper superUserMapper;

    //来到管理员列表页
    @GetMapping("/manageSu")
    public String toManageSuPage(Model model){
        List<SuperUser> superUsers =superUserMapper.selectList(null);
        model.addAttribute("suList",superUsers);
        return "su/list";
    }
    //来到服装添加页面
    @GetMapping("/manageAddSu")
    public String toAddSuPage(){
        return"su/add";
    }

    //添加服装
    @PostMapping("/manageAddSu")
    public String addSu(SuperUser superUser){
        superUserMapper.insert(superUser);
        return "redirect:/manageSu";
    }

    //来到修改页面，查出当前管理员并在页面回显
    @GetMapping("/manageAddSu/{id}")
    public String findSuPage(@PathVariable("id")Integer id, Model model){
        SuperUser superUser =superUserMapper.selectById(id);
        model.addAttribute("su",superUser);
        return "su/add";

    }
    //更新管理员信息
    @PutMapping("/manageAddSu")
    public String updateUser(SuperUser superUser){
        superUserMapper.updateSuperUser(superUser);
        return"redirect:/manageSu";
    }

    //删除管理员信息
    @DeleteMapping("/manageAddSu/{id}")
    public String deleteUser(@PathVariable("id")Integer id){
        superUserMapper.deleteById(id);
        return "redirect:/manageSu";
    }
}
