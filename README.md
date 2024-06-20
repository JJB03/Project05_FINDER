![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/a669e595-187c-4f86-a757-8575ef004aeb)# 프로젝트: FINDER

[시연영상](유튜브)
 
## 목차
### 1. 프로젝트 개요
  - 프로젝트 주제
  - 주제 선정 배경
  - 기획 의도
  - 활용방안 및 기대효과
### 2. 프로젝트 구조
  - 주요 기능
  - Menu Structure
  - Project Structure
  - Flow Chart
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
### 6. REST Architecture로 전환
  - 대표 컨트롤러 코드 비교 및 설명
### 7. 핵심기능 코드 리뷰
  - 기능 목표
  - QR코드 생성 및 처리과정
  - 개선 할 점
### 8. 자체 평가 의견
  - 개별 평가
  - 종합 평가

# 1. 프로젝트 개요
## 1-1. 프로젝트 주제
- 인공지능으로 더욱 효율적인 인재 채용을 위한 AI 이력서 평가 구인구직 사이트!



## 1-2. 주제 선정 배경
- 직장을 구하고자 하는 사람들에게는 간편한 구직 사이트, 기업에게는 채용의 편리성을 제공하는 사이트를 만들고자 주제를 선정하였습니다!



## 1-3. 기획의도
1, 채용 프로세스의 비효율성
현재 많은 기업들이 인재 채용 과정에서 많은 시간과 자원을 소모하고 있습니다. 
수많은 이력서를 검토하고, 후보자들을 선별하는 과정에서 인사 담당자들은 큰 부담을 느끼고 있습니다. 이러한 비효율성을 개선하기 위해 인공지능을 도입하게 되었습니다

2, 인재 채용의 공정성과 다양성을 증대
기존의 채용 방식에서는 종종 편견과 주관이 개입될 수 있지만, AI를 활용하면 보다 객관적이고 공정한 채용 프로세스를 구축할 수 있습니다.


## 1-4. 활용 방안 및 기대효과
1, AI를 활용하여 지원자의 역량과 적합도를 객관적으로 평가하는 도구를 제공합니다.
 이를 통해 기업은 보다 공정하고 정확한 기준으로 지원자를 빠르게 평가할 수 있습니다.

2, AI 알고리즘은 다양한 배경과 역량을 가진 인재들을 공정하게 평가하여, 모든 지원자들이 동등한 기회를 가질 수 있도록 합니다. 
이를 통해 기업은 다양한 인재를 채용할 수 있는 환경을 조성할 수 있습니다.

구직자는 1차 서류 합격의 경우 메시지나 메일을 확인하지 않아도
웹사이트 자체에서 합격 여부를 확인할 수 있어 직접 찾아봐야 하는 수고를 줄여줍니다!


# 2. 프로젝트 구조
## 2-1. 주요기능
- 사용자
  - 회원가입
  - 로그인/로그아웃
  - 마이페이지
  - 이력서
   
- 관리자
  - 회원가입
  - 로그인/로그아웃
  - 마이페이지
  - 채용공고
  - 결제
  - 제출된 이력서
  - AI 간편 평가
     
- 채용공고 게시판
  - 채용공고 조회 정보 제공
  - 이미 만든 이력서로 바로 지원하기 기능 제공

## 2-2. Menu Structure
<details>
<summary><h3>Menu Structure 👆</h3></summary>
<div markdown="1">


</div>
</details>

## 2-3. Flow Chart
<details>
<summary><h3>Flow Chart 👆</h3></summary>
<div markdown="1">


</div>
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

 
# 4. 프로젝트 수행절차 및 방법
## 4-1. 프로젝트 수행 절차
- 2024-05-16 ~ 2023-06-12
![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/cd51476b-e8b6-4cd6-bddb-bbc4fe1e2fa7)



## 4-2. 수행 방법
- 사용 언어와 협업툴
![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/1df705e2-0851-469d-a4a1-7ddedd9522e4)


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
 ![image](https://github.com/JJB03/Project05_FINDER/assets/160222162/aeddf1b0-099b-4f05-a9e8-6e68b7360413)


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
<summary><h3>예매 서비스 👆</h3></summary>
<div markdown="1">


</div>
</details>

----

<details>
<summary><h3>게시판 👆</h3></summary>
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
<summary><h3>예매 서비스 👆</h3></summary>
<div markdown="1">


</div>
</details>

----

<details>
<summary><h3>게시판 👆</h3></summary>
<div markdown="1">

</div>
</details>


----

# 6. REST Architecture로 전환
<details>
<summary><h3>대표 컨트롤러 코드 비교 및 설명 👆</h3></summary>
<div markdown="1">

</div>
</details>


# 7. 핵심기능 코드 리뷰
## 7-1. 기능목표
### 탑승권을 QR 코드의 형태로 제공하여 관리자가 편리하게 업무(사용자 탑승권 탑승 처리)를 볼 수 있도록 함



## 7-2. QR코드 생성 및 처리과정
### QR코드 생성 : 항공권 결제 완료 → 티켓 번호 발급 → QR 코드 생성
<details>
<summary><h3>QR코드 생성 👆</h3></summary>
<div markdown="1">


</div>
</details>

----

### QR코드 처리 : QR 코드 인식 →  탑승권 처리 페이지로 연결 → 해당 티켓 번호에 대한 탑승권 조회 → 탑승 처리 완료 → QR 코드 삭제
<details>
<summary><h3>QR코드 처리 👆</h3></summary>
<div markdown="1">


</div>
</details>

----

## 7-3. 개선 할 점
- 
  - 



# 8. 자체 평가 의견
## 8-1. 개별 평가
- 홍준범
  - 
- 유상준
  - 
- 정주빈
  -   
- 백승헌
  -   

## 8-2. 종합 평가

### 한계점
- 


### 개선점
- 


### 문제해결방법
- 


## 참조
- 
- 
