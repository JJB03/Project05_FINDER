package com.finder.project.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.finder.project.company.dto.Company;
import com.finder.project.company.service.CompanyService;
import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;
import com.finder.project.recruit.service.RecruitService;
import com.finder.project.user.dto.Users;

import lombok.extern.slf4j.Slf4j;






@Slf4j
@Controller
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    RecruitService recruitService;

    @Autowired
    CompanyService companyService;

    
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
    public String getPost_jobs_com() {
        return "/recruit/post_jobs_com";
    }

    @PostMapping("/post_jobs_com")
    public String postPost_jobs_com(RecruitPost recruitPost) throws Exception {
        log.info("11"+ recruitPost);
        
        int result = recruitService.recruitPost(recruitPost);

        if (result > 0) {
            log.info(" insert 성공 ");
        }

        return "redirect:/index";
    }
    // 채용공고 등록 페이지 ---- 끝

    // 채용공고 조회/수정 페이지 ----
    @GetMapping("/post_jobs_read_com")
    public String getPost_jobs_read_com(@RequestParam("recuitNo") int recuitNo, Model model) throws Exception {
        
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

        return "/recruit/post_jobs_read_com";
    }

    @PostMapping("/post_jobs_read_com")
    public String postPost_jobs_read_com(RecruitPost recruitPost) throws Exception {
        log.info("11"+ recruitPost);
        
        int result = recruitService.recruitPost(recruitPost);

        if (result > 0) {
            log.info(" insert 성공 ");
        }

        return "redirect:/index";
    }
    // 채용공고 등록 페이지 ---- 끝


    // 기업이 등록 한 채용공고 목록
    @GetMapping("/posted_jobs_com")
    public String getPosted_jobs_com(@SessionAttribute("user") Users user , Model model) throws Exception {

        Company company = companyService.selectByUserNo(user.getUserNo()); 
        int comNo = company.getComNo();

        List<RecruitPost> recruitPosts = recruitService.postsRecruitList(comNo);
        model.addAttribute("recruitPosts", recruitPosts);

        return "/recruit/posted_jobs_com";
    }
    // 채용공고 삭제 비동기
    @ResponseBody
    @GetMapping("/posted_jobs_com/{recruitNo}")
    public ResponseEntity<Boolean> userCheck(@PathVariable("recruitNo") int recruitNo) throws Exception {
        log.info("채용공고 삭제 : " + recruitNo);
        int result = recruitService.deleteRecruitList(recruitNo);
        // 아이디 중복
        if( result > 0 ) {
            log.info("삭제되었습니다. ");
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        // 사용 가능한 아이디입니다.
        log.info("삭제가 불가능합니다.");
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    // 기업이 등록 한 채용공고 페이지 ---- 끝


    

}
