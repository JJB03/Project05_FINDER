package com.finder.project.recruit.service;

import java.util.List;

import com.finder.project.recruit.dto.RecruitPost;

/**
 * RecruitService
 */

public interface RecruitService {

    public List<RecruitPost> recruitList() throws Exception;

    public int recruitPost(RecruitPost recruitPost) throws Exception;

}