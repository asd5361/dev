--�� ���б� ��ũ�� ����
--SQL01_SELECT(Basic)

-- 1��
-- �� ������б��� �а� �̸��� �迭�� ǥ���Ͻÿ�. ��, ��� ����� "�а� ��", "�迭"���� ǥ���ϵ��� �Ѵ�.
SELECT department_name AS "�а� ��",category AS "�迭" FROM tb_department;

-- 2��
-- �а��� �а� ������ ������ ���� ���·� ȭ�鿡 ����Ѵ�.
/* EX )
    ������а��� ������ 20�� �Դϴ�.
    ������а��� ������ 36�� �Դϴ�.
    ...
*/
SELECT department_name||'�� ������ '||capacity||'�� �Դϴ�.' AS "�а� ����" FROM tb_department;

-- 3��
-- "������а�" �� �ٴϴ� ���л� �� ���� �������� ���л��� ã�ƴ޶�� ��û�� ���Դ�. �����ΰ�?
-- (�����а��� '�а��ڵ�'�� �а� ���̺�(TB_DEPARTMENT)�� ��ȸ�ؼ� ã�� ������ ����)
SELECT STUDENT_NAME FROM tb_student WHERE ABSENCE_YN LIKE 'Y'
AND SUBSTR(STUDENT_SSN, 8, 1) = '2' AND department_NO ='001';

                     
-- 4�� 
-- ���������� ���� ���� ��� ��ü�ڵ��� ã�� �̸��� �Խ��ϰ��� �Ѵ�.
-- �� ����ڵ��� �й��� ������ ���� �� ����ڵ��� ã�� ������ SQL������ �ۼ��Ͻÿ�.
-- A513079, A513090, A513091, A513110, A513119
-- (�̸� ���� �������� ����)
SELECT STUDENT_NAME FROM tb_student 
WHERE student_no IN ('A513079','A513090','A513091','A513110','A513119') order by 1 desc;

-- 5��
-- ���� ������ 20�� �̻� 30�� ������ �а����� �а� �̸��� �迭�� ����Ͻÿ�.
SELECT DEPARTMENT_NAME, CATEGORY FROM tb_department 
WHERE capacity BETWEEN 20 AND 30;

-- 6��
-- �� ������б��� ������ �����ϰ� ��� �������� �Ҽ� �а��� ������ �ִ�.
-- �׷� �� ������б� ������ �̸��� �˾Ƴ� �� �ִ� SQL ������ �ۼ��Ͻÿ�.
SELECT PROFESSOR_NAME FROM tb_professor WHERE department_no IS NULL;

-- 7��
-- Ȥ�� ������� ������ �а��� �����Ǿ� ���� ���� �л��� �ִ��� Ȯ���ϰ��� �Ѵ�.
-- ��� SQL������ ����ϸ� �� ������ �ۼ��Ͻÿ�.
-- (SELECT STUDENT_NAME � ����) 
SELECT * FROM tb_student WHERE STUDENT_NO IS NULL;
-- 8��
-- ������û�� �Ϸ��� �Ѵ�. �������� ���θ� Ȯ���ؾ� �ϴµ�, ���������� �����ϴ� ������� � �������� ���� ��ȣ�� ��ȸ�� ���ÿ�.
SELECT class_no FROM tb_class WHERE preattending_class_no IS NOT NULL;

-- 9��
-- �� ���п��� � �迭(CATEGORY)���� �ִ��� ��ȸ�� ���ÿ�.
SELECT DISTINCT CATEGORY from tb_department ORDER BY 1;

-- 10��
-- 02�й� ���� �����ڵ��� ������ ������� �Ѵ�. 
-- ������ ������� ������ �������� �л����� 
-- �й�, �̸�, �ֹι�ȣ�� ����ϴ� ������ �ۼ��Ͻÿ�.
select STUDENT_NO, STUDENT_NAME, STUDENT_SSN 
FROM tb_student WHERE STUDENT_ADDRESS LIKE '����%' AND ABSENCE_YN = 'N' 
AND EXTRACT(YEAR FROM ENTRANCE_DATE) = 2002;
