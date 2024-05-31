package com.finder.project.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finder.project.company.dto.Company;
import com.finder.project.company.dto.CompanyDetail;
import com.finder.project.company.mapper.CompanyMapper;
import com.finder.project.user.dto.Users;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;


    // 기업 상세 정보 조회 (기업 소개)
    @Override
    public CompanyDetail selectCompanyDetail(int no) throws Exception {
        CompanyDetail companyDetail = companyMapper.selectCompanyDetail(no);
        return companyDetail;
    }
    // 기업 상세 정보 등록 (기업 소개)
    @Override
    public int insertCompanyDetail(CompanyDetail companyDetail) throws Exception {
        int result = companyMapper.insertCompanyDetail(companyDetail);

        return result;
    }
    // 기업 상세 정보 수정 (기업 소개)
    @Override
    public int updateCompanyDetail(CompanyDetail companyDetail) throws Exception {
        int result = companyMapper.updateCompanyDetail(companyDetail);

        return result;
    }




    // 기업 정보 조회 (기업 정보)
    @Override
    public Company selectCompanyByComNo(int no) throws Exception {
        Company company = companyMapper.selectCompanyByComNo(no);
        return company;
    }
    // 기업 정보 등록 (기업 정보)
    @Override
    public int insertCompany(Company company) throws Exception {
        int result = companyMapper.insertCompany(company);
        return result;
    }
    // 기업회원 정보 수정 (기업 정보)
    @Transactional
    @Override
    public int updateUserComInfo(Users user, Company company) throws Exception {
        int resultUserCom = companyMapper.updateUserCom(user);
        int resultCompany = companyMapper.updateCompanyAddress(company);
        return resultUserCom + resultCompany;
    }



    // 비밀번호 변경
    @Override
    public int updateUserPw(Users user) throws Exception {
        int result = companyMapper.updateUserPw(user);
        return result;
    }

    




    // 쌤이랑 한거 userNo로 company 가져오기, comNo 으로 companyDetail 가져오기
    @Override
    public Company selectByUserNo(int userNo) {
        Company company = companyMapper.selectByUserNo(userNo);
        return company;
    }
    @Override
    public CompanyDetail selectCompanyDetailByComNo(int comNo) {
        CompanyDetail companyDetail = companyMapper.selectCompanyDetailByComNo(comNo);
        return companyDetail;
    }


}
