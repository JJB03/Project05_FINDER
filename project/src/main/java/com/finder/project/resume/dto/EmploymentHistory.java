package com.finder.project.resume.dto;

import java.util.Date;


import lombok.Data;

@Data
public class EmploymentHistory {
    private int employmentHistoryNo;
    private String organization;
    private Date duration;
    private String duties;
    private int cvNo;
}