package com.finder.project.company.dto;

import lombok.Data;

@Data
public class CompanyDetail {
    
    private int comInfoNo;
    private String comRepresent;
    private String comCategory;
    private String comUrl;
    private int comBirth;
    private ComSize comSize;
    private int comEmpCount;
    private int comSales;
    private String comContent;
    private String comAddress;
    private String comVision;
    private String comWelfare;
    private int comAvgSalary;
    private int comNo;
}


enum ComSize {
    대기업,
    중견기업,
    중소기업
}