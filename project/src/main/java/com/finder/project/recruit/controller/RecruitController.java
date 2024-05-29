package com.finder.project.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;
import com.finder.project.recruit.service.RecruitService;

import lombok.extern.slf4j.Slf4j;






@Slf4j
@Controller
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    RecruitService recruitService;
    
    // 채용공고 상세 페이지 ----
    @GetMapping("/detail_jobs_user")
    public String getMethodName(@RequestParam("recuitNo") int recuitNo, Model model) throws Exception {

        RecruitPost recruitPost = recruitService.recruitRead(recuitNo);
        if (recruitPost == null) {
            log.error("RecruitPost 객체가 null입니다. : ", recruitPost);
        } else {
            log.info("RecruitPost 정보: {}", recruitPost);
        }

        // List<Keyword> keywords = recruitService.recruitReadKeyword(recuitNo);
        // if (keywords == null) {
        //     log.error("keywords 객체가 null입니다. : ", keywords);
        // } else {
        //     log.info("keywords 정보: {}", keywords);
        // }

        model.addAttribute("recruitPost", recruitPost);
        // model.addAttribute("keywords", keywords);

        return "/recruit/detail_jobs_user";
    }
    // 채용공고 상세 페이지 ---- 끝

    // 채용공고 등록 페이지 ----
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

        return "redirect:/index";
    }
    // 채용공고 등록 페이지 ---- 끝

    

}
