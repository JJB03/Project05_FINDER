package com.finder.project.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/recruit")
public class RecruitController {

    @GetMapping("/{page}")
    public String main(@PathVariable("page") String page) {
        log.info("채용 화면...");
        return "/recruit/" + page;
    }

    

}
