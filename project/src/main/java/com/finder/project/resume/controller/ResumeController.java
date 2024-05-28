package com.finder.project.resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/resume")
public class ResumeController {
    
    @GetMapping("/{page}")
    public String main(@PathVariable("page") String page) {
        log.info("메인 화면...");
        return "/resume/" + page;
    }

    // @GetMapping("/{domain}/{page}")
    // public String main(@PathVariable("domain") String domain
    //                   ,@PathVariable("page") String page  ) {
    //     log.info("메인 화면...");
    //     return domain + "/" + page;
    // }   
    
}
