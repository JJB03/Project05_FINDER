-- 테이블 삭제 ( 총 15개 )

-- 메일인증 테이블
DROP TABLE IF EXISTS mail;

-- 썸네일 테이블
DROP TABLE IF EXISTS thumbnail;

-- 회원 테이블
DROP TABLE IF EXISTS user;

-- 권한 테이블
DROP TABLE IF EXISTS user_auth;

-- 메일인증 실험 테이블
DROP TABLE IF EXISTS email_verification;

-- 이력서 테이블
DROP TABLE IF EXISTS cv;

-- 경력사항 테이블
DROP TABLE IF EXISTS employment_history;

-- 학력 테이블
DROP TABLE IF EXISTS education;

-- 지원내역 테이블
DROP TABLE IF EXISTS apply_employee;

-- 기업 테이블
DROP TABLE IF EXISTS company;

-- 채용공고 게시글 테이블
DROP TABLE IF EXISTS recruit;

-- 채용공고 키워드 테이블
DROP TABLE IF EXISTS recruit_keyword;

-- 파일 테이블
DROP TABLE IF EXISTS file;

-- 기업 상세 정보 테이블
DROP TABLE IF EXISTS company_detail;

-- 상품 테이블
DROP TABLE IF EXISTS product;

-- 주문 테이블
DROP TABLE IF EXISTS `order`;

-- 결제내역 테이블
DROP TABLE IF EXISTS credit;

-- 소셜 테이블
DROP TABLE IF EXISTS user_social;


-- 테이블 생성 ( 총 16개 )

-- 메일 인증 실험 테이블
CREATE TABLE email_verification (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    verification_code VARCHAR(255) NOT NULL
);

-- 소셜 테이블
CREATE TABLE user_social (
    `ID` CHAR(36) PRIMARY KEY,
    `USERNAME` VARCHAR(100) NOT NULL,
    `PROVIDER` VARCHAR(50) NOT NULL,
    `SOCIAL_ID` VARCHAR(255) NOT NULL,
    `NAME` VARCHAR(100) NOT NULL,
    `EMAIL` VARCHAR(200) DEFAULT NULL,
    `PICTURE` TEXT DEFAULT NULL,
    `CREATED_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `UPDATED_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 회원 테이블
CREATE TABLE `user` (
    `user_no` int NOT NULL AUTO_INCREMENT,
    `user_name` varchar(500) NOT NULL,
    `user_id` varchar(500) NOT NULL,
    `user_pw` varchar(500) NOT NULL,
    `user_before_pw` varchar(500) NULL,
    `user_birth` varchar(50) NOT NULL,
    `user_phone` varchar(50) NOT NULL,
    `user_email` varchar(500) NOT NULL,
    `user_reg_date` timestamp NOT NULL DEFAULT now(),
    `user_upd_date` timestamp NULL DEFAULT now(),
    `user_gender` enum('남자', '여자') NOT NULL,
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
    `cv_no` int NOT NULL,
    `recruit_no` int NOT NULL,
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




-- 메일인증 테이블
-- CREATE TABLE `mail` (
-- 	`mail_key` varchar(500) NOT NULL,
-- 	`user_no` int NOT NULL,
-- 	PRIMARY KEY (`mail_key`),
-- 	FOREIGN KEY (`user_no`) REFERENCES `user`(`user_no`)
-- );

-- 썸네일 테이블 없어도될듯
-- CREATE TABLE `thumbnail` (
--     `thumbnail_no` INT NOT NULL AUTO_INCREMENT,
--     `thumbnail_type` INT NOT NULL,
--     `thumbnail_name` VARCHAR(500) NOT NULL,
--     `thumbnail_size` VARCHAR(500) NOT NULL,
--     `thumbnail_reg_date` TIMESTAMP NOT NULL,
--     `thumbnail_upd_date` TIMESTAMP NOT NULL,
--     `cv_no` INT NULL,
--     `recruit_no` INT NULL,
--     PRIMARY KEY (`thumbnail_no`),
-- 	FOREIGN KEY (`cv_no`) REFERENCES `cv`(`cv_no`),
-- 	FOREIGN KEY (`recruit_no`) REFERENCES `recruit`(`recruit_no`)
-- );
