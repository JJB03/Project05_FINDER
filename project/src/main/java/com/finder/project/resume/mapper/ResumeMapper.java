package com.finder.project.resume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.finder.project.resume.dto.ResumeDto;

@Mapper
 public interface ResumeMapper {
          //게시글 목록 + 나중에 페이징 (아니면 스크롤로 감)
          public List<ResumeDto> list() throws Exception;

          // 게시글 검색
          // dto 추가 예정
      
        //   게시글 조회
          public ResumeDto select(int cv_no) throws Exception;
      
          // 게시글 등록
          public int create(ResumeDto resumeDto) throws Exception;
      
          // 게시글 수정
          public int update(ResumeDto resumeDto) throws Exception;
      
          // 게시글 삭제
          public int delete(int cv_no) throws Exception;
      

 }
