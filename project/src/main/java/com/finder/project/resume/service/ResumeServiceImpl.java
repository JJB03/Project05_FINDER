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
    public int create(Resume resume) throws Exception {


        int cvNo = resumeMapper.maxPk() + 1;
        int result = resumeMapper.create(resume);

        if( result > 0 ) {
            List<Education> educationList = resume.getEducationList();

            for (Education education : educationList) {
                education.setCvNo(cvNo);
                educationService.create(education);
            }

            List<EmploymentHistory> employmentHistoryList = resume.getEmploymentHistoryList();
            for (EmploymentHistory employmentHistory : employmentHistoryList) {
                employmentHistory.setCvNo(cvNo);
                employmentHistoryService.create(employmentHistory);
            }

        }
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
