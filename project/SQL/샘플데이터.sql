-- Active: 1716771298869@@127.0.0.1@3306@joeun
# 회원 컬럼 나열
-- user_no, user_name, user_id, user_pw, user_before_pw, user_birth, user_phone, user_email, user_like_job, user_reg_date, user_upd_date, user_gender, enabled


-- user_name, user_id, user_pw, user_birth, user_phone, user_email, user_like_job, user_gender


TRUNCATE user;
TRUNCATE user_auth;


## 회원
INSERT INTO user( user_name, user_id, user_pw, user_birth, user_phone, user_email, user_gender )
VALUES ('정주빈', 'jjb', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '20240101', '01012341234', 'jjb@naver.com', '여자');


INSERT INTO user_auth (user_no, auth) VALUES (1, 'ROLE_USER');
## 기업



SELECT c.*, r.* 
  FROM company c 
  INNER JOIN recruit r ON c.com_no

SELECT c.*, r.* 
  FROM company c 
  INNER JOIN recruit r ON c.com_no = r.com_no






















INSERT INTO company (com_name, com_category, com_phone, com_email, com_employee, com_address, com_business, user_no) VALUES
('ABC 주식회사', '소프트웨어 및 기술', '123-456-7890', 'abc@example.com', 100, '서울특별시 강남구 역삼동 123번지', '소프트웨어 개발 및 컨설팅', 1),
('XYZ 주식회사', '제조업', '987-654-3210', 'xyz@example.com', 50, '경기도 성남시 분당구 정자동 456번지', '전자제품 제조 및 판매', 2)




INSERT INTO user( user_name, user_id, user_pw, user_birth, user_phone, user_email, user_gender, enabled)
VALUES ('홍준범', 'hjb', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '20240101', '01012341234', 'jjb@naver.com', '남자', 1);



INSERT INTO user_auth (user_no, auth) VALUES (2, 'ROLE_COMPANY');



