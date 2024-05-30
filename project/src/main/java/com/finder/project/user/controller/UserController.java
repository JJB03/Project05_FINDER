package com.finder.project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finder.project.company.dto.Company;
import com.finder.project.user.dto.Users;
import com.finder.project.user.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;        // 변수명은 카멜케이스로 (유상준)

    @GetMapping("/{page}")
    public String main(@PathVariable("page") String page) {
        log.info("메인 화면...");
        return "/user/" + page;
    }

    @GetMapping("/join_user")
    public String join() {

        return "user/join_user";
    }

    
    
    @PostMapping("/join_com")
    public String companyjoinPro(@ModelAttribute("user") Users user, @ModelAttribute("company") Company company) throws Exception {

        int result = userService.comJoin(user,company);
        
         // 회원가입 성공
         if (result > 0) {
            return "redirect:/login";
        }

        // 회원가입 실패
        return "redirect:/user/join_user";
    }
    
    
    // public class YourController {
        
    //     @PostMapping("/yourEndpoint")
    //     public String yourMethod(@ModelAttribute("object1") Object1 object1, @ModelAttribute("object2") Object2 object2) {
    //         // object1과 object2를 사용하여 로직 처리
    //         return "yourView"; // 처리 결과를 보여줄 뷰 이름 반환
    //     }
    // }
    

    @PostMapping("/join_user")
    public String userjoinPro(Users users) throws Exception {
        // 생년월일의 쉼표를 "-"으로 변경
        // String userBirth = users.getUserBirth();
        // userBirth = userBirth.replace(",", "-");
        // users.setUserBirth(userBirth);

        String userEmail = users.getUserEmail();
        userEmail = userEmail.replace(",","");
        users.setUserEmail(userEmail);

        log.info("유저정보" + users);

        int result = userService.join(users);

        // 회원가입 성공
        if (result > 0) {
            return "redirect:/login";
        }

        // 회원가입 실패
        return "redirect:/user/join_user";
    }

    @ResponseBody
    @GetMapping("/check/{userId}")
    public ResponseEntity<Boolean> userCheck(@PathVariable("userId") String userId) throws Exception {
        log.info("아이디 중복 확인 : " + userId);
        Users user = userService.select(userId);
        // 아이디 중복
        if( user != null ) {
            log.info("중복된 아이디 입니다 - " + userId);
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        // 사용 가능한 아이디입니다.
        log.info("사용 가능한 아이디 입니다." + userId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    


//     import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

}
