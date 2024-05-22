package com.finder.project.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/{page}")
    public String main(@PathVariable("page") String page) {
        log.info("메인 화면...");
        return "/user/" + page;
    }

    // @GetMapping("/{domain}/{page}")
    // public String main(@PathVariable("domain") String domain
    //                   ,@PathVariable("page") String page  ) {
    //     log.info("메인 화면...");
    //     return domain + "/" + page;
    // }   
    
}
