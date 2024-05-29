package com.finder.project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finder.project.user.dto.Users;
import com.finder.project.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("/{page}")
    public String main(@PathVariable("page") String page) {
        log.info("메인 화면...");
        return "/user/" + page;
    }

    @GetMapping("/join_user")
    public String join() {

        return "user/join_user";
    }

    @PostMapping("/join_user")
    public String joinPro(Users users) throws Exception {
        // 생년월일의 쉼표를 "-"으로 변경
        String userBirth = users.getUserBirth();
        userBirth = userBirth.replace(",", "-");
        users.setUserBirth(userBirth);

        String userEmail = users.getUserEmail();
        userEmail = userEmail.replace(",","");
        users.setUserEmail(userEmail);

        log.info("유저정보" + users);

        int result = UserService.join(users);

        // 회원가입 성공
        if (result > 0) {
            return "redirect:/login";
        }

        // 회원가입 실패
        return "redirect:/error";
    }

    // @GetMapping("/{domain}/{page}")
    // public String main(@PathVariable("domain") String domain
    // ,@PathVariable("page") String page ) {
    // log.info("메인 화면...");
    // return domain + "/" + page;
    // }

}
