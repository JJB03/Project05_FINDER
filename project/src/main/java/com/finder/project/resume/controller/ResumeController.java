package com.finder.project.resume.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


import com.finder.project.main.dto.Files;
import com.finder.project.main.service.FileService;

import com.finder.project.resume.dto.Resume;
import com.finder.project.resume.service.ResumeService;
import com.finder.project.user.dto.Users;


import org.springframework.web.bind.annotation.PostMapping;




/**
 *  /resume 경로로 요청 왔을 때 처리
 *  [GET]   - /resume/cv_list        : 게시글 목록 화면
 *  [GET]   - /resume/cv_create      : 게시글 등록 화면
 *  [POST]  - /resume/cv_create      : 게시글 등록 처리
 *  [GET]   - /resume/cv_read_user   : 구직자 게시글 상세 조회/수정 화면
 *  [GET]   - /resume/cv_read_com    : 사업가 게시글 상세 조회/수정 화면
 *  [POST]  - /resume/cv_read_user   : 사업가 게시글 조회/수정 화면
 *  [POST]  - /resume/cv_read_com    : 사업가 게시글 조회/수정 화면
 *  [POST]  - /resume/delete         : 게시글 삭제 처리
 */

@Slf4j
@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @Autowired
    private FileService fileService;




    
    /**
     * 이력서 목록 화면
     * @param page
     * @return
     */
    // @GetMapping("/cv_list_user")
    // public String CvList(Model model, Option option) throws Exception {
    //     log.info("이력서 목록 조회화면입니다.");
    //     //1)데이터 요청
    //     List<Resume> resumeList = resumeService.list(option);

    //     //2)모델 등록하기
    //     model.addAttribute("resumeList", resumeList);
    //     model.addAttribute("option", option); //검색

    //     //*검색*/)동적으로 옵션값을 가져오는 경우
    //     /* List<Option> optionList = new ArrayList<>();
    //     optionList.add(new Option("전체", 0));
    //     optionList.add(new Option("제목", 1));
    //     optionList.add(new Option("내용", 2));
    //     optionList.add(new Option("제목+내용", 3));
    //     optionList.add(new Option("작성자", 4));
    //     model.addAttribute("optionList", optionList); */
        
    //     //3)뷰 페이지 지정
    //     return "/resume/cv_list_user";
    // }
        

    @GetMapping("/cv_list_user")
    public String CvList(HttpSession session,Model model) throws Exception {
        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        int userNo = user.getUserNo();
        log.info(" 이력서 목차는 : " + userNo);
        List<Resume> resumeList = resumeService.resumelist(userNo);
       

        //모델 등록
        model.addAttribute("resumeList", resumeList);
        model.addAttribute("user", user);

        
        //뷰페이지 지정
        return "resume/cv_list_user";
    }
    

    /**
     * 게시글 등록 처리화면
     * @return
     */
    @GetMapping("/cv_create_user")
    public String CvCreate( HttpSession session) throws Exception{
        Users user = (Users) session.getAttribute("user");

        
        // insert  한 서비스로 insert수행
        int useruno = user.getUserNo();
        int result = resumeService.create(useruno);
        

        if( result >0){
            log.info("성공했어요");
            return "/resume/cv_create_user";
        }
        return "redirect:/resume/cv_list_user?error";
    }

/*     @PostMapping("/cv_create_user")
    public String CvCreatePro(HttpSession session, Resume resume, Model model) throws Exception {
        Users user = (Users) session.getAttribute("user"); // 세션 사용자 정보 가져오기

        if (user == null) {
            log.info("돌아가라");
            return "redirect:/login"; // 사용자 확인
        }
        
        // Resume 객체에 사용자 정보 추가
        resume.setUserNo(user.getUserNo());
        
        int result = resumeService.create(0);

        if (result>0) {
           
            return "redirect:/resume/cv_list_user";
        }
        return "redirect:/resume/cv_create_user?error";
    }
     */

    /**
     * 구직자 게시글 상세 조회/수정 화면
     * @param param
     * @return
     * 파일 요청도 해야함.
     */
    @GetMapping("/cv_read_user")
    public String cvReadUser(HttpSession session
                                ,Model model) throws Exception{
        // 세션으로 가져온 User 객체의 user_no을 참조해서 service에 넣기
        Users user = (Users) session.getAttribute("user");
        

        if (user == null) {
            // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

            // 세션에서 사용자 정보를 가져옴
            int userNo = user.getUserNo();

            // 사용자의 이력서 정보를 가져옴
            Resume resume = resumeService.select(userNo);


            // 가져온 이력서 정보를 모델에 추가하여 화면에 전달
            model.addAttribute("resume", resume);
            model.addAttribute("user", user);

            // 이력서 정보가 담긴 화면으로 이동
            return "/resume/cv_read_user";
    }
    
    /**
     * 구직자 게시글 수정 처리
     * @param Resume
     * @return
     * @throws Exception
     */
    @PostMapping("/cv_update_user")
    public String updateUserPro(HttpSession session, Resume resume)  throws Exception{
            // 세션에서 사용자 정보를 가져옴
            Users user = (Users) session.getAttribute("user");

            if (user == null) {
                return "redirect:/login"; // 사용자가 로그인되어 있지 않은 경우 로그인 페이지로 이동
            }
            int cvNo = resumeService.maxPk();
            
            if (cvNo == 0) {
                cvNo = 1;
            }

            resume.setCvNo(cvNo);
            
            // 사용자의 이력서 정보를 업데이트
            int result = resumeService.update(resume);

            // 데이터 처리 성공 시
            if (result > 0) {
                log.info("정보가 수정되었어요.");
                return "redirect:/resume/cv_list_user"; // 성공 시 이력서를 다시 읽는 페이지로 리다이렉트
            }
            
            // 데이터 처리 실패 시
            return "redirect:/resume/cv_create_user?cvNo=" + cvNo + "&error"; // 실패 시 오류 메시지와 함께 이력서 읽는 페이지로 리다이렉트
        }
    


    /**
     * 사업가 게시글 상세 조회/수정화면
     * @param param
     * @return
     */
    @GetMapping("/cv_read_com")
    public String ReadCom(HttpSession session
                            , Model model) throws Exception {

            // 세션에서 사용자 정보를 가져옴
            Users user = (Users) session.getAttribute("user");

            if (user == null) {
                // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
                return "redirect:/login";
            }

            int userNo = user.getUserNo();

            // 사용자의 이력서 정보를 가져옴
            Resume resume = resumeService.select(userNo);

            // 가져온 이력서 정보를 모델에 추가하여 화면에 전달
            model.addAttribute("Resume", resume);
            model.addAttribute("user", user);

            // 화면 이동
            return "resume/cv_read_com";
    }

    /**
     * 사업가 게시글 수정 처리
     * @param Resume
     * @return
     * @throws Exception
     */
/*     @PostMapping("/cv_read_com")
    public String ReadComPro(Resume Resume) throws Exception{
        int result = resumeService.update(Resume);
        if (result>0) {
            return "redirect:/resume/cv_read_com";
        }
        //실패시
        int cv_no = Resume.getCvNo();
        return "redirect:/resume/cv_read_com=" + cv_no + "&error";
    } */

    @PostMapping("/delete")
    public String deletePro(@RequestParam("cv_no") int cv_no) throws Exception {
        int result = resumeService.delete(cv_no);
        if (result>0) {
            //파일까지 삭제
            Files file = new Files();
            file.setParentTable("Resume");
            file.setParentNo(cv_no);
            fileService.deleteByParent(file);
            
            return "redirect:/resume/cv_list_user";
        }
        
        return "redirect:/resume/cv_read?no=" + cv_no + "&error";
    }
    
}
