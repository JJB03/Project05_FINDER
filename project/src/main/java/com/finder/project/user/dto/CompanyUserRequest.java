package com.finder.project.user.dto;

import com.finder.project.company.dto.Company;

import lombok.Data;

@Data
public class CompanyUserRequest {

    private String comName;
    private String userId;
    
}
