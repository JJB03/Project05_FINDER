package com.finder.project.resume.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.finder.project.resume.dto.EmploymentHistory;

import java.util.List;

@Mapper
public interface EmploymentHistoryMapper {
    //경력
    public List<EmploymentHistory> listByCvNo(int cvNo) throws Exception;

    //경력 조회
    public EmploymentHistory select(int employmentHistoryNo) throws Exception;

    //경력 만들기
    public int create (EmploymentHistory employmentHistory) throws Exception;

    //경력 수정
    public int update (EmploymentHistory employmentHistory) throws Exception;

    //경력 삭제
    public int delete (int employmentHistoryNo) throws Exception;

    //경력 번호
    public int maxPk() throws Exception;
}
