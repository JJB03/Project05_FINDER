package com.finder.project.resume.service;

import java.util.List;

import com.finder.project.resume.dto.EmploymentHistory;


public interface EmploymentHistoryService {
    public List<EmploymentHistory> employmentHistoryList(int userNo) throws Exception;

    public EmploymentHistory select(int userNo) throws Exception;

    public int create (EmploymentHistory employmentHistory) throws Exception;

    public int update (EmploymentHistory employmentHistory) throws Exception;

    public int delete (int cvNo) throws Exception;
}
