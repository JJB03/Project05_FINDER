package com.finder.project.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.finder.project.company.dto.Company;
import com.finder.project.user.dto.UserAuth;
import com.finder.project.user.dto.Users;
import com.finder.project.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public boolean login(Users user) throws Exception {
        // // 💍 토큰 생성
        String username = user.getUserId();    // 아이디
        String password = user.getUserPw();    // 암호화되지 않은 비밀번호
        UsernamePasswordAuthenticationToken token 
            = new UsernamePasswordAuthenticationToken(username, password);
        
        // 토큰을 이용하여 인증
        Authentication authentication = authenticationManager.authenticate(token);

        // 인증 여부 확인
        boolean result = authentication.isAuthenticated();

        // 시큐리티 컨텍스트에 등록
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return result;
    }

    @Override
    public Users select(String username) throws Exception {
        Users user = userMapper.select(username);
        return user;
    }

    // 사용자 권한 등록
    @Override
    public int join(Users user) throws Exception {
        String username = user.getUserId();
        String password = user.getUserPw();
        String encodedPassword = passwordEncoder.encode(password);  // 🔒 비밀번호 암호화
        user.setUserPw(encodedPassword);

        // 회원 등록
        int result = userMapper.join(user);

        if( result > 0 ) {
            // 회원 기본 권한 등록
            // USER 조회 ->  userNo 가져오기
            Users joinedUser = userMapper.select(username);
            int userNo = joinedUser.getUserNo();

            UserAuth userAuth = new UserAuth();
            userAuth.setUserNo(userNo);
            userAuth.setAuth("ROLE_USER");
            result = userMapper.insertAuth(userAuth);
        }
        return result;
    }

    // 기업 권한 등록
    // @Override
    // public int comJoin(Users user, Company company) throws Exception {
    //     String username = user.getUserId();
    //     String password = user.getUserPw();
    //     String encodedPassword = passwordEncoder.encode(password);  // 🔒 비밀번호 암호화
    //     user.setUserPw(encodedPassword);

    //     // 회원 등록
    //     int result = userMapper.comJoin(user,company);

    //     // 여기 까지 문제 없음 ~!~!~!~!~!---------------
    //     if( result > 0 ) {
    //         // 기업 권한 등록
    //         // USER 조회 ->  userNo 가져오기
    //         Users joinedUser = userMapper.select(username);
    //         int userNo = joinedUser.getUserNo();

    //         UserAuth userAuth = new UserAuth();
    //         userAuth.setUserNo(userNo);
    //         userAuth.setAuth("ROLE_COMPANY");
    //         result = userMapper.insertAuth(userAuth);
    //     }
    //     return result;
    // }



    @Override
    public int update(Users user) throws Exception {
        int result = userMapper.update(user);
        return result;
    }

    @Override
    public int insertAuth(UserAuth userAuth) throws Exception {
        int result = userMapper.insertAuth(userAuth);
        return result;
    }
    
}