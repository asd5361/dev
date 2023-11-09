/*
    <PROCEDURE>
        PL/SQL 문을 저장하는 객체이다.
        필요할 때마다 복잡한 구문을 다시 입력할 필요 없이 간단하게 호출해서 실행 결과를 얻을 수 있다.
        특정 로직을 처리하기만 하고 결과값을 반환하지 않는다.
        
        [문법]
            CREATE PROCEDURE 프로시저명
            (
                매개변수 1 [IN/OUT] 테이터타입 [:=DEFAULT 값],
                매개변수 2 [IN/OUT] 테이터타입 [:=DEFAULT 값],
                ...
            )
            IS [AS]
                선언부
            BEGIN
                실행부
            EXCEPTION
                예외처리부
            END [프로시저명];
            /
            
        [실행방법]
            EXECUTE(EXEC) 프로시저명[(매개값1, 매개값2, ...)];
*/
DROP TABLE TEMP;
CREATE TABLE TEMP(
    DATA VARCHAR2(100)
);
SELECT * FROM TEMP;

CREATE OR REPLACE PROCEDURE ABC
IS
BEGIN
    INSERT INTO TEMP(DATA) VALUES ('HELLO');
    INSERT INTO TEMP(DATA) VALUES ('안녕');
    INSERT INTO TEMP(DATA) VALUES ('안녕하세요');
    INSERT INTO TEMP(DATA) VALUES ('HI');
END;
/
-- 프로시저 실행
EXECUTE ABC;

--프로시저 삭제
DROP PROCEDURE ABC;

/*
    <FUNCTION>
        프로시저와 사용 용도가 비슷하지만
        프로시저와 다르게 OUT 변수를 사용하지 않아도 실행 결과를 되돌려 받을 수 있다.(RETURN )
        
        [문법]
            CREATE FUNCTION 함수명
            (
                매개변수 1 타입,
                매개변수 2 타입,
                ...
            )
            RETURN 데이터타입
            IS
                선언부
            BEGIN
                실행부
                
                RETRUN 반환값; -- 프로시저랑 다르게 RETURN 구문이 추가된다.
            EXCEPTION
                예외처리부
            END [함수명];
            /
*/
--리턴값 있는 프로시저
CREATE OR REPLACE FUNCTION F01
RETURN NUMBER
IS
BEGIN
    RETURN 10+20;
END;
/

-- 프로시저 실행
SELECT F01 FROM DUAL;
