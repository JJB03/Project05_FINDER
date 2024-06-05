package com.finder.project.main.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finder.project.recruit.mapper.RecruitMapper;

@RestController
public class SearchController {

    @Autowired
    RecruitMapper recruitMapper;

    @GetMapping("/search")
    public List<String> searchItems(@RequestParam String query) {
        // 실제로는 DB에서 데이터를 필터링하여 가져옵니다.
        
        

        List<String> allItems = recruitMapper.selectCompanyNameList();

        // query를 사용하여 필터링
        return allItems.stream()
                .filter(item -> item.toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}