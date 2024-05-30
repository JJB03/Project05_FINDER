package com.finder.project.resume.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.finder.project.resume.dto.EmploymentHistory;

import java.util.List;

@Mapper
public interface EmploymentHistoryMapper {
    public List<EmploymentHistory> employmentHistoryList(int cvNo) throws Exception;

    public EmploymentHistory select(int cvNo) throws Exception;

    public int create (EmploymentHistory employmentHistory) throws Exception;

    public int update (EmploymentHistory employmentHistory) throws Exception;

    public int delete (int cvNo) throws Exception;
}
