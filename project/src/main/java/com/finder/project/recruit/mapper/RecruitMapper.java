package com.finder.project.recruit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;

@Mapper
public interface RecruitMapper {

    // 채용공고 List
    public List<RecruitPost> recruitList() throws Exception;

    // keyword
    public int max() throws Exception;
    
    public int recruitPost(RecruitPost recruitPost) throws Exception;

    // public int recruitKeyword(@Param("recruitNo") int recruitNo, @Param("keyword") String keyword);
    public int recruitKeyword(Keyword keyword) throws Exception;
}
