package com.finder.project.recruit.service;

import java.util.List;

import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;

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
}