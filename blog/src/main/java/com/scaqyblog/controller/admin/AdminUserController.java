package com.scaqyblog.controller.admin;


import com.scaqyblog.pojo.User;
import com.scaqyblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminUserController {
    @Autowired
    private UserService userService;


    @GetMapping("/userManagement")
    public String to_userManagement(Model model){
        List<User> users = userService.listUser();
        model.addAttribute("users",users);
        return "/admin/userManagement";
    }

    @GetMapping("/addUser")
    public String to_register(){
        return "/admin/addUser";
    }

    @PostMapping("/addUser")
    public String register(User user){
        userService.addUser(user);
        return "redirect:/userManagement";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userService.deleteUser(id);
        return "redirect:/userManagement";
    }

}
