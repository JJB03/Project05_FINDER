package com.finder.project.recruit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;

@Mapper
public interface RecruitMapper {

    // 채용공고 목록
    public List<RecruitPost> recruitList() throws Exception;

    // 채용공고 등록
    public int recruitPost(RecruitPost recruitPost) throws Exception;

    // keyword
    public int max() throws Exception;
    // public int recruitKeyword(@Param("recruitNo") int recruitNo, @Param("recruitKeyword") String keyword);
    public int recruitKeyword(Keyword keyword) throws Exception;
    // keyword 끝

    // 채용공고 상세조회
    public RecruitPost recruitRead(int recruitNo) throws Exception;
    
    // public List<Keyword> recruitReadKeyword(int recruitNo) throws Exception;
    // 채용공고 상세조회 끝

}
