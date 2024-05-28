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

    // 채용공고 Keyword input
    @Override
    public int recruitPost(RecruitPost recruitPost) throws Exception {
        
        int result = recruitMapper.recruitPost(recruitPost);
        int recruitNo = recruitMapper.max();

        if( recruitNo == 0 ) return 0;
        recruitPost.setRecruitNo(recruitNo);

        for (String keyword : recruitPost.getKeyword()) {
            Keyword k = new Keyword();
            k.setKeyword(keyword);
            k.setRecruitNo(recruitNo);
            recruitMapper.recruitKeyword(k);     
        }
        return result;
    }


    
}
