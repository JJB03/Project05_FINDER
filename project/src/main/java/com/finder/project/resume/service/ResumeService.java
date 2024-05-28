package com.finder.project.resume.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.finder.project.resume.dto.Option;
import com.finder.project.resume.dto.ResumeDto;

public interface ResumeService {
          // 게시글 목록 + 검색
          public List<ResumeDto> list(@Param("option") Option option) throws Exception;

          // 게시글 조회
          public ResumeDto select(int cv_no) throws Exception;
      
          // 게시글 등록
          public int create(ResumeDto resumeDto) throws Exception;
      
          // 게시글 수정
          public int update(ResumeDto resumeDto) throws Exception;
      
          // 게시글 삭제
          public int delete(int cv_no) throws Exception;
      
          // 게시글 데이터 개수 조회
          public int count(@Param("option") Option option) throws Exception;
}
