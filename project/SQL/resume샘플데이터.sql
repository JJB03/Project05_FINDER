-- Active: 1716536339109@@127.0.0.1@3306@joeun
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

SELECT * FROM cv;

SELECT * FROM `cv` WHERE user_no = 1;

    SELECT c.*, eh.*, ed.*
      FROM cv c
      INNER JOIN employment_history eh ON c.cv_no = eh.cv_no
      INNER JOIN education ed ON c.cv_no = ed.cv_no
    WHERE user_no = 1;


     SELECT c.*, u.*
        FROM cv c
        INNER JOIN user u ON c.user_no = u.user_no
    WHERE u.user_no = 1;


    SELECT c.*, u.*
      FROM cv c
        INNER JOIN user u ON c.user_no = u.user_no
    WHERE c.cv_no = 51

-- 문법은 맞음
UPDATE `cv`
SET cv_title = '바뀌는게 맞나요?',
    cover_letter = '저는 잘 모르겠어요. 일단 에스퀴엘이 맞는지 확인 저는 잘 모르겠어요. 일단 에스퀴엘이 맞는지 확인 저는 잘 모르겠어요. 일단 에스퀴엘이 맞는지 확인',
    cv_upd_date = now()
WHERE cv_no = 51;



