package com.finder.project.resume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.finder.project.resume.dto.Resume;

@Mapper
 public interface ResumeMapper {
          //게시글 목록 + 나중에 페이징 (아니면 스크롤로 감)
          public List<Resume> resumelist(int userNo) throws Exception;

          // 게시글 검색
          // dto 추가 예정
      
          // 이력서 가져올때 리스트 여러개 가져오려면 List<Resume> 리턴받는 메서드 필요
          //   이려서 하나 조회
          public Resume select(int user_no) throws Exception;
      
          // 게시글 등록
          public int create(Resume Resume) throws Exception;
      
          // 게시글 수정
          public int update(Resume Resume) throws Exception;
      
          // 게시글 삭제
          public int delete(int cv_no) throws Exception;
      

 }
