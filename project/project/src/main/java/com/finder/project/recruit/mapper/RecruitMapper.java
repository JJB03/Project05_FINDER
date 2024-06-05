package com.finder.project.recruit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finder.project.main.dto.Option;
import com.finder.project.main.dto.Page;
import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;

@Mapper
public interface RecruitMapper {

    // 채용공고 목록
    public List<RecruitPost> recruitList(@Param("page") Page page, @Param("option") Option option) throws Exception;

    // 채용공고 등록
    public int recruitPost(RecruitPost recruitPost) throws Exception;

    public int recruitUpdate(RecruitPost recruitPost) throws Exception;

    // keyword
    public int max() throws Exception;
    // public int recruitKeyword(@Param("recruitNo") int recruitNo, @Param("recruitKeyword") String keyword);
    public int recruitKeyword(Keyword keyword) throws Exception;
    // keyword 끝

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

    // 등록 한 채용공고 수정
    public int updateRecruitRead(RecruitPost recruitPost) throws Exception;

    // 키워드 삭제
    public int deleteKeyword(int recruitNo) throws Exception;
    
    // 키워드 삭제 후 등록 할 때
    public int recruitKeyword(int recruitNo, String recruitKeyword);

    
    public List<RecruitPost> selectRecruitsByNos(List<Integer> recruitNos);
    
    // 연관검색
    public List<String> selectCompanyNameList();

    // 공고 갯수
    public int count(@Param("option") Option option);
}
