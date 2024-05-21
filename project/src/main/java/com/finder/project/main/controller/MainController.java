package com.finder.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {


    @GetMapping("/{page}")
    public String main(@PathVariable("page") String page) {
        log.info("메인 화면...");
        return page;
    }

    
}
