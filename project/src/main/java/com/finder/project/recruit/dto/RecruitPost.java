package com.finder.project.recruit.dto;

import java.util.List;

import com.finder.project.company.dto.Company;

import lombok.Data;

@Data
public class RecruitPost {
    // Post DTO
    private int recruitNo;
    private String recruitTitle;
    private String recruitContent;
    private String recruitResponsibilities;
    private String recruitQualifications;
    private String recruitPreferredQualifications;
    private String recruitRegDate;
    private int comNo;

    // Keyword 참조
    private List<String> keyword;
    private List<Keyword> keywordList;
    
    // Company 테이블 참조
    private List<Company> company;
    
}
