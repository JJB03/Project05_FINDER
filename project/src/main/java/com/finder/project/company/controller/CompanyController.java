package com.finder.project.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finder.project.company.dto.CompanyDetail;
import com.finder.project.company.service.CompanyService;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    
    @GetMapping("/{page}")
    public String main(@PathVariable("page") String page) {
        log.info("기업 화면...");
        return "/company/" + page;
    }


    // introduce_com 화면 (기업소개)
    @GetMapping("/company/introduce_com")
    public String introduce_com(@RequestParam("no") int no
                                ,Model model) throws Exception {

        // 데이터 요청
        CompanyDetail companyDetail = companyService.selectCompanyDetail(no);
        
        // 모델 등록
        model.addAttribute("companyDetail", companyDetail);                        

        return "/company/introduce_com";
    }

    // 기업 상세 정보 등록 (기업소개)
    @PostMapping("/company/insert_detail")
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
    // @GetMapping("/{comNo}")
    // public Company getCompanyById(@PathVariable int comNo) {
    //     return companyService.getCompanyById(comNo);
    // }

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
