package com.finder.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class MainController {


    // @GetMapping("/{page}")
    // public String main(@PathVariable("page") String page) {
    //     log.info("메인 화면...");
    //     return "/" + page;
    // }

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
    
    // 메인페이지 (채용공고)
    @GetMapping("/index")
    public String index() {
        return "/index";
    }
    
    
}
