package com.finder.project.resume.dto;


import java.sql.Timestamp;
import java.util.List;


import lombok.Data;

// 이력서 정보
@Data
public class Resume {
    private int cvNo;
    private int userNo;
    private String cvTitle;
    private String coverLetter;
    private Timestamp cvRegDate;
    private Timestamp cvUpdDate;

    private List<Education> educationList; // Ensure this is lowercased
    private List<EmploymentHistory> employmentHistoryList; // Ensure this is lowercased
}

