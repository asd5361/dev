-- DQL (SELECT)
/*
    DQL : Date Query Lanaguage == SELECT
        <SELECT>
            [����]
                SELECT Į��1, Į��2, ....
                FROM ���̺� ��;
            -�����͸� ��ȸ�Ҷ� ���
            -��ȸ�� ����� RESULT SET(��� ����) ���� ǥ���ȴ�.
            -���̺� ���� Į���� ��ȸ�ϸ� �ȵ�
*/

-- EMPLOTEE ���̺��� ��ü ����� ���(emo_id), �̸�(emp_name), ����(salary)�� ��ȸ
SELECT EMP_ID,EMP_NAME,SALARY
FROM employee;

-- EMPLOTEE ���̺��� ��ü ����� ��� �÷�(*) ���� ��ȸ
SELECT *
FROM employee;

/*
    <�������>
    SELECT ������ ��� ���� ����
    
    
*/

SELECT emp_name, salary*12 FROM EMPLOYEE;

--���ʽ� �����ؼ� ��ȸ
--��� ���� �߿� NULL���� �����ϸ� ������� ������ NULL
SELECT EMP_NAME,SALARY*12+NVL(BONUS,0) AS TOTAL FROM employee;

--EMPLOYEE ���̺��� ������, �Ի���, �ٹ��ϼ�(���� ��¥ - �Ի���) 
    --FLOOR(����)�ݳ��� --CEIL(����)�ݿø� --TRUNC(����,1)�Ҽ��� ���ֱ� -TO_CHAR(SYSTEMDATE'YYYY.MM.DD',) ��¥ǥ�����ĺ���
SELECT 
    emp_name,
    FLOOR(SYSDATE-HIRE_DATE) AS "�ٹ� �ϼ�",
    TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') as HIRE_DATE  
FROM employee;

--Į���� ��Ī (AS)

/*
    <���ͷ�> --������ ��?
        SELECT ������ ���ͷ��� ��� ����
*/
SELECT EMP_NAME,EMAIL,123,'ABC'
FROM employee;

/************** ���� *****************/
-- ��� ���̺��� ��� ����� ��� ���� ��ȸ
SELECT * FROM EMPLOYEE;

--��� ���̺��� ��� ����� �̸�, �̸���, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, EMAIL, PHONE FROM employee;

--��� ���̺��� ��� ����� �̸�, ����, ���� ��ȸ (������ ����*12�� ���) (�� ���� ��ȸ ����� Į�� ��Ī�� �������� ����)
SELECT emp_name AS ������, salary AS ����, salary*12 AS ���� FROM employee;

--��� ���̺��� ��� ����� �����ڵ�(JOB_CODE) ��ȸ --DISTINCT �ߺ� ����
SELECT DISTINCT job_code AS �����ڵ� FROM employee;

--�μ� �ڵ� ��ȸ
SELECT DISTINCT DEPT_CODE FROM employee;

-- �����ڵ�, �μ��ڵ� ��ȸ --GROUP BY �ߺ� ����
SELECT DISTINCT JOB_CODE, DEPT_CODE FROM EMPLOYEE;

/******************* ������� ********************/

/*
    <���� ������>
        ���� ���� �÷� ���� ���� / ���ͷ� ���� ����
*/
    SELECT EMP_ID ||'����� ����' || emp_name ||'����� �޿���'|| salary||'�Դϴ�' FROM employee;

/*
    <WHERE> -- != / ^= / <> �� ��ȣ ��� ���� �ʴٶ�� ���� �ǹ��Ѵ�.
        SELECT Į�� FROM ���̺�� WHERE ����;
        ��ȸ�Ϸ��� ROW�� ���ǽ��� �����ؾ� ����
        ���ǽĿ��� ������ ��� ����
*/

-- �μ��ڵ尡 D9�� ������� ��� Į�� ��ȸ
    SELECT * FROM employee WHERE dept_code = 'D9';

-- �μ��ڵ尡 D9�� �ƴ� ������� ��� Į�� ��ȸ
    SELECT * FROM employee WHERE dept_code != 'D9';
    
-- EMPLOYEE ���̺��� �޿��� 400���� �̻��� �������� ������, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_NAME, dept_code, job_code, SALARY FROM employee WHERE salary >= 4000000;

-- 1. EMPLOYEE ���̺��� ���� ��(ENT_YN �÷� ���� 'N')�� �������� ���, �̸�, �Ի��� ��ȸ 
SELECT emp_no, emp_name, hire_date FROM employee WHERE ENT_YN = 'N';

-- 2. EMPLOYEE ���̺��� ������ 5000�̻��� ������ ������, �޿�, ����, �Ի��� ��ȸ
SELECT EMP_NAME,SALARY,SALARY*12 AS ����, HIRE_DATE FROM employee WHERE salary*12 >= 50000000;

-- EMPLOYEE ���̺��� �μ� �ڵ尡 D6�̸鼭 �޿��� 300���� �̻��� �������� ���, ������, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_ID,EMP_NAME,dept_code,salary FROM employee where salary>=3000000 AND dept_code ='D6';

-- EMPLOYEE ���̺��� �޿��� 400���� �̻�, ���� �ڵ尡 J2�� ����� ��� �÷� ��ȸ
SELECT * FROM employee WHERE salary >= 4000000 AND job_code = 'J2';

-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���ϸ� �޴� ������ ���, ������, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_ID,EMP_NAME,dept_code,salary FROM employee WHERE salary <= 6000000 AND salary >=3500000;

/*
    < BETWEEN A AND B >
    A�̻� B ����
*/
-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���ϰ� �ƴ� �޴� ������ ���, ������, �μ� �ڵ�, �޿� ��ȸ
    SELECT EMP_ID,EMP_NAME,dept_code,salary FROM employee WHERE salary NOT BETWEEN 3500000 AND 6000000;

-- EMPLOYEE ���̺��� �Ի��� '90/01/01' ~ '01/01/01'�� ����� ��� �÷� ��ȸ
    SELECT * FROM employee WHERE hire_date BETWEEN '90/01/01' AND '01/01/01'
    ORDER BY hire_date;
    
/*
    
    <LIKE>
    [����]
    WHERE �񱳴���÷� LIKE 'Ư�� ����';
    
    - ���Ϸ��� �÷� ���� ������ Ư�� ���Ͽ� ������ ��� TRUE�� �����Ѵ�.
    - Ư�� ���Ͽ��� '%', '_'�� ���ϵ�ī��� ����� �� �ִ�.
    - LIKE �ȿ� '%', '_'�� ����ؾ� �Ѵٸ� �̽��������� �����ϰ� ����Ѵ�. ESCAPE '\'
      '%' : 0���� �̻�
        ex) �񱳴���÷� LIKE '����%'  => �񱳴���÷� �� �߿� '����'�� �����ϴ� ��� ���� ��ȸ�Ѵ�.
            �񱳴���÷� LIKE '%����'  => �񱳴���÷� �� �߿� '����'�� ������ ��� ���� ��ȸ�Ѵ�.
            �񱳴���÷� LIKE '%����%' => �񱳴���÷� �� �߿� '����'�� ���ԵǾ� �ִ� ��� ���� ��ȸ�Ѵ�.
            
      '_' : 1����
        ex) �񱳴���÷� LIKE '_����'  => �񱳴���÷� �� �߿� '����'�տ� ������ �� ���ڰ� ���� ��� ���� ��ȸ�Ѵ�.
            �񱳴���÷� LIKE '__����' => �񱳴���÷� �� �߿� '����'�տ� ������ �� ���ڰ� ���� ��� ���� ��ȸ�Ѵ�.

    ESCAPE : Ư�� ���� ����
        ex) SELECT * FROM employee WHERE email LIKE '___\_%' ESCAPE '\';
*/

-- EMPLOYEE ���̺��� ���� �� ���� ����� �����, �޿�, �Ի��� ��ȸ
SELECT EMP_ID,EMP_NAME,salary FROM employee WHERE emp_name LIKE '��%';

-- EMPLOYEE ���̺��� �̸� �߿� '��'�� ���Ե� ����� �����, �ֹι�ȣ, �μ� �ڵ� ��ȸ
SELECT emp_name, EMP_NO, DEPT_CODE FROM employee WHERE emp_name LIKE '%��%';

-- EMPLOYEE ���̺��� ��ȭ��ȣ 4��° �ڸ��� 9�� �����ϴ� ����� ���Į�� ��ȸ
SELECT emp_name, EMP_NO, DEPT_CODE, phone FROM employee WHERE phone LIKE '___9%';

--EMPLOYEE ���̺��� �̸��� �� _ �� ���ڰ� 3�ڸ��� �̸��� �ּҸ� ���� ����� ��� �����, �̸��� ��ȸ
-- ex) sun_di@kh.or.kr, yoo_js@kh.or.kr, ...
SELECT * FROM employee WHERE email LIKE '___\_%' ESCAPE '\';

/*
    <IS NULL / IS NOT NULL>
        [����]
            WHERE �񱳴���÷� IS [NOT] NULL;
            
        - �÷� ���� NULL�� ���� ��� NULL �� �񱳿� ���ȴ�.
          IS NULL : �񱳴���÷� ���� NULL�� ��� TRUE�� �����Ѵ�.
          IS NOT NULL : �񱳴���÷� ���� NULL�� �ƴ� ��� TRUE �����Ѵ�.
*/ 
-- EMPLOYEE ���̺��� ���ʽ��� ���� �ʴ� ����� ���, �����, �޿� ��ȸ
SELECT * FROM EMPLOYEE WHERE bonus IS NULL; -- NULL�� �� ���� �Ұ���

--EMPLOYEE ���̺��� ������(���)�� ���� ��� �̸�, �μ� �ڵ� ��ȸ 
SELECT EMP_NAME, dept_code FROM employee WHERE MANAGER_ID IS NULL;
SELECT EMP_NAME, dept_code FROM employee WHERE MANAGER_ID IS NOT NULL;

SELECT * FROM employee WHERE dept_code IS NULL AND bonus IS NOT NULL;

/*
    <IN>
        [����]
            WHERE �񱳴���÷� IN('��', '��', '��', ..., '��');
        
        - �� ��� �߿� ��ġ�ϴ� ���� ���� �� TRUE �����Ѵ�.
*/
-- �μ��ڵ� D5, D6, D8 �� �ش��ϴ� ������� ��� �÷� ��ȸ
SELECT * FROM EMPLOYEE WHERE dept_code IN ('D5','D6','D8');

/*
    <������ �켱����>
        0. ()
        1. ��� ������
        2. ���� ������
        3. �� ������
        4. IS NULL, LIKE, IN
        5. BETWEEN AND
        6. �� ������ - NOT
        7. �� ������ - AND
        8. �� ������ - OR
*/

/*
    <ORDER BY>
        [����]
            SELECT �÷�, �÷�, ..., �÷�
              FROM ���̺��
             WHERE ���ǽ�
          ORDER BY ���Ľ�Ű���� �ϴ� �÷���|��Ī|�÷� ���� [ASC|DESC] [NULLS FIRST | NULLS LAST];
          
        - SELECT ������ ���� �������� �����ϴ� �������� ���� ���� ���� �������� ����ȴ�.
        - ASC : ������������ �����Ѵ�. (ASC �Ǵ� DESC ���� �� �⺻��)
        - DESC : ������������ �����Ѵ�.
        - NULLS FIRST : �����ϰ��� �ϴ� �÷� ���� NULL�� �ִ� ��� �ش� ������ ���� �� ������ �����Ѵ�.
        - NULLS LAST : �����ϰ��� �ϴ� �÷� ���� NULL�� �ִ� ��� �ش� ������ ���� �� �ڷ� �����Ѵ�.
*/
-- EMPLOYEE ���̺��� BONUS�� �������� ����
    SELECT * FROM employee ORDER BY BONUS; --������ �⺻�� ASC , ASC�� NULLS LSAT

-- EMPLOYEE ���̺��� BONUS�� �������� ����(��, BONUS ���� ��ġ�� ��� �׶��� SALARY ������ ������������)
    SELECT * FROM employee ORDER BY BONUS DESC, salary;
-- NVL(BONUS,0)
-- EMPLOYEE ���̺��� ������ ������������ ���ĵ� ����� �����, ���� ��ȸ
    SELECT EMP_NAME,SALARY*12 AS "����" FROM employee ORDER BY "����" DESC;

    
