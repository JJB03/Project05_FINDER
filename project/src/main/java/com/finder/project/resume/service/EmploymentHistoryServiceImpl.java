package com.finder.project.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finder.project.resume.dto.EmploymentHistory;
import com.finder.project.resume.mapper.EmploymentHistoryMapper;

@Service
public class EmploymentHistoryServiceImpl implements EmploymentHistoryService {
    @Autowired
    private EmploymentHistoryMapper employmentHistoryMapper;
    
    @Override
    public List<EmploymentHistory> employmentHistoryList(int userNo) throws Exception {
       List<EmploymentHistory> employmentHistoryList = employmentHistoryMapper.employmentHistoryList(userNo);
       return employmentHistoryList; 
    }

    @Override
    public EmploymentHistory select(int userNo) throws Exception {
        EmploymentHistory employmentHistory = employmentHistoryMapper.select(userNo);
        return employmentHistory;
    }

    @Override
    public int create(EmploymentHistory employmentHistory) throws Exception {
        int result = employmentHistoryMapper.create(employmentHistory);
        return result;
    }

    @Override
    public int update(EmploymentHistory employmentHistory) throws Exception {
        int result = employmentHistoryMapper.update(employmentHistory);
        return result;
    }

    @Override
    public int delete(int cvNo) throws Exception {
        int result = employmentHistoryMapper.delete(cvNo);
        return result;
    }
    
}
