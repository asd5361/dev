/*
    <SUBQUERY>
        하나의 SQL 문 안에 포함된 또 다른 SQL 문을 뜻한다. 
        메인 쿼리(기존 쿼리)를 보조하는 역할을 하는 쿼리문이다.
*/
SELECT (SELECT 10 FROM DUAL) + 20
FROM DUAL;

--노옹철 사원과 같은 부서 사람들의 사원명 조회
SELECT * 
FROM EMPLOYEE 
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE
WHERE EMP_NAME = '노옹철')
;
/*
    <서브 쿼리 구분>
        서브 쿼리는 서브 쿼리를 수행한 결과값의 행과 열의 개수에 따라서 분류할 수 있다.
        
        1) 단일행, 단일열 서브 쿼리  : 서브 쿼리의 조회 결과 값의 행과 열의 개수가 1개 일 때
        2) 다중행 서브 쿼리         : 서브 쿼리의 조회 결과 값의 행의 개수가 여러 행 일 때
        3) 다중열 서브 쿼리         : 서브 쿼리의 조회 결과 값이 한 행이지만 칼럼이 여러개 일때
        4) 다중행, 다중열 서브 쿼리  : 서브 쿼리의 조회 결과 값이 여러행, 여러열 일 때
        
        * 서브 쿼리의 유형에 따라서 서브 쿼리 앞에 붙는 연산자가 달라진다.
 */
 
 
 /*
    <단일행 단일열 서브 쿼리>
        서브 쿼리의 조회 결과 값의 행과 열의 개수가 1개 일 때 (단일행, 단일열)
        비교 연산자(단일행 연산자) 사용 가능 (=, !=, <>, ^=, >, <, >=, <=, ...)
*/

-- 1) 전 직원의 평균 급여보다 급여를 적게 받는 직원들의 이름, 직급 코드, 급여 조회
SELECT EMP_NAME, JOB_CODE,SALARY 
FROM EMPLOYEE WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEE)
;

-- 2) 최저 급여를 받는 직원의 이름, 급여 조회
SELECT EMP_NAME, JOB_CODE,SALARY 
FROM EMPLOYEE WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE)
;

-- 3) 노옹철 사원의 급여보다 더 많은 급여를 받는 사원들의 사원명, 급여 조회
SELECT EMP_NAME , SALARY 
FROM EMPLOYEE WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');

-- 4) 부서별 급여의 합이 가장 큰 부서의 부서 코드, 급여의 합 조회
SELECT DEPT_CODE, SUM(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING SUM(SALARY) = 17700000; -- 밑에 쿼리 결과값 대입
SELECT DEPT_CODE, SUM(SALARY) 
FROM EMPLOYEE GROUP BY DEPT_CODE 
HAVING SUM(SALARY) = (
                        SELECT MAX(A) FROM (SELECT DEPT_CODE,SUM(SALARY)AS A FROM EMPLOYEE GROUP BY DEPT_CODE)
                    );
-- 5) 전지연 사원이 속해있는 부서원들 조회 (단, 전지연 사원은 제외)
SELECT E.EMP_ID, 
       E.EMP_NAME, 
       E.PHONE, 
       J.JOB_NAME, 
       D.DEPT_TITLE,
       E.HIRE_DATE
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
WHERE E.DEPT_CODE = (
                        SELECT DEPT_CODE
                        FROM EMPLOYEE
                        WHERE EMP_NAME = '전지연'
                    ) 
AND E.EMP_NAME != '전지연'
;

/*
    <다중행 서브 쿼리>
        서브 쿼리의 조회 결과 값의 행의 개수가 여러 행 일 때
        
        IN / NOT IN (서브 쿼리) : 여러 개의 결과값 중에서 한 개라도 일치하는 값이 있다면 혹은 없다면 TRUE를 리턴한다.
        ANY : 여러 개의 값들 중에서 한 개라도 만족하면 TRUE, IN과 다른 점은 비교 연산자를 함께 사용한다는 점이다. 
            ANY(100, 200, 300)
            SALARY = ANY(...)  : IN과 같은 결과
            SALARY != ANY(...) : NOT IN과 같은 결과
            SALARY > ANY(...)  : 최소값 보다 크면 TRUE
            SALARY < ANY(...)  : 최대값 보다 작으면 TRUE
        ALL : 여러 개의 값들 모두와 비교하여 만족해야 TRUE, IN과 다른 점은 비교 연산자를 함께 사용한다는 점이다.
            ALL(100, 200, 300)
            SALARY > ALL(...)  : 최대값 보다 크면 TRUE
            SALARY < ALL(...)  : 최소값 보다 작으면 TRUE
*/
--부서 별 최고 급여를 받는 직원의 이름, 급여, 부서코드
SELECT EMP_NAME, SALARY,DEPT_CODE  
FROM EMPLOYEE 
WHERE SALARY IN (SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE )
;

--부사수가 있는 사원의 사번, 이름 조회
SELECT EMP_ID,EMP_NAME
FROM EMPLOYEE 
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID) FROM EMPLOYEE WHERE MANAGER_ID IS NOT NULL)
;

--대리 직급의 사원들 중 급여가 과장 직급의 최소 급여보다 많은 직원 
--직급, 사원명, 급여

SELECT JOB_NAME, EMP_NAME, SALARY FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE J.JOB_NAME = '대리'
AND SALARY > ANY(
        SELECT E.SALARY
        FROM EMPLOYEE E
        JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
        WHERE J.JOB_NAME = '과장'
);--답안

SELECT JOB_NAME, EMP_NAME, SALARY FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE --JOIN JOB USING(JOB_CODE)
WHERE J.JOB_NAME IN '대리'
AND SALARY > (
    SELECT MIN(SALARY) FROM EMPLOYEE WHERE JOB_CODE = (
        SELECT JOB_CODE FROM JOB WHERE JOB_NAME = '과장')
);--내가 한거

/*
    GROUP BY 설명 :
    - GROUP BY 기준이 되는 칼럼
    - GROUP 함수
*/

--다중 열 서브쿼리

--하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원 이름, 부서코드, 직급코드 조회
SELECT EMP_NAME, DEPT_CODE, JOB_CODE FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '하이유')
--WHERE (DEPT_CODE, JOB_CODE) = (('D5','J5')) --이런 형식도 가능
;

--인라인 뷰 (FROM 절에 서브쿼리 작성)
select * from (select * from employee);

-- TOP-N ,상위 N 칼럼 조회
SELECT * --EMP_ID, EMP_NAME ,SALARY 
FROM (
    select ROWNUM AS RNUM, E.* FROM
    (SELECT EMP_ID, EMP_NAME ,SALARY FROM EMPLOYEE ORDER BY SALARY DESC) E
)
WHERE RNUM BETWEEN 4 AND 6
;

--
/* 
    WITH (임시 테이블 생성)
    필요시 검색
*/

/*
    <RANK 함수>
        [표현법]
            RANK() OVER(정렬 기준) / DENSE_RANK() OVER(정렬 기준)
        
         RANK() OVER(정렬 기준)         : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 순위를 계산한다.
                                         (EX. 공동 1위가 2명이면 다음 순위는 3위)
         DENSE_RANK() OVER(정렬 기준)   : 동일한 순위 이후의 등수를 무조건 1씩 증가한다.
                                         (EX. 공동 1위가 2명이면 다음 순위는 2위)
*/
--급여 높은 순으로 순위 매기기
--급여 순위, 사원명, 급여
SELECT * 
FROM(
    SELECT RANK() OVER(ORDER BY SALARY DESC) AS SRANK, EMP_NAME, SALARY FROM EMPLOYEE
    )
WHERE SRANK >= 3
;
