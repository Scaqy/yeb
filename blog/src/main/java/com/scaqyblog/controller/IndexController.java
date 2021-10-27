package com.scaqyblog.controller;

import com.scaqyblog.pojo.Type;
import com.scaqyblog.pojo.User;
import com.scaqyblog.service.TypeService;
import com.scaqyblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/login")
    public String to_login(){
        return "/index";
    }

    @RequestMapping("/user/login")
    public String login(@RequestParam("username")String userName,
                        @RequestParam("password")String passWord,
                        HttpSession session,
                        Model model){
        User user=userService.selectPassWordByName(userName,passWord);
        Collection<User> users=userService.listUser();
        Collection<Type> types = typeService.listType();
        if(user != null){
            session.setAttribute("username",userName);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","请重新输入用户名和密码");
            return "redirect:/login";
        }
    }

    @GetMapping("/user/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/main";
    }

    @GetMapping("/register")
    public String toregister(){
        return "register";
    }
    @PostMapping("/user/register")
    public String register(User user,
                           @RequestParam("username")String userName,
                           Model model,
                           HttpSession session){
        User userByUserName = userService.getUserByUserName(userName);
        if (userByUserName != null){
            model.addAttribute("msg","用户名已存在，请重新输入");
            return "redirect:/register";
        }else{
            userService.addUser(user);
            session.setAttribute("username",userName);
            return "redirect:/main";
        }
    }
}
