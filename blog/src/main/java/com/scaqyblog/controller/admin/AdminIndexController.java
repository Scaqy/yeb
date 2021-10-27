package com.scaqyblog.controller.admin;


import com.scaqyblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AdminIndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String loginPage(){
        return "/admin/adminIndex";
    }

    @RequestMapping("/admin/login")
    public String login(@RequestParam("adminName") String adminName,
                        @RequestParam("passWord") String passWord,
                        Model model,
                        HttpSession session){
        if("admin".equals(adminName) && "123456".equals(passWord)){
            session.setAttribute("adminname",adminName);
            return "redirect:/userManagement";
        }else {
            model.addAttribute("msg","请重新输入用户名和密码");
            return "redirect:/admin";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "/admin/adminIndex";
    }

}
