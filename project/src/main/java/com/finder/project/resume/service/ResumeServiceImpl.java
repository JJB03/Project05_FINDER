package com.finder.project.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finder.project.main.service.FileService;
import com.finder.project.resume.dto.ResumeDto;
import com.finder.project.resume.mapper.ResumeMapper;




@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private FileService fileService;
    
    /*
     * 게시글 목록 조회
     */
    @Override
    public List<ResumeDto> list() throws Exception {
        List<ResumeDto> resumeList = resumeMapper.list();
        return resumeList;
    }

    /*
     * 게시글 상세 조회
     */
    @Override
    public ResumeDto select(int cv_no) throws Exception {
        ResumeDto resumeDto = resumeMapper.select(cv_no);
        return resumeDto;
    }

    /*
     * 게시글 등록
     */
    @Override
    public int create(ResumeDto resumeDto) throws Exception {
        int result = resumeMapper.create(resumeDto);
        return result;
    }

    /*
     * 게시글 수정
     */
    @Override
    public int update(ResumeDto resumeDto) throws Exception {
        int result = resumeMapper.update(resumeDto);
        return result;
    }

    /*
     게시글 삭제
     */
    @Override
    public int delete(int cv_no) throws Exception {
        int result = resumeMapper.delete(cv_no);
        return result;
    }


  

}
