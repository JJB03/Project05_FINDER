package com.finder.project.company.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.finder.project.company.dto.Company;
import com.finder.project.company.dto.CompanyDetail;

@Mapper
public interface CompanyMapper {


    // 기업 상세 정보 조회 (기업 소개)
    public CompanyDetail selectCompanyDetail(int comInfoNo) throws Exception;

    // 기업 상세 정보 등록 (기업 소개)
    public int insertCompanyDetail(CompanyDetail companyDetail) throws Exception;

    // 기업 상세 정보 수정 (기업 소개)
    public int updateCompanyDetail(CompanyDetail companyDetail) throws Exception;

    // 기업 상세 정보 삭제는 없음 (기업 소개)

    

    // // 기업 정보 조회 (기업 정보)
    public Company selectCompanyById(int comNo) throws Exception;

    // // 기업 정보 조회 (기업 정보)
    public int insertCompany(Company company) throws Exception;

    // // 기업 정보 조회 (기업 정보)
    public int updateCompany(Company company) throws Exception;

    // // 기업 정보 삭제는 없음 (기업 정보)
}

