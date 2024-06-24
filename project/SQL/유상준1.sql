-- 테슬라
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
        11,
        '테슬라',
        'com5',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        '19910101',
        '01012341234',
        'bsh@naver.com',
        '남자',
        2
    );
    
INSERT INTO user_auth (user_no, auth) VALUES (11, 'ROLE_COMPANY');
-- 기업권한
INSERT INTO user_auth (user_no, auth) VALUES (11, 'ROLE_USER');

-- 구글
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
        12,
        '구글코리아',
        'com6',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        '19910101',
        '01012341234',
        'bsh@naver.com',
        '남자',
        2
    );

    
INSERT INTO user_auth (user_no, auth) VALUES (12, 'ROLE_COMPANY');
-- 기업권한
INSERT INTO user_auth (user_no, auth) VALUES (12, 'ROLE_USER');

-- 메타
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
        13,
        '메타',
        'com7',
        '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92',
        '19910101',
        '01012341234',
        'bsh@naver.com',
        '남자',
        2
    );

    
INSERT INTO user_auth (user_no, auth) VALUES (13, 'ROLE_COMPANY');
-- 기업권한
INSERT INTO user_auth (user_no, auth) VALUES (13, 'ROLE_USER');



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
        11,
        '테슬라',
        '자동차 및 에너지',
        '서울특별시 강남구 역삼동 123번지',
        '전기 자동차 및 에너지 저장 시스템 개발',
        11
    );

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
        12,
        '구글 코리아',
        '인터넷 및 기술',
        '서울특별시 강남구 역삼동 123번지',
        '인터넷 서비스 및 광고',
        12
    );

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
        13,
        '메타',
        '소셜 미디어 및 기술',
        '서울특별시 강남구 역삼동 123번지',
        '소셜 미디어 플랫폼 및 가상 현실',
        13
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
        6,
        11,
        '일론 머스크',
        'www.tesla.com',
        '2003',
        '대기업',
        99290,
        814300,
        '테슬라는 2003년에 설립된 혁신적인 전기 자동차 및 에너지 솔루션을 제공하는 글로벌 기업입니다. 
    모델 S, 모델 3, 모델 X, 모델 Y 등 다양한 전기차 제품 라인업을 통해 지속 가능한 에너지 사용을 촉진하고 있으며, 
    전 세계적으로 큰 인기를 끌고 있습니다. 테슬라는 또한 태양광 패널과 에너지 저장 시스템인 파워월, 파워팩 등을 통해 
    에너지 분야에서도 혁신을 추구하고 있습니다.',
        '우리의 비전은 지속 가능한 에너지로의 전환을 가속화하고, 혁신적인 기술을 통해 미래를 변화시키는 것입니다. 
    테슬라는 최고의 성능과 안전성을 갖춘 전기 자동차를 통해 자동차 산업의 패러다임을 바꾸고 있으며, 
    지속 가능한 에너지 솔루션을 통해 지구 환경 보호에 기여하고 있습니다. 
    또한, 인공지능과 자율 주행 기술을 선도하며, 미래의 모빌리티 혁신을 이끌어 나가고 있습니다.',
        '직원 복지를 위해 최신 장비 지원, 건강 검진, 유연 근무제도, 자녀 교육 지원 등의 혜택을 제공하고 있습니다. 
    또한, 글로벌 인재 양성을 위해 다양한 교육 및 연수 프로그램을 운영하고 있습니다. 
    직원들은 사내 헬스케어 프로그램, 피트니스 센터 이용, 사내 카페테리아, 다양한 문화 활동 지원 등의 혜택을 누릴 수 있습니다. 
    테슬라는 직원의 워라밸을 중시하며, 유연 근무제도와 재택 근무를 통해 직원들의 만족도를 높이고 있습니다.',
        150000
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
        7,
        12,
        '존 리',
        'www.google.co.kr',
        '1998',
        '대기업',
        190234,
        2568700,
        '구글 코리아는 1998년에 설립된 인터넷 서비스 및 광고를 제공하는 글로벌 기업 구글의 한국 지사입니다. 
    검색 엔진, 유튜브, 구글 클라우드 등 다양한 서비스와 제품을 통해 전 세계적으로 큰 인기를 끌고 있으며, 
    사용자에게 최상의 인터넷 경험을 제공하고 있습니다. 구글은 인공지능과 머신러닝 기술을 선도하며, 
    데이터 기반의 혁신을 추구하고 있습니다.',
        '우리의 비전은 전 세계의 정보를 조직하여 누구나 접근하고 유용하게 사용할 수 있도록 하는 것입니다. 
    구글은 사용자의 요구를 반영한 혁신적인 제품과 서비스를 통해 인터넷 경험을 혁신하고 있으며, 
    전 세계적으로 연결된 디지털 생태계를 구축하고 있습니다. 또한, 지속 가능한 경영을 통해 환경 보호와 
    사회적 책임을 실천하고 있으며, 다양한 사회 공헌 활동을 통해 글로벌 커뮤니티에 기여하고 있습니다.',
        '직원 복지를 위해 최신 장비 지원, 건강 검진, 유연 근무제도, 자녀 교육 지원 등의 혜택을 제공하고 있습니다. 
    또한, 글로벌 인재 양성을 위해 다양한 교육 및 연수 프로그램을 운영하고 있습니다. 
    직원들은 사내 헬스케어 프로그램, 피트니스 센터 이용, 사내 카페테리아, 다양한 문화 활동 지원 등의 혜택을 누릴 수 있습니다. 
    구글은 직원의 워라밸을 중시하며, 유연 근무제도와 재택 근무를 통해 직원들의 만족도를 높이고 있습니다.',
        180000
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
        8,
        13,
        '마크 저커버그',
        'www.meta.com',
        '2004',
        '대기업',
        71970,
        117929,
        '메타는 2004년에 설립된 소셜 미디어 및 기술을 제공하는 글로벌 기업입니다. 
    페이스북, 인스타그램, 왓츠앱 등 다양한 소셜 미디어 플랫폼을 통해 전 세계 사용자들을 연결하고 있으며, 
    가상 현실과 증강 현실 기술을 통해 새로운 사용자 경험을 제공하고 있습니다. 
    메타는 디지털 혁신을 주도하며, 글로벌 커뮤니케이션의 패러다임을 바꾸고 있습니다.',
        '우리의 비전은 사람들을 연결하고, 커뮤니케이션을 혁신하며, 가상 현실과 증강 현실을 통해 새로운 가능성을 탐구하는 것입니다. 
    메타는 소셜 미디어를 통해 사람들 간의 연결을 강화하고, 가상 현실 기술을 통해 새로운 형태의 상호작용을 제공하고 있습니다. 
    또한, 지속 가능한 경영을 통해 환경 보호와 사회적 책임을 실천하고 있으며, 다양한 사회 공헌 활동을 통해 글로벌 커뮤니티에 기여하고 있습니다.',
        '직원 복지를 위해 최신 장비 지원, 건강 검진, 유연 근무제도, 자녀 교육 지원 등의 혜택을 제공하고 있습니다. 
    또한, 글로벌 인재 양성을 위해 다양한 교육 및 연수 프로그램을 운영하고 있습니다. 
    직원들은 사내 헬스케어 프로그램, 피트니스 센터 이용, 사내 카페테리아, 다양한 문화 활동 지원 등의 혜택을 누릴 수 있습니다. 
    메타는 직원의 워라밸을 중시하며, 유연 근무제도와 재택 근무를 통해 직원들의 만족도를 높이고 있습니다.',
        170000
    );
