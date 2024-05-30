package com.finder.project.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finder.project.resume.dto.Resume;
import com.finder.project.resume.mapper.ResumeMapper;




@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    /*
     * 이력서 목록 조회
     */
    @Override
    public List<Resume> resumelist(int userNo) throws Exception {
        List<Resume> resumeList = resumeMapper.resumelist(userNo);
        return resumeList;
    }

    /*
     * 이력서 상세 조회
     */
    @Override
    public Resume select(int userNo) throws Exception {
        Resume Resume = resumeMapper.select(userNo);
        return Resume;
    }

    /*
     * 이력서 등록
     */
    @Override
    public int create(Resume Resume) throws Exception {
        int result = resumeMapper.create(Resume);
        return result;
    }

    /*
     * 이력서 수정
     */
    @Override
    public int update(Resume Resume) throws Exception {
        int result = resumeMapper.update(Resume);
        return result;
    }

    /*
     이력서 삭제
     */
    @Override
    public int delete(int cv_no) throws Exception {
        int result = resumeMapper.delete(cv_no);
        return result;
    }


  

}
