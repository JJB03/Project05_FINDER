SELECT c.*, r.*, rk.*
    FROM company c
    INNER JOIN recruit r ON c.com_no = r.com_no
    INNER JOIN recruit_keyword rk ON r.recruit_no = rk.recruit_no;
SELECT c.*, r.* 
  FROM company c 
  INNER JOIN recruit r ON c.com_no = r.com_no;

SELECT c.*, r.*, rk.*
    FROM company c
    INNER JOIN recruit r ON c.com_no = r.com_no
    INNER JOIN recruit_keyword rk ON r.recruit_no = rk.recruit_no;
    
  SELECT c.*, r.*, rk.*
    FROM company c
    INNER JOIN recruit r ON c.com_no = r.com_no
    INNER JOIN recruit_keyword rk ON r.recruit_no = rk.recruit_no
    WHERE r.com_no = 1;
  

    SELECT c.*, r.*
    FROM company c
    INNER JOIN recruit r ON c.com_no = r.com_no
    WHERE r.recruit_no = 28;

    SELECT rk.recruit_keyword
    FROM recruit r
    INNER JOIN recruit_keyword rk ON rk.recruit_no = r.recruit_no
    WHERE r.recruit_no = 28;


    SELECT c.*
        ,r.*
        ,rk.*
        ,f.file_no AS file_no
        ,f.file_name
        ,f.file_path
        ,f.file_code
        FROM company c
        INNER JOIN recruit r ON c.com_no = r.com_no
        LEFT JOIN recruit_keyword rk ON r.recruit_no = rk.recruit_no
        LEFT JOIN (
            SELECT *
            FROM file
            WHERE parent_table = 'recruit'
              AND file_code = 1
        ) f ON r.recruit_no = f.parent_no















INSERT INTO user( user_name, user_id, user_pw, user_birth, user_phone, user_email, user_gender, enabled)
VALUES ('홍준범', 'hjb', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '20240101', '01012341234', 'jjb@naver.com', '남자', 1);


INSERT INTO user_auth (user_no, auth) VALUES (1, 'ROLE_COMPANY');





## 기업 테이블
## 기업 상세 정보 테이블

INSERT INTO company (com_name, com_category, com_address, com_business, user_no) VALUES
('ABC 주식회사', '소프트웨어 및 기술', '서울특별시 강남구 역삼동 123번지', '소프트웨어 개발 및 컨설팅', 1);
INSERT INTO company (com_name, com_category, com_address, com_business, user_no) VALUES
('XYZ 주식회사', '제조업', '경기도 성남시 분당구 정자동 456번지', '전자제품 제조 및 판매', 2);

INSERT INTO `company_detail` (`com_represent`, `com_category`, `com_url`, `com_birth`, `com_size`, `com_emp_count`, `com_sales`, `com_content`, `com_address`, `com_vision`, `com_welfare`, `com_avg_salary`, `com_no`) VALUES
('김철수', 'IT', 'http://www.abccorp.com', 1995, '대기업', 1000, 500000000, 'ABC Corporation은 소프트웨어 개발을 전문으로 하는 회사입니다.', '서울특별시 강남구 테헤란로 123', '글로벌 리더가 되겠습니다.', '식사 제공, 건강 검진', 6000, 1)
;


SELECT c.*
      ,r.*
      ,rk.*
      ,f.file_no AS file_no
      ,f.file_name
      ,f.file_path
      ,f.file_code
      FROM company c
      INNER JOIN recruit r ON c.com_no = r.com_no
      LEFT JOIN recruit_keyword rk ON r.recruit_no = rk.recruit_keyword_no
      LEFT JOIN (
          SELECT *
          FROM file
          WHERE parent_table = 'recruit'
            AND file_code = 1
      ) f ON r.recruit_no = f.parent_no
      WHERE r.com_no = 1;

      SELECT *
        FROM file
        WHERE parent_table = 'recruit'
          AND parent_no = 35
          AND file_code = 1
        ORDER BY reg_date DESC

        SELECT c.*
        ,r.*
        ,rk.*
        ,f.file_no AS file_no
        ,f.file_name
        ,f.file_path
        ,f.file_code
        FROM company c
        INNER JOIN recruit r ON c.com_no = r.com_no
        LEFT JOIN recruit_keyword rk ON r.recruit_no = rk.recruit_no
        LEFT JOIN (
            SELECT *
            FROM file
            WHERE parent_table = 'recruit'
              AND file_code = 1
        ) f ON r.recruit_no = f.parent_no
        

    --     SELECT c.*, r.*, rk.*
    -- FROM company c
    -- INNER JOIN recruit r ON c.com_no = r.com_no
    -- LEFT JOIN recruit_keyword rk ON r.recruit_no = rk.recruit_no