package com.finder.project.main.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.finder.project.main.dto.Files;
import com.finder.project.main.service.FileService;
import com.finder.project.recruit.dto.RecruitPost;
import com.finder.project.recruit.service.RecruitService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

    @Autowired
    RecruitService recruitService;

    @Autowired
    FileService fileService;

    // 메인페이지 (채용공고)
    @GetMapping({ "/index", "" })
    public String main(Model model, Files file) throws Exception {
        log.info("메인 화면...");

        List<RecruitPost> recruitList = recruitService.recruitList();
        log.info(recruitList+"");
        for (RecruitPost recruitPost : recruitList) {

            log.info("Keyword list: " + recruitPost.getKeywordList());
            log.info("잘 나오니 ?" + recruitPost.getCompany().getComName());
        }
        log.info("파일값 나오냐 안나오냐 나와라" + file);
        recruitList.forEach(recruit -> {
            if (recruit.getKeywordList() == null) {
                recruit.setKeywordList(Collections.emptyList());

            }
            log.info("파일값 나오냐 안나오냐 나와라!!!!!!" + recruit.getFileNo());
           

            
        });
        model.addAttribute("recruitList", recruitList);

        return "/index";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    // 토스 결제 모듈
    @GetMapping("/toss_payments")
    public String toss() {
        return "/toss_payments";
    }

}
