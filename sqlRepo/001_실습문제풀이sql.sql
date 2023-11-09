------------------- 실습 문제 -------------------
-- 1. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호 조회
select emp_name, phone from employee where NOT phone like '010%';

-- 2. DEPARTMENT 테이블에서 해외영업부에 대한 모든 컬럼 조회
select * from DEPARTMENT where dept_title like '해외영업%';


------------------------------------------------

