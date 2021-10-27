package com.scaqyblog.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/main.html").setViewName("main");
        /**后台*/
        registry.addViewController("/admin").setViewName("admin/adminIndex");
        registry.addViewController("/addBlog").setViewName("/admin/addBlog");
        registry.addViewController("/addType").setViewName("/admin/addType");
        registry.addViewController("/addUser").setViewName("/admin/addUser");
        registry.addViewController("/userManagement").setViewName("/admin/userManagement");
        registry.addViewController("/typeManagement").setViewName("/admin/typeManagement");
        registry.addViewController("/blogManagement").setViewName("/admin/blogManagement");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor())
                .addPathPatterns(
                        "/userManagement","/typeManagement","/blogManagement","/addUser","/addType","/addBlog","/blogUpdate"
                )
                .excludePathPatterns(
                        "/admin","/adminIndex","/admin/login"
                );
    }
}
