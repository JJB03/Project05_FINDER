-- Active: 1716818238004@@127.0.0.1@3306@finder


-- 테이블 삭제 ( 총 15개 )

-- 메일인증 테이블
DROP TABLE IF EXISTS mail;

-- 썸네일 테이블
DROP TABLE IF EXISTS thumbnail;

-- 권한 테이블
DROP TABLE IF EXISTS user_auth;

-- 메일인증 실험 테이블
DROP TABLE IF EXISTS email_verification;
-- 경력사항 테이블
DROP TABLE IF EXISTS employment_history;
-- 지원내역 테이블
DROP TABLE IF EXISTS apply_employee;

-- 학력 테이블
DROP TABLE IF EXISTS education;

-- 채용공고 키워드 테이블
DROP TABLE IF EXISTS recruit_keyword;

-- 채용공고 게시글 테이블
DROP TABLE IF EXISTS recruit;
-- 이력서 테이블
DROP TABLE IF EXISTS cv;

-- 기업 상세 정보 테이블
DROP TABLE IF EXISTS company_detail;
-- 기업 테이블
DROP TABLE IF EXISTS company;

-- 결제내역 테이블
DROP TABLE IF EXISTS credit;
-- 주문 테이블
DROP TABLE IF EXISTS `order`;
-- 회원 테이블
DROP TABLE IF EXISTS user;

-- 파일 테이블
DROP TABLE IF EXISTS file;

-- 상품 테이블
DROP TABLE IF EXISTS product;

-- 소셜 테이블
DROP TABLE IF EXISTS user_social;

-- 테이블 생성 ( 총 16개 )

-- 메일 인증 실험 테이블

CREATE TABLE IF NOT EXISTS persistent_logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) PRIMARY KEY,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL
);

CREATE TABLE email_verification (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    verification_code VARCHAR(255) NOT NULL
);

-- 소셜 테이블
CREATE TABLE user_social (
    `ID` CHAR(36) NOT NULL,
    `USERNAME` VARCHAR(100),
    `PROVIDER` VARCHAR(50),
    `SOCIAL_ID` VARCHAR(255),
    `NAME` VARCHAR(100),
    `EMAIL` VARCHAR(200),
    `PICTURE` TEXT DEFAULT NULL,
    `CREATED_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `UPDATED_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`ID`)
);

-- 회원 테이블
-- CREATE TABLE `user` (
--     `user_no` int NOT NULL AUTO_INCREMENT,
--     `user_name` varchar(500) NOT NULL,
--     `user_id` varchar(500) NOT NULL,
--     `user_pw` varchar(500) NOT NULL,
--     `user_before_pw` varchar(500) NULL,
--     `user_birth` varchar(50) NOT NULL,
--     `user_phone` varchar(50) NOT NULL,
--     `user_email` varchar(500) NOT NULL,
--     `user_reg_date` timestamp NOT NULL DEFAULT now(),
--     `user_upd_date` timestamp NULL DEFAULT now(),
--     `user_gender` enum('남자', '여자') NOT NULL,
--     `ENABLED` int DEFAULT 1,
--     PRIMARY KEY (`user_no`)
-- );

-- INSERT INTO user (user_name, user_id, user_pw, user_birth, user_phone, user_email, user_gender)
-- VALUES ('John Doe', 'johndoe', 'password', '1990-01-01', '010-1234-5678', 'johndoe@example.com', '남자');
CREATE TABLE `user` (
    `user_no` int NOT NULL AUTO_INCREMENT,
    `user_name` varchar(500),
    `user_id` varchar(500),
    `user_pw` varchar(500),
    `user_before_pw` varchar(500),
    `user_birth` varchar(50),
    `user_phone` varchar(50),
    `user_email` varchar(500),
    `user_reg_date` timestamp NOT NULL DEFAULT now(),
    `user_upd_date` timestamp NULL DEFAULT now(),
    `user_gender` enum('남자', '여자'),
    `ENABLED` int DEFAULT 1,
    PRIMARY KEY (`user_no`)
);

-- 권한 테이블
CREATE TABLE `user_auth` (
    `auth_no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `auth` varchar(500) NULL,
    `user_no` int NOT NULL,
    FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`)
);

-- 이력서 테이블
CREATE TABLE `cv` (
    `cv_no` int NOT NULL AUTO_INCREMENT,
    `user_no` int NOT NULL,
    `cover_letter` text NULL,
    `cv_title` VARCHAR(255) NULL,
    `cv_reg_date` timestamp NOT NULL DEFAULT now(),
    `cv_upd_date` timestamp NULL DEFAULT now(),
    PRIMARY KEY (`cv_no`),
    FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`)
);

-- 경력사항 테이블
CREATE TABLE `employment_history` (
    `employment_history_no` int NOT NULL AUTO_INCREMENT,
    `cv_no` int NOT NULL,
    `organization` varchar(500) NULL,
    `start_date` DATE NULL,
    `end_date` DATE NULL,
    `duties` varchar(500) NULL,
    PRIMARY KEY (`employment_history_no`),
    FOREIGN KEY (`cv_no`) REFERENCES `cv` (`cv_no`)
);

-- 학력 테이블
CREATE TABLE `education` (
    `education_no` int NOT NULL AUTO_INCREMENT,
    `cv_no` int NOT NULL,
    `university` varchar(500) NULL,
    `major` varchar(500) NULL,
    `university_status` varchar(500) NULL,
    PRIMARY KEY (`education_no`),
    FOREIGN KEY (`cv_no`) REFERENCES `cv` (`cv_no`)
);

-- 기업 테이블
CREATE TABLE `company` (
    `com_no` int NOT NULL AUTO_INCREMENT,
    `user_no` int NOT NULL,
    `com_name` varchar(500) NOT NULL,
    `com_category` varchar(500) NOT NULL,
    `com_address` varchar(500) NOT NULL,
    `com_business` varchar(500) NOT NULL,
    PRIMARY KEY (`com_no`),
    FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`)
);

-- 채용공고 게시글 테이블
CREATE TABLE `recruit` (
    `recruit_no` int NOT NULL AUTO_INCREMENT,
    `com_no` int NOT NULL,
    `recruit_title` varchar(500) NOT NULL,
    `recruit_content` text NOT NULL,
    `recruit_responsibilities` varchar(500) NULL,
    `recruit_qualifications` varchar(500) NULL,
    `recruit_preferred_qualifications` varchar(500) NULL,
    `recruit_reg_date` varchar(500) NOT NULL,
    `com_reg_date` timestamp NOT NULL DEFAULT now(),
    `com_upd_date` timestamp NULL DEFAULT now(),
    PRIMARY KEY (`recruit_no`),
    FOREIGN KEY (`com_no`) REFERENCES `company` (`com_no`)
);

-- 지원내역 테이블
CREATE TABLE `apply_employee` (
    `apply_no` int NOT NULL AUTO_INCREMENT,
    -- `apply_title` varchar(100) NOT NULL,
    -- `apply_date` timestamp NOT NULL DEFAULT now(),
    `check` int,
    `cv_no` int,
    `recruit_no` int,
    PRIMARY KEY (`apply_no`),
    FOREIGN KEY (`cv_no`) REFERENCES `cv` (`cv_no`),
    FOREIGN KEY (`recruit_no`) REFERENCES `recruit` (`recruit_no`)
);

-- 채용공고 키워드 테이블
CREATE TABLE `recruit_keyword` (
    `recruit_keyword_no` int NOT NULL AUTO_INCREMENT,
    `recruit_keyword` varchar(500) NOT NULL,
    `recruit_no` int NOT NULL,
    PRIMARY KEY (`recruit_keyword_no`),
    FOREIGN KEY (`recruit_no`) REFERENCES `recruit` (`recruit_no`) ON DELETE CASCADE
);

-- 파일 테이블
CREATE TABLE `file` (
    `file_no` INT NOT NULL AUTO_INCREMENT,
    `parent_table` VARCHAR(500) NOT NULL,
    `parent_no` INT NOT NULL,
    `file_name` VARCHAR(500) NULL,
    `origin_name` VARCHAR(500) NOT NULL,
    `file_path` VARCHAR(500) NOT NULL,
    `file_size` INT NOT NULL,
    `reg_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `upd_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `file_code` INT NOT NULL,
    PRIMARY KEY (`file_no`)
);

-- 기업 상세 정보 테이블
CREATE TABLE `company_detail` (
    `com_info_no` int NOT NULL AUTO_INCREMENT,
    `com_no` int NOT NULL,
    `com_represent` varchar(100) NOT NULL,
    `com_url` varchar(500) NULL,
    `com_birth` int NOT NULL,
    -- `com_size` enum('대기업','중견기업','중소기업') NOT NULL,
    `com_size` varchar(500) NOT NULL,
    `com_emp_count` int NOT NULL,
    `com_sales` int NOT NULL,
    `com_content` text NOT NULL,
    `com_vision` varchar(500) NULL,
    `com_welfare` varchar(500) NULL,
    `com_avg_salary` int NULL,
    PRIMARY KEY (`com_info_no`),
    FOREIGN KEY (`com_no`) REFERENCES `company` (`com_no`)
);

-- 상품 테이블
CREATE TABLE `product` (
    `product_no` int NOT NULL AUTO_INCREMENT COMMENT 'auto_increment',
    `product_name` varchar(100) NOT NULL,
    `product_count` int NOT NULL,
    `product_price` int NOT NULL,
    `product_duration` int NULL DEFAULT 0 COMMENT '개월수(ex)1,2,3,4,5)',
    PRIMARY KEY (`product_no`)
);

-- 주문 테이블
CREATE TABLE `order` (
    `order_no` int NOT NULL AUTO_INCREMENT,
    `user_no` int NOT NULL,
    `product_no` int NOT NULL,
    `total_quantity` int NOT NULL DEFAULT 1,
    `total_price` int NOT NULL DEFAULT 0,
    `order_status` ENUM(
        'PENDING',
        'PAID',
        'CANCELLED'
    ) NOT NULL DEFAULT 'PAID' COMMENT '결제대기,결제완료,주문취소',
    `ordered_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `expiration_date` DATE NULL COMMENT '상품 만료',
    `remain_quantity` int NULL COMMENT '채용공고 사용 가능 횟수',
    `access_order` int NOT NULL DEFAULT 1 COMMENT '1이면 주문접근불가, 0이면 접근가능', -- remain_quantity 가 0이면 0이 됨 
    PRIMARY KEY (`order_no`),
    FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`),
    FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`)
);

-- 결제내역 테이블
CREATE TABLE `credit` (
    `credit_no` INT NOT NULL AUTO_INCREMENT,
    `order_no` INT NOT NULL,
    `credit_method` varchar(500) NULL DEFAULT '간편결제',
    `credit_status` ENUM('PENDING', 'PAID', 'REFUND') NOT NULL DEFAULT 'PAID' COMMENT '결제대기,결제완료,환불',
    `credit_code` VARCHAR(500) NULL, -- 토스페이먼츠 order_id 랜덤 주문번호
    `credit_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`credit_no`),
    FOREIGN KEY (`order_no`) REFERENCES `order` (`order_no`)
);
--  유저 정보
INSERT INTO
    `user` (
        user_no,
        user_name,
        user_id,
        user_pw,
        user_before_pw,
        user_birth,
        user_phone,
        user_email,
        user_gender
    )
VALUES 
    (
        1,
        '홍준범',
        'user2',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        'password1234',
        '1990-02-02',
        '010-4512-8901',
        'janesmith@gmail.com',
        '남자'
    ),
    (
        2,
        '백승헌',
        'user3',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        'password1234',
        '1985-03-03',
        '010-4321-7754',
        'alicejohnson@gmail.com',
        '남자'
    ),
    (
        3,
        '정주빈',
        'user4',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        'password1234',
        '1975-04-04',
        '010-3421-7754',
        'bobbrown@naver.com',
        '여자'
    ),
    (
        4,
        '신준수',
        'user5',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        'password1234',
        '2000-05-05',
        '010-4332-7754',
        'charliedavis@naver.com',
        '남자'
    ),
    (
        5,
        '유상준',
        'user1',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        'password1234',
        '1980-01-01',
        '010-1153-1154',
        'johndoe@gmail.com',
        '남자'
    );

-- 유저 권한 정보
INSERT INTO
    user_auth (auth_no, user_no, auth)
VALUES (1, 1, 'ROLE_USER'),
    (2, 2, 'ROLE_USER'),
    (3, 3, 'ROLE_USER'),
    (4, 4, 'ROLE_USER'),
    (5, 5, 'ROLE_USER');

INSERT INTO
    cv (
        cv_no,
        user_no,
        cover_letter,
        cv_title,
        cv_reg_date,
        cv_upd_date
    )
VALUES 
    (
        1,
        1,
        '저는 Java를 주 언어로 사용하며, Spring 프레임워크를 활용한 웹 애플리케이션 개발에 능숙합니다. Spring Boot를 이용해 RESTful API를 설계하고 구현한 경험이 있으며, 프로젝트의 효율성을 높이기 위해 Spring Security를 통한 인증 및 권한 부여 기능을 구현하였습니다.

React를 이용한 프론트엔드 개발에도 능숙하여, 사용자 친화적인 UI/UX를 구현할 수 있습니다. React Hooks와 Context API를 활용하여 상태 관리를 효율적으로 처리하며, 다양한 컴포넌트를 재사용 가능한 형태로 설계하여 코드의 유지보수성을 높였습니다.

데이터베이스는 MySQL을 주로 사용하며, 효율적인 데이터 모델링과 복잡한 쿼리 작성에 자신이 있습니다. 인덱스 최적화와 쿼리 튜닝을 통해 성능을 향상시키고, 데이터 무결성을 유지하는 데 주력하고 있습니다.',
        'Java 애플리케이션 개발 전문가 - 홍준범',
        '2024-06-20 01:05:28',
        '2024-06-20 01:09:14'
    ),
    (
        2,
        2,
        '저는 Java를 주 언어로 사용하며, Spring 프레임워크를 활용한 웹 애플리케이션 개발에 능숙합니다. Spring Boot를 이용해 RESTful API를 설계하고 구현한 경험이 있으며, 프로젝트의 효율성을 높이기 위해 Spring Security를 통한 인증 및 권한 부여 기능을 구현하였습니다.

React를 이용한 프론트엔드 개발에도 능숙하여, 사용자 친화적인 UI/UX를 구현할 수 있습니다. React Hooks와 Context API를 활용하여 상태 관리를 효율적으로 처리하며, 다양한 컴포넌트를 재사용 가능한 형태로 설계하여 코드의 유지보수성을 높였습니다.

데이터베이스는 MySQL을 주로 사용하며, 효율적인 데이터 모델링과 복잡한 쿼리 작성에 자신이 있습니다. 인덱스 최적화와 쿼리 튜닝을 통해 성능을 향상시키고, 데이터 무결성을 유지하는 데 주력하고 있습니다.',
        'Java 애플리케이션 개발 전문가 - 백승헌',
        '2024-06-20 01:05:28',
        '2024-06-20 01:09:14'
    ),
    (
        3,
        3,
        '저는 Java를 주 언어로 사용하며, Spring 프레임워크를 활용한 웹 애플리케이션 개발에 능숙합니다. Spring Boot를 이용해 RESTful API를 설계하고 구현한 경험이 있으며, 프로젝트의 효율성을 높이기 위해 Spring Security를 통한 인증 및 권한 부여 기능을 구현하였습니다.

React를 이용한 프론트엔드 개발에도 능숙하여, 사용자 친화적인 UI/UX를 구현할 수 있습니다. React Hooks와 Context API를 활용하여 상태 관리를 효율적으로 처리하며, 다양한 컴포넌트를 재사용 가능한 형태로 설계하여 코드의 유지보수성을 높였습니다.

데이터베이스는 MySQL을 주로 사용하며, 효율적인 데이터 모델링과 복잡한 쿼리 작성에 자신이 있습니다. 인덱스 최적화와 쿼리 튜닝을 통해 성능을 향상시키고, 데이터 무결성을 유지하는 데 주력하고 있습니다.',
        'Java 애플리케이션 개발 전문가 - 정주빈',
        '2024-06-20 01:05:28',
        '2024-06-20 01:09:14'
    ),
    (
        4,
        4,
        '안녕하세요. 저는 아침에 한번 점심에 한번 저녁에 한번 똥을 쌉니다 지금도 너무 마려워요 ㅠ.ㅠ 힝... 뿡뿌부웁부국',
        '개발자가 되고싶어요!!! - 신준수',
        '2024-06-20 01:05:28',
        '2024-06-20 01:09:14'
    );



INSERT INTO
    file (
        file_no,
        parent_table,
        parent_no,
        file_name,
        origin_name,
        file_path,
        file_size,
        reg_date,
        upd_date,
        file_code
    )
VALUES (
        1,
        'resume',
        4,
        NULL,
        "이력서 사진.jpg",
        "C:/upload/9517227f-c906-4794-9e6f-6d88bb5373a7_준수 이력서 사진.jpg",
        3348217,
        "2024-06-20 01:19:40",
        "2024-06-20 01:19:40",
        1
    );

INSERT INTO
    `employment_history` (
        `cv_no`,
        `organization`,
        `start_date`,
        `end_date`,
        `duties`
    )
VALUES
    (
        4,
        'LG전자',
        '2016-06-10',
        '2017-12-20',
        '고객관리시스템 관리자'
    );

INSERT INTO
    `education` (
        `cv_no`,
        `university`,
        `major`,
        `university_status`
    )
VALUES 
    (4, '안조은대학교', '컴퓨터공학과', '학사');

INSERT INTO
    user (
        user_no,
        user_name,
        user_id,
        user_pw,
        user_birth,
        user_phone,
        user_email,
        user_gender,
        enabled
    )
VALUES (
        6,
        '홍준범 컴퍼니',
        'com',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        '19870101',
        '01012341234',
        'bsh@naver.com',
        '남자',
        2
    );

INSERT INTO user_auth (user_no, auth) VALUES (6, 'ROLE_COMPANY');
-- 기업권한
INSERT INTO user_auth (user_no, auth) VALUES (6, 'ROLE_USER');
-- 기업권한
-- 기업
INSERT INTO
    user (
        user_no,
        user_name,
        user_id,
        user_pw,
        user_birth,
        user_phone,
        user_email,
        user_gender,
        enabled
    )
VALUES (
        7,
        '삼성전자',
        'com1',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        '19880101',
        '01012341234',
        'bsh@naver.com',
        '남자',
        2
    );

INSERT INTO user_auth (user_no, auth) VALUES (7, 'ROLE_COMPANY');
-- 기업권한
INSERT INTO user_auth (user_no, auth) VALUES (7, 'ROLE_USER');
-- 기업권한
-- 기업
INSERT INTO
    user (
        user_no,
        user_name,
        user_id,
        user_pw,
        user_birth,
        user_phone,
        user_email,
        user_gender,
        enabled
    )
VALUES (
        8,
        '현대자동차그룹',
        'com2',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        '19890101',
        '01012341234',
        'bsh@naver.com',
        '남자',
        2
    );

INSERT INTO user_auth (user_no, auth) VALUES (8, 'ROLE_COMPANY');
-- 기업권한
INSERT INTO user_auth (user_no, auth) VALUES (8, 'ROLE_USER');
-- 기업권한
-- 기업
INSERT INTO
    user (
        user_no,
        user_name,
        user_id,
        user_pw,
        user_birth,
        user_phone,
        user_email,
        user_gender,
        enabled
    )
VALUES (
        9,
        'LG화학 ',
        'com3',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        '19900101',
        '01012341234',
        'bsh@naver.com',
        '남자',
        2
    );

INSERT INTO user_auth (user_no, auth) VALUES (9, 'ROLE_COMPANY');
-- 기업권한
INSERT INTO user_auth (user_no, auth) VALUES (9, 'ROLE_USER');
-- 기업권한
-- 기업
INSERT INTO
    user (
        user_no,
        user_name,
        user_id,
        user_pw,
        user_birth,
        user_phone,
        user_email,
        user_gender,
        enabled
    )
VALUES (
        10,
        '애플코리아',
        'com4',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        '19910101',
        '01012341234',
        'bsh@naver.com',
        '남자',
        2
    );

INSERT INTO user_auth (user_no, auth) VALUES (10, 'ROLE_COMPANY');
-- 기업권한
INSERT INTO user_auth (user_no, auth) VALUES (10, 'ROLE_USER');
-- 기업권한
-- 기업
-- 6번 HJB 주식회사
INSERT INTO
    company (
        com_no,
        com_name,
        com_category,
        com_address,
        com_business,
        user_no
    )
VALUES (
        6,
        'HJB 주식회사',
        '소프트웨어 및 기술',
        '서울특별시 강남구 역삼동 123번지',
        '소프트웨어 개발 및 컨설팅',
        6
    );

-- 7번 삼성전자
INSERT INTO
    company (
        com_no,
        com_name,
        com_category,
        com_address,
        com_business,
        user_no
    )
VALUES (
        7,
        '삼성전자',
        '전자 및 정보통신',
        '서울특별시 서초구 서초동 11-3',
        '전자 제품 제조 및 판매',
        7
    );

-- 8번 현대자동차
INSERT INTO
    company (
        com_no,
        com_name,
        com_category,
        com_address,
        com_business,
        user_no
    )
VALUES (
        8,
        '현대자동차',
        '자동차 제조',
        '서울특별시 양재동 231',
        '자동차 제조 및 판매',
        8
    );

-- 9번 LG화학
INSERT INTO
    company (
        com_no,
        com_name,
        com_category,
        com_address,
        com_business,
        user_no
    )
VALUES (
        9,
        'LG화학',
        '화학 및 소재',
        '서울특별시 영등포구 여의도동 20',
        '화학 제품 제조 및 판매',
        9
    );

-- 10번 애플코리아
INSERT INTO
    company (
        com_no,
        com_name,
        com_category,
        com_address,
        com_business,
        user_no
    )
VALUES (
        10,
        '애플코리아',
        '정보통신 및 기술',
        '서울특별시 강남구 삼성동 100',
        '전자 제품 및 소프트웨어 판매',
        10
    );

INSERT INTO
    company_detail (
        com_info_no,
        com_no,
        com_represent,
        com_url,
        com_birth,
        com_size,
        com_emp_count,
        com_sales,
        com_content,
        com_vision,
        com_welfare,
        com_avg_salary
    )
VALUES (
        1,
        6,
        '홍준범',
        'www.HJBdea.com',
        '2011',
        '대기업',
        4000,
        7000,
        '홍준범 대표가 2011년에 설립한 HJBdea는 최신 소프트웨어 기술 개발을 전문적으로 연구하는 회사입니다. 우리는 인공지능, 빅데이터, 클라우드 컴퓨팅 등의 최신 기술을 활용하여 혁신적인 소프트웨어 솔루션을 제공하고 있습니다. 다양한 산업 분야에서 우리의 소프트웨어는 고객의 비즈니스 효율성을 극대화하고 비용을 절감하는 데 기여하고 있습니다.',
        '우리의 비전은 전 세계가 사용할 만큼 관리하기 쉬운 소프트웨어를 개발하여 글로벌 소프트웨어 시장을 선도하는 리더가 되는 것입니다. 우리는 끊임없는 혁신과 품질 향상을 통해 고객에게 최고의 가치를 제공하고자 합니다.',
        '직원 복지를 위해 숙소 제공, 최신 노트북 지원, 자격증 취득 비용 지원 등의 혜택을 제공하고 있습니다. 또한, 사내 헬스케어 프로그램, 연 2회 전직원 해외 워크숍, 유연 근무제도 등의 다양한 복지 제도를 운영하고 있습니다.',
        7000
    );

INSERT INTO
    company_detail (
        com_info_no,
        com_no,
        com_represent,
        com_url,
        com_birth,
        com_size,
        com_emp_count,
        com_sales,
        com_content,
        com_vision,
        com_welfare,
        com_avg_salary
    )
VALUES (
        2,
        7,
        '김기현',
        'www.samsung.com',
        '1938',
        '대기업',
        287000,
        2360000,
        '삼성전자는 1938년에 설립된 세계를 선도하는 전자 및 정보통신 기술 기업입니다. 
    다양한 전자 제품을 제조 및 판매하며, 스마트폰, 반도체, 가전제품, 디스플레이, 네트워크 장비, 그리고 IoT 솔루션 등을 포함한 폭넓은 제품 라인업을 보유하고 있습니다. 
    지속적인 연구 개발과 혁신을 통해 새로운 기술을 도입하고 있으며, 전 세계 80개국 이상에 지사를 운영하여 글로벌 시장에서의 입지를 강화하고 있습니다. 
    삼성전자의 제품은 높은 품질과 성능으로 인정받고 있으며, 고객 만족을 최우선으로 하는 경영 철학을 바탕으로 다양한 사회적 책임 활동도 수행하고 있습니다.',
        '우리의 비전은 지속 가능한 혁신을 통해 사람들의 삶을 풍요롭게 하고, 글로벌 시장에서의 리더십을 강화하는 것입니다. 
    우리는 품질, 고객 중심의 경영, 사회적 책임을 바탕으로 미래를 준비하고 있습니다. 
    특히, 친환경 제품 개발과 지속 가능한 경영을 통해 환경 보호에도 기여하고 있습니다. 
    또한, 삼성전자는 디지털 전환을 가속화하여 4차 산업혁명 시대에 발맞춘 혁신적인 솔루션을 제공하고자 합니다.',
        '직원 복지를 위해 주택 자금 지원, 의료 지원, 교육 지원, 유연 근무제도 등의 다양한 혜택을 제공하고 있습니다. 
    또한, 글로벌 인재 양성을 위해 해외 파견 및 교육 프로그램도 운영하고 있습니다. 
    직원들은 사내 헬스케어 프로그램, 자녀 교육비 지원, 직무 관련 교육비 지원, 사내 카페테리아 및 피트니스 센터 이용 등의 혜택을 누릴 수 있습니다. 
    삼성전자는 직원의 워라밸(Work-Life Balance)을 중시하며, 유연 근무제도와 재택 근무를 적극적으로 도입하여 직원들의 삶의 질을 향상시키고 있습니다.',
        80000
    );

INSERT INTO
    company_detail (
        com_info_no,
        com_no,
        com_represent,
        com_url,
        com_birth,
        com_size,
        com_emp_count,
        com_sales,
        com_content,
        com_vision,
        com_welfare,
        com_avg_salary
    )
VALUES (
        3,
        8,
        '정의선',
        'www.hyundai.com',
        '1967',
        '대기업',
        120000,
        1170000,
        '현대자동차는 1967년에 설립된 전 세계에서 사랑받는 자동차 브랜드로, 다양한 차종을 제조 및 판매하고 있습니다. 
    승용차, SUV, 상용차를 포함한 다양한 모델을 생산하며, 친환경차, 전기차, 수소차 등 미래 모빌리티를 선도하는 기술 개발에 주력하고 있습니다. 
    현대자동차는 글로벌 시장에서의 경쟁력을 강화하기 위해 지속적인 연구 개발과 품질 개선에 투자하고 있으며, 고객 만족을 위한 혁신적인 서비스를 제공하고 있습니다. 
    전 세계 190개국 이상에서 차량을 판매하며, 주요 시장에서의 입지를 공고히 하고 있습니다.',
        '우리의 비전은 혁신적인 모빌리티 솔루션을 통해 사람과 사람, 사람과 세상을 연결하고, 지속 가능한 미래를 만들어 나가는 것입니다. 
    우리는 고객의 행복과 만족을 최우선으로 생각하며, 사회적 책임을 다하고자 합니다. 
    특히, 친환경 기술과 지속 가능한 경영을 통해 환경 보호와 사회적 책임을 실천하고 있습니다. 
    미래 이동수단의 패러다임을 바꾸기 위해 자율주행 기술, 스마트 모빌리티 솔루션 개발에 앞장서고 있습니다.',
        '직원 복지를 위해 차량 구매 지원, 주택 자금 지원, 의료 지원, 자녀 교육 지원 등의 혜택을 제공하고 있습니다. 
    또한, 사내 동호회 활동 지원 및 다양한 문화 프로그램을 운영하여 직원의 삶의 질을 높이고 있습니다. 
    직원들은 연 2회 건강 검진, 사내 피트니스 센터 이용, 자녀 학자금 지원, 해외 연수 프로그램 등의 혜택을 누릴 수 있습니다. 
    현대자동차는 직원의 워라밸(Work-Life Balance)을 중시하며, 유연 근무제도와 재택 근무를 통해 직원들의 만족도를 높이고 있습니다.',
        90000
    );

INSERT INTO
    company_detail (
        com_info_no,
        com_no,
        com_represent,
        com_url,
        com_birth,
        com_size,
        com_emp_count,
        com_sales,
        com_content,
        com_vision,
        com_welfare,
        com_avg_salary
    )
VALUES (
        4,
        9,
        '신학철',
        'www.lgchem.com',
        '1947',
        '대기업',
        22000,
        300000,
        'LG화학은 1947년에 설립된 글로벌 화학 및 소재 기업으로, 배터리, 석유화학, 첨단소재 등을 제조 및 판매하고 있습니다. 
    LG화학은 지속 가능한 기술 개발을 통해 친환경 제품을 선보이며, 다양한 산업에 걸쳐 혁신적인 솔루션을 제공합니다. 
    전기차 배터리, 고성능 플라스틱, 신재생 에너지 소재 등 다양한 분야에서 혁신을 추구하고 있으며, 글로벌 시장에서의 입지를 강화하고 있습니다. 
    LG화학의 제품은 전 세계에서 인정받고 있으며, 친환경 경영과 지속 가능한 성장에 기여하고 있습니다.',
        '우리의 비전은 지속 가능한 미래를 위한 혁신적인 소재 솔루션을 제공하는 글로벌 리더가 되는 것입니다. 
    우리는 환경과 사회를 고려한 책임 있는 경영을 통해 고객과 사회에 기여하고자 합니다. 
    LG화학은 친환경 소재 개발과 에너지 효율성을 높이는 기술 혁신을 통해 지속 가능한 성장에 기여하고 있습니다. 
    또한, 글로벌 환경 문제 해결을 위한 다양한 사회공헌 활동을 펼치고 있습니다.',
        '직원 복지를 위해 주택 자금 지원, 건강 검진, 자녀 교육 지원, 유연 근무제도 등의 혜택을 제공하고 있습니다. 
    또한, 지속적인 자기 개발을 위해 다양한 교육 프로그램과 자격증 취득 지원을 운영하고 있습니다. 
    직원들은 사내 피트니스 센터, 문화 생활 지원, 의료비 지원 등의 혜택을 누릴 수 있으며, 해외 파견 및 연수 프로그램을 통해 글로벌 역량을 강화할 수 있습니다. 
    LG화학은 직원의 워라밸을 중시하며, 유연 근무제도와 재택 근무를 통해 직원들의 만족도를 높이고 있습니다.',
        85000
    );

-- 애플코리아
INSERT INTO
    company_detail (
        com_info_no,
        com_no,
        com_represent,
        com_url,
        com_birth,
        com_size,
        com_emp_count,
        com_sales,
        com_content,
        com_vision,
        com_welfare,
        com_avg_salary
    )
VALUES (
        5,
        10,
        '팀 쿡',
        'www.apple.com/kr',
        '1976',
        '대기업',
        147000,
        2745000,
        '애플코리아는 1976년에 설립된 혁신적인 전자 제품과 소프트웨어 솔루션을 제공하는 글로벌 기업 애플의 한국 지사입니다. 
    아이폰, 아이패드, 맥북 등 다양한 제품 라인업을 통해 사용자 경험을 혁신적으로 개선하고 있으며, 전 세계적으로 큰 인기를 끌고 있습니다. 
    애플은 하드웨어와 소프트웨어의 완벽한 통합을 통해 사용자가 쉽게 접근하고 활용할 수 있는 생태계를 구축하고 있습니다. 
    또한, 지속적인 혁신을 통해 새로운 제품과 서비스를 선보이며, 글로벌 시장에서의 경쟁력을 강화하고 있습니다.',
        '우리의 비전은 혁신을 통해 사람들의 삶을 변화시키고, 최고의 제품과 서비스를 제공하는 것입니다. 
    우리는 디자인, 사용자 경험, 성능의 균형을 맞춘 제품을 통해 고객에게 새로운 가치를 제공합니다. 
    애플은 지속 가능한 경영을 통해 환경 보호와 사회적 책임을 실천하고 있으며, 재생 가능 에너지 사용 확대와 제품 재활용 프로그램을 운영하고 있습니다. 
    또한, 전 세계 모든 사람이 기술의 혜택을 누릴 수 있도록 교육 및 접근성을 향상시키는 다양한 프로그램을 지원하고 있습니다.',
        '직원 복지를 위해 최신 장비 지원, 건강 검진, 유연 근무제도, 자녀 교육 지원 등의 혜택을 제공하고 있습니다. 
    또한, 글로벌 인재 양성을 위해 다양한 교육 및 연수 프로그램을 운영하고 있습니다. 
    직원들은 사내 헬스케어 프로그램, 피트니스 센터 이용, 사내 카페테리아, 다양한 문화 활동 지원 등의 혜택을 누릴 수 있습니다. 
    애플은 직원의 워라밸을 중시하며, 유연 근무제도와 재택 근무를 통해 직원들의 만족도를 높이고 있습니다.',
        120000
    );

INSERT INTO
    `recruit` (
        recruit_no,
        com_no,
        recruit_title,
        recruit_content,
        recruit_responsibilities,
        recruit_qualifications,
        recruit_preferred_qualifications,
        recruit_reg_date
    )
VALUES (
        1,
        6,
        'Spring Boot 경험자를 찾습니다',
        '우리 회사는 소프트웨어 기술 개발을 전문으로 하는 회사입니다. 다양한 산업에서 혁신적인 기술을 통해 변화를 선도하며 고객의 비즈니스 성과를 극대화하는 솔루션을 제공합니다.',
        '소프트웨어 관련 연구 및 개발',
        '소프트웨어 관련 학사 학위',
        'RESTful API 및 마이크로서비스 아키텍처 경험 우대',
        '2024-06-20'
    ),
    (
        6,
        6,
        '웹 개발자 모집',
        '우리 회사는 혁신적인 웹 기술을 통해 고객의 비즈니스 성과를 극대화합니다. 다양한 프로젝트를 통해 풍부한 경험을 쌓을 수 있는 기회를 제공합니다.',
        '웹 애플리케이션 개발 및 유지보수',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'JavaScript 및 React 경험 우대',
        '2024-06-20'
    ),
    (
        11,
        6,
        '데이터 분석가 모집',
        '우리 회사는 데이터를 통해 인사이트를 도출하고 비즈니스 결정을 지원하는 역할을 합니다. 데이터 분석과 관련된 다양한 프로젝트를 수행합니다.',
        '데이터 분석 및 보고서 작성',
        '통계학 또는 관련 분야 학사 학위',
        'Python 및 R 경험 우대',
        '2024-06-20'
    ),
    (
        16,
        6,
        '시스템 엔지니어 모집',
        '우리 회사는 안정적인 IT 인프라를 구축하고 유지하는 데 중점을 둡니다. 시스템 관리 및 유지보수 경험이 풍부한 인재를 찾고 있습니다.',
        '시스템 설치 및 유지보수',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'Linux 및 Windows 서버 관리 경험 우대',
        '2024-06-20'
    ),
    (
        21,
        6,
        '네트워크 엔지니어 모집',
        '우리 회사는 네트워크 인프라 구축과 유지보수에 중점을 두고 있습니다. 네트워크 관리 및 최적화 경험이 풍부한 인재를 찾고 있습니다.',
        '네트워크 설치 및 유지보수',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'Cisco 장비 경험 우대',
        '2024-06-20'
    );

-- 삼성전자
INSERT INTO
    `recruit` (
        recruit_no,
        com_no,
        recruit_title,
        recruit_content,
        recruit_responsibilities,
        recruit_qualifications,
        recruit_preferred_qualifications,
        recruit_reg_date
    )
VALUES (
        2,
        7,
        'AI 엔지니어 모집',
        '삼성전자는 기술의 글로벌 리더로서 새로운 가능성을 열고 있습니다. 다양한 산업에서 혁신적인 기술을 통해 변화를 선도하며 고객의 비즈니스 성과를 극대화하는 솔루션을 제공합니다.',
        'AI 솔루션 개발 및 구현',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        '기계 학습 및 데이터 분석 경험 우대',
        '2024-06-20'
    ),
    (
        7,
        7,
        '모바일 앱 개발자 모집',
        '삼성전자는 모바일 기술의 혁신을 선도하고 있습니다. 우리는 전 세계 수백만 명의 사용자에게 최상의 모바일 경험을 제공하기 위해 노력하고 있습니다.',
        '모바일 애플리케이션 개발 및 유지보수',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'Android 및 iOS 개발 경험 우대',
        '2024-06-20'
    ),
    (
        12,
        7,
        'IoT 엔지니어 모집',
        '삼성전자는 사물인터넷(IoT) 기술을 통해 다양한 산업에서 혁신을 주도하고 있습니다. IoT 기술 개발 및 구현에 열정적인 인재를 찾고 있습니다.',
        'IoT 솔루션 개발 및 테스트',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'IoT 플랫폼 경험 우대',
        '2024-06-20'
    ),
    (
        17,
        7,
        '네트워크 엔지니어 모집',
        '삼성전자는 안정적이고 신뢰할 수 있는 네트워크 인프라를 구축하고 유지하는 데 중점을 두고 있습니다. 네트워크 관리 및 유지보수 경험이 풍부한 인재를 찾고 있습니다.',
        '네트워크 설치 및 유지보수',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'Cisco 네트워크 장비 경험 우대',
        '2024-06-20'
    ),
    (
        22,
        7,
        '데이터 사이언티스트 모집',
        '삼성전자는 데이터를 통해 혁신적인 인사이트를 도출하고 비즈니스 결정을 지원하는 역할을 합니다. 데이터 분석과 관련된 다양한 프로젝트를 수행합니다.',
        '데이터 분석 및 모델 개발',
        '통계학 또는 관련 분야 학사 학위',
        'Python 및 R 경험 우대',
        '2024-06-20'
    );

-- 현대자동차
INSERT INTO
    `recruit` (
        recruit_no,
        com_no,
        recruit_title,
        recruit_content,
        recruit_responsibilities,
        recruit_qualifications,
        recruit_preferred_qualifications,
        recruit_reg_date
    )
VALUES (
        3,
        8,
        '자율 주행 엔지니어 모집',
        '현대자동차는 자동차 산업의 혁신을 선도하고 있습니다. 우리는 전 세계 고객에게 안전과 편의를 제공하는 최첨단 자율 주행 기술을 개발하는 데 전념하고 있습니다.',
        '자율 주행 소프트웨어 개발 및 테스트',
        '공학 또는 관련 분야 학사 학위',
        '자동차 소프트웨어 및 센서 경험 우대',
        '2024-06-20'
    ),
    (
        8,
        8,
        '전기차 엔지니어 모집',
        '현대자동차는 전기차 기술 개발에 앞장서고 있습니다. 우리는 친환경 미래를 위해 전기차 기술을 개발하는 데 최선을 다하고 있습니다.',
        '전기차 시스템 설계 및 개발',
        '전기 공학 또는 관련 분야 학사 학위',
        '전기차 배터리 및 충전 시스템 경험 우대',
        '2024-06-20'
    ),
    (
        13,
        8,
        '차량 제어 시스템 개발자 모집',
        '현대자동차는 차량 제어 시스템 개발에 주력하고 있습니다. 우리는 안전하고 효율적인 차량 제어 솔루션을 제공합니다.',
        '차량 제어 시스템 설계 및 개발',
        '전자 공학 또는 관련 분야 학사 학위',
        'MATLAB 및 Simulink 경험 우대',
        '2024-06-20'
    ),
    (
        18,
        8,
        '차량 네트워크 엔지니어 모집',
        '현대자동차는 차량 네트워크 기술의 발전에 주력하고 있습니다. 우리는 차량 간 통신 및 네트워크 기술을 개발하고 있습니다.',
        '차량 네트워크 설계 및 개발',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'CAN 및 Ethernet 경험 우대',
        '2024-06-20'
    ),
    (
        23,
        8,
        '엔진 개발 엔지니어 모집',
        '현대자동차는 엔진 기술 개발에 주력하고 있습니다. 우리는 고효율, 친환경 엔진 개발을 위해 노력하고 있습니다.',
        '엔진 설계 및 테스트',
        '기계 공학 또는 관련 분야 학사 학위',
        '엔진 개발 경험 우대',
        '2024-06-20'
    );

-- LG화학
INSERT INTO
    `recruit` (
        recruit_no,
        com_no,
        recruit_title,
        recruit_content,
        recruit_responsibilities,
        recruit_qualifications,
        recruit_preferred_qualifications,
        recruit_reg_date
    )
VALUES (
        4,
        9,
        '화학 엔지니어 모집',
        'LG화학은 석유화학, 에너지 솔루션, 첨단 소재, 생명 과학 등 다양한 사업 포트폴리오를 보유한 글로벌 선도 화학 기업입니다. 우리는 지속 가능한 미래를 위한 솔루션을 창출하기 위해 노력하고 있습니다.',
        '화학 공정 연구 및 개발',
        '화학 또는 화학 공학 학사 학위',
        '산업 화학 공정 경험 우대',
        '2024-06-20'
    ),
    (
        9,
        9,
        '배터리 엔지니어 모집',
        'LG화학은 배터리 기술 개발에 앞장서고 있습니다. 우리는 전기차 및 에너지 저장 솔루션을 위한 첨단 배터리 기술을 개발하고 있습니다.',
        '배터리 설계 및 개발',
        '화학 또는 화학 공학 학사 학위',
        '배터리 설계 및 개발 경험 우대',
        '2024-06-20'
    ),
    (
        14,
        9,
        '소재 엔지니어 모집',
        'LG화학은 첨단 소재 기술 개발에 주력하고 있습니다. 우리는 다양한 산업에 적용 가능한 혁신적인 소재를 개발하고 있습니다.',
        '첨단 소재 연구 및 개발',
        '화학 또는 화학 공학 학사 학위',
        '첨단 소재 개발 경험 우대',
        '2024-06-20'
    ),
    (
        19,
        9,
        '환경 기술 엔지니어 모집',
        'LG화학은 환경 친화적인 기술 개발에 중점을 두고 있습니다. 우리는 지속 가능한 미래를 위한 환경 기술 솔루션을 제공합니다.',
        '환경 기술 연구 및 개발',
        '환경 공학 또는 관련 분야 학사 학위',
        '환경 기술 개발 경험 우대',
        '2024-06-20'
    ),
    (
        24,
        9,
        '연구소 연구원 모집',
        'LG화학 연구소는 다양한 첨단 기술을 연구하고 개발하는 곳입니다. 우리는 혁신적인 연구를 통해 미래를 선도할 기술을 개발하고 있습니다.',
        '첨단 기술 연구 및 개발',
        '화학, 물리학 또는 관련 분야 박사 학위',
        '연구 경험 우대',
        '2024-06-20'
    );

-- 애플코리아
INSERT INTO
    `recruit` (
        recruit_no,
        com_no,
        recruit_title,
        recruit_content,
        recruit_responsibilities,
        recruit_qualifications,
        recruit_preferred_qualifications,
        recruit_reg_date
    )
VALUES (
        5,
        10,
        'iOS 개발자 모집',
        '애플코리아는 소비자 전자 제품, 소프트웨어 및 서비스를 선도하는 Apple Inc.의 자회사입니다. 우리는 차세대 모바일 경험을 창출하는 데 도움을 줄 재능 있는 iOS 개발자를 찾고 있습니다.',
        'iOS 애플리케이션 및 기능 개발',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'Swift 및 iOS SDK 경험 우대',
        '2024-06-20'
    ),
    (
        10,
        10,
        'Mac 소프트웨어 개발자 모집',
        '애플코리아는 Mac 소프트웨어 개발에 주력하고 있습니다. 우리는 고성능 Mac 소프트웨어 솔루션을 제공합니다.',
        'Mac 애플리케이션 및 기능 개발',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        'Mac 소프트웨어 개발 경험 우대',
        '2024-06-20'
    ),
    (
        15,
        10,
        'UI/UX 디자이너 모집',
        '애플코리아는 UI/UX 디자인에 중점을 두고 있습니다. 우리는 사용자 경험을 극대화하는 혁신적인 디자인 솔루션을 제공합니다.',
        'UI/UX 디자인 및 프로토타이핑',
        '디자인 또는 관련 분야 학사 학위',
        'UI/UX 디자인 경험 우대',
        '2024-06-20'
    ),
    (
        20,
        10,
        '데이터 분석가 모집',
        '애플코리아는 데이터 분석을 통해 비즈니스 인사이트를 도출합니다. 우리는 데이터 기반 의사 결정을 지원하는 분석 솔루션을 제공합니다.',
        '데이터 분석 및 보고',
        '컴퓨터 공학 또는 관련 분야 학사 학위',
        '데이터 분석 경험 우대',
        '2024-06-20'
    ),
    (
        25,
        10,
        '하드웨어 엔지니어 모집',
        '애플코리아는 하드웨어 개발에 중점을 두고 있습니다. 우리는 최첨단 하드웨어 솔루션을 개발하고 있습니다.',
        '하드웨어 설계 및 개발',
        '전자 공학 또는 관련 분야 학사 학위',
        '하드웨어 개발 경험 우대',
        '2024-06-20'
    );

-- HJB Company 키워드 삽입
INSERT INTO
    recruit_keyword (recruit_keyword, recruit_no)
VALUES ('#SpringBoot', 1),
    ('#Java', 1),
    ('#웹개발', 6),
    ('#JavaScript', 6),
    ('#React', 11),
    ('#데이터분석', 11),
    ('#Python', 11),
    ('#R', 11),
    ('#시스템엔지니어', 16),
    ('#Linux', 16),
    ('#Windows서버', 16),
    ('#네트워크', 21),
    ('#Cisco', 21);

-- 삼성전자 키워드 삽입
INSERT INTO
    recruit_keyword (recruit_keyword, recruit_no)
VALUES ('#AI', 2),
    ('#기계학습', 2),
    ('#모바일개발', 7),
    ('#Android', 7),
    ('#iOS', 7),
    ('#IoT', 12),
    ('#사물인터넷', 12),
    ('#네트워크', 17),
    ('#Cisco', 17),
    ('#데이터사이언티스트', 22),
    ('#Python', 22),
    ('#R', 22);

-- 현대자동차 키워드 삽입
INSERT INTO
    recruit_keyword (recruit_keyword, recruit_no)
VALUES ('#자율주행', 3),
    ('#자동차소프트웨어', 3),
    ('#전기차', 8),
    ('#배터리', 8),
    ('#차량제어', 13),
    ('#MATLAB', 13),
    ('#Simulink', 13),
    ('#차량네트워크', 18),
    ('#CAN', 18),
    ('#Ethernet', 18),
    ('#엔진개발', 23),
    ('#기계공학', 23);

-- LG화학 키워드 삽입
INSERT INTO
    recruit_keyword (recruit_keyword, recruit_no)
VALUES ('#화학', 4),
    ('#화학공학', 4),
    ('#배터리', 9),
    ('#전기차', 9),
    ('#소재', 14),
    ('#첨단소재', 14),
    ('#환경기술', 19),
    ('#지속가능성', 19),
    ('#연구소', 24),
    ('#첨단기술', 24);

-- 애플코리아 키워드 삽입
INSERT INTO
    recruit_keyword (recruit_keyword, recruit_no)
VALUES ('#iOS', 5),
    ('#Swift', 5),
    ('#Mac', 10),
    ('#소프트웨어개발', 10),
    ('#UI/UX', 15),
    ('#디자인', 15),
    ('#데이터분석', 20),
    ('#인사이트', 20),
    ('#하드웨어', 25),
    ('#전자공학', 25);

INSERT INTO `product` (`product_name`, `product_count`, `product_price`, `product_duration`)
VALUES 
('10만원', 30, 100000, 2),
('30만원', 80, 300000, 3),
('50만원', 150, 500000, 5);


-- 채용공고 썸네일 파일
INSERT INTO `file` (`file_no`,`parent_table`,`parent_no`,`file_name`,`origin_name`,`file_path`,`file_size`,`reg_date`,`upd_date`,`file_code`)
VALUES (3,'recruit',1,NULL,'HJB-logo.png','C:/upload/cdeb601f-a295-49c2-a8b3-e79fabcaae32_HJB-logo.png',9279,'2024-06-20 02:16:07','2024-06-20 02:16:07',1),
       (4,'recruit',6,NULL,'HJB-logo.png','C:/upload/af6debc8-2e8b-4e92-84d7-d8f034dfd036_HJB-logo.png',9279,'2024-06-20 02:16:14','2024-06-20 02:16:14',1),
       (5,'recruit',11,NULL,'HJB-logo.png','C:/upload/21367aca-807a-42c9-99e4-d898eba22a83_HJB-logo.png',9279,'2024-06-20 02:16:20','2024-06-20 02:16:20',1),
       (6,'recruit',16,NULL,'HJB-logo.png','C:/upload/91401f26-00d0-4b14-9f01-ea3246be2cf6_HJB-logo.png',9279,'2024-06-20 02:16:31','2024-06-20 02:16:31',1),
       (7,'recruit',21,NULL,'HJB-logo.png','C:/upload/72605c52-683d-4a6f-a5e4-021ccba47ec7_HJB-logo.png',9279,'2024-06-20 02:16:42','2024-06-20 02:16:42',1),
       (8,'recruit',2,NULL,'samsung-logo.png','C:/upload/23ab4599-3687-483f-94f6-fbc8c7f55eeb_samsung-logo.png',19466,'2024-06-20 02:17:18','2024-06-20 02:17:18',1),
       (9,'recruit',7,NULL,'samsung-logo.png','C:/upload/03b5c843-2b72-4b39-aab5-6d36da8ee052_samsung-logo.png',19466,'2024-06-20 02:17:24','2024-06-20 02:17:24',1),
       (10,'recruit',12,NULL,'samsung-logo.png','C:/upload/cf304b62-c630-491c-b648-24311bc4eff3_samsung-logo.png',19466,'2024-06-20 02:17:32','2024-06-20 02:17:32',1),
       (11,'recruit',17,NULL,'samsung-logo.png','C:/upload/5491a6e2-0563-4a57-bd28-1e2beddf0e64_samsung-logo.png',19466,'2024-06-20 02:17:38','2024-06-20 02:17:38',1),
       (12,'recruit',22,NULL,'samsung-logo.png','C:/upload/5ecf8ea0-ae5b-4980-b2dd-2067d90c62d5_samsung-logo.png',19466,'2024-06-20 02:17:44','2024-06-20 02:17:44',1),
       (13,'recruit',3,NULL,'hyundai-logo.png','C:/upload/8a9cde39-1fb7-4be6-ab93-89ace572e0d9_hyundai-logo.png',47444,'2024-06-20 02:18:12','2024-06-20 02:18:12',1),
       (14,'recruit',8,NULL,'hyundai-logo.png','C:/upload/b45c7ca5-50e6-4c58-aae6-90d8ae2ad6eb_hyundai-logo.png',47444,'2024-06-20 02:18:18','2024-06-20 02:18:18',1),
       (15,'recruit',13,NULL,'hyundai-logo.png','C:/upload/29d94947-3d1d-4919-b278-171d79167284_hyundai-logo.png',47444,'2024-06-20 02:18:25','2024-06-20 02:18:25',1),
       (16,'recruit',18,NULL,'hyundai-logo.png','C:/upload/b62a74c7-a98d-4acd-b30f-2bf64e90efeb_hyundai-logo.png',47444,'2024-06-20 02:18:32','2024-06-20 02:18:32',1),
       (17,'recruit',23,NULL,'hyundai-logo.png','C:/upload/3323e907-d948-4211-8585-cbd259e4e74a_hyundai-logo.png',47444,'2024-06-20 02:18:39','2024-06-20 02:18:39',1),
       (18,'recruit',4,NULL,'lg-logo.png','C:/upload/26befd28-d191-4db1-a11c-0ca24280ce55_lg-logo.png',5611,'2024-06-20 02:19:09','2024-06-20 02:19:09',1),
       (19,'recruit',9,NULL,'lg-logo.png','C:/upload/8fc5aefb-57bc-4be5-a3c3-3c5ddda21fe6_lg-logo.png',5611,'2024-06-20 02:19:15','2024-06-20 02:19:15',1),
       (20,'recruit',14,NULL,'lg-logo.png','C:/upload/212fc5ca-fb82-488a-9cc8-dd8431726148_lg-logo.png',5611,'2024-06-20 02:19:21','2024-06-20 02:19:21',1),
       (21,'recruit',19,NULL,'lg-logo.png','C:/upload/bf024ebd-4203-48bf-b941-d436a7fbeea1_lg-logo.png',5611,'2024-06-20 02:19:28','2024-06-20 02:19:28',1),
       (22,'recruit',24,NULL,'lg-logo.png','C:/upload/4dc50110-3981-400c-bedb-0a626ff129cc_lg-logo.png',5611,'2024-06-20 02:19:36','2024-06-20 02:19:36',1),
       (23,'recruit',5,NULL,'apple-logo.png','C:/upload/f1ca50f4-7dc6-4511-aed1-662afab73d0b_apple-logo.png',12354,'2024-06-20 02:21:01','2024-06-20 02:21:01',1),
       (24,'recruit',10,NULL,'apple-logo.png','C:/upload/9109f101-d668-4a4f-9ded-c607de8c19d6_apple-logo.png',12354,'2024-06-20 02:21:09','2024-06-20 02:21:09',1),
       (25,'recruit',15,NULL,'apple-logo.png','C:/upload/328b9bc0-cd13-48aa-bc25-3f03b70d3d2c_apple-logo.png',12354,'2024-06-20 02:21:27','2024-06-20 02:21:27',1),
       (26,'recruit',20,NULL,'apple-logo.png','C:/upload/4c24dd2d-24b1-4821-8946-49d6786695d4_apple-logo.png',12354,'2024-06-20 02:21:37','2024-06-20 02:21:37',1),
       (27,'recruit',25,NULL,'apple-logo.png','C:/upload/fae91d7f-0572-4797-85d0-af5c556bdf9c_apple-logo.png',12354,'2024-06-20 02:21:52','2024-06-20 02:21:52',1);

-- 채용공고 파일
INSERT INTO `file` (`file_no`,`parent_table`,`parent_no`,`file_name`,`origin_name`,`file_path`,`file_size`,`reg_date`,`upd_date`,`file_code`) 
VALUES (28,'recruit',1,NULL,'HJB-poster.png','C:/upload/b3ed9fba-6bfc-458b-af87-7147ae45c981_HJB-poster.png',252482,'2024-06-20 05:15:41','2024-06-20 05:15:41',0),
       (29,'recruit',2,NULL,'samsung-poster.jpg','C:/upload/c726faea-5664-43df-88d8-48f90862a3df_samsung-poster.jpg',594042,'2024-06-20 05:16:15','2024-06-20 05:16:15',0),
       (30,'recruit',3,NULL,'hyundai-poster.jpg','C:/upload/3ff0c4b7-1ea3-49c5-b034-690a5c57acfb_hyundai-poster.jpg',338876,'2024-06-20 05:16:44','2024-06-20 05:16:44',0),
       (31,'recruit',4,NULL,'lg-poster.png','C:/upload/94e21a7f-b76d-4f0b-9772-d22559cf9754_lg-poster.png',180645,'2024-06-20 05:17:28','2024-06-20 05:17:28',0),
       (32,'recruit',5,NULL,'apple-poster.png','C:/upload/88ac41d1-6648-4b6d-9eee-7e9174199dda_apple-poster.png',167945,'2024-06-20 05:17:54','2024-06-20 05:17:54',0);


-- 이력서 지원 후 기업 지원한 이력서에서 1개 밖에 없어서 여기서 추가해줄거임
INSERT INTO `apply_employee` (`check`, `cv_no`, `recruit_no`) 
VALUES 
(-1, 1, 26),
(-1, 2, 26),
(-1, 3, 26),
(-1, 4, 26);




