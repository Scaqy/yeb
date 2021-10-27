package com.scaqyblog.service;


import com.scaqyblog.pojo.User;

import java.util.List;

public interface UserService {
    List<User> listUser();
    User getUserByUserName(String username);
    User selectPassWordByName(String userName,String passWord);
    int addUser(User user);
    void deleteUser(int id);
}
