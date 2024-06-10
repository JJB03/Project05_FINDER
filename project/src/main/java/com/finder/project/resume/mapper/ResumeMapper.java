package com.finder.project.resume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finder.project.resume.dto.Resume;

import groovy.transform.Undefined.EXCEPTION;

@Mapper
 public interface ResumeMapper {
    //게시글 목록 + 나중에 페이징 (아니면 스크롤로 감)
          // 이력서 목록 + 검색 ⭕
          public List<Resume> resumelist(int userNo) throws Exception;

          // 이력서 조회 ⭕
          public Resume select(int cvNo) throws Exception;
      
          // 이력서 등록 ⭕
          public int create(int userNo) throws Exception;
      
          // 이력서 수정 ⭕
          public int update(Resume resume) throws Exception;
      
          // 이력서 삭제
          public int delete(int cvNo) throws Exception;


         // 회원번호로 이력서 조회 ⭕
         public Resume selectCV(int user_no) throws Exception;  
         
         public int maxPk() throws Exception;





         // 합불
         public int applyCheck(@Param("cvNo") int cvNo,@Param("check") int check) throws Exception;

 }
