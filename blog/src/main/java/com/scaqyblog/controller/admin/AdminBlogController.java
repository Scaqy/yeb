package com.scaqyblog.controller.admin;


import com.scaqyblog.pojo.Blog;
import com.scaqyblog.pojo.Type;
import com.scaqyblog.service.BlogService;
import com.scaqyblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class AdminBlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;


    @GetMapping("/blogManagement")
    public String list_management(Model model){
        Collection<Blog> blogs = blogService.listBlog();
        Collection<Type> types = typeService.listType();
        model.addAttribute("blogs",blogs);
        model.addAttribute("types",types);
        return "/admin/blogManagement";
    }

    /**to添加页面*/
    @GetMapping("/addBlog")
    public String toBlogInput(Model model){
        Collection<Type> types = typeService.listType();
        model.addAttribute("types",types);
        return "/admin/addBlog";
    }

    /**添加文章*/
    @PostMapping("/addBlog")
    public String blogInput(Blog blog){
        blogService.addBlog(blog);
        return "redirect:/blogManagement";
    }
    @PostMapping("/search")
    public String search(@RequestParam("title") String title,
                         @RequestParam("typeName") String typeName,
                         Model model){
        if (title == null && typeName == null){
            Collection<Blog> blogs = blogService.listBlog();
            Collection<Type> types = typeService.listType();
            model.addAttribute("blogs",blogs);
            model.addAttribute("types",types);
            return "redirect:/blogManagement";
        }else{
            List<Blog> blogs = blogService.searchBlog(title, typeName);
            List<Type> types = typeService.listType();
            model.addAttribute("blogs",blogs);
            model.addAttribute("types",types);
            return "/admin/blogManagement";
        }

    }
    /**根据id查找文章*/
    @GetMapping("/blogUpdate/{id}")
    public String toUpdateBlog(@PathVariable("id")Integer id,Model model){
        Blog blogById = blogService.getBlog(id);
        model.addAttribute("blog",blogById);
        Collection<Type> types = typeService.listType();
        model.addAttribute("types",types);
        return "/admin/blogUpdate";
    }

    @PostMapping("/blogUpdate")
    public String updateBlog(Blog blog){
        blogService.updateBlog(blog);
        return "redirect:/blogManagement";
    }


    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Integer id){
        blogService.deleteBlog(id);
        return "redirect:/blogManagement";
    }



}
