package com.finder.project.user.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Users {
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
    
    private List<UserAuth> authList;
}