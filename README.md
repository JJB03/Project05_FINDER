

[시연영상](유튜브)
 
## 목차
### 1. 프로젝트 개요
  - 프로젝트 주제
  - 주제 선정 배경
  - 기획 의도
  - 활용방안 및 기대효과
### 2. 프로젝트 구조
  - 주요 기능 요약
  - 메뉴 구조도
### 3. 프로젝트 팀 구성 및 역할
### 4. 프로젝트 수행절차 및 방법
  - 수행 절차
  - 수행 방법
### 5. 프로젝트 수행 경과
  - 요구사항 정의서
  - 기능 정의서
  - ERD
  - 테이블 정의서
  - 화면 설계서
  - 프로젝트 실제 화면 UI
### 6. 자체 평가 의견
  - 개별 평가
  - 종합 평가


# 1. 프로젝트 개요
## 1-1. 프로젝트 주제
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/9bc0d384-969a-4862-9e72-8ecece3c78f0)


## 1-2. 주제 선정 배경
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/84df17d6-6acf-469a-9e07-7c33e05f6316)


## 1-3. 기획의도
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/87d9328c-2652-493e-8a25-0a85d458491f)


## 1-4. 활용 방안 및 기대효과
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/4f347318-04d9-4af9-ad58-ceb6201f7ef2)


# 2. 프로젝트 구조
## 2-1. 주요기능

- 공통 ( 회원가입 / 로그인 / 로그아웃 / 마이페이지 / 채용공고 조회 )
- 일반회원 ( 이력서 작성 / 채용공고 지원 / 합불 여부 확인 )
- 기업회원 ( 결제 / 채용공고 작성 / 제출된 이력서 조회 / AI 간편 평가 / 합불 평가 )


![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/f38e061a-ec14-4522-b9cc-59ec80d511cc)


## 2-2. 메뉴 구조도
<details>
<summary><h3>Site Map 👆</h3></summary>

![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/2053216c-af3c-4e67-b7aa-8c00db307e63)
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/01fa1cf7-4013-4daa-a5ec-77089715afe4)
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/a57221e7-51d5-4570-b3d0-1bfd022bcc61)
</details>


# 3.프로젝트 팀 구성 및 역할
- 인원 : 4명
- 홍준범
  - 주요 담당
   - OPEN AI API를 이용한 이력서 평가
   - 연관 검색어 AJAX 비동기 처리
   - 파일 업로드 및 AJAX 비동기 처리
   - 전체적인 UI 디자인
   - ERD 설계
   - 프로젝트 설계 및 DB 구축
   
- 유상준
  - 주요 담당
   - SpringBoot에 있는 Email인증 API
   - 회원가입
   - 아이디/비밀번호 찾기
   - 비밀번호 재확인
   - 자동로그인 및 아이디 저장
   - 간편한 로그인을 위한 Kakao로그인 API
 
- 정주빈
  - 주요 담당
   - 구직자작성 이력서
   - 구직자수정 이력서
   - 기업확인 이력서
   - 기업 - 구직자 1차 서류 합격발표 연결
   - 비동기 경력,학력 데이터 삽입  및 삭제
   - 비동기 파일 썸네일, 문서 삽입
    
- 백승헌
  - 주요 담당
   - 기업 결제를 위한 토스 페이먼츠 결제모듈 API
   - 개인정보 수정
   - 비밀번호 변경
   - 기업 소개
   - 프로젝트 설계 및 DB 구축

![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/02617f5f-6b63-48f7-a314-0d97dd6c66e6)
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/fcd3081b-4a7b-46cd-b9aa-34b827c21433)


 
# 4. 프로젝트 수행절차 및 방법
## 4-1. 프로젝트 수행 절차
2024-05-16 ~ 2023-06-12
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/cb041109-5d15-4173-a62b-efb2038a7305)



## 4-2. 수행 방법
사용 언어와 협업툴
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/7f89dc68-61f7-4578-8dad-15008387628f)



# 5. 프로젝트 수행 경과
## 5-1. 요구사항 정의서
<details>
<summary><h3>요구사항 정의서 👆</h3></summary>
 
![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/3e10d519-e56a-4d52-812a-7e3defede2b0)
</details>

 ## 5-2. 기능 정의서
<details>
<summary><h3>기능 정의서 👆</h3></summary>
<h5>사용자</h5>
 
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/73dfe6ea-1a29-49ea-ac52-068bc502563a)

<h5>기업</h5>

![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/83fa3dbd-b8e4-4e21-9d08-2b5beefefc30)
<h5>API</h5>

![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/c53a93c8-5996-4ab6-b544-00a8fa5100b5)
</details>

## 5-3. ERD
<details>
<summary><h3>ERD 👆</h3></summary>
 
![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/815f99ba-d9fe-478b-8ae2-639c9e94b3d5)
</details>

## 5-4. 테이블 정의서
<details>
<summary><h3>테이블 정의서 👆</h3></summary>
 
![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/8ac77214-3e01-4e8d-ba24-1d4df2c68f65)
![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/7d19637f-86a3-4ce1-9ee5-3293d9beced4)
</details>

## 5-5. 화면 설계서
<details>
<summary><h3>일반회원 👆</h3></summary>
<div markdown="1">




</div>
</details>

----

<details>
<summary><h3>기업회원 👆</h3></summary>
<div markdown="1">


</div>
</details>

----



## 5-6. 프로젝트 실제 화면 UI

<details>
<summary><h3>사용자 👆</h3></summary>
<div markdown="1">


</div>
</details>

----

<details>
<summary><h3>관리자 👆</h3></summary>
<div markdown="1">


</div>
</details>

----

<details>
<summary><h3>AI 간편 평가 👆</h3></summary>
<div markdown="1">


</div>
</details>

----




# 6. 자체 평가 의견
## 6-1. 개별 평가
- 홍준범
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/c7e9ea99-3009-4f41-a563-c23f657175ec)

- 유상준
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/e2d5effe-4585-4b38-ba16-daffd2f0aeaa)

- 정주빈
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/e0980c87-4122-4712-8eea-4d84a4f367a9)
   
- 백승헌
![image](https://github.com/JJB03/Project05_FINDER/assets/121448554/52ae0ee8-ef9f-4980-acb6-f08cd2dd2875)



  

## 6-2. 종합 평가

### 한계점
- 무리한 기획으로 인한 시간소요. 커뮤니티 기능, 네이버, 구글 소셜 로그인을 
시간부족으로 인해 구현 X

### 개선점
- ERD 설계의 아쉬움. 테이블 다중 조인이 자주 필요했음. 개별 도메인에 메인 기능이 없어, 서브 기능에 주객이 전도됨. 프론트 작업시간이 생각 이상으로 소요. 백-엔드 작업의 시간 부족.

### 문제해결방법
- 처음 기획에서, 규모를 미리 파악하고 설계해서 메인 기능을 우선시하여 설정한 다음 늘리는 방향으로 개발.설계 시 단계별 어느정도 시간을 할애할지 정하고, 여분의 시간에 못한 부분을 보충하는 방식을 채택.





## 참조
- 
- 
