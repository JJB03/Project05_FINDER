package com.finder.project.company.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finder.project.company.dto.Company;
import com.finder.project.company.dto.CompanyDetail;
import com.finder.project.company.service.CompanyService;
import com.finder.project.user.dto.Users;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    // introduce_com 화면 (기업소개)
    // 조회는 세션에서 해주고 있다. (Users에서 Company CompanyDetail 받아옴)
    @GetMapping("/introduce_com")
    public String introduce_com() throws Exception {

        return "/company/introduce_com";
    }



    // 기업 상세 정보 등록 (기업소개)
    @PostMapping("/insert_detail")
    public String introduce_com_insertPro(CompanyDetail companyDetail) throws Exception {
        
        // 데이터 요청
        int result = companyService.insertCompanyDetail(companyDetail);

        // 데이터 처리 성공
        if(result > 0) {
            return "redirect:/company/introduce_com";
        }
        // 데이터 처리 실패 
        return "redirect:/error";
    }

    // 기업 상세 정보 수정 (기업소개)
    @PostMapping("/update_detail")
    public String introduce_com_updatePro(CompanyDetail companyDetail) throws Exception {

        // 데이터 요청
        int result = companyService.updateCompanyDetail(companyDetail);
        
        // 데이터 처리 성공 
        if( result > 0 ) {
            return "redirect:/company/introduce_com";
        }
        // 데이터 처리 실패
        return "redirect:/error";
    }







    // 기업 조회 (기업정보)
    @GetMapping("/info_update_com")
    public String getCompanyById(@RequestParam("no") int no
                                ,Model model) throws Exception {

        // 데이터 요청
        Company company = companyService.selectCompanyById(no);
        
        // 모델 등록
        model.addAttribute("company", company);                                            

        return "/company/info_update_com";
    }

    // 기업 등록 (기업정보)
    // @PostMapping("/")
    // public void createCompany(@RequestBody Company company) {
    //     companyService.createCompany(company);
    // }

    // 기업 수정 (기업정보)
    // @PostMapping("/")
    // public void updateCompany(@PathVariable int comNo, @RequestBody Company company) {
    //     company.setComNo(comNo);
    //     companyService.updateCompany(company);
    // }

    
}
