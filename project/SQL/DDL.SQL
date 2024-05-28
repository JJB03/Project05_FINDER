-- Active: 1716771409910@@127.0.0.1@3306@joeun
DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
	`user_no`	int	NOT NULL,
	`user_name`	varchar(500)	NOT NULL,
	`user_id`	varchar(500)	NOT NULL,
	`user_pw`	varchar(500)	NOT NULL,
	`user_before_pw`	varchar(500)	NULL,
	`user_birth`	varchar(8)	NOT NULL,
	`user_phone`	varchar(11)	NOT NULL,
	`user_email`	varchar(500)	NOT NULL,
	`user_reg_date`	timestamp	NOT NULL	DEFAULT now(),
	`user_upd_date`	timestamp	NULL	DEFAULT now(),
	`user_gender`	enum('남자','여자')	NOT NULL
);

DROP TABLE IF EXISTS user_auth;

CREATE TABLE `user_auth` (
   `auth_no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `auth` varchar(500) NULL,
   `user_no` int NOT NULL,
   FOREIGN KEY (`user_no`) REFERENCES `user`(`user_no`)
);

DROP TABLE IF EXISTS mail;

CREATE TABLE `mail` (
	`Key`	bigint	NOT NULL,
	`user_no`	int	NOT NULL
);

DROP TABLE IF EXISTS cv;

CREATE TABLE `cv` (
	`cv_no`	int	NOT NULL,
	`user_no`	int	NOT NULL,
	`cover_letter`	text	NULL,
	`cv_reg_date`	timestamp	NOT NULL	DEFAULT now(),
	`cv_upd_date`	timestamp	NULL	DEFAULT now()
);

-- 경력
DROP TABLE IF EXISTS employment_history;

CREATE TABLE `employment_history` (
	`employment_history_no`	int	NOT NULL,
	`organization`	varchar(500)	NULL,
	`duration`	timestamp	NULL,
	`duties`	varchar(500)	NULL,
	`cv_no`	int	NOT NULL
);

DROP TABLE IF EXISTS education;

CREATE TABLE `education` (
	`education_no`	int	NOT NULL,
	`cv_no`	int	NOT NULL,
	`university`	varchar(500)	NULL,
	`major`	varchar(500)	NULL,
	`university_ status`	varchar(500)	NULL
);

DROP TABLE IF EXISTS apply_employee;

CREATE TABLE `apply_employee` (
	`apply_no`	int	NOT NULL,
	`apply_title`	varchar(100)	NOT NULL,
	`apply_date`	timestamp	NOT NULL	DEFAULT now(),
	`cv_no`	int	NOT NULL,
	`apply_no2`	int	NOT NULL
);

DROP TABLE IF EXISTS thumbnail;

CREATE TABLE `thumbnail` (
    `thumbnail_no` INT NOT NULL,
    `thumbnail_type` INT NOT NULL,
    `thumbnail_name` VARCHAR(500) NOT NULL,
    `thumbnail_size` VARCHAR(500) NOT NULL,
    `thumbnail_reg_date` TIMESTAMP NOT NULL,
    `thumbnail_upd_date` TIMESTAMP NOT NULL,
    `cv_no` INT NOT NULL,
    `apply_no` INT NOT NULL
);


DROP TABLE IF EXISTS company;

CREATE TABLE `company` (
	`com_no`	int	NOT NULL,
	`com_name`	varchar(500)	NOT NULL,
	`com_category`	varchar(500)	NOT NULL,
	`com_phone`	varchar(500)	NOT NULL,
	`com_email`	varchar(500)	NOT NULL,
	`com_employee`	int	NULL,
	`com_address`	varchar(500)	NOT NULL,
	`com_business`	varchar(500)	NOT NULL,
	`user_no`	int	NOT NULL
);



DROP TABLE IF EXISTS recruit;

CREATE TABLE `recruit` (
	`recruit_no`	int	NOT NULL,
	`recruit_title`	varchar(500)	NOT NULL,
	`recruit_writer`	varchar(500)	NOT NULL,
	`recruit_content`	text	NOT NULL,
	`com_no`	int	NOT NULL,
	`recruit_responsibilities`	varchar(500)	NULL,
	`recruit_qualifications`	varchar(500)	NULL,
	`reruit_preferred_qualifications`	varchar(500)	NULL,
	`recruit_reg_date`	date	NOT NULL,
	`com_reg_date`	timestamp	NOT NULL	DEFAULT now(),
	`com_upd_date`	timestamp	NULL	DEFAULT now()
);

DROP TABLE IF EXISTS file;

CREATE TABLE `file` (
	`file_no`	VARCHAR(255)	NOT NULL,
	`parent_table`	varchar(500)	NOT NULL,
	`parent_no`	int	NOT NULL,
	`file_name`	varchar(500)	NOT NULL,
	`origin _name`	varchar(500)	NOT NULL,
	`file_path`	varchar(500)	NOT NULL,
	`file_size`	int	NOT NULL,
	`reg_date`	timestamp	NOT NULL,
	`upd_date`	timestamp	NOT NULL,
	`file_code`	int	NOT NULL,
	`cv_no`	int	NOT NULL,
	`recruit_no`	int	NOT NULL
);


DROP TABLE IF EXISTS company_detail;

CREATE TABLE `company_detail` (
	`com_info_no`	int	NOT NULL,
	`com_represent`	varchar(100)	NOT NULL,
	`com_category`	varchar(100)	NOT NULL,
	`com_url`	varchar(500)	NULL,
	`com_size`	enum('대기업','중견기업','중소기업')	NOT NULL,
	`com_emp_count`	int	NOT NULL,
	`com_sales`	int	NOT NULL,
	`com_content`	text	NOT NULL,
	`com_address`	varchar(500)	NULL,
	`com_vision`	varchar(500)	NULL,
	`com_welfare`	varchar(500)	NULL,
	`com_avg_salary`	int	NOT NULL,
	`com_no`	int	NOT NULL
);

DROP TABLE IF EXISTS product;

CREATE TABLE `product` (
	`product_no`	int	NOT NULL	COMMENT 'auto_increment',
	`product_name`	varchar(100)	NOT NULL,
	`product_option`	varchar(500)	NULL,
	`product_price`	int	NOT NULL
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`order_no`	int	NOT NULL,
	`product_no`	int	NOT NULL,
	`type`	enum('order','refund')	NOT NULL,
	`process_date`	timestamp	NOT NULL	DEFAULT now(),
	`com_no2`	int	NOT NULL
);

DROP TABLE IF EXISTS credit;

CREATE TABLE `credit` (
    `credit_no` INT NOT NULL,
    `credit_method` INT NOT NULL,
    `credit_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `credit_money` VARCHAR(100) NOT NULL,
    `order_code` VARCHAR(500) NOT NULL,
    `order_no` INT NOT NULL
);
