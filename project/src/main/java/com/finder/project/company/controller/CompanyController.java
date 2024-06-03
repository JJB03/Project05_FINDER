package com.finder.project.company.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.finder.project.company.dto.Order;
import com.finder.project.company.dto.PasswordConfirmRequest;
import com.finder.project.company.dto.Product;
import com.finder.project.company.service.CompanyService;
import com.finder.project.user.dto.Users;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller("CompanyController")
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    PasswordEncoder passwordEncoder; 

    // main_com 화면 (기업 메인 메뉴선정화면?)
    @GetMapping("/main_com")
    public String main_com() {
        return "/company/main_com";
    }

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
                               @RequestParam("userEmail") String userEmail
                               ) throws Exception {
        
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

        
        // company = companyService.selectByUserNo(user.getUserNo());
        
        // company = user.getCompany();
        // company.setComAddress(comAddress); // 기업 주소 업데이트
        

        // 데이터 요청
        int result = companyService.updateUserInfo(user);
        
        // 데이터 처리 성공 
        if( result > 0 ) {
            log.info("User : " + user.getUserBirth());
            // log.info("Company : " + company.getComAddress());
            // user.setCompany(company);
            // session.setAttribute("user", user);
            return "redirect:/user/update_user";
        }
        // 데이터 처리 실패
        return "redirect:/user/error";
    }

    // 현재 비밀번호 확인⭕
    @PostMapping("/update_com_pw_confirm")
    public ResponseEntity<Boolean> pw_confirm(@RequestBody PasswordConfirmRequest request, HttpSession session) {
        
        // 세션에서 사용자 정보 가져오기
        Users user = (Users) session.getAttribute("user");
        // 현재 비밀번호를 암호화해서, 세션에 암호화된 비밀번호와 비교 (맞으면 1)
        boolean isMatch = passwordEncoder.matches(request.getPassword(), user.getUserPw());
        return ResponseEntity.ok(isMatch);
    }

    // 기업 비밀번호 수정 ⭕
    @PostMapping("/update_com_pw")
    public String updateCompany(HttpSession session 
                                ,@RequestParam("userPw") String userPw
                                //,@RequestParam("userBeforePw") String userBeforePw
                                ) throws Exception {
        
        // 세션에서 사용자 정보 가져오기
        Users user = (Users) session.getAttribute("user");
        
        if (user == null) {
            // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }
        
        user.setUserPw(userPw);
        // user.setUserBeforePw(userBeforePw);

        String password = user.getUserPw();
        String encodedPassword = passwordEncoder.encode(password);  // 🔒 비밀번호 암호화
        user.setUserPw(encodedPassword);

        // String beforePassword = user.getUserBeforePw();
        // String encodedBeforePassword = passwordEncoder.encode(beforePassword);  // 🔒 비밀번호 암호화
        // user.setUserBeforePw(encodedBeforePassword);

        
        // 데이터 요청
        int result = companyService.updateUserPw(user);


        // 데이터 처리 성공 
        if( result > 0 ) {
            session.setAttribute("user", user);
            return "redirect:/user/update_user";
        }
        // 데이터 처리 실패
        return "redirect:/user/error";
    }
    


    // 토스 페이먼츠 메인
    @GetMapping("/credit/checkout")
    public String checkout(@RequestParam("productNo") int productNo, Model model) throws Exception {
        
        Product product = companyService.selectProduct(productNo);
        
        model.addAttribute("product", product);
        return "/company/credit/checkout";
    }
    // 토스 페이먼츠 success [GET]
    @GetMapping("/credit/success")
    public String success(@RequestParam("productNo") int productNo, Model model) throws Exception {

        Product product = companyService.selectProduct(productNo);

        model.addAttribute("product", product);
        return "/company/credit/success";
    }
    // // // 토스 페이먼츠 success [POST]
    // @PostMapping("/credit/success")
    // public String successPro() throws Exception {

    //     // int result = companyService.insertOrder(order);

    //     // if(result > 0) {
    //     //     return "/company/credit/success";
    //     // }
    //     return "/company/credit/fail";    
    // }

     // 결제 확인 및 데이터베이스 저장
     @PostMapping("/confirm")
     public ResponseEntity<?> confirmPayment( HttpSession session
                                             ,@RequestBody Map<String, Object> paymentData) throws Exception {

        // String paymentKey = (String) paymentData.get("paymentKey");
        // String orderId = (String) paymentData.get("orderId");
        int amount = (int) paymentData.get("amount");
        int productNo = (int) paymentData.get("productNo");
        // int userNo = (int) paymentData.get("userNo");
        int totalQuantity = (int) paymentData.get("total_quantity");

        // 세션에서 사용자 정보 가져오기
        Users user = (Users) session.getAttribute("user");
 
         // 결제 성공 시 주문 데이터를 데이터베이스에 저장
         Order order = new Order();
         Product product = companyService.selectProduct(productNo);
         
         order.setUserNo(user.getUserNo()); /* session이나 다른 방식으로 userNo 설정 */
         order.setProductNo(product.getProductNo());
         order.setTotalQuantity(totalQuantity); // 필요한 경우 적절히 설정
         order.setTotalPrice(amount);
         order.setOrderStatus("PAID");
 
         int result = companyService.insertOrder(order);
 
         if (result > 0) {
             return ResponseEntity.ok().body("Payment confirmed and order saved.");
         } else {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save order.");
         }
     }

    


    // 토스 페이먼츠 fail
    @GetMapping("/credit/fail")
    public String fail() {
        return "/company/credit/fail";
    }




    // 결제상품 목록 화면
    @GetMapping("/credit/credit_com")
    public String credit_com() throws Exception {
        return "/company/credit/credit_com";
    }
    // 결제상품 세부 화면
    @GetMapping("/credit/credit_detail_com")
    public String credit_detail_com(@RequestParam("productNo") int productNo, Model model, Product product) throws Exception {

        product.setProductNo(productNo);
        product = companyService.selectProduct(productNo);

        model.addAttribute("product", product);
        return "company/credit/credit_detail_com";
    }
    // 결제 목록 내역 화면
    @GetMapping("/credit/credit_list_com")
    public String credit_list_com() throws Exception {
        return "/company/credit/credit_list_com";
    }










    // 등록된 채용공고 화면
    @GetMapping("/recruit_list_com")
    public String recruit_list_com() throws Exception {
        return "/company/recruit_list_com";
    }

    // AI 평가 화면
    @GetMapping("/score_com")
    public String score_com() throws Exception {
        return "/company/score_com";
    }
    
}
