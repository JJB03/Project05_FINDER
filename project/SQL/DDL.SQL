-- Active: 1716771298869@@127.0.0.1@3306@joeun
DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS user_auth; -- 권한 테이블

DROP TABLE IF EXISTS mail;  	-- 메일인증 테이블

DROP TABLE IF EXISTS cv;  		-- 이력서 테이블

DROP TABLE IF EXISTS employment_history;	-- 경력사항 테이블

DROP TABLE IF EXISTS education;		-- 학력 테이블

DROP TABLE IF EXISTS apply_employee;	-- 지원내역 테이블

DROP TABLE IF EXISTS thumbnail;		-- 썸네일 테이블

DROP TABLE IF EXISTS company;		-- 기업 테이블

DROP TABLE IF EXISTS recruit;		-- 채용공고 게시글 테이블

DROP TABLE IF EXISTS recruit_keyword;		-- 채용공고 키워드 테이블

DROP TABLE IF EXISTS file;		-- 파일 테이블

DROP TABLE IF EXISTS company_detail;		-- 기업 상세 정보 테이블

DROP TABLE IF EXISTS product;	-- 상품 테이블

DROP TABLE IF EXISTS `order`;	-- 주문 테이블

DROP TABLE IF EXISTS credit;	-- 결제내역 테이블



-- 테이블 생성

-- 회원 테이블
CREATE TABLE `user` (
	`user_no` int NOT NULL AUTO_INCREMENT,
	`user_name` varchar(500) NOT NULL,
	`user_id` varchar(500) NOT NULL,
	`user_pw` varchar(500) NOT NULL,
	`user_before_pw` varchar(500) NULL,
	`user_birth` varchar(8) NOT NULL,
	`user_phone` varchar(11) NOT NULL,
	`user_email` varchar(500) NOT NULL,
	`user_reg_date` timestamp NOT NULL DEFAULT now(),
	`user_upd_date` timestamp NULL DEFAULT now(),
	`user_gender` enum('남자','여자') NOT NULL,
	`ENABLED` int DEFAULT 1,
	PRIMARY KEY (`user_no`)
);

-- 권한 테이블
CREATE TABLE `user_auth` (
   `auth_no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `auth` varchar(500) NULL,
   `user_no` int NOT NULL,
   FOREIGN KEY (`user_no`) REFERENCES `user`(`user_no`)
);

-- 메일인증 테이블
CREATE TABLE `mail` (
	`mail_key` bigint NOT NULL,
	`user_no` int NOT NULL,
	PRIMARY KEY (`mail_key`),
	FOREIGN KEY (`user_no`) REFERENCES `user`(`user_no`)
);

-- 이력서 테이블
CREATE TABLE `cv` (
	`cv_no` int NOT NULL AUTO_INCREMENT,
	`user_no` int NOT NULL,
	`cover_letter` text NULL,
	`cv_reg_date` timestamp NOT NULL DEFAULT now(),
	`cv_upd_date` timestamp NULL DEFAULT now(),
	PRIMARY KEY (`cv_no`),
	FOREIGN KEY (`user_no`) REFERENCES `user`(`user_no`)
);

-- 경력사항 테이블
CREATE TABLE `employment_history` (
	`employment_history_no` int NOT NULL AUTO_INCREMENT,
	`organization` varchar(500) NULL,
	`duration` timestamp NULL,
	`duties` varchar(500) NULL,
	`cv_no` int NOT NULL,
	PRIMARY KEY (`employment_history_no`),
    FOREIGN KEY (`cv_no`) REFERENCES `cv`(`cv_no`)
);

-- 학력 테이블
CREATE TABLE `education` (
	`education_no` int NOT NULL AUTO_INCREMENT,
	`cv_no` int NOT NULL,
	`university` varchar(500) NULL,
	`major` varchar(500) NULL,
	`university_status` varchar(500) NULL,
	PRIMARY KEY (`education_no`),
	FOREIGN KEY (`cv_no`) REFERENCES `cv`(`cv_no`)
);

-- 지원내역 테이블
CREATE TABLE `apply_employee` (
	`apply_no` int NOT NULL AUTO_INCREMENT,
	`apply_title` varchar(100) NOT NULL,
	`apply_date` timestamp NOT NULL DEFAULT now(),
	`cv_no` int NOT NULL,
	`recruit_no` int NOT NULL,
	PRIMARY KEY (`apply_no`),
	FOREIGN KEY (`cv_no`) REFERENCES `cv`(`cv_no`),
	FOREIGN KEY (`recruit_no`) REFERENCES `recruit`(`recruit_no`)
);

-- 썸네일 테이블
CREATE TABLE `thumbnail` (
    `thumbnail_no` INT NOT NULL AUTO_INCREMENT,
    `thumbnail_type` INT NOT NULL,
    `thumbnail_name` VARCHAR(500) NOT NULL,
    `thumbnail_size` VARCHAR(500) NOT NULL,
    `thumbnail_reg_date` TIMESTAMP NOT NULL,
    `thumbnail_upd_date` TIMESTAMP NOT NULL,
    `cv_no` INT NULL,
    `recruit_no` INT NULL,
    PRIMARY KEY (`thumbnail_no`),
	FOREIGN KEY (`cv_no`) REFERENCES `cv`(`cv_no`),
	FOREIGN KEY (`recruit_no`) REFERENCES `recruit`(`recruit_no`)
);

-- 기업 테이블
CREATE TABLE `company` (
	`com_no` int NOT NULL AUTO_INCREMENT,
	`com_name` varchar(500) NOT NULL,
	`com_category` varchar(500) NOT NULL,
	`com_phone` varchar(500) NOT NULL,
	`com_email` varchar(500) NOT NULL,
	`com_employee` int NULL,
	`com_address` varchar(500) NOT NULL,
	`com_business` varchar(500) NOT NULL,
	`user_no` int NOT NULL,
	PRIMARY KEY (`com_no`),
	FOREIGN KEY (`user_no`) REFERENCES `user`(`user_no`)
);

-- 채용공고 게시글 테이블
CREATE TABLE `recruit` (
	`recruit_no` int NOT NULL AUTO_INCREMENT,
	`recruit_title` varchar(500) NOT NULL,
	`recruit_content` text NOT NULL,
	`com_no` int NOT NULL,
	`recruit_responsibilities` varchar(500) NULL,
	`recruit_qualifications` varchar(500) NULL,
	`reruit_preferred_qualifications` varchar(500) NULL,
	`recruit_reg_date` varchar(500) NOT NULL,
	`com_reg_date` timestamp NOT NULL DEFAULT now(),
	`com_upd_date` timestamp NULL DEFAULT now(),
	PRIMARY KEY (`recruit_no`),
	FOREIGN KEY (`com_no`) REFERENCES `company`(`com_no`)
);

-- 채용공고 키워드 테이블
CREATE TABLE `recruit_keyword` (
	`recruit_keyword_no` int NOT NULL AUTO_INCREMENT,
    `recruit_keyword` varchar(500) NOT NULL,
	`recruit_no` int NOT NULL,
    PRIMARY KEY (`recruit_keyword_no`),
	FOREIGN KEY (`recruit_no`) REFERENCES `recruit`(`recruit_no`)
);

-- 파일 테이블
CREATE TABLE `file` (
	`file_no` INT NOT NULL AUTO_INCREMENT,
	`parent_table` varchar(500) NOT NULL,
	`parent_no` int NOT NULL,
	`file_name` varchar(500) NOT NULL,
	`origin_name` varchar(500) NOT NULL,
	`file_path` varchar(500) NOT NULL,
	`file_size` int NOT NULL,
	`reg_date` timestamp NOT NULL,
	`upd_date` timestamp NOT NULL,
	`file_code` int NOT NULL,
	`cv_no` int NOT NULL,
	`recruit_no` int NOT NULL,
	PRIMARY KEY (`file_no`),
	FOREIGN KEY (`cv_no`) REFERENCES `cv`(`cv_no`),
	FOREIGN KEY (`recruit_no`) REFERENCES `recruit`(`recruit_no`)
);

-- 기업 상세 정보 테이블
CREATE TABLE `company_detail` (
	`com_info_no` int NOT NULL AUTO_INCREMENT,
	`com_represent` varchar(100) NOT NULL,
	`com_category` varchar(100) NOT NULL,
	`com_url` varchar(500) NULL,
	`com_size` enum('대기업','중견기업','중소기업') NOT NULL,
	`com_emp_count` int NOT NULL,
	`com_sales` int NOT NULL,
	`com_content` text NOT NULL,
	`com_address` varchar(500) NULL,
	`com_vision` varchar(500) NULL,
	`com_welfare` varchar(500) NULL,
	`com_avg_salary` int NOT NULL,
	`com_no` int NOT NULL,
	PRIMARY KEY (`com_info_no`),
	FOREIGN KEY (`com_no`) REFERENCES `company`(`com_no`)
);

-- 상품 테이블
CREATE TABLE `product` (
	`product_no` int NOT NULL AUTO_INCREMENT COMMENT 'auto_increment',
	`product_name` varchar(100) NOT NULL,
	`product_option` varchar(500) NULL,
	`product_price` int NOT NULL,
	PRIMARY KEY (`product_no`)
);

-- 주문 테이블
CREATE TABLE `order` (
	`order_no` int NOT NULL AUTO_INCREMENT,
	`product_no` int NOT NULL,
	`type` enum('order','refund') NOT NULL,
	`process_date` timestamp NOT NULL DEFAULT now(),
	`com_no` int NOT NULL,
	PRIMARY KEY (`order_no`),
	FOREIGN KEY (`product_no`) REFERENCES `product`(`product_no`),
	FOREIGN KEY (`com_no`) REFERENCES `company`(`com_no`)
);

-- 결제내역 테이블
CREATE TABLE `credit` (
    `credit_no` INT NOT NULL AUTO_INCREMENT,
    `credit_method` INT NOT NULL,
    `credit_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `credit_money` VARCHAR(100) NOT NULL,
    `order_code` VARCHAR(500) NOT NULL,
    `order_no` INT NOT NULL,
    PRIMARY KEY (`credit_no`),
	FOREIGN KEY (`order_no`) REFERENCES `order`(`order_no`)
);