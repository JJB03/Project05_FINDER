package com.finder.project.resume.service;

import java.util.List;

import com.finder.project.resume.dto.EmploymentHistory;


public interface EmploymentHistoryService {
    //경력사항 목차
    public List<EmploymentHistory> employmentHistoryList(int cvNo) throws Exception;

    //경력사항 조회
    public EmploymentHistory select(int employmentHistoryNo) throws Exception;

    //경력사항 등록
    public int create (EmploymentHistory employmentHistory) throws Exception;

    //경력사항 수정
    public int update (EmploymentHistory employmentHistory) throws Exception;

    //경력사항 삭제
    public int delete (int cvNo) throws Exception;

    //이력서 번호
    public int maxPk() throws Exception;
}
