--�� ���б� ��ũ�� ����
--SQL03_SELECT(Option)

-- 1��
-- �л��̸��� �ּ����� ǥ���Ͻÿ�. ��, ��� ����� "�л� �̸�", "�ּ���"�� �ϰ�, ������ �̸����� �������� ǥ���ϵ��� �Ѵ�.
SELECT STUDENT_NAME AS "�л� �̸�", STUDENT_ADDRESS AS "�ּ���"
FROM TB_STUDENT ORDER BY 1 ;

-- 2��
-- �������� �л����� �̸��� �ֹι�ȣ�� ���̰� ���� ������ ȭ�鿡 ����Ͻÿ�
SELECT STUDENT_NAME, STUDENT_SSN FROM TB_STUDENT WHERE ABSENCE_YN = 'Y'
ORDER BY STUDENT_SSN DESC ;

-- 3��
-- �ּ����� �������� ��⵵�� �л��� �� 1900��� �й��� ���� �л����� �̸��� �й�, �ּҸ� �̸��� ������������ ȭ�鿡 ����Ͻÿ�.
-- ��, ���������� "�л��̸�", "�й�", "������ �ּ�"�� ��µǵ��� �Ѵ�.

SELECT STUDENT_NAME AS "�л��̸�", STUDENT_NO AS "�й�",STUDENT_ADDRESS AS "������ �ּ�" 
FROM TB_STUDENT WHERE STUDENT_NO LIKE '9%' 
AND (STUDENT_ADDRESS LIKE '��⵵%' OR STUDENT_ADDRESS LIKE '������%')
ORDER BY 1
;

-- 4��
-- ���� ���а� ���� �� ���� ���̰� ���� ������� �̸��� Ȯ���� �� �ִ� SQL ������ �ۼ��Ͻÿ�.
-- (���а��� '�а� �ڵ�'�� �а� ���̺��� ��ȸ�ؼ� ã�� ������ ����)
SELECT PROFESSOR_NAME, PROFESSOR_SSN FROM TB_PROFESSOR 
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '���а�')
ORDER BY 2
;

-- 5��
-- 2004�� 2�б⿡ 'C3118100' ������ ������ �л����� ������ ��ȸ�Ϸ��� �Ѵ�. 
-- ������ ���� �л����� ǥ���ϰ�,
-- ������ ������ �й��� ���� �л����� ǥ���ϴ� ������ �ۼ��� ���ÿ�.
-- ��ũ�� ����� �����ϰ� �Ҽ��� �Ʒ� 2�ڸ����� 0���� ǥ���ϱ� ���ؼ� TO_CHAR(NUMBER, 'FM9.00') ���� ���
SELECT STUDENT_NO, TO_CHAR(POINT,'99.99') "POINT"
FROM TB_GRADE WHERE TERM_NO = '200402' AND CLASS_NO = 'C3118100'
ORDER BY POINT DESC, STUDENT_NO
;

-- 6��
-- �л� ��ȣ, �л� �̸�, �а� �̸��� �л� �̸����� �������� �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�.
SELECT STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME FROM TB_STUDENT
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
ORDER BY 2;



-- 7��
-- �� ������б��� ���� �̸��� ������ �а� �̸��� ����ϴ� SQL������ �ۼ��Ͻÿ�.
SELECT CLASS_NAME, DEPARTMENT_NAME FROM TB_CLASS
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
ORDER BY 2,1
;


-- 8��
-- ���� ���� �̸��� ã������ �Ѵ�. ���� �̸��� ���� �̸��� ����ϴ� SQL���� �ۼ��Ͻÿ�.
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO)
ORDER BY 2, 1;

-- 9��
-- 8���� ��� �� '�ι� ��ȸ' �迭�� ���� ������ ���� �̸��� ã������ �Ѵ�.
-- �̿� �ش��ϴ� ���� �̸��� ���� �̸��� ����ϴ� SQL���� �ۼ��Ͻÿ�.
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS 
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR P USING(PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON (P.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE CATEGORY= '�ι���ȸ'
ORDER BY 2, 1
;
                        
-- 10��
-- '�����а�' �л����� ������ ���Ϸ��� �Ѵ�. 
-- �����а� �л����� "�й�", "�л� �̸�", "��ü ����"�� ����ϴ� SQL ������ �ۼ��Ͻÿ�.
-- (��, ������ �Ҽ��� 1�ڸ������� �ݿø��Ͽ� ǥ���Ѵ�.)
SELECT S.STUDENT_NO AS "�й�", STUDENT_NAME AS "�л� �̸�", ROUND(AVG(POINT),1) "��ü ����" 
FROM TB_STUDENT S LEFT JOIN TB_GRADE G ON S.STUDENT_NO = G.STUDENT_NO
WHERE DEPARTMENT_NO= (SELECT DEPARTMENT_NO FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME= '�����а�')
GROUP BY S.STUDENT_NO, STUDENT_NAME
ORDER BY 1
;


-- 11��
-- �й��� A313047�� �л��� �б��� ������ ���� �ʴ�. ���� �������� ������ �����ϱ� ���� 
-- �а� �̸�, �л� �̸��� ���� ���� �̸��� �ʿ��ϴ�.
-- �̶� ����� SQL���� �ۼ��Ͻÿ�.
SELECT DEPARTMENT_NAME AS �а��̸�, STUDENT_NAME AS �л��̸�, PROFESSOR_NAME AS ���������̸�
FROM TB_STUDENT S JOIN TB_DEPARTMENT D USING(DEPARTMENT_NO)
JOIN TB_PROFESSOR P ON S. COACH_PROFESSOR_NO = P.PROFESSOR_NO
WHERE STUDENT_NO ='A313047'
;

-- 12��
-- 2007�⵵�� '�ΰ������' ������ ������ �л��� ã�� 
-- �л��̸��� �����б⸦ ǥ���ϴ� SQL ������ �ۼ��Ͻÿ�.
SELECT STUDENT_NAME, TERM_NO FROM TB_GRADE G 
JOIN TB_STUDENT S USING(STUDENT_NO)
JOIN TB_CLASS C USING(CLASS_NO)
WHERE TERM_NO LIKE '2007%' AND CLASS_NAME = '�ΰ������'
;

-- 13��
-- ��ü�� �迭 ���� �� ���� ��米���� �� �� �������� ���� ������ ã�� 
-- �� ���� �̸��� �а� �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�.
-- ��� ���� ���� �����ϳ� ���� ������ ���� �ٸ� ������ ����
SELECT CLASS_NAME , DEPARTMENT_NAME FROM TB_CLASS C
LEFT JOIN TB_CLASS_PROFESSOR P USING(CLASS_NO)
LEFT JOIN TB_DEPARTMENT D  USING(DEPARTMENT_NO)
WHERE CATEGORY = '��ü��' AND PROFESSOR_NO IS NULL
ORDER BY 2,1
;


-- 14��
-- �� ������б� ���ݾƾ��а� �л����� ���������� �Խ��ϰ��� �Ѵ�. 
-- �л��̸��� �������� �̸��� ã�� ���� ���� ������ ���� �л��� ���
-- "�������� ������"���� ǥ���ϵ��� �ϴ� SQL ���� �ۼ��Ͻÿ�. 
-- �� �������� "�л��̸�", "��������"�� ǥ���ϸ� ���й� �л��� ���� ǥ�õǵ��� �Ѵ�.
SELECT STUDENT_NAME AS "�л��̸�", NVL(PROFESSOR_NAME,'�������� ������') AS "��������" FROM TB_STUDENT S 
LEFT JOIN TB_PROFESSOR P ON(COACH_PROFESSOR_NO = PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '���ݾƾ��а�'
ORDER BY STUDENT_NO
;

-- 15��
-- ���л��� �ƴ� �л� �� ������ 4.0 �̻��� �л��� ã�� 
-- �� �л��� �й�, �̸�, �а�, �̸�, ������ ����ϴ� SQL���� �ۼ��Ͻÿ�.
SELECT STUDENT_NO AS "�й�" , STUDENT_NAME AS "�̸�", DEPARTMENT_NAME AS " �а� �̸�"
,ROUND(AVG(POINT),2) AS "����" FROM TB_STUDENT S 
LEFT JOIN TB_GRADE G USING(STUDENT_NO)
LEFT JOIN TB_DEPARTMENT D USING(DEPARTMENT_NO)
WHERE ABSENCE_YN = 'N' 
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT) >= 4.0
ORDER BY 1
;

-- 16��
-- ȯ�������а� ����������� ���� �� ������ �ľ��� �� �ִ� SQL ���� �ۼ��Ͻÿ�.
SELECT CLASS_NO, CLASS_NAME, ROUND(AVG(POINT),2) FROM TB_CLASS
LEFT JOIN TB_GRADE USING(CLASS_NO)
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = 'ȯ�������а�'
AND CLASS_TYPE LIKE '%����%'
GROUP BY CLASS_NO, CLASS_NAME
ORDER BY 1
;

-- 17��
-- �� ������б��� �ٴϰ� �ִ� �ְ��� �л��� ���� �� �л����� �̸��� �ּҸ� ����ϴ� SQL ���� �ۼ��Ͻÿ�.
SELECT STUDENT_NAME, STUDENT_ADDRESS FROM TB_STUDENT WHERE DEPARTMENT_NO =
(SELECT DEPARTMENT_NO FROM TB_STUDENT WHERE STUDENT_NAME = '�ְ���');



-- 18��
-- ������а����� �������� ���� ���� �л��� �̸��� �й��� ǥ���ϴ� SQL���� �ۼ��Ͻÿ�

SELECT STUDENT_NO, STUDENT_NAME FROM TB_STUDENT S
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '������а�' 
GROUP BY STUDENT_NO, STUDENT_NAME
HAVING AVG(POINT) = (SELECT MAX(AVG(POINT))
                     FROM TB_STUDENT
                     JOIN TB_GRADE USING(STUDENT_NO)
                     JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                     WHERE DEPARTMENT_NAME = '������а�'
                     GROUP BY STUDENT_NO)
;


-- 19��
-- �� ������б��� "ȯ�������а�"�� ���� ���� �迭 �а����� 
-- �а� �� �������� ������ �ľ��ϱ� ���� ������ SQL���� ã�Ƴ��ÿ�.
-- ��, �������� "�迭 �а���", "��������"���� ǥ�õǵ��� �ϰ�, 
-- ������ �Ҽ��� ���ڸ������� �ݿø��Ͽ� ǥ�õǵ��� �Ѵ�.

SELECT DEPARTMENT_NAME AS "�迭 �а���", ROUND(AVG(POINT),1) AS "��������" 
FROM TB_DEPARTMENT
JOIN TB_CLASS USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(CLASS_NO)
WHERE CATEGORY =(SELECT CATEGORY FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = 'ȯ�������а�')
AND CLASS_TYPE LIKE '%����%' --> �� �߰������ ����� ����!!
GROUP BY DEPARTMENT_NAME
ORDER BY 1
; 

