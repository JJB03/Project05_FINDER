-- cv 테이블에 임시 값 삽입
INSERT INTO cv (user_no, cover_letter, cv_title, cv_reg_date, cv_upd_date) VALUES
(1, '자기소개서입니다', '이력서 제목입니다1', NOW(), NOW()),
(2, '자기소개서입니다2', '이력서 제목입니다.2', NOW(), NOW());

-- employment_history 테이블에 임시 값 삽입
INSERT INTO employment_history (organization, duration, duties, cv_no) VALUES
('기관명1', NOW(), '담당업무 1입니다.', 1),
('기관명2', NOW(), '담당업무 2입니다', 2);

-- education 테이블에 임시 값 삽입
INSERT INTO education (cv_no, university, major, university_status) VALUES
(1, '대학 1입니다', '전공 1입니다', '학사 1입니다.'),
(2, '대학 2이다.', '전공 2입니다.', '학사 2입니다');
