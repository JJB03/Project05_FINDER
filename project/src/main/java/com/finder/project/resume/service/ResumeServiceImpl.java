package com.finder.project.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finder.project.resume.dto.Education;
import com.finder.project.resume.dto.EmploymentHistory;
import com.finder.project.resume.dto.Resume;
import com.finder.project.resume.mapper.ResumeMapper;




@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private EducationService educationService;

    @Autowired
    private EmploymentHistoryService employmentHistoryService;

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
    public int create(int userNo) throws Exception {
    // Resume 객체를 초기화
    Resume resume = new Resume();
    // 사용자 번호를 설정
    resume.setUserNo(userNo);
    // 이력서 생성 메서드를 호출하여 데이터베이스에 저장
    int result = resumeMapper.create(resume);

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
