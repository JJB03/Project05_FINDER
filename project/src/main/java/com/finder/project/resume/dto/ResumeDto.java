package com.finder.project.resume.dto;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

// 이력서 정보
@Data
public class ResumeDto {
    private int cv_no;
    private int user_no;
    private String cover_letter;
    private Timestamp cv_reg_date;
    private Timestamp cv_upd_date;

    //이미지 파일
    MultipartFile thumbnail;
    
    //파일 
    List<MultipartFile> file;

    //파일 번호
    private int file_no;

}

