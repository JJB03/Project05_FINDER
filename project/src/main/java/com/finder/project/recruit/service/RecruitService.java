package com.finder.project.recruit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;
import com.finder.project.user.dto.Users;

/**
 * RecruitService
 */

public interface RecruitService {

    // 채용공고 목록
    public List<RecruitPost> recruitList() throws Exception;

    // 채용공고 등록
    public int recruitPost(RecruitPost recruitPost) throws Exception;
    
    // 채용공고 상세조회
    public RecruitPost recruitRead(int recruitNo) throws Exception;
    // public List<Keyword> recruitReadKeyword(int recruitNo) throws Exception;
    // 채용공고 상세조회 끝
    
    // 등록 한 채용공고 목록
    public List<RecruitPost> postsRecruitList(int comNo) throws Exception;

    // 등록 한 채용공고 삭제
    public int deleteRecruitList(int recruitNo) throws Exception;

    // 등록 한 채용공고 조회
    public RecruitPost postsRecruitRead(int recruitNo) throws Exception;

    // 등록 한 채용공고 키워드 삭제 후 수정
    public int updateRecruitRead(RecruitPost recruitPost) throws Exception;

   
}