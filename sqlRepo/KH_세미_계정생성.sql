-- ����� ���� ���� (������ �������� �� ����)
-- [����]
-- CREATE USER ������ IDENTIFIED BY ��й�ȣ;
CREATE USER C##SEMI IDENTIFIED BY 1234;

-- ���� �ο�
-- [����]
-- GRANT ����1, ����2, 
GRANT CONNECT , RESOURCE TO C##SEMI;

ALTER USER C##SEMI DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;