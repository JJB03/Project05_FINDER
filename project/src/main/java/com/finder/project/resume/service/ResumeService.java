package com.finder.project.resume.service;

import java.util.List;


import com.finder.project.resume.dto.Resume;

public interface ResumeService {
          // 이력서 목록 + 검색
          public List<Resume> resumelist(int userNo) throws Exception;

          // 이력서 조회
          public Resume select(int user_no) throws Exception;
      
          // 이력서 등록
          public int create(int userNo) throws Exception;
      
          // 이력서 수정
          public int update(Resume Resume) throws Exception;
      
          // 이력서 삭제
          public int delete(int cv_no) throws Exception;

}
