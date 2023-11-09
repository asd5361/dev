--�� ���б� ��ũ�� ����
--SQL02_SELECT(Function)

-- 1��
-- ������а�(�а��ڵ� 002) �л����� �й��� �̸�, ���� �⵵�� ���� �⵵�� ���� ������ ǥ���ϴ� SQL������ �ۼ��Ͻÿ�.
-- (��, ����� "�й�", "�̸�", "���г⵵" �� ǥ�õǵ��� �Ѵ�.)
SELECT STUDENT_NO AS �й�, STUDENT_NAME AS �̸�, TO_CHAR(ENTRANCE_DATE, 'YYYY-MM-DD') AS ���г⵵
FROM TB_STUDENT WHERE DEPARTMENT_NO = '002' ORDER BY ENTRANCE_DATE;

-- 2��
-- �� ������б��� ���� �� �̸��� �� ���ڰ� �ƴ� ������ �� �� �ִٰ� �Ѵ�. �� ������ �̸��� �ֹι�ȣ�� ȭ�鿡 ����ϴ� SQL������ �ۼ��غ���.
-- (*�̶� �ùٸ��� �ۼ��� SQL ������ ��� ���� ����� �ٸ��� ���� �� �ִ�. ������ �������� �����غ� ��) 
SELECT PROFESSOR_NAME, PROFESSOR_SSN FROM TB_PROFESSOR WHERE PROFESSOR_NAME NOT LIKE '___';

-- 3��
-- �� ������б��� ���� �������� �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�. �� �̶� ���̰� ���� ������� ���� ��� ����
-- (���̰� ���ٸ� �̸��� ������ ����)�� ȭ�鿡 ��µǵ��� ����ÿ�.
-- (��, ���� �� 2000�� ���� ����ڴ� ������ ��� ����� "�����̸�"���� �Ѵ�. ���̴� '��'���� ����Ѵ�.)
-- ���� ���� ���� ��� �� �ٸ� �� �����Ƿ� PROFESSOR_SSN ���� SELECT �ؼ� Ȯ���غ���!!
SELECT PROFESSOR_NAME "�����̸�", TRUNC(MONTHS_BETWEEN(SYSDATE, TO_DATE('19'||SUBSTR(PROFESSOR_SSN, 1, 2),'YYYY'))/12) "����"
FROM TB_PROFESSOR WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = '1' ORDER BY 2;

-- 4��
-- �������� �̸� �� ���� ������ �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�. ��� ����� "�̸�"�� �������� �Ѵ�.
-- (���� 2���� ����� ������ ���ٰ� �����Ͻÿ�)
SELECT SUBSTR(PROFESSOR_NAME, 2) AS �̸� FROM TB_PROFESSOR;

-- 5��
-- �� ������б��� ����� ������ �й��� �̸��� ǥ���Ͻÿ�.(�̶�, 19�쿡 �����ϸ� ����� ���� ���� ������ ����)
-- �������� �䱸�ϴ� ������ ������ ������� ��� ������ ������� �߷����� �� (������� ������ ����� 245��)
-- 0301���� ������ �л��� ���ܽ�Ű�� ���� 19 �ʰ� 20 ���϶�� ���ǽ� ���

SELECT STUDENT_NO, STUDENT_NAME--, MONTHS_BETWEEN(ENTRANCE_DATE, TO_DATE(SUBSTR(STUDENT_SSN, 1, 6), 'RRMMDD'))/12
FROM TB_STUDENT WHERE MONTHS_BETWEEN(ENTRANCE_DATE, TO_DATE(SUBSTR(STUDENT_SSN, 1, 6), 'RRMMDD'))/12 > 19
    AND MONTHS_BETWEEN(ENTRANCE_DATE, TO_DATE(SUBSTR(STUDENT_SSN, 1, 6), 'RRMMDD'))/12 <= 20;
    
-- 6��
-- 2020�� ũ���������� ���� �����ΰ�?
--'DAY': �ݿ��� 'DY': �� 'D': 6
SELECT TO_CHAR(TO_DATE('2020/12/25'), 'DAY') 
FROM DUAL;

-- 7��
-- TO_DATE('99/10/11', 'YY/MM/DD'), TO_DATE('49/10/11', 'YY/MM/DD')�� ���� �� �� �� �� �� ���� �ǹ��ұ�?
-- �� TO_DATE('99/10/11', 'RR/MM/DD'), TO_DATE('49/10/11', 'RR/MM/DD')�� ���� �� �� �� �� �� ���� �ǹ��ұ�?
-- YY�� ��� 2000���
-- RR�� 49���ϴ� 2000��� 50�̻��� 1900���
SELECT TO_CHAR(TO_DATE('99/10/11', 'YY/MM/DD'),'YYYY'), 
       TO_CHAR(TO_DATE('49/10/11', 'YY/MM/DD'),'YYYY'),
       TO_CHAR(TO_DATE('99/10/11', 'RR/MM/DD'), 'RRRR'), 
       TO_CHAR(TO_DATE('49/10/11', 'RR/MM/DD'), 'RRRR')
FROM DUAL;

-- 8��
-- �� ������б��� 2000�⵵ ���� �����ڵ��� �й��� A�� �����ϰ� �Ǿ��ִ�. 
-- 2000�⵵ ���� �й��� ���� �л����� �й��� �̸��� �����ִ� SQL ������ �ۼ��Ͻÿ�.
SELECT STUDENT_NO, STUDENT_NAME FROM TB_STUDENT WHERE STUDENT_NO NOT LIKE 'A%';

-- 9��
-- �й��� A517178�� �ѾƸ� �л��� ���� �� ������ ���ϴ� SQL���� �ۼ��Ͻÿ�.
-- ��, �̶� ��� ȭ���� ����� "����"�̶�� ������ �ϰ�, ������ �ݿø��Ͽ� �Ҽ��� ���� ���ڸ������� ǥ���Ѵ�.
SELECT ROUND(AVG(POINT),1) AS ���� FROM TB_GRADE WHERE STUDENT_NO = 'A517178';

-- 10��
-- �а��� �л� ���� ���Ͽ� "�а���ȣ", "�л���(��)"�� ���·� Į������ ����� ������� ��µǵ��� �Ͻÿ�.
SELECT DEPARTMENT_NO �а���ȣ, COUNT(*) �л��� FROM TB_STUDENT GROUP BY DEPARTMENT_NO ORDER BY 1;

-- 11��
-- ���� ������ �������� ���� �л��� ���� �� �� ���� �Ǵ��� �˾Ƴ��� SQL���� �ۼ��Ͻÿ�
SELECT COUNT(*) FROM TB_STUDENT WHERE COACH_PROFESSOR_NO IS NULL;

-- 12��
-- �й��� A112113�� ���� �л��� �⵵ �� ������ ���ϴ� SQL���� �ۼ��Ͻÿ�.
-- ��, �̶� ���ȭ���� ����� "�⵵", "�⵵ �� ����"�̶�� ������ �ϰ�, ������ �ݿø��Ͽ� �Ҽ��� ���� ���ڸ������� ǥ���Ѵ�.
SELECT SUBSTR(TERM_NO,1,4) AS �⵵, ROUND(AVG(POINT),1) AS "�⵵ �� ����" FROM TB_GRADE WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4) ORDER BY 1;


-- 13��
-- �а� �� ���л� ���� �ľ��ϰ��� �Ѵ�. �а� ��ȣ�� ���л� ���� ǥ���ϴ� SQL������ �ۼ��Ͻÿ�.
-- COUNT(DECODE(ABSENCE_YN, 'Y', 1, NULL)) �� �ο�����
-- ���� ABSENCE_YN�� ���� 'Y'���� ��� COUNT(1)�� �Ǿ� ������ ���� �ǰ�
--     ABSENCE_YN�� ���� 'Y'�� �ƴϿ��� ��� COUNT(NULL)�� �Ǿ� ������ ���� �ʰԵǴ� ����!!
SELECT DEPARTMENT_NO �а��ڵ��, COUNT(DECODE(ABSENCE_YN, 'Y', 1, NULL)) "���л� ��"
FROM TB_STUDENT GROUP BY DEPARTMENT_NO ORDER BY 1;

-- 14��
-- �� ���б��� �ٴϴ� �������� �л����� �̸��� ã���� �Ѵ�.
-- � SQL ������ ����ϸ� �����ϰڴ°�?
SELECT STUDENT_NAME AS �����̸�, COUNT(*) AS "������ ��"
FROM TB_STUDENT GROUP BY STUDENT_NAME HAVING COUNT(*) > 1 ORDER BY 1;

-- 15��
-- �й��� A112113�� ���� �л��� �⵵, �б� �� ������ �⵵ �� ���� ����, �� ������ ���ϴ� SQL���� �ۼ��Ͻÿ�.
-- (��, ������ �Ҽ��� 1�ڸ������� �ݿø��Ͽ� ǥ���Ѵ�.)
-- �б� �� ���� => POINT / �⵵ �� ���� ���� => POINT 

SELECT 
    NVL(SUBSTR(term_no,1,4),' ') "�⵵"
    ,NVL(SUBSTR(term_no,5,2),' ') �б� 
    ,ROUND(AVG(POINT),1) "����" 
FROM tb_grade 
WHERE student_no ='A112113'
GROUP BY ROLLUP(SUBSTR(term_no,1,4),SUBSTR(term_no,5,2));