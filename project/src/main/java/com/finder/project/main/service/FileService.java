package com.finder.project.main.service;

import java.util.List;

import com.finder.project.main.dto.File;


public interface FileService {
    //파일 목록
    public List<File> list() throws Exception;

    //파일 조회
    public File select(int fileNo) throws Exception;

    //파일 등록
    public int insert(File file) throws Exception;

    //파일 수정
    public int update(File file) throws Exception;

    //파일 삭제
    public int delete(int fileNo) throws Exception;

    //파일 목록 - 부모기준
    public List<File> listByParent(File file) throws Exception;
    
    // 파일 삭제 - 부모 기준
    public int deleteByParent(File file) throws Exception;

    //파일 업로드
    public boolean upload(File file) throws Exception;

    //파일 다운로드
    public File downFile(int fileNo) throws Exception;
}
