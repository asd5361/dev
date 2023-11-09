--�Լ�(FUNCTION)
/*
    <�Լ�>
        �÷����� �о ��� ����� ��ȯ�Ѵ�.
          - ������ �Լ� : N���� ���� �о N���� ����� �����Ѵ�. (�� �� �Լ� ���� -> ��� ��ȯ)
          - �׷� �Լ�   : N���� ���� �о 1���� ����� �����Ѵ�. (�ϳ��� �׷캰�� �Լ� ���� -> ��� ��ȯ)
        SELECT ���� ������ �Լ��� �׷� �Լ��� �Բ� ������� ���Ѵ�. (��� ���� ������ �ٸ��� ������)
        �Լ��� ����� �� �ִ� ��ġ�� SELECT, WHERE, ORDER BY, GROUP BY, HAVING ���� ����� �� �ִ�.
*/

/*
    <���� ���� �Լ�>
    1) LENGTH / LENGTHB
      - LENGTH(�÷�|'���ڰ�') : ���� �� ��ȯ
      - LENGTHB(�÷�|'���ڰ�') : ������ ����Ʈ �� ��ȯ
        �ѱ� �� ���� -> 3BYTE
        ������, ����, Ư������ �� ���� -> 1BYTE
        
    * DUAL ���̺�
      - SYS ����ڰ� �����ϴ� ���̺�
      - SYS ����ڰ� ���������� ��� ����ڰ� ������ �����ϴ�.
      - �� ��, �� �÷��� ������ �ִ� ����(DUMMY) ���̺��̴�.
      - ����ڰ� �Լ�(���)�� ����� �� �ӽ÷� ����ϴ� ���̺��̴�.
*/

SELECT 'HELLO' FROM DUAL;
SELECT LENGTH('HELLO') FROM DUAL;

-- ��� ����� �̸���, �̸��� ���� ��(���� �� ��Ī) ��ȸ
SELECT EMP_NAME,EMAIL,LENGTH(EMAIL) AS "���� ��" FROM employee;


/*
    2) INSTR
        - INSTR(Į��|'���ڰ�', '����'[, POSITION[, OCCURRENCE]])
        - ������ ��ġ���� ������ ���� ��°�� ��Ÿ���� ������ ���� ��ġ�� ��ȯ�Ѵ�.
*/
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; -- ù��° ���ڿ��� �ι�° ���ڸ� Ž��
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL; -- 3��° ���ڰ� ���ؽ����� Ž�� ����
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- (4��° ���ڰ�)�� ° ������ ���� ��ġ
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- -1�� �ڿ��� ù��°���� Ž���� �ǹ�
SELECT INSTR('AABAACAABBAA', 'B', -1, 3) FROM DUAL;

/*
    3) LPAD / RPAD
        - LPAD/RPAD(�÷�|'���ڰ�', ����[, '�����̷��� �ϴ� ����'])
        - ���õ� �÷�|'���ڰ�'�� ������ ���ڸ� ���� �Ǵ� �����ʿ� ���ٿ� ���� N ���� ��ŭ�� ���ڿ��� ��ȯ�Ѵ�.
        - ���ڿ� ���� ���ϰ� �ְ� ǥ���ϰ��� �� �� ����Ѵ�.
*/
SELECT lPAD(EMAIL,20) FROM EMPLOYEE;

/*
    4) LTRIM / RTRIM
        - LTRIM/RTRIM(�÷�|'���ڰ�'[, '�����ϰ��� �ϴ� ����'])
        - ���ڿ��� ���� Ȥ�� �����ʿ��� �����ϰ��� �ϴ� ���ڵ��� ã�Ƽ� ������ ����� ��ȯ�Ѵ�.
        - �����ϰ��� �ϴ� ���ڰ��� ���� �� �⺻������ ������ �����Ѵ�.
*/
SELECT LTRIM('   KH') FROM DUAL;
SELECT LTRIM('0001234560', '0') FROM DUAL;
SELECT LTRIM(' 123123KH', '312 ') FROM DUAL;

SELECT RTRIM('KH   ') FROM DUAL;
SELECT RTRIM('00012300004560000', '0' ) FROM DUAL;

SELECT RTRIM(LTRIM('   KH   ')) FROM DUAL;

/*
    5) TRIM
        - TRIM([[LEADING|TRAILING|BOTH] '�����ϰ��� �ϴ� ���ڰ�' FROM] �÷�|'���ڰ�')
        - ���ڰ� ��/��/���ʿ� �ִ� ������ ���ڸ� ������ �������� ��ȯ�Ѵ�. 
        - �����ϰ��� �ϴ� ���ڰ��� ���� �� �⺻������ ���ʿ� �ִ� ������ �����Ѵ�. 
*/
SELECT TRIM('   KH   ') FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;

/*
    6) SUBSTR
        - SUBSTR(�÷�|'���ڰ�', POSITION[, LENGTH])
        - ���ڵ����Ϳ��� ������ ��ġ���� ������ ������ŭ�� ���ڿ��� �����ؼ� ��ȯ�Ѵ�.  
*/
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;
SELECT SUBSTR('��� �� �� �Ӵ�', 2, 5) FROM DUAL;

/*
    7) LOWER / UPPER / INITCAP
        - LOWER/UPPER/INITCAP(�÷�|'���ڰ�')
            LOWER : ��� �ҹ��ڷ� �����Ѵ�.
            UPPER : ��� �빮�ڷ� �����Ѵ�.
            INITCAP : �ܾ� �� ���ڸ��� �빮�ڷ� �����Ѵ�.
*/
SELECT LOWER('Welcome To My World!') FROM DUAL;
SELECT UPPER('Welcome To My World!') FROM DUAL;
SELECT INITCAP('welcome to my world!') FROM DUAL;
/*
    8) CONCAT
        - CONCAT(�÷�|'���ڰ�', �÷�|'���ڰ�')
        - ���ڵ����� �� ���� ���޹޾Ƽ� �ϳ��� ��ģ �� ����� ��ȯ�Ѵ�.
*/
SELECT CONCAT('�����ٶ�', 'ABCD') FROM DUAL;
SELECT '�����ٶ�' || 'ABCD' FROM DUAL;

SELECT CONCAT('�����ٶ�', 'ABCD', '1234') FROM DUAL; -- ���� �߻�(CONCAT�� �� ���� ���ڵ����͸� ���޹��� �� �ִ�. )
SELECT CONCAT(CONCAT('�����ٶ�', 'ABCD'), '1234') FROM DUAL;
SELECT '�����ٶ�' || 'ABCD' || '1234' FROM DUAL;

SELECT CONCAT(EMP_ID, EMP_NAME) FROM EMPLOYEE;

/*
    9) REPLACE
    - REPLACE(�÷�|'���ڰ�', �����Ϸ��� �ϴ� ����, �����ϰ��� �ϴ� ����)
    - �÷� �Ǵ� ���ڰ����� "�����Ϸ��� �ϴ� ����"�� "�����ϰ��� �ϴ� ����"�� �����ؼ� ��ȯ�Ѵ�.
*/
SELECT REPLACE('����� ������ ���ﵿ', '���ﵿ', '�Ｚ��') FROM DUAL;

----���� ���� �Լ� ----
/*
    1) ABS
        - ABS(NUBER)
        - ���밪�� ���ϴ� �Լ�
*/
SELECT ABS(10.9) FROM DUAL;
SELECT ABS(-10.9) FROM DUAL;

/*
    2) MOD
        - MOD(NUMBER, NUMBER)
        - �� ���� ���� �������� ��ȯ�� �ִ� �Լ� (�ڹ��� % ����� �����ϴ�.)
*/

-- SELECT 10 % 3 FROM DUAL;
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(-10, 3) FROM DUAL;
SELECT MOD(10, -3) FROM DUAL;
SELECT MOD(10.9, -3) FROM DUAL;
SELECT MOD(-10.9, 3) FROM DUAL;

/*
    3) ROUND
        - ROUND(NUMBER[, ��ġ])
        - ��ġ�� �����Ͽ� �ݿø����ִ� �Լ�
        - ��ġ : �⺻�� 0(.), ���(�Ҽ��� �������� ������)�� ����(�Ҽ��� �������� ����)�� �Է°���
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
        - �Ҽ��� �������� �ø����ִ� �Լ�
*/
--SELECT CEIL(123.456, 2) FROM DUAL;
SELECT CEIL(123.456) FROM DUAL;

/*
    5) FLOOR
        - FLOOR(NUMBER)
        - �Ҽ��� �������� �����ϴ� �Լ�
*/
SELECT FLOOR(123.456) FROM DUAL;
SELECT FLOOR(123.789) FROM DUAL;

/*
    6) TRUNC
        - TRUNC(NUMBER[, ��ġ])
        - ��ġ�� �����Ͽ� ������ ������ �Լ�
        - ��ġ : �⺻�� 0(.), ���(�Ҽ��� �������� ������)�� ����(�Ҽ��� �������� ����)�� �Է°���
*/
SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.456, 1) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

/*
    <��¥ ���� �Լ�>
    
    1) SYSDATE
        �ý����� ���� ��¥�� �ð��� ��ȯ�Ѵ�.
*/
SELECT SYSDATE FROM DUAL;

/* 
    2) MONTHS_BETWEEN
        [����]
            MONTHS_BETWEEN(DATE1, DATE2)
            
        - �Է¹��� �� ��¥ ������ ���� ���� ��ȯ�Ѵ�.
        - ������� NUMBER Ÿ���̴�.
*/
-- EMPLOYEE ���̺��� ������, �Ի���, �ٹ�������
SELECT EMP_NAME, HIRE_DATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
FROM EMPLOYEE;

/*
    3) ADD_MONTHS
        [����]
            ADD_MONTHS(DATE, NUMBER)
            
        - Ư�� ��¥�� �Է¹޴� ���ڸ�ŭ�� ���� ���� ���� ��¥�� �����Ѵ�.
        - ������� DATE Ÿ���̴�.
*/

SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL;
SELECT ADD_MONTHS('20/12/31', 2) FROM DUAL;

/*
    4) NEXT_DAY
        [����]
            NEXT_DAY(DATE, ����(����|����))
        
        - Ư�� ��¥���� ���Ϸ��� ������ ���� ����� ��¥�� �����Ѵ�.
        - ������� DATE Ÿ���̴�.
*/
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'ȭ') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1) FROM DUAL;-- 1:�Ͽ���, 2:������, ..., 7:�����
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY') FROM DUAL; -- ����(���� �� KOREAN�̱� ������)

ALTER SESSION SET NLS_LANGUAGE = AMERICAN; -- ��� ����
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'MON') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 6) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL; -- ���� �߻�
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����') FROM DUAL; -- ���� �߻�

ALTER SESSION SET NLS_LANGUAGE = KOREAN; -- ��� ����

/*
    5) LAST_DAY
        [����]
            LAST_DAY(DATE)
        
        - �ش� ���� ������ ��¥�� ��ȯ�Ѵ�.
        - ������� DATE Ÿ���̴�.   
*/
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- EMPLOYEE ���̺��� ������, �Ի���, �Ի���� ������ ��¥ ��ȸ
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE)
FROM EMPLOYEE;

/*
    6) EXTRACT
        [����]
            EXTRACT(YEAR|MONTH|DAY FROM DATE);
            
        - Ư�� ��¥���� ����, ��, �� ������ �����ؼ� ��ȯ�Ѵ�.
          YEAR : ������ ����
          MONTH : ���� ����
          DAY :  �ϸ� ����
        - ������� NUMBER Ÿ���̴�.
*/
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;

-- EMPLOYEE ���̺��� ������, �Ի翬��, �Ի��, �Ի��� ��ȸ
SELECT EMP_NAME, 
       HIRE_DATE,
       EXTRACT(YEAR FROM HIRE_DATE) AS "����",
       EXTRACT(MONTH FROM HIRE_DATE),
       EXTRACT(DAY FROM HIRE_DATE)
FROM EMPLOYEE
--ORDER BY EXTRACT(YEAR FROM HIRE_DATE);
--ORDER BY "����";
--ORDER BY 3, 4, 5;
ORDER BY HIRE_DATE;

-- ��¥���亯��
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

SELECT SYSDATE FROM DUAL;

/*
    <����ȯ �Լ�>
    
    1) TO_CHAR
        [����]
            TO_CHAR(��¥|����[, ����])
        
        - ��¥ �Ǵ� ���� Ÿ���� �����͸� ���� Ÿ������ ��ȯ�ؼ� ��ȯ�Ѵ�.
        - ������� CHARACTER Ÿ���̴�.
*/
-- ���� --> ����
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '999999') FROM DUAL; -- 6ĭ�� ������ Ȯ��, ������ ����, ��ĭ�� �������� ä���.
SELECT TO_CHAR(1234, '000000') FROM DUAL; -- 6ĭ�� ������ Ȯ��, ������ ����, ��ĭ�� 0���� ä���.
SELECT TO_CHAR(1234, 'L999999') FROM DUAL; -- ���� ������ ����(LOCAL)�� ȭ�����
SELECT TO_CHAR(1234, '$999999') FROM DUAL;
SELECT TO_CHAR(1234, 'L') FROM DUAL;
SELECT TO_CHAR(1234, 'L999,999') FROM DUAL; -- �ڸ��� ���� �޸�

--EMPLOYEE ���̺��� �����, �޿� ��ȸ
SELECT EMP_NAME, TO_CHAR(SALARY, 'FML99,999,999')
FROM EMPLOYEE
ORDER BY SALARY;

-- ��¥ --> ����
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD(DY)') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY"��"MM"��"DD"��"(DY)') FROM DUAL;

-- ������ ���� ����
-- ������ ���õ� ���� ���ڴ� 'Y', 'R'�� �ִ�.
SELECT TO_CHAR(SYSDATE, 'YYYY'),
       TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

-- ���� ���� ����
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MON'),
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'RM') -- �θ� ��ȣ
FROM DUAL;

-- �Ͽ� ���� ����
SELECT TO_CHAR(SYSDATE, 'DDD'), -- 1���� �������� ��ĥ°
       TO_CHAR(SYSDATE, 'DD'),  -- 1���� �������� ��ĥ°
       TO_CHAR(SYSDATE, 'D')    -- 1�ָ� �������� ��ĥ°
FROM DUAL;

-- ���Ͽ� ���� ����
SELECT TO_CHAR(SYSDATE, 'DAY'),
       TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

-- EMPLOYEE ���̺��� ������, �Ի��� ��ȸ
-- ��, �Ի����� ������ �����ؼ� ��ȸ�Ѵ�.(2021-09-28(ȭ))
SELECT EMP_NAME,
       TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��"(DY)')
FROM EMPLOYEE;

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;


/*
    2) TO_DATE
        [����]
            TO_DATE(����|����[, ����])
        
        - ���� �Ǵ� ������ �����͸� ��¥ Ÿ������ ��ȯ�ؼ� ��ȯ�Ѵ�.
        - ������� DATE Ÿ���̴�.
*/
-- ���� --> ��¥
SELECT TO_DATE(20211014) FROM DUAL;
SELECT TO_DATE(20211014190830) FROM DUAL;

-- ���� --> ��¥
SELECT TO_DATE('20211014') FROM DUAL;
SELECT TO_DATE('20211014 190830') FROM DUAL; 
SELECT TO_DATE('20211014', 'YYYYMMDD') FROM DUAL;

-- YY�� RR ��
SELECT TO_DATE('110923', 'YYMMDD') FROM DUAL;
SELECT TO_DATE('990923', 'YYMMDD') FROM DUAL; -- YY : ������ ���� ����

SELECT TO_DATE('110923', 'RRMMDD') FROM DUAL;
SELECT TO_DATE('990923', 'RRMMDD') FROM DUAL; -- RR : �ش� ���� 50 �̻��̸� ���� ����, 50 �̸��̸� ���� ���� 

-- EMPLOYEE ���̺��� 1998�� 1�� 1�� ���Ŀ� �Ի��� ����� ���, �̸�, �Ի��� ��ȸ
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
        [����]
            TO_NUMBER('���ڰ�'[, ����])
        
        - ���� Ÿ���� �����͸� ���� Ÿ���� �����ͷ� ��ȯ�ؼ� ��ȯ�Ѵ�.
        - ������� NUMBER Ÿ���̴�.
*/
SELECT TO_NUMBER('0123456789') FROM DUAL;
SELECT '123' + '456' FROM DUAL; -- �ڵ����� ���� Ÿ������ ����ȯ �� ����ó���� ���ش�.
SELECT '123' + '456A' FROM DUAL; -- ���� �߻�(���� ������ ���ڵ鸸 �ڵ�����ȯ �ȴ�.)
SELECT '10,000,000' + '500,000' FROM DUAL; -- ���� �߻�
SELECT TO_NUMBER('10,000,000', '99,999,999') + TO_NUMBER('500,000', '999,999') FROM DUAL;

--NULL ó�� �Լ�
/*
    1) NVL
        [����]
        - NVL(�÷�, �÷����� NULL�� ��� ��ȯ�� ��)
        
        - NULL�� �Ǿ��ִ� �÷��� ���� ���ڷ� ������ ������ �����Ͽ� ��ȯ�Ѵ�.
    
    2) NVL2
        [����]
        - NVL2(�÷�, ������ �� 1, ������ �� 2)
            
        - �÷� ���� NULL�� �ƴϸ� ������ �� 1, �÷� ���� NULL�̸� ������ �� 2�� �����Ͽ� ��ȯ�Ѵ�.  
    
    3) NULLIF
        [����]
        - NULLIF(�񱳴�� 1, �񱳴�� 2)
            
        - �� ���� ���� �����ϸ� NULL ��ȯ, �� ���� ���� �������� ������ �񱳴�� 1�� ��ȯ�Ѵ�.
*/
-- EMPLOYEE ���̺��� �����, ���ʽ�, ���ʽ��� ���Ե� ���� ��ȸ
SELECT EMP_NAME, NVL(bonus,0)AS BONUS, NVL(BONUS,0)*salary+salary*12 AS "����" FROM employee;

-- EMPLOYEE ���̺��� �����, �μ� �ڵ� ��ȸ(��, �μ��ڵ尡 NULL �̸� "�μ�����" ���)
SELECT EMP_NAME, NVL(DEPT_CODE,'�μ�����') AS DEPT_CODE FROM EMPLOYEE;

--���ʽ� �ϰ����� �Ͽ� ���� ��ȸ(�ִ� ������� ������ 10%�� ����, ������ ����)
-- ��� �̸�, ���ʽ�, ����, ����, ���ʽ� ���� �ݾ�
SELECT EMP_NAME, NVL(bonus,0) AS BONUS, 
SALARY*12+salary*NVL2(bonus,0.1,0)AS "����" ,
SALARY, salary*NVL2(bonus,0.1,0)AS "���ʽ�"
FROM employee;

--NVLIF ���� �ڵ�
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;

SELECT NULLIF(123, 123) FROM DUAL; 
SELECT NULLIF(123, 456) FROM DUAL;
/*
    <�����Լ�>
        ���� ���� ��쿡 ������ �� �� �ִ� ����� �����ϴ� �Լ��̴�.
    
    1) DECODE
        [����]
            DECODE(Į��|����, ���ǰ� 1, ����� 1, ���ǰ� 2, ����� 2, ..., �����)
        
        - ���ϰ��� �ϴ� ���� ���ǰ��� ��ġ�� ��� �׿� �ش��ϴ� ������� ��ȯ�� �ִ� �Լ��̴�.
*/
-- ���� �������ٸ� DECODE ���� CASE END �̿��ϴ� ���� ����.
SELECT EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO,8,1),1,'����',2,'����') AS "����" FROM EMPLOYEE;

/*
    2) CASE
        [����]
            CASE WHEN ���ǽ� 1 THEN ����� 1
                 WHEN ���ǽ� 2 THEN ����� 2
                 ...
                 ELSE ����� N
            END
*/
SELECT 
    EMP_NAME
    ,EMP_NO
    ,CASE
        WHEN SUBSTR(EMP_NO,8,1)=1 THEN '����'
        WHEN SUBSTR(EMP_NO,8,1)=2 THEN '����'
        ELSE '2000���� �̰ų� �ܱ����Դϴ�'
    END  AS "����"
FROM EMPLOYEE;

/*
    <�׷� �Լ�>
        �뷮�� �����͵�� ���質 ��� ���� �۾��� ó���ؾ� �ϴ� ��� ���Ǵ� �Լ����̴�.
        ��� �׷� �Լ��� NULL ���� �ڵ����� �����ϰ� ���� �ִ� �͵鸸 ����� �Ѵ�.
        ���� AVG �Լ��� ����� ���� �ݵ�� NVL() �Լ��� �Բ� ����ϴ� ���� �����Ѵ�.
        
              1) SUM
            [����]
                SUM(NUMBER)
                
            - �ش� Į�� ������ �� �հ踦 ��ȯ�Ѵ�.
            
         2) AVG
            [����]
                AVG(NUMBER)
            
            - �ش� �÷� ������ ����� ���ؼ� ��ȯ�Ѵ�.
        
         3) MIN / MAX
            [����]
                MIN/MAX(��� Ÿ�� �÷�)
            
            - MIN : �ش� �÷� ���� �߿� ���� ���� ���� ��ȯ�Ѵ�.
            - MAX : �ش� �÷� ���� �߿� ���� ū ���� ��ȯ�Ѵ�.
            
         4) COUNT
            [����]
                COUNT(*|�÷���|DISTINCT �÷���)
            
            - �÷� �Ǵ� ���� ������ ���� ��ȯ�ϴ� �Լ��̴�.
            - COUNT(*) : ��ȸ ����� �ش��ϴ� ��� ���� ������ ��ȯ�Ѵ�.
            - COUNT(�÷���) : ������ �÷� ���� NULL�� �ƴ� ���� ������ ��ȯ�Ѵ�.
            - COUNT(DISTINCT �÷���) �ش� �÷� ���� �ߺ��� ������ ���� ������ ��ȯ�Ѵ�. 
*/

-- ��� ����� ���� �հ�
SELECT  SUM(salary)
        ,AVG(SALARY)
        ,MIN(SALARY)
        ,MAX(sALARY)
        ,COUNT(SALARY) 
FROM EMPLOYEE;

-- �׷��Լ��� NULL���� ������� �ʴ´�. NULL���� 0���� ġȯ�� �� ���
SELECT AVG(NVL(BONUS,0)) FROM EMPLOYEE;
