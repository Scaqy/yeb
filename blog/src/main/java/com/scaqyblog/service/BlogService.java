package com.scaqyblog.service;

import com.scaqyblog.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog getAndBlog(Integer id);
    Blog getBlog(Integer id);
    List<Blog> listBlog();
    int addBlog(Blog blog);
    int updateBlog(Blog blog);
    void deleteBlog(Integer id);
    Map<Integer,List<Blog>> archiveBlog();
    int blogCount();
    List<Blog> recommendBlog();
    List<Blog> getBlogByTypeName(String typeName);
    List<Blog> searchBlog(String title, String typeName);
    List<Blog> searchAllBlog(String title);
}
