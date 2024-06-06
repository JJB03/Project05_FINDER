package com.finder.project.main.dto;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private int userNo;
    private String userName;
    private String userId;
    private String userPw;
    private String userBeforePw;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private Date userRegDate;
    private Date userUpdDate;
    private String userGender;
    private int enabled;
}
