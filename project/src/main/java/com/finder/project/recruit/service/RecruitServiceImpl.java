package com.finder.project.recruit.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finder.project.main.dto.Files;
import com.finder.project.main.service.FileService;
import com.finder.project.recruit.dto.Keyword;
import com.finder.project.recruit.dto.RecruitPost;
import com.finder.project.recruit.mapper.RecruitMapper;
import com.finder.project.user.dto.Users;

import groovy.util.logging.Slf4j;

@Slf4j
@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    RecruitMapper recruitMapper;

    @Autowired
    FileService fileService;
    
    // 채용공고 List
    @Override
    public List<RecruitPost> recruitList() throws Exception {
        List<RecruitPost> recruitList = recruitMapper.recruitList();
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + recruitList);
        return recruitList;
    } 

    // 채용공고 등록 & keyword 등록
    @Override
    public int recruitPost(RecruitPost recruitPost) throws Exception {
        
        int result = recruitMapper.recruitPost(recruitPost);
        int recruitNo = recruitMapper.max();

        if( recruitNo == 0 ) return 0;
        recruitPost.setRecruitNo(recruitNo);

        for (String keyword : recruitPost.getKeyword()) {
            Keyword k = new Keyword();
            k.setRecruitKeyword(keyword);
            k.setRecruitNo(recruitNo);
            recruitMapper.recruitKeyword(k);     
        }

        String parentTable = "recruit";
        int parentNo = recruitMapper.max();
        

        System.out.println("겟파일 "+ recruitPost.getFile());
        System.out.println("겟파일 "+ recruitPost.getThumbnail());
        // 썸네일 업로드
        // - 부모테이블, 부모번호, 멀티파트파일, 파일코드:1(썸네일)
        MultipartFile thumbnailFile = recruitPost.getThumbnail();
        if (thumbnailFile != null && !thumbnailFile.isEmpty()) {
            
            Files thumbnail = new Files();
            thumbnail.setFile(thumbnailFile);
            thumbnail.setParentTable(parentTable);
            thumbnail.setParentNo(parentNo);
            thumbnail.setFileCode(1);
            
            fileService.upload(thumbnail);      // 썸네일 파일 업로드
        }

        // 첨부파일 업로드
        List<MultipartFile> fileList = recruitPost.getFile();
        if( fileList != null && !fileList.isEmpty() ) {
            for (MultipartFile file : fileList) {
                if( file.isEmpty() ) continue;

                // 파일 정보 등록
                Files uploadFile = new Files();
                uploadFile.setParentTable(parentTable);
                uploadFile.setParentNo(parentNo);
                uploadFile.setFile(file);
                

                fileService.upload(uploadFile);

            }
        }
        
        return result;
    }

    // 채용공고 상세조회
    @Override
    public RecruitPost recruitRead(int recruitNo) throws Exception {
        RecruitPost recruitPost = recruitMapper.recruitRead(recruitNo);


        return recruitPost;
    }    
    // 채용공고 상세조회 끝

    // 등록 한 채용공고 목록
    @Override
    public List<RecruitPost> postsRecruitList(int comNo) throws Exception {
        
        List<RecruitPost> postsRecruitList = recruitMapper.postsRecruitList(comNo);

        return postsRecruitList;
    }

    // 등록 한 채용공고 조회
    @Override
    public RecruitPost postsRecruitRead(int recruitNo) throws Exception {
        RecruitPost recruitPost = recruitMapper.postsRecruitRead(recruitNo);
        return recruitPost;
    }

    @Override
    public int deleteRecruitList(int recruitNo) throws Exception {
        int result = recruitMapper.deleteRecruitList(recruitNo);
        
        return result;
    }

    // 등록 한 채용공고 키워드 삭제 후 수정
    @Override
    public int updateRecruitRead(RecruitPost recruitPost) throws Exception {
        int recruitNo = recruitPost.getRecruitNo();

        
        int result2 = recruitMapper.deleteKeyword(recruitNo);
        for (String keyword : recruitPost.getKeyword()) {
            Keyword k = new Keyword();
            k.setRecruitKeyword(keyword);
            k.setRecruitNo(recruitNo);
            recruitMapper.recruitKeyword(k);     
        }

        int result = recruitMapper.updateRecruitRead(recruitPost);

        return result;
    }

   
   
    @Override
    public List<RecruitPost> selectRecruitsByNos(List<Integer> recruitNos) {
        // TODO Auto-generated method stub
        return recruitMapper.selectRecruitsByNos(new ArrayList<>(recruitNos));
    }

    
    
     

    
}
