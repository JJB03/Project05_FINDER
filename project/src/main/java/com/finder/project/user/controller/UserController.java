package com.finder.project.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finder.project.company.dto.Company;
import com.finder.project.company.service.CompanyService;
import com.finder.project.user.dto.Users;
import com.finder.project.user.service.EmailService;
import com.finder.project.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService; // 변수명은 카멜케이스로 (유상준)

    private CompanyService companyService;

    @Autowired
    private EmailService emailService;

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
    public String userjoinPro(Users users) throws Exception {

        // 이메일에서 오늘 ,지우기
        String userEmail = users.getUserEmail();
        userEmail = userEmail.replace(",", "");
        users.setUserEmail(userEmail);
        // ---
        log.info("유저정보" + users);

        int result = userService.join(users);

        // 회원가입 성공
        if (result > 0) {
            return "redirect:/login";
        }

        // 회원가입 실패
        return "redirect:/user/join_user";
    }

    @PostMapping("/join_com")
    public String companyjoinPro(Users user, Company company) throws Exception {

        String userEmail = user.getUserEmail();
        userEmail = userEmail.replace(",", "");
        user.setUserEmail(userEmail);

        int result = userService.join(user);

        int userNo = userService.max();

        company.setUserNo(userNo);

        int result1 = userService.comJoin(company);

        // 회원가입 성공
        if (result + result1 > 1) {
            return "redirect:/login";
        }

        // 회원가입 실패
        log.info("회사 회원가입 실패 돌아가~!~!~!");
        return "redirect:/user/join_user";
    }

    @ResponseBody
    @GetMapping("/check/{userId}")
    public ResponseEntity<Boolean> userCheck(@PathVariable("userId") String userId) throws Exception {
        log.info("아이디 중복 확인 : " + userId);
        Users user = userService.select(userId);
        // 아이디 중복
        if (user != null) {
            log.info("중복된 아이디 입니다 - " + userId);
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        // 사용 가능한 아이디입니다.
        log.info("사용 가능한 아이디 입니다." + userId);
        return new ResponseEntity<>(true, HttpStatus.OK);

    }

    // --- 아이디 비번 찾기 하는중 -----------------------------------------
    // @ResponseBody
    // @PostMapping("/find_user")
    // public String findId(@RequestParam("userEmail") String userEmail , @RequestParam("userName") String userName) throws Exception {
        
    //     log.info("이메일 파라미터 : " + userEmail); 
    //     log.info("유저 이름 파라미터 : " +  userName); 
    //     Users user = new Users();
    //     user.setUserEmail(userEmail);
    //     user.setUserName(userName);

    //     String userId = userService.findId(user);
    //     log.info("유저아이디 : " +  userId); 

    //     if (userId != null) {
    //         return "<script>alert('Your ID is " + userId + "'); location.href='/login';</script>";
    //     } else {
    //         return "<script>alert('No user found with that username and email'); history.back();</script>";
    //     }
    // }


    // 아이디 이메일로 전송 하는중 이거는 확실하지는 않음
    @ResponseBody
    @PostMapping("/find_user")
    public String findId(@RequestParam("userEmail") String userEmail, @RequestParam("userName") String userName) throws Exception {
        log.info("이메일 파라미터 : " + userEmail); 
        log.info("유저 이름 파라미터 : " + userName); 

        Users user = new Users();
        user.setUserEmail(userEmail);
        user.setUserName(userName);

        String userId = userService.findId(user);
        log.info("유저아이디 : " + userId); 

        if (userId != null) {
            String subject = "FINDER의 아이디 찾기";
            String text = "회원님의 아이디는: " + userId;
            emailService.sendSimpleMessage(userEmail, subject, text);
            return "<script>alert('해당 이메일로 ID를 발송하였습니다.'); location.href='/login';</script>";
        } else {
            return "<script>alert('해당 이메일을 찾을 수 없습니다.'); history.back();</script>";
        }
    }


    // @GetMapping("/reset-password")
    // public String resetPasswordForm() {
    //     return "reset-password";
    // }

    @ResponseBody
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam int id, @RequestParam String username, @RequestParam String email,
            @RequestParam String newPassword) throws Exception {
        Users user = userService.findPw(id, username, email);
        if (user != null) {
            userService.updatePw(id, newPassword);
            return "<script>alert('Password updated successfully'); location.href='/login';</script>";
        } else {
            return "<script>alert('No user found with that information'); history.back();</script>";
        }
    }

    // import org.springframework.stereotype.Controller;
    // import org.springframework.web.bind.annotation.ModelAttribute;
    // import org.springframework.web.bind.annotation.PostMapping;

}
