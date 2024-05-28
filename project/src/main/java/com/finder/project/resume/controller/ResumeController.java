package com.finder.project.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

import com.finder.project.main.dto.File;
import com.finder.project.main.service.FileService;
import com.finder.project.resume.dto.ResumeDto;
import com.finder.project.resume.service.ResumeService;
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
    //     List<ResumeDto> resumeList = resumeService.list(option);

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
    public String CvList(Model model) throws Exception {
        List<ResumeDto> resumeList = resumeService.list();

        //모델 등록
        model.addAttribute("resumeList", resumeList);

        //뷰페이지 지정
        return "/resume/cv_list_user";
    }
    

    /**
     * 게시글 등록 처리
     * @return
     */
    @GetMapping("/cv_create_user")
    public String CvCreate() throws Exception{
        return "/resume/cv_create_user";
    }

    @PostMapping("/cv_create_user")
    public String CvCreatePro(ResumeDto resumeDto) throws Exception {
        log.info(resumeDto.toString());

        //데이터요청
        int result = resumeService.create(resumeDto);
        //리다이렉트 데이터 처리 성공
        if (result>0) {
            return"redirect:/resume/cv_create_user";
        }
        //데이터 처리 실패
        return "redirect:/index";
    }
    
    /**
     * 구직자 게시글 상세 조회/수정 화면
     * @param param
     * @return
     * 파일 요청도 해야함.
     */
    @GetMapping("/cv_read_user")
    public String ReadUser(@RequestParam("cv_no") int cv_no
                            , Model model
                            , File file) throws Exception {
        //데이터 요청
        ResumeDto resumeDto = resumeService.select(cv_no);

        //파일 목록 요청
        file.setParentTable("resumeDto");
        file.setCvNo(cv_no);

        List<File> fileList = fileService.listByParent(file);

        //모델등록
        model.addAttribute("resumeList", resumeDto);
        model.addAttribute("fileList", fileList);

        //뷰페이지 지정
        return "resume/cv_read_user";
    }

    /**
     * 사업가 게시글 상세 조회/수정화면
     * @param param
     * @return
     */
    @GetMapping("/cv_read_com")
    public String ReadCom(@RequestParam("cv_no") int cv_no
                            , Model model
                            , File file) throws Exception {
        //데이터 요청
        ResumeDto resumeDto = resumeService.select(cv_no);

        //파일 목록 요청
        file.setParentTable("resumeDto");
        file.setCvNo(cv_no);

        List<File> fileList = fileService.listByParent(file);

        //모델등록
        model.addAttribute("resumeList", resumeDto);
        model.addAttribute("fileList", fileList);

        //뷰페이지 지정
        return "resume/cv_read_com";
    }

    /**
     * 구직자 게시글 수정 처리
     * @param resumeDto
     * @return
     * @throws Exception
     */
    @PostMapping("/cv_read_user")
    public String ReadUserPro(ResumeDto resumeDto) throws Exception{
        int result = resumeService.update(resumeDto);
        if (result>0) {
            return "redirect:/cv_read_user";
        }
        //실패시
        int cv_no = resumeDto.getCv_no();
        return "redirect:/resume/cv_read_user=" + cv_no + "&error";
    }
    
    /**
     * 사업가 게시글 수정 처리
     * @param resumeDto
     * @return
     * @throws Exception
     */
    @PostMapping("/cv_read_com")
    public String ReadComPro(ResumeDto resumeDto) throws Exception{
        int result = resumeService.update(resumeDto);
        if (result>0) {
            return "redirect:/cv_read_com";
        }
        //실패시
        int cv_no = resumeDto.getCv_no();
        return "redirect:/resume/cv_read_com=" + cv_no + "&error";
    }

    @PostMapping("/delete")
    public String deletePro(@RequestParam("cv_no") int cv_no) throws Exception {
        int result = resumeService.delete(cv_no);
        if (result>0) {
            //파일까지 삭제
            File file = new File();
            file.setParentTable("resumeDto");
            file.setParentNo(cv_no);
            fileService.deleteByParent(file);
            
            return "redirect:/resume/cv_list_user";
        }
        
        return "redirect:/resume/cv_read?no=" + cv_no + "&error";
    }
    
}
