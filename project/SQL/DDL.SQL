-- Active: 1716771409910@@127.0.0.1@3306@joeun



DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
   `user_no`   int   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `user_name`   varchar(500)   NOT NULL,
   `user_id`   varchar(500)   NOT NULL,
   `user_pw`   varchar(500)   NOT NULL,
   `user_before_pw`   varchar(500)   NULL,
   `user_birth`   varchar(8)   NOT NULL,
   `user_phone`   varchar(11)   NOT NULL,
   `user_email`   varchar(500)   NOT NULL,
   `user_like_job`   varchar(500)   NULL,
   `user_reg_date`   timestamp   NOT NULL   DEFAULT now(),
   `user_upd_date`   timestamp   NOT NULL   DEFAULT now(),
   `user_gender`   enum('남자','여자')   NOT NULL,
   `enabled` INT DEFAULT 1
);


--

DROP TABLE IF EXISTS user_auth;
CREATE TABLE `user_auth` (
	`auth_no`	INT	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`auth`	varchar(500)	NULL,
	`user_no`	int	NOT NULL
);