package com.ibm.ma.entity;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    private String id;

    private String username;

    private Date createTime;

    private Date updateTime;

    private String fullname;

    private String mail;

    private String password;

    private Boolean status;

    private Boolean isDelete;
}