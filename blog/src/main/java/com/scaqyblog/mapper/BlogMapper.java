package com.scaqyblog.mapper;


import com.scaqyblog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BlogMapper {

    Blog getAndBlog(Integer id);

    Blog getBlog(Integer id);
    List<Blog> listBlog();
    int addBlog(Blog blog);
    int updateBlog(Blog blog);
    void deleteBlog(Integer id);
    Map<String,List<Blog>> archiveBlog();
    List<Integer> findGroupYear();
    List<Blog> findByYear(Integer year);
    List<Blog> recommendBlog();
    List<Blog> getBlogByTypeName(String typeName);
    List<Blog> searchBlog(String title, String typeName);
    List<Blog> searchAllBlog(String title);
}
