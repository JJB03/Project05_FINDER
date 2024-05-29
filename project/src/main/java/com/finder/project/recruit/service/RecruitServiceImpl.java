package com.finder.project.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;
import com.finder.project.recruit.mapper.RecruitMapper;

import groovy.util.logging.Slf4j;

@Slf4j
@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    RecruitMapper recruitMapper;
    
    // 채용공고 List
    @Override
    public List<RecruitPost> recruitList() throws Exception {
        List<RecruitPost> recruitList = recruitMapper.recruitList();
        
        return recruitList;
    } 

    // 채용공고 등록 & keyword 등록
    @Override
    public int recruitPost(RecruitPost recruitPost) throws Exception {
        
        int result = recruitMapper.recruitPost(recruitPost);
        int recruitNo = recruitMapper.max();

        if( recruitNo == 0 ) return 0;
        recruitPost.setRecruitNo(recruitNo);

        for (String keyword : recruitPost.getKeyword()) {
            Keyword k = new Keyword();
            k.setRecruitKeyword(keyword);
            k.setRecruitNo(recruitNo);
            recruitMapper.recruitKeyword(k);     
        }
        return result;
    }

    // 채용공고 상세조회
    @Override
    public RecruitPost recruitRead(int recruitNo) throws Exception {
        RecruitPost recruitPost = recruitMapper.recruitRead(recruitNo);
        return recruitPost;
    }

    // @Override
    // public List<Keyword> recruitReadKeyword(int recruitNo) throws Exception {
    //     List<Keyword> keywords = recruitMapper.recruitReadKeyword(recruitNo);
    //     return keywords;
    // }
    // 채용공고 상세조회 끝


    
}
