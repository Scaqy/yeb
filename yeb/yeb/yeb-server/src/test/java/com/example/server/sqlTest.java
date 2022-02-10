package com.example.server;

import com.example.server.controller.AdminController;
import com.example.server.mapper.AdminMapper;
import com.example.server.pojo.Admin;
import com.example.server.utils.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class sqlTest {
    private static AdminMapper adminMapper;

    public static List<Admin> getAdminTest(String keywords){
        return adminMapper.getAllAdmins(1,keywords);
    }

    public static void main(String[] args) {
        System.out.println(getAdminTest("淑"));
    }
}
