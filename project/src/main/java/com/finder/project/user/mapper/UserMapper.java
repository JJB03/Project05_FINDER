package com.finder.project.user.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finder.project.company.dto.Company;
import com.finder.project.user.dto.UserAuth;
import com.finder.project.user.dto.Users;

@Mapper
public interface UserMapper {

    // 로그인
    public Users login(String username) throws Exception;

    // 회원 조회
    public Users select(String username) throws Exception;

    // 회원 가입
    public int join(Users user) throws Exception;

    // 기업 회원 가입 
    public int comJoin(Company company) throws Exception;

    // 회원 수정
    public int update(Users user) throws Exception;

    // 회원 권한 등록
    public int insertAuth(UserAuth userAuth) throws Exception;

    // 권한 업데이트 
    // public int updateAuth(UserAuth userAuth) throws Exception;

    public int max() throws Exception;


    // 아이디 비번 찾기 하는중
    
    // 아이디 찾기
    public String findId(Users user) throws Exception;

    // 비밀번호 찾기
    public Users findPw(@Param("id") int id, @Param("username") String username, @Param("email") String email) throws Exception;
 
    // 비밀번호 수정하기
    public int updatePw(@Param("id") int id, @Param("password") String password) throws Exception;



}