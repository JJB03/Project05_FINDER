package com.finder.project.resume.service;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.finder.project.resume.dto.Resume;
import com.finder.project.resume.mapper.ResumeMapper;




@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    FileService fileService;



    /*
     * 이력서 목록 조회⭕
     */
    @Override
    public List<Resume> resumelist(int userNo) throws Exception {
        List<Resume> resumeList = resumeMapper.resumelist(userNo);
        return resumeList;
    }
    
    /*
     * 이력서 첫 페이지 만들기⭕
     * 파일 임플 적어야 함.
     */
    @Override
    public int create(int userNo) throws Exception {
    // Resume 객체를 초기화
    Resume resume = new Resume();
    int cvNo = resumeMapper.maxPk();
    
    // 사용자 번호를 설정
    resume.setUserNo(userNo);
    // 이력서 생성 메서드를 호출하여 데이터베이스에 저장
    int result = resumeMapper.create(userNo);

    return result;
    }
    
    /*
     * 이력서 상세 조회
     */
    @Override
    public Resume select(int cvNo) throws Exception {
        Resume Resume = resumeMapper.select(cvNo);
        return Resume;
    }

    /*
     * 이력서 내용 업로드하기⭕
     */
    @Override
    public int update(Resume resume) throws Exception {
        int result = resumeMapper.update(resume);
        return result;
    }

    /*
     이력서 삭제⭕
     */
    @Override
    public int delete(int cvNo) throws Exception {
        int result = resumeMapper.delete(cvNo);
        return result;
    }

    // 회원번호로 이력서 조회 ⭕
    @Override
    public Resume selectCV(int user_no) throws Exception {
        Resume resume = resumeMapper.selectCV(user_no);
        return resume;
    }

    // ⭕
    @Override
    public int maxPk() throws Exception {
        
        int maxPk = resumeMapper.maxPk();
        return maxPk;
    }


  //파일 업로드 service impl 만들기
  //썸네일
  @Override
  public int FileUpdate (Resume resume) throws Exception {
    String parentTable = "resume";
    int parentNo = resumeMapper.max();

    System.out.println("이미지 파일 : " + resume.getThumbnail());
    System.out.println("파일 : " + resume.getFile());

    //이미지 파일 업로드 = 1
    MultipartFile thumbnailFile = resume.getThumbnail();
    if (thumbnailFile != null && !thumbnailFile.isEmpty()) {
        Files thumbnail = new Files();
    }
  }

}
