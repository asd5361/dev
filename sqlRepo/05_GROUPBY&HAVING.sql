-- GROUP BY , HAVING
/*  
    <GROUP BY>
        �׷� ������ ������ �� �ִ� ����
        ���� ���� ������ �ϳ��� �׷����� ��� ó���� �������� ����Ѵ�.
*/

-- ��ü ����� ��
SELECT COUNT(*) FROM employee;
-- �μ��� ��� ��
SELECT dept_code,COUNT(*) FROM employee GROUP BY dept_code;
--���ʽ��� �޴� ��� ��
SELECT COUNT(BONUS) FROM employee GROUP BY BONUS;

--�μ��� ���ʽ��� �޴� ��� ��
SELECT dept_code,COUNT(BONUS) FROM EMPLOYEE GROUP BY dept_code;

--�޿� ��� ��ȸ
SELECT ROUND(AVG(SALARY),0) FROM EMPLOYEE;

--�μ��� �޿� ��� ��ȸ
SELECT dept_code,ROUND(AVG(SALARY),1) FROM EMPLOYEE GROUP BY dept_code;

--���� ��� ��
SELECT  SUBSTR(EMP_NO,8,1) AS "����" ,COUNT(*) 
FROM EMPLOYEE GROUP BY SUBSTR(EMP_NO,8,1);

--�μ��ڵ�� �����ڵ尡 ���� �ο� ��
SELECT DEPT_CODE, JOB_CODE, COUNT(*) FROM EMPLOYEE GROUP BY DEPT_CODE, JOB_CODE;

/*  
    <HAVING>
        �׷쿡 ���� ������ ������ �� ����ϴ� ����
        (�ַ� �׷� �Լ��� ����� ������ �� ����)
        
        5: SELECT      ��ȸ�ϰ��� �ϴ� �÷��� AS "��Ī" | ���� | �Լ���
        1: FROM        ��ȸ�ϰ��� �ϴ� ���̺��
        2: WHERE       ���ǽ�
        3: GROUP BY    �׷� ���ؿ� �ش��ϴ� �÷��� | ���� | �Լ���
        4: HAVING      �׷쿡 ���� ���ǽ�
        6: ORDER BY    ���� ���ؿ� �ش��ϴ� �÷��� | ��Ī | �÷� ����
*/

--���ʽ��� �޴� ����鿡 ���Ͽ� �μ��ڵ�� �μ��� ��� �޿��� ��ձ޿� ������ ��ȸ�϶�
--(��, ��ձ޿��� 300���� �̸��� �μ��� �����Ѵ�)
SELECT DEPT_CODE, AVG(SALARY) FROM EMPLOYEE 
WHERE BONUS IS NOT NULL GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000
ORDER BY AVG(SALARY);

-- �� �μ��� �޿��� 300���� �̻��� ������ ��� �޿� ��ȸ
SELECT DEPT_CODE, AVG(SALARY) FROM EMPLOYEE WHERE SALARY >= 3000000 GROUP BY DEPT_CODE;
-- �� �μ��� ��� �޿��� 300���� �̻��� �μ��鸸 ��ȸ
SELECT DEPT_CODE, AVG(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING AVG(SALARY) >= 3000000;
-- ���޺� �� �޿��� ���� 10000000 �̻��� ���޵鸸 ��ȸ
SELECT JOB_CODE,SUM(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE HAVING SUM(SALARY) >=10000000;
-- �μ��� ���ʽ��� �޴� ����� ���� �μ��鸸 ��ȸ
SELECT DEPT_CODE FROM EMPLOYEE GROUP BY DEPT_CODE HAVING COUNT(BONUS) = 0;

/*
    <���� �Լ�>
            �׷캰 ������ ��� ���� �߰� ���踦 ��� ���ִ� �Լ�
*/

--���޺� �޿� �հ� ��ȸ
SELECT JOB_CODE,SUM(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE 
GROUP BY ROLLUP(JOB_CODE);

SELECT JOB_CODE, DEPT_CODE,SUM(SALARY)
FROM EMPLOYEE 
GROUP BY ROLLUP(JOB_CODE, DEPT_CODE);

SELECT DEPT_CODE, JOB_CODE,SUM(SALARY)
FROM EMPLOYEE 
GROUP BY CUBE(DEPT_CODE,JOB_CODE)
ORDER BY DEPT_CODE,  JOB_CODE;
/*
    ROLLUP(Į��1, Į��2, ...)Į�� 1�� ������ �߰�����
    CUBE(Į��1, Į��2, ...)Į�� 1�� �߰�����, Į��2�� �߰����� ...
*/

/*
    <���� ������>
        ���� ���� �������� ������ �ϳ��� ���������� ����� �������̴�.
        
        UNION       : �� �������� ������ ������� ���� �� �ߺ��Ǵ� ���� �����Ѵ�. (������)
        UNION ALL   : UNION�� �����ϰ� �� �������� ������ ������� ���ϰ� �ߺ��� ����Ѵ�. (������)
        INTERSECT   : �� �������� ������ ������� �ߺ��� ������� �����Ѵ�. (������)
        MINUS       : ���� ������ ��������� ���� ������ ������� �� ������ ������� �����Ѵ�. (������)
    
*/
-- �μ��ڵ尡 D5�� ��� ��ȸ
    SELECT * FROM EMPLOYEE WHERE DEPT_CODE= 'D5';
-- �޿��� 300���� �ʰ��� ��� ��ȸ
    SELECT * FROM EMPLOYEE WHERE SALARY > 3000000;
-- �μ��ڵ尡 D5�̸鼭, �޿��� 300���� �ʰ��� ��� ��ȸ
    SELECT * FROM EMPLOYEE WHERE DEPT_CODE= 'D5' UNION SELECT * FROM EMPLOYEE WHERE SALARY > 30000000;



