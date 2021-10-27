package com.scaqyblog.service;


import com.scaqyblog.mapper.BlogMapper;
import com.scaqyblog.pojo.Blog;
import com.scaqyblog.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Blog getBlog(Integer id) {
        return blogMapper.getBlog(id);
    }

    @Override
    public Blog getAndBlog(Integer id) {
        Blog blog = blogMapper.getBlog(id);
        Blog b = new Blog();
        BeanUtils.copyProperties(blog,b);
        String content = b.getContent();
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return b;
    }



    @Override
    public List<Blog> recommendBlog() {
        return blogMapper.recommendBlog();
    }

    @Override
    public List<Blog> getBlogByTypeName(String typeName) {
        return blogMapper.getBlogByTypeName(typeName);
    }

    @Override
    public Map<Integer, List<Blog>> archiveBlog() {
        List<Integer> years = blogMapper.findGroupYear();
        Map<Integer, List<Blog>> map = new HashMap<>();
        for (Integer year :years){
            map.put(year,blogMapper.findByYear(year));
        }
        return map;
    }

    @Override
    public int blogCount() {
        return blogMapper.listBlog().size();
    }

//    @Override
//    public int blogCountByTitle() {
//        return blogMapper.searchAllBlog().size();
//    }
    @Override
    public int addBlog(Blog blog) {
        return blogMapper.addBlog(blog);
    }
    @Override
    public List<Blog> searchBlog(String title, String typeName) {
        return blogMapper.searchBlog(title, typeName);
    }

    @Override
    public List<Blog> listBlog() {
        return blogMapper.listBlog();
    }

    @Override
    public List<Blog> searchAllBlog(String title) {
        return blogMapper.searchAllBlog(title);
    }



    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogMapper.deleteBlog(id);
    }
}
