package com.finder.project.recruit.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.finder.project.company.dto.Company;
import com.finder.project.main.dto.Option;

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
    private Company company;

    // 썸네일 이미지 파일
    MultipartFile thumbnail;
    
    // 파일
    List<MultipartFile> file;
    
    // 파일 번호
    private int fileNo;

    private Option option;
    
}
