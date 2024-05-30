package com.finder.project.company.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finder.project.company.dto.Company;
import com.finder.project.company.dto.CompanyDetail;
import com.finder.project.company.dto.PasswordConfirmRequest;
import com.finder.project.company.service.CompanyService;
import com.finder.project.user.dto.Users;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    PasswordEncoder passwordEncoder; 


    // introduce_com 화면 (기업소개)
    // 조회는 세션에서 해주고 있다. (Users에서 Company CompanyDetail 받아옴)
    @GetMapping("/introduce_com")
    public String introduce_com(HttpSession session, Model model) throws Exception {
        

        return "/company/introduce_com";
    }



    // 기업 상세 정보 등록 (기업소개)
    @PostMapping("/insert_detail")
    public String introduceComInsertPro(HttpSession session, CompanyDetail companyDetail) throws Exception {
        // 세션에서 사용자 정보 가져오기
        Users user = (Users) session.getAttribute("user");
        
        if (user == null) {
            // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        Company company = companyService.selectByUserNo(user.getUserNo());

        
        // CompanyDetail 객체에 사용자 정보 설정
        companyDetail.setComNo(company.getComNo());

        // 데이터 삽입 요청
        int result = companyService.insertCompanyDetail(companyDetail);

        // 데이터 처리 성공
        if (result > 0) {
            user.setCompanyDetail(companyDetail);
            session.setAttribute("user", user);
            // session.setAttribute("companyDetail", companyDetail);
            return "redirect:/company/introduce_com";
        }
        // 데이터 처리 실패
        return "redirect:/error";
    }


    
    // 기업 상세 정보 수정 (기업소개)
    @PostMapping("/update_detail")
    public String introduce_com_updatePro(HttpSession session, CompanyDetail companyDetail) throws Exception {

        // 세션에서 사용자 정보 가져오기
        Users user = (Users) session.getAttribute("user");
        
        if (user == null) {
            // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        Company company = companyService.selectByUserNo(user.getUserNo());

        // CompanyDetail 객체에 사용자 정보 설정
        companyDetail.setComNo(company.getComNo());


        // 데이터 요청
        int result = companyService.updateCompanyDetail(companyDetail);
        
        // 데이터 처리 성공 
        if( result > 0 ) {
            user.setCompanyDetail(companyDetail);
            session.setAttribute("user", user);
            return "redirect:/company/introduce_com";
        }
        // 데이터 처리 실패
        return "redirect:/error";
    }







    // 기업 조회 (기업정보)
    @GetMapping("/info_update_com")
    public String info_update_com() throws Exception {  

        return "/company/info_update_com";
    }

    // 기업 등록 (기업정보)
    // @PostMapping("/")
    // public void createCompany(@RequestBody Company company) {
    //     companyService.createCompany(company);
    // }

    // 기업 정보 수정
    @PostMapping("/update_com_info")
    public String updateCompany(HttpSession session, Company company
                              ,@RequestParam("userName") String userName,
                               @RequestParam("userBirth") String userBirth,
                               @RequestParam("userPhone") String userPhone,
                               @RequestParam("userEmail") String userEmail,
                               @RequestParam("comAddress") String comAddress) throws Exception {
        
        // 세션에서 사용자 정보 가져오기
        Users user = (Users) session.getAttribute("user");
        
        if (user == null) {
            // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // 사용자 정보 업데이트
        user.setUserBirth(userBirth);
        user.setUserPhone(userPhone);
        user.setUserEmail(userEmail);

        
        company = companyService.selectByUserNo(user.getUserNo());
        
        company = user.getCompany();
        company.setComAddress(comAddress); // 기업 주소 업데이트
        

        // 데이터 요청
        int result = companyService.updateUserComInfo(user, company);
        
        // 데이터 처리 성공 
        if( result > 1 ) {
            log.info("User : " + user.getUserBirth());
            log.info("Company : " + company.getComAddress());
            user.setCompany(company);
            // session.setAttribute("user", user);
            return "redirect:/company/info_update_com";
        }
        // 데이터 처리 실패
        return "redirect:/user/error";
    }




    // 현재 비밀번호 확인 
    @PostMapping("/update_com_pw")
    public ResponseEntity pw_confirm(@RequestBody PasswordConfirmRequest request, HttpSession session) {
        
        // 세션에서 사용자 정보 가져오기
        Users user = (Users) session.getAttribute("user");

        boolean isMatch = passwordEncoder.matches(request.getPassword(), user.getUserPw());
        return ResponseEntity.ok(isMatch);
    }

    
    


    // 결제 종류 화면
    @GetMapping("/credit_com")
    public String credit_com() throws Exception {
        return "/company/credit_com";
    }

    
}
