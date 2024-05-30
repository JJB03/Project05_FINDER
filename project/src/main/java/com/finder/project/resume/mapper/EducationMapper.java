package com.finder.project.resume.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.finder.project.resume.dto.Education;


@Mapper
public interface EducationMapper {
    //이력서 
    public List<Education> educationList(int cvNo) throws Exception;
    //이력서 조회
    public Education select(int cvNo) throws Exception;
    //이력서 등록
    public int create(Education education) throws Exception;
    //이력서 수정
    public int update(Education education) throws Exception;
    //이력서 삭제
    public int delete(int cv_no) throws Exception;
    
}
