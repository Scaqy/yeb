package com.scaqyblog.mapper;


import com.scaqyblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> listUser();
    User getUserByUserName(String username);
    User selectPassWordByName(@Param("username")String userName,@Param("password")String passWord);
    int addUser(User user);
    void deleteUser(int id);
}
