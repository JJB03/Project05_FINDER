package com.finder.project.resume.service;

import java.util.List;


import com.finder.project.resume.dto.ResumeDto;

public interface ResumeService {
          // 게시글 목록 + 검색
          public List<ResumeDto> list() throws Exception;

          // 게시글 조회
          public ResumeDto select(int user_no) throws Exception;
      
          // 게시글 등록
          public int create(ResumeDto resumeDto) throws Exception;
      
          // 게시글 수정
          public int update(ResumeDto resumeDto) throws Exception;
      
          // 게시글 삭제
          public int delete(int cv_no) throws Exception;

}
