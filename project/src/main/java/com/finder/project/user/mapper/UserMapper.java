package com.finder.project.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    // 기업 비밀번호 찾기
    @Select("SELECT * FROM company WHERE com_name = #{comName}")
    public Company getComName(String comName) throws Exception;

    // 아이디 찾기
    public String findId(Users user) throws Exception;

    // 사용자 비밀번호 찾기
    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    public Users findUserById(String userId) throws Exception;
 
    // 비밀번호 수정하기
    public int updatePw(Users userPw) throws Exception;

    // 이메일 코드 받아오기



}