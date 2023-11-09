/*
    <DDL(Data Definition Language)>
        데이터 정의 언어로 오라클에서 제공하는 객체를 만들고(CREATE), 변경하고(ALTER), 삭제하는(DROP) 등
        실제 데이터 값이 아닌 데이터의 구조 자체를 정의하는 언어로 DB 관리자, 설계자가 주로 사용한다.

        * 오라클에서의 객체 : 테이블, 뷰, 시퀀스, 인덱스, 트리거, 프로시져, 함수, 사용자 등등
        
    <CREATE>
        데이터베이스의 객체를 생성하는 구문이다.
    
    <TABLE(테이블)>
        테이블은 행과 열로 구성되는 가장 기본적인 데이터베이스 객체로 데이터베이스 내에서 모든 데이터는 테이블에 저장된다.
        
    <테이블 생성>
        [문법]
            CREATE TABLE 테이블명 (
                칼럼명 자료형(크기) [DEFAULT 기본값] [제약조건],
                칼럼명 자료형(크기) [DEFAULT 기본값] [제약조건],
                ...
            );
*/
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID             VARCHAR(100) 
    ,PWD            VARCHAR(100) 
    ,NICK           VARCHAR(100) 
    ,ENROLL_DATE    TIMESTAMP   
    ,QUIT_YN        CHAR(1)     
);
CREATE TABLE MEMBER(
    NO              NUMBER       PRIMARY KEY
    ,ID             VARCHAR(100) NOT NULL UNIQUE
    ,PWD            VARCHAR(100) NOT NULL
    ,NICK           VARCHAR(100) 
    ,ENROLL_DATE    TIMESTAMP   DEFAULT SYSDATE
    ,QUIT_YN        CHAR(1)     CHECK (QUIT_YN IN ('Y','N'))
);
SELECT * FROM MEMBER;
DESC MEMBER;

/*
    <칼럼에 주석 달기>
        [문법]
            COMMENT ON COLUMN 테이블명.칼럼명 IS '주석내용';
*/
COMMENT ON COLUMN MEMBER.ID IS '아이디';
COMMENT ON COLUMN MEMBER.PWD IS '비밀번호';
COMMENT ON COLUMN MEMBER.NICK IS '닉네임';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '가입일시';

/*
    데이터 딕셔너리(메타 데이터)
        자원을 효율적으로 관리하기 위한 다양한 객체들의 정보를 저장하는 시스템 테이블이다.
        사용자가 객체를 생성하거나 객체를 변경하는 등의 작업을 할 때 데이터베이스에 의해서 자동으로 갱신되는 테이블이다.
        데이터에 관한 데이터가 저장되어 있다고 해서 메타 데이터라고도 한다.
        
    USER_TABLES         : 사용자가 가지고 있는 테이블들의 전반적인 구조를 확인하는 뷰 테이블이다. 
    USER_TAB_COLUMNS    : 테이블, 뷰의 칼럼과 관련된 정보를 조회하는 뷰 테이블이다.
*/
SELECT * FROM USER_TABLES;
SELECT * FROM USER_TAB_COLUMNS;
SELECT * FROM MEMBER;

--INSERT
INSERT INTO MEMBER(ID,PWD,NICK,ENROLL_DATE) VALUES('USER01','1234','USER01',SYSDATE);
INSERT INTO MEMBER VALUES('USER02','1234','USER02',SYSDATE);
INSERT INTO MEMBER(ID,PWD) VALUES('USER01','1234');
INSERT INTO MEMBER(ID,PWD,NICK,ENROLL_DATE) VALUES('USER01','1234',NULL,DEFAULT);
INSERT INTO MEMBER(ID,PWD,NICK,ENROLL_DATE,QUIT_YN) VALUES('USER01','1234',NULL,DEFAULT,'N');



--COMMIT;
SHOW AUTOCOMMIT;
SET AUTOCOMMIT ON;
SET AUTOCOMMIT OFF;

----------------------------------------------------------------------------
/*
    <제약 조건(CONSTRAINT)>
        사용자가 원하는 조건의 데이터만 유지하기 위해서 테이블 작성 시 각 칼럼에 대해 저장될 값에 대한 제약조건을 설정할 수 있다.
        제약 조건은 데이터 무결성 보장을 목적으로 한다. (데이터의 정확성과 일관성을 유지시키는 것)
        
        * 종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
        + DEFAULT
        [문법]
            1) 칼럼 레벨
                CRATE TABLE 테이블명 (
                    칼럼명 자료형(크기) [CONSTRAINT 제약조건명] 제약조건,
                    ...
                );
            
            2) 테이블 레벨
                CRATE TABLE 테이블명 (
                    칼럼명 자료형(크기),
                    ...,
                    [CONSTRAINT 제약조건명] 제약조건(칼럼명)
                );
*/
DROP TABLE SCORE;
CREATE TABLE SCORE(
    MEMBER_NO NUMBER 
    , GRADE CHAR(1)
    ,FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
);

SELECT * FROM SCORE;
SELECT * FROM MEMBER;

INSERT INTO SCORE(MEMBER_NO,GRADE) VALUES (1,'A');
INSERT INTO MEMBER(MEMBER_NO,ID,PWD,NICK,QUIT_YN) VALUES(1,'USER01','1234','NICK01','N');

-- ON DELETE SET NULL
-- ON DELETE CASCADE

DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    MEMBER_NO       NUMBER       --PRIMARY KEY
    ,ID             VARCHAR(100) NOT NULL -- UNIQUE
    ,PWD            VARCHAR(100) --CONSTRAINT 에러코드00123패스워드낫널 NOT NULL
    ,NICK           VARCHAR(100) 
    ,ENROLL_DATE    TIMESTAMP   DEFAULT SYSDATE
    ,QUIT_YN        CHAR(1)     --CHECK (QUIT_YN IN ('Y','N'))
--  ,NOT NULL(ID)   --NOT NULL 제약 조건은 테이블 레벨에서 설정 불가능
    ,UNIQUE(ID)
    ,CHECK(QUIT_YN IN ('Y','N'))
    ,PRIMARY KEY(MEMBER_NO)
--    ,FOREIGN KEY()
);
