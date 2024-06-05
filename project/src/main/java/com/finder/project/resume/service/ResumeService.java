package com.finder.project.resume.service;

import java.util.List;


import com.finder.project.resume.dto.Resume;

public interface ResumeService {
          // 이력서 목록 + 검색
          public List<Resume> resumelist(int userNo) throws Exception;

          // 이력서 조회
          public Resume select(int cvNo) throws Exception;
      
          // 이력서 등록
          public int create(int cvNo) throws Exception;
      
          // 이력서 수정
          public int update(Resume resume) throws Exception;
      
          // 이력서 삭제
          public int delete(int employmentHistoryNo) throws Exception;

        // 회원번호로 이력서 조회 ⭕
         public Resume selectCV(int user_no) throws Exception;   

         public int maxPk() throws Exception;
}
