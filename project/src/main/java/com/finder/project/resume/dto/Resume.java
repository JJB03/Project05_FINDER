package com.finder.project.resume.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.finder.project.main.dto.Option;

import lombok.Data;

// 이력서 정보
@Data
public class Resume {
    private int cvNo;
    private int userNo;
    private String coverLetter;
    private String cvTitle;
    private Date cvRegDate;
    private Date cvUpdDate;
    private List<Education> educationList = new ArrayList<>();
    private List<EmploymentHistory> employmentHistoryList = new ArrayList<>();
    
    //파일
    List<MultipartFile> file;
    private int fileNo;
    private Option option;
}

