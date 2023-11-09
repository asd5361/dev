--함수(FUNCTION)
/*
    <함수>
        컬럼값을 읽어서 계산 결과를 반환한다.
          - 단일행 함수 : N개의 값을 읽어서 N개의 결과를 리턴한다. (매 행 함수 실행 -> 결과 반환)
          - 그룹 함수   : N개의 값을 읽어서 1개의 결과를 리턴한다. (하나의 그룹별로 함수 실행 -> 결과 반환)
        SELECT 절에 단일행 함수와 그룹 함수를 함께 사용하지 못한다. (결과 행의 개수가 다르기 때문에)
        함수를 기술할 수 있는 위치는 SELECT, WHERE, ORDER BY, GROUP BY, HAVING 절에 기술할 수 있다.
*/

/*
    <문자 관련 함수>
    1) LENGTH / LENGTHB
      - LENGTH(컬럼|'문자값') : 글자 수 반환
      - LENGTHB(컬럼|'문자값') : 글자의 바이트 수 반환
        한글 한 글자 -> 3BYTE
        영문자, 숫자, 특수문자 한 글자 -> 1BYTE
        
    * DUAL 테이블
      - SYS 사용자가 소유하는 테이블
      - SYS 사용자가 소유하지만 모든 사용자가 접근이 가능하다.
      - 한 행, 한 컬럼을 가지고 있는 더미(DUMMY) 테이블이다.
      - 사용자가 함수(계산)를 사용할 때 임시로 사용하는 테이블이다.
*/

SELECT 'HELLO' FROM DUAL;
SELECT LENGTH('HELLO') FROM DUAL;

-- 모든 사원의 이메일, 이메일 글자 수(글자 수 별칭) 조회
SELECT EMP_NAME,EMAIL,LENGTH(EMAIL) AS "글자 수" FROM employee;


/*
    2) INSTR
        - INSTR(칼럼|'문자값', '문자'[, POSITION[, OCCURRENCE]])
        - 지정한 위치부터 지정된 숫자 번째로 나타나는 문자의 시작 위치를 반환한다.
*/
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; -- 첫번째 인자에서 두번째 인자를 탐색
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL; -- 3번째 인자값 인텍스부터 탐색 시작
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- (4번째 인자값)번 째 등장한 값의 위치
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- -1은 뒤에서 첫번째부터 탐색을 의미
SELECT INSTR('AABAACAABBAA', 'B', -1, 3) FROM DUAL;

/*
    3) LPAD / RPAD
        - LPAD/RPAD(컬럼|'문자값', 길이[, '덧붙이려고 하는 문자'])
        - 제시된 컬럼|'문자값'에 임의의 문자를 왼쪽 또는 오른쪽에 덧붙여 최종 N 길이 만큼의 문자열을 반환한다.
        - 문자에 대해 통일감 있게 표시하고자 할 때 사용한다.
*/
SELECT lPAD(EMAIL,20) FROM EMPLOYEE;

/*
    4) LTRIM / RTRIM
        - LTRIM/RTRIM(컬럼|'문자값'[, '제거하고자 하는 문자'])
        - 문자열의 왼쪽 혹은 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 결과를 반환한다.
        - 제거하고자 하는 문자값을 생략 시 기본값으로 공백을 제거한다.
*/
SELECT LTRIM('   KH') FROM DUAL;
SELECT LTRIM('0001234560', '0') FROM DUAL;
SELECT LTRIM(' 123123KH', '312 ') FROM DUAL;

SELECT RTRIM('KH   ') FROM DUAL;
SELECT RTRIM('00012300004560000', '0' ) FROM DUAL;

SELECT RTRIM(LTRIM('   KH   ')) FROM DUAL;

/*
    5) TRIM
        - TRIM([[LEADING|TRAILING|BOTH] '제거하고자 하는 문자값' FROM] 컬럼|'문자값')
        - 문자값 앞/뒤/양쪽에 있는 지정한 문자를 제거한 나머지를 반환한다. 
        - 제거하고자 하는 문자값을 생략 시 기본적으로 양쪽에 있는 공백을 제거한다. 
*/
SELECT TRIM('   KH   ') FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;

/*
    6) SUBSTR
        - SUBSTR(컬럼|'문자값', POSITION[, LENGTH])
        - 문자데이터에서 지정한 위치부터 지정한 개수만큼의 문자열을 추출해서 반환한다.  
*/
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;
SELECT SUBSTR('쇼우 미 더 머니', 2, 5) FROM DUAL;

/*
    7) LOWER / UPPER / INITCAP
        - LOWER/UPPER/INITCAP(컬럼|'문자값')
            LOWER : 모두 소문자로 변경한다.
            UPPER : 모두 대문자로 변경한다.
            INITCAP : 단어 앞 글자마다 대문자로 변경한다.
*/
SELECT LOWER('Welcome To My World!') FROM DUAL;
SELECT UPPER('Welcome To My World!') FROM DUAL;
SELECT INITCAP('welcome to my world!') FROM DUAL;
/*
    8) CONCAT
        - CONCAT(컬럼|'문자값', 컬럼|'문자값')
        - 문자데이터 두 개를 전달받아서 하나로 합친 후 결과를 반환한다.
*/
SELECT CONCAT('가나다라', 'ABCD') FROM DUAL;
SELECT '가나다라' || 'ABCD' FROM DUAL;

SELECT CONCAT('가나다라', 'ABCD', '1234') FROM DUAL; -- 에러 발생(CONCAT은 두 개의 문자데이터만 전달받을 수 있다. )
SELECT CONCAT(CONCAT('가나다라', 'ABCD'), '1234') FROM DUAL;
SELECT '가나다라' || 'ABCD' || '1234' FROM DUAL;

SELECT CONCAT(EMP_ID, EMP_NAME) FROM EMPLOYEE;

/*
    9) REPLACE
    - REPLACE(컬럼|'문자값', 변경하려고 하는 문자, 변경하고자 하는 문자)
    - 컬럼 또는 문자값에서 "변경하려고 하는 문자"를 "변경하고자 하는 문자"로 변경해서 반환한다.
*/
SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') FROM DUAL;

----숫자 관련 함수 ----
/*
    1) ABS
        - ABS(NUBER)
        - 절대값을 구하는 함수
*/
SELECT ABS(10.9) FROM DUAL;
SELECT ABS(-10.9) FROM DUAL;

/*
    2) MOD
        - MOD(NUMBER, NUMBER)
        - 두 수를 나눈 나머지를 반환해 주는 함수 (자바의 % 연산과 동일하다.)
*/

-- SELECT 10 % 3 FROM DUAL;
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(-10, 3) FROM DUAL;
SELECT MOD(10, -3) FROM DUAL;
SELECT MOD(10.9, -3) FROM DUAL;
SELECT MOD(-10.9, 3) FROM DUAL;

/*
    3) ROUND
        - ROUND(NUMBER[, 위치])
        - 위치를 지정하여 반올림해주는 함수
        - 위치 : 기본값 0(.), 양수(소수점 기준으로 오른쪽)와 음수(소수점 기준으로 왼쪽)로 입력가능
*/
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL;
SELECT ROUND(123.456, 4) FROM DUAL;
SELECT ROUND(123.456, -1) FROM DUAL;
SELECT ROUND(123.456, -2) FROM DUAL;
SELECT ROUND(123.456, -3) FROM DUAL;
SELECT ROUND(723.456, -3) FROM DUAL;

/*
    4) CEIL
        - CEIL(NUMBER)
        - 소수점 기준으로 올림해주는 함수
*/
--SELECT CEIL(123.456, 2) FROM DUAL;
SELECT CEIL(123.456) FROM DUAL;

/*
    5) FLOOR
        - FLOOR(NUMBER)
        - 소수점 기준으로 버림하는 함수
*/
SELECT FLOOR(123.456) FROM DUAL;
SELECT FLOOR(123.789) FROM DUAL;

/*
    6) TRUNC
        - TRUNC(NUMBER[, 위치])
        - 위치를 지정하여 버림이 가능한 함수
        - 위치 : 기본값 0(.), 양수(소수점 기준으로 오른쪽)와 음수(소수점 기준으로 왼쪽)로 입력가능
*/
SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.456, 1) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

/*
    <날짜 관련 함수>
    
    1) SYSDATE
        시스템의 현재 날짜와 시간을 반환한다.
*/
SELECT SYSDATE FROM DUAL;

/* 
    2) MONTHS_BETWEEN
        [문법]
            MONTHS_BETWEEN(DATE1, DATE2)
            
        - 입력받은 두 날짜 사이의 개월 수를 반환한다.
        - 결과값은 NUMBER 타입이다.
*/
-- EMPLOYEE 테이블에서 직원명, 입사일, 근무개월수
SELECT EMP_NAME, HIRE_DATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
FROM EMPLOYEE;

/*
    3) ADD_MONTHS
        [문법]
            ADD_MONTHS(DATE, NUMBER)
            
        - 특정 날짜에 입력받는 숫자만큼의 개월 수를 더한 날짜를 리턴한다.
        - 결과값은 DATE 타입이다.
*/

SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL;
SELECT ADD_MONTHS('20/12/31', 2) FROM DUAL;

/*
    4) NEXT_DAY
        [문법]
            NEXT_DAY(DATE, 요일(문자|숫자))
        
        - 특정 날짜에서 구하려는 요일의 가장 가까운 날짜를 리턴한다.
        - 결과값은 DATE 타입이다.
*/
SELECT SYSDATE, NEXT_DAY(SYSDATE, '목요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '화') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1) FROM DUAL;-- 1:일요일, 2:월요일, ..., 7:토요일
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY') FROM DUAL; -- 에러(현재 언어가 KOREAN이기 때문에)

ALTER SESSION SET NLS_LANGUAGE = AMERICAN; -- 언어 변경
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'MON') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 6) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '목') FROM DUAL; -- 에러 발생
SELECT SYSDATE, NEXT_DAY(SYSDATE, '목요일') FROM DUAL; -- 에러 발생

ALTER SESSION SET NLS_LANGUAGE = KOREAN; -- 언어 변경

/*
    5) LAST_DAY
        [문법]
            LAST_DAY(DATE)
        
        - 해당 월의 마지막 날짜를 반환한다.
        - 결과값은 DATE 타입이다.   
*/
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- EMPLOYEE 테이블에서 직원명, 입사일, 입사월의 마지막 날짜 조회
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE)
FROM EMPLOYEE;

/*
    6) EXTRACT
        [문법]
            EXTRACT(YEAR|MONTH|DAY FROM DATE);
            
        - 특정 날짜에서 연도, 월, 일 정보를 추출해서 반환한다.
          YEAR : 연도만 추출
          MONTH : 월만 추출
          DAY :  일만 추출
        - 결과값은 NUMBER 타입이다.
*/
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;

-- EMPLOYEE 테이블에서 직원명, 입사연도, 입사월, 입사일 조회
SELECT EMP_NAME, 
       HIRE_DATE,
       EXTRACT(YEAR FROM HIRE_DATE) AS "연도",
       EXTRACT(MONTH FROM HIRE_DATE),
       EXTRACT(DAY FROM HIRE_DATE)
FROM EMPLOYEE
--ORDER BY EXTRACT(YEAR FROM HIRE_DATE);
--ORDER BY "연도";
--ORDER BY 3, 4, 5;
ORDER BY HIRE_DATE;

-- 날짜포멧변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

SELECT SYSDATE FROM DUAL;

/*
    <형변환 함수>
    
    1) TO_CHAR
        [문법]
            TO_CHAR(날짜|숫자[, 포멧])
        
        - 날짜 또는 숫자 타입의 데이터를 문자 타입으로 변환해서 반환한다.
        - 결과값은 CHARACTER 타입이다.
*/
-- 숫자 --> 문자
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '999999') FROM DUAL; -- 6칸의 공간을 확보, 오른쪽 정렬, 빈칸은 공백으로 채운다.
SELECT TO_CHAR(1234, '000000') FROM DUAL; -- 6칸의 공간을 확보, 오른쪽 정렬, 빈칸은 0으로 채운다.
SELECT TO_CHAR(1234, 'L999999') FROM DUAL; -- 현재 설정된 나라(LOCAL)의 화폐단위
SELECT TO_CHAR(1234, '$999999') FROM DUAL;
SELECT TO_CHAR(1234, 'L') FROM DUAL;
SELECT TO_CHAR(1234, 'L999,999') FROM DUAL; -- 자리수 구분 콤마

--EMPLOYEE 테이블에서 사원명, 급여 조회
SELECT EMP_NAME, TO_CHAR(SALARY, 'FML99,999,999')
FROM EMPLOYEE
ORDER BY SALARY;

-- 날짜 --> 문자
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD(DY)') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일"(DY)') FROM DUAL;

-- 연도에 대한 포멧
-- 연도에 관련된 포맷 문자는 'Y', 'R'이 있다.
SELECT TO_CHAR(SYSDATE, 'YYYY'),
       TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

-- 월에 대한 포멧
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MON'),
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'RM') -- 로마 기호
FROM DUAL;

-- 일에 대한 포멧
SELECT TO_CHAR(SYSDATE, 'DDD'), -- 1년을 기준으로 며칠째
       TO_CHAR(SYSDATE, 'DD'),  -- 1달을 기준으로 며칠째
       TO_CHAR(SYSDATE, 'D')    -- 1주를 기준으로 며칠째
FROM DUAL;

-- 요일에 대한 포멧
SELECT TO_CHAR(SYSDATE, 'DAY'),
       TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

-- EMPLOYEE 테이블에서 직원명, 입사일 조회
-- 단, 입사일은 포멧을 지정해서 조회한다.(2021-09-28(화))
SELECT EMP_NAME,
       TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"(DY)')
FROM EMPLOYEE;

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;


/*
    2) TO_DATE
        [문법]
            TO_DATE(숫자|문자[, 포멧])
        
        - 숫자 또는 문자형 데이터를 날짜 타입으로 변환해서 반환한다.
        - 결과값은 DATE 타입이다.
*/
-- 숫자 --> 날짜
SELECT TO_DATE(20211014) FROM DUAL;
SELECT TO_DATE(20211014190830) FROM DUAL;

-- 문자 --> 날짜
SELECT TO_DATE('20211014') FROM DUAL;
SELECT TO_DATE('20211014 190830') FROM DUAL; 
SELECT TO_DATE('20211014', 'YYYYMMDD') FROM DUAL;

-- YY와 RR 비교
SELECT TO_DATE('110923', 'YYMMDD') FROM DUAL;
SELECT TO_DATE('990923', 'YYMMDD') FROM DUAL; -- YY : 무조건 현재 세기

SELECT TO_DATE('110923', 'RRMMDD') FROM DUAL;
SELECT TO_DATE('990923', 'RRMMDD') FROM DUAL; -- RR : 해당 값이 50 이상이면 이전 세기, 50 미만이면 현재 세기 

-- EMPLOYEE 테이블에서 1998년 1월 1일 이후에 입사한 사원의 사번, 이름, 입사일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
--WHERE HIRE_DATE > TO_DATE('19980101', 'YYYYMMDD');
--WHERE HIRE_DATE > TO_DATE('980101', 'RRMMDD');
WHERE HIRE_DATE > '980101';

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

/*
    3) TO_NUMBER
        [문법]
            TO_NUMBER('문자값'[, 포멧])
        
        - 문자 타입의 데이터를 숫자 타입의 데이터로 변환해서 반환한다.
        - 결과값은 NUMBER 타입이다.
*/
SELECT TO_NUMBER('0123456789') FROM DUAL;
SELECT '123' + '456' FROM DUAL; -- 자동으로 숫자 타입으로 형변환 뒤 연산처리를 해준다.
SELECT '123' + '456A' FROM DUAL; -- 에러 발생(숫자 형태의 문자들만 자동형변환 된다.)
SELECT '10,000,000' + '500,000' FROM DUAL; -- 에러 발생
SELECT TO_NUMBER('10,000,000', '99,999,999') + TO_NUMBER('500,000', '999,999') FROM DUAL;

--NULL 처리 함수
/*
    1) NVL
        [문법]
        - NVL(컬럼, 컬럼값이 NULL일 경우 반환할 값)
        
        - NULL로 되어있는 컬럼의 값을 인자로 지정한 값으로 변경하여 반환한다.
    
    2) NVL2
        [문법]
        - NVL2(컬럼, 변경할 값 1, 변경할 값 2)
            
        - 컬럼 값이 NULL이 아니면 변경할 값 1, 컬럼 값이 NULL이면 변경할 값 2로 변경하여 반환한다.  
    
    3) NULLIF
        [문법]
        - NULLIF(비교대상 1, 비교대상 2)
            
        - 두 개의 값이 동일하면 NULL 반환, 두 개의 값이 동일하지 않으면 비교대상 1을 반환한다.
*/
-- EMPLOYEE 테이블에서 사원명, 보너스, 보너스가 포함된 연봉 조회
SELECT EMP_NAME, NVL(bonus,0)AS BONUS, NVL(BONUS,0)*salary+salary*12 AS "연봉" FROM employee;

-- EMPLOYEE 테이블에서 사원명, 부서 코드 조회(단, 부서코드가 NULL 이면 "부서없음" 출력)
SELECT EMP_NAME, NVL(DEPT_CODE,'부서없음') AS DEPT_CODE FROM EMPLOYEE;

--보너스 일괄적용 하여 연봉 조회(있던 사람들은 무조건 10%로 적용, 없으면 안줌)
-- 사원 이름, 보너스, 연봉, 월급, 보너스 받은 금액
SELECT EMP_NAME, NVL(bonus,0) AS BONUS, 
SALARY*12+salary*NVL2(bonus,0.1,0)AS "연봉" ,
SALARY, salary*NVL2(bonus,0.1,0)AS "보너스"
FROM employee;

--NVLIF 예제 코드
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;

SELECT NULLIF(123, 123) FROM DUAL; 
SELECT NULLIF(123, 456) FROM DUAL;
/*
    <선택함수>
        여러 가지 경우에 선택을 할 수 있는 기능을 제공하는 함수이다.
    
    1) DECODE
        [문법]
            DECODE(칼럼|계산식, 조건값 1, 결과값 1, 조건값 2, 결과값 2, ..., 결과값)
        
        - 비교하고자 하는 값이 조건값과 일치할 경우 그에 해당하는 결과값을 반환해 주는 함수이다.
*/
-- 값이 많아진다면 DECODE 말고 CASE END 이용하는 것이 좋다.
SELECT EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO,8,1),1,'남자',2,'여자') AS "성별" FROM EMPLOYEE;

/*
    2) CASE
        [문법]
            CASE WHEN 조건식 1 THEN 결과값 1
                 WHEN 조건식 2 THEN 결과값 2
                 ...
                 ELSE 결과값 N
            END
*/
SELECT 
    EMP_NAME
    ,EMP_NO
    ,CASE
        WHEN SUBSTR(EMP_NO,8,1)=1 THEN '남자'
        WHEN SUBSTR(EMP_NO,8,1)=2 THEN '여자'
        ELSE '2000년대생 이거나 외국인입니다'
    END  AS "성별"
FROM EMPLOYEE;

/*
    <그룹 함수>
        대량의 데이터들로 집계나 통계 같은 작업을 처리해야 하는 경우 사용되는 함수들이다.
        모든 그룹 함수는 NULL 값을 자동으로 제외하고 값이 있는 것들만 계산을 한다.
        따라서 AVG 함수를 사용할 때는 반드시 NVL() 함수와 함께 사용하는 것을 권장한다.
        
              1) SUM
            [문법]
                SUM(NUMBER)
                
            - 해당 칼럼 값들의 총 합계를 반환한다.
            
         2) AVG
            [문법]
                AVG(NUMBER)
            
            - 해당 컬럼 값들의 평균을 구해서 반환한다.
        
         3) MIN / MAX
            [문법]
                MIN/MAX(모든 타입 컬럼)
            
            - MIN : 해당 컬럼 값들 중에 가장 작은 값을 반환한다.
            - MAX : 해당 컬럼 값들 중에 가장 큰 값을 반환한다.
            
         4) COUNT
            [문법]
                COUNT(*|컬럼명|DISTINCT 컬럼명)
            
            - 컬럼 또는 행의 개수를 세서 반환하는 함수이다.
            - COUNT(*) : 조회 결과에 해당하는 모든 행의 개수를 반환한다.
            - COUNT(컬럼명) : 제시한 컬럼 값이 NULL이 아닌 행의 개수를 반환한다.
            - COUNT(DISTINCT 컬럼명) 해당 컬럼 값의 중복을 제거한 행의 개수를 반환한다. 
*/

-- 모든 사원의 월급 합계
SELECT  SUM(salary)
        ,AVG(SALARY)
        ,MIN(SALARY)
        ,MAX(sALARY)
        ,COUNT(SALARY) 
FROM EMPLOYEE;

-- 그룹함수는 NULL값을 취급하지 않는다. NULL값을 0으로 치환한 뒤 계산
SELECT AVG(NVL(BONUS,0)) FROM EMPLOYEE;
