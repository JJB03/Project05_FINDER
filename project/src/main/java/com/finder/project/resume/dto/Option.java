package com.finder.project.resume.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 검색 옵션
 * - keyword    : 검색어
 * - code       : 옵션 코드
 * * 0 : 전체
 * * 1 : 제목
 * * 2 : 내용
 * * 3 : 제목+내용
 * * 4 : 작성자
 */
@Data
@AllArgsConstructor     // 모든 매개변수를 가지고 있는 생성자 생성
public class Option {
    String keyword;
    int code;
    
    public Option() {
        this.keyword = "";        
    }
    

}

