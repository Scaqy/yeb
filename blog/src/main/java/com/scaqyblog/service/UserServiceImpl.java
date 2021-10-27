package com.scaqyblog.service;


import com.scaqyblog.mapper.UserMapper;
import com.scaqyblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }

    @Override
    public User selectPassWordByName(String userName, String passWord) {
        return userMapper.selectPassWordByName(userName,passWord);
    }
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
