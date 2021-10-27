package com.scaqyblog.controller;


import com.scaqyblog.pojo.Blog;
import com.scaqyblog.pojo.Type;
import com.scaqyblog.pojo.User;
import com.scaqyblog.service.BlogService;
import com.scaqyblog.service.TypeService;
import com.scaqyblog.service.UserService;
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
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private UserService userService;

    @GetMapping("/blogById/{id}")
    public String toBlog(@PathVariable("id")Integer id, Model model){
        Blog blogById = blogService.getAndBlog(id);
        List<Blog> recommendBlog = blogService.recommendBlog();
        model.addAttribute("blog",blogById);
        model.addAttribute("recommend",recommendBlog);
        return "/blog";
    }

    @GetMapping("/main")
    public String toMain(Model model){
        Collection<Blog> blogs = blogService.listBlog(); //获取所有博客
        Collection<Blog> recommendBlog = blogService.recommendBlog(); //获取推荐博客
        int blogCount = blogService.blogCount();  //博客数量
        Collection<User> users = userService.listUser();  //所有用户
        model.addAttribute("blogs",blogs);
        model.addAttribute("recommendBlog",recommendBlog);
        model.addAttribute("blogCount",blogCount);
        model.addAttribute("users",users);
        return "/main";
    }

//    @GetMapping("/searchMain")
//    public String toSearchMain(Model model){
//        Collection<Blog> blogs = blogService.listBlog();
//        int blogCount = blogService.blogCount();
//        Collection<User> users = userService.listUser();
//        model.addAttribute("blogs",blogs);
//        model.addAttribute("blogCount",blogCount);
//        model.addAttribute("users",users);
//        return "/searchMain";
//    }

    @GetMapping("/type")
    public String toType(Model model){
        Collection<Type> types = typeService.listType();
        Collection<Blog> blogs = blogService.listBlog();
        model.addAttribute("types",types);
        model.addAttribute("blogs",blogs);
        model.addAttribute("blogCount",blogs.size());
        return "/type";
    }

    @GetMapping("/file")
    public String toFile(Model model){
        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.blogCount());
        return "/file";
    }

    @GetMapping("/aboutMe")
    public String to_about_me(){
        return "/aboutMe";
    }




    /**根据typeName查找文章*/
    @GetMapping("/blogBytypeName/{typeName}")
    public String getBlogByTypeName(@PathVariable("typeName")String typeName,Model model){
            List<Blog> blogByTypeName = blogService.getBlogByTypeName(typeName);
            List<Type> types = typeService.listType();
            model.addAttribute("blogs",blogByTypeName);
            model.addAttribute("blogCount",blogByTypeName.size());
            model.addAttribute("types",types);
            return "/searchType";
    }


    //查询文章
    @PostMapping("/blog/Search")
    public String search(@RequestParam("title") String title,
                         Model model){
        if (title == null || title.isEmpty()){
            return "redirect:/main";
        }else{
            List<Blog> blogs = blogService.searchAllBlog(title);
            model.addAttribute("blogs",blogs);
            model.addAttribute("blogCount",blogs.size());
            return "/searchMain";
        }
    }


//    /** 导航栏数据*/
//    @GetMapping("/commons")
//    public String common(Model model){
//        List<User> users = userService.listUser();
//        model.addAttribute("users",users);
//        return "redirect:/main";
//    }


}
