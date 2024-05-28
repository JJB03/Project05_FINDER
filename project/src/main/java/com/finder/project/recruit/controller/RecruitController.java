package com.finder.project.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finder.project.recruit.dto.RecruitPost;
import com.finder.project.recruit.service.RecruitService;

import lombok.extern.slf4j.Slf4j;





@Slf4j
@Controller
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    RecruitService recruitService;
    

    @GetMapping("/post_jobs_com")
    public String getMethodName() {
        return "/recruit/post_jobs_com";
    }
    

    @PostMapping("/post_jobs_com")
    public String postMethodName(RecruitPost recruitPost) throws Exception {
        log.info("11"+ recruitPost);
        
        int result = recruitService.recruitPost(recruitPost);

        if (result > 0) {
            log.info(" insert 성공 ");
        }

        return "redirect:/recruit/post_jobs_com";
    }

    

}
