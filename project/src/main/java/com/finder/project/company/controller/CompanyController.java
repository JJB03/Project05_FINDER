package com.finder.project.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/company")
public class CompanyController {
    
    @GetMapping("/{page}")
    public String main(@PathVariable("page") String page) {
        log.info("기업 화면...");
        return "/company/" + page;
    }

}
