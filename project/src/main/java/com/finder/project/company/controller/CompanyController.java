package com.finder.project.company.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.finder.project.company.dto.Company;
import com.finder.project.company.dto.CompanyDetail;
import com.finder.project.company.dto.Credit;
import com.finder.project.company.dto.Order;
import com.finder.project.company.dto.PasswordConfirmRequest;
import com.finder.project.company.dto.Product;
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
    



    // 토스 페이먼츠 메인 [GET]
    @GetMapping("/credit/checkout")
    public String checkout(@RequestParam("productNo") int productNo
                          ,@RequestParam("orderNo") int orderNo 
                          ,Model model) throws Exception {
        
        Order order = companyService.selectOrder(orderNo);  // orderNo로 주문 정보 조회
        Product product = companyService.selectProduct(productNo);
        
        model.addAttribute("order", order);
        model.addAttribute("product", product);
        return "/company/credit/checkout";
    }

    // 토스 페이먼츠 중간 프로세스 [GET]
    @GetMapping("/credit/process")
    public String process() throws Exception {
        
        return "/company/credit/process";
    }

    // 토스 페이먼츠 success [GET]
    @GetMapping("/credit/success")
    public String success(@RequestParam("productNo") int productNo
                         ,@RequestParam("orderNo") int orderNo
                         ,Model model) throws Exception {

        Product product = companyService.selectProduct(productNo);
        Order order = companyService.selectOrder(orderNo);
        Credit credit = companyService.selectCredit(orderNo);
        log.info(credit.toString());
        log.info(order.toString());
        log.info(product.toString());

        model.addAttribute("credit", credit);
        model.addAttribute("order", order);
        model.addAttribute("product", product);
        return "/company/credit/success";
    }


     // 결제 테이블 추가
     @ResponseBody
     @PostMapping("/credit/process")
     public ResponseEntity<Map<String, Object>> successPro(HttpSession session,
                              @RequestParam("paymentKey") String paymentKey,
                              @RequestParam("orderId") String orderId,
                              @RequestParam("price") int price,
                              @RequestParam("productNo") int productNo,
                              @RequestParam("orderNo") int orderNo
                              ) throws Exception {
     
        // 세션에서 사용자 정보 가져오기
        // Users user = (Users) session.getAttribute("user");
        log.info("Received data: paymentKey = " + paymentKey + ", orderId = " + orderId + ", price = " + price + ", productNo = " + productNo + ", orderNo = " + orderNo);

        log.info("orderNo : " + orderNo);

        Order order = companyService.selectOrder(orderNo);
        log.info("order : " + order);
        Product product = companyService.selectProduct(productNo);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, product.getProductDuration());
        log.info("개월수" + product.getProductDuration());
        log.info("현재 날짜" + calendar.getTime());
        order.setExpirationDate(calendar.getTime()); // 만료일 개월수만큼 더해서 나오게끔해야됨

        log.info(order.toString());

        int result = companyService.updateOrder(order);

        if(result>0){
            log.info("성공했어요!~");
        }else{
            log.info("실패했어용");
        }
     
        Credit credit = new Credit();
        credit.setOrderNo(orderNo);
        credit.setCreditCode(orderId);
        credit.setCreditMethod("간편결제");
        credit.setCreditStatus("PAID");

        int creditResult = companyService.insertCredit(credit);

        Map<String, Object> response = new HashMap<>();

        if(creditResult > 0) {
            response.put("status", "success");
        } else {
            response.put("status", "fail");
        }
        
        response.put("productNo", productNo);
        response.put("orderNo", orderNo);

        return ResponseEntity.ok(response);
     }


    // 주문 테이블 추가
    @ResponseBody
    @PostMapping("/credit/checkout")
    public Map<String, Object> successPro(HttpSession session,
                                      @RequestBody Map<String, Integer> requestBody) throws Exception {
    int productNo = requestBody.get("productNo");

    // 세션에서 사용자 정보 가져오기
    Users user = (Users) session.getAttribute("user");

    // 결제 성공 시 주문 데이터를 데이터베이스에 저장
    Order order = new Order();
    Product product = companyService.selectProduct(productNo);

    order.setUserNo(user.getUserNo()); /* session이나 다른 방식으로 userNo 설정 */
    order.setProductNo(product.getProductNo());
    order.setTotalQuantity(product.getProductCount()); // 필요한 경우 적절히 설정
    order.setTotalPrice(product.getProductPrice());
    order.setOrderStatus("PENDING");

    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, product.getProductDuration());

    order.setExpirationDate(calendar.getTime()); // 만료일 개월수만큼 더해서 나오게끔해야됨

    // order_no를 반환하는 insertOrder 메서드 호출
    int orderNo = companyService.insertOrder(order);

    Map<String, Object> response = new HashMap<>();
    if (orderNo > 0) {
        response.put("success", true);
        response.put("orderNo", orderNo);
    } else {
        response.put("success", false);
    }
    return response;
}

    


    // 토스 페이먼츠 fail
    @GetMapping("/credit/fail")
    public String fail() {
        return "/company/credit/fail";
    }




    // 결제상품 화면
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
    public String credit_list_com(Model model) throws Exception {

    List<Order> orderCreditList = companyService.orderCreditList();

    model.addAttribute("orderCreditList", orderCreditList);

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
