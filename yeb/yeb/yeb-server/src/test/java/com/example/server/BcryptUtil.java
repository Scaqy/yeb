package com.example.server;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *密码加密工具
 */
public class BcryptUtil {
    public static void main(String[] args) {
        String password = "admin";

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String newPassWord = bCryptPasswordEncoder.encode(password);
        System.out.println(newPassWord);
    }
}
