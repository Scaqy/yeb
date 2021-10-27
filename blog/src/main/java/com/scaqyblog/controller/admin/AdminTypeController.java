package com.scaqyblog.controller.admin;


import com.scaqyblog.pojo.Type;
import com.scaqyblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Lenovo
 */
@Controller
public class AdminTypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/typeManagement")
    public String list_type(Model model){
        List<Type> types = typeService.listType();
        model.addAttribute("types",types);
        return "/admin/typeManagement";
    }

    @GetMapping("/addType")
    public String toAddType(){
        return "/admin/addType";
    }

    @PostMapping("/addType")
    public String addType(Type type){
        typeService.addType(type);
        return "redirect:/typeManagement";
    }

    @GetMapping("/delType/{typeId}")
    public String delType(@PathVariable("typeId") Integer typeId){
        typeService.deleteType(typeId);
        return "redirect:/typeManagement";
    }

}
