package com.scaqyblog.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private Integer id;
    private String username;
    private String title;
    private String content;
    private String conIntroduction;
    private String typeName;
    private Date time;
    private String image;
    private String labelName;

}
