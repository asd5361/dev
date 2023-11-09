/*
    <TRIGGER>
        테이블이 INSERT, UPDATE, DELETE 등 DML 구문에 의해서 변경될 경우
        자동으로 실행될 내용을 정의해놓는 객체이다.
        
        * 트리거의 종류
          1) SQL 문의 실행 시기에 따른 분류
            - BEFORE TRIGGER : 해당 SQL 문장 실행 전에 트리거를 실행한다.
            - AFTER TRIGGER : 해당 SQL 문장 실행 후에 트리거를 실행한다.
          
          2) SQL 문에 의해 영향을 받는 행에 따른 분류
            - 문장 트리거 : 해당 SQL 문에 한 번만 트리거를 실행한다.
            - 행 트리거 : 해당 SQL 문에 영향을 받는 행마다 트리거를 실행한다.
            
        [문법]
            CREATE OR REPLACE TRIGGER 트리거명
            BEFORE|AFTER INSERT|UPDATE|DELETE ON 테이블명
            [FOR EACH ROW]
            DECLARE
                선언부
            BEGIN
                실행부
            EXCEPTION
                예외처리부
            END;
            /
*/
DROP TABLE TEMP;
CREATE TABLE TEMP(
    DATA VARCHAR2(100)
);

DROP TABLE TEMP_BACKUP;
CREATE TABLE TEMP_BACKUP(
    DATA_BACKUP VARCHAR2(100)    
);

SELECT * FROM TEMP;

-- TEMP 테이블에 트리거 설정
-- 시점 : UPDATE 이전 동작
-- 대상 : 모든 행 대상
-- 실행내용 : TEMP_BACKUP 테이블에 기존 ROW 를 INSERT

CREATE OR REPLACE TRIGGER T01
BEFORE UPDATE ON TEMP
FOR EACH ROW
BEGIN
    INSERT INTO TEMP_BACKUP (DATA_BACKUP) VALUES (:OLD.DATA);
END;
/
SELECT * FROM TEMP;
SELECT * FROM TEMP_BACKUP;

INSERT INTO TEMP(DATA) VALUES('HELLO');
UPDATE TEMP SET DATA = 'HI';


