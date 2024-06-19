-- Active: 1711633953173@@127.0.0.1@3306@joeun
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