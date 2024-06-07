package com.finder.project.recruit.service;

import java.util.List;

import com.finder.project.company.dto.Company;
import com.finder.project.company.dto.CompanyDetail;
import com.finder.project.main.dto.Option;
import com.finder.project.main.dto.Page;
import com.finder.project.recruit.dto.RecruitPost;
import com.finder.project.resume.dto.Resume;

/**
 * RecruitService
 */

public interface RecruitService {

    // 채용공고 목록
    public List<RecruitPost> recruitList(Page page, Option option) throws Exception;

    // 채용공고 등록
    public int recruitPost(RecruitPost recruitPost) throws Exception;
    
    public int recruitUpdate(RecruitPost recruitPost) throws Exception;
    
    // 채용공고 상세조회
    public RecruitPost recruitRead(int recruitNo) throws Exception;
    // public List<Keyword> recruitReadKeyword(int recruitNo) throws Exception;
    public CompanyDetail selectCompanyDetailsWithRecruit(int comNo) throws Exception;
    // 채용공고 상세조회 끝
    
    // 등록 한 채용공고 목록
    public List<RecruitPost> postsRecruitList(int comNo) throws Exception;

    // 등록 한 채용공고 삭제
    public int deleteRecruitList(int recruitNo) throws Exception;

    // 등록 한 채용공고 조회
    public RecruitPost postsRecruitRead(int recruitNo) throws Exception;

    // 등록 한 채용공고 키워드 삭제 후 수정
    public int updateRecruitRead(RecruitPost recruitPost) throws Exception;


    public List<RecruitPost> selectRecruitsByNos(List<Integer> recruitNos);

    public List<String> selectCompanyNameList();

    // 비동기 이력서 삭제
    public int deleteCvList(int cvNo) throws Exception;

    // 지원
    public int apply(int recruitNo, int cvNo) throws Exception;

    // 지원한 이력서list
    public List<RecruitPost> applyCvList(int userNo) throws Exception;

    // 제출된 이력서
    public List<Resume> applyCom(int comNo, Page page) throws Exception;

    // userNo 으로 com
    public Company userNoToCom(int userNo) throws Exception;

    // recruit에 comNo으로 com
    public Company recruitToCom(int comNo) throws Exception;

    // recruitNo 으로 recruit
    public RecruitPost recruitNoToRecruit(int recruitNo) throws Exception;
   
}