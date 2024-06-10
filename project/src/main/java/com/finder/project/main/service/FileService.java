package com.finder.project.main.service;

import java.util.List;

import com.finder.project.main.dto.Files;


public interface FileService {
    //파일 목록
    public List<Files> list() throws Exception;

    //파일 조회
    public Files select(int fileNo) throws Exception;

    //cv_no 로 파일 조회
    public Files selectByCvNo(int cvNo) throws Exception;

    //파일 등록
    public int insert(Files file) throws Exception;

    //파일 수정
    public int update(Files file) throws Exception;

    //파일 삭제
    public int delete(int fileNo) throws Exception;

    //파일 목록 - 부모기준
    public List<Files> listByParent(Files file) throws Exception;

    //파일 조회 - 썸네일 [RECRUIT]
    public Files listByParentThumbnail(Files file) throws Exception;
   
    //파일 조회 - 썸네일 [CV]
    public Files listByCVParentThumbnail(Files file) throws Exception;
    
    // 파일 삭제 - 부모 기준
    public int deleteByParent(Files file) throws Exception;

    //파일 업로드
    public boolean upload(Files file) throws Exception;

    //파일 다운로드
    public Files downFile(int fileNo) throws Exception;

    // 파일 번호 최댓값
    public int maxPk() throws Exception;

}
