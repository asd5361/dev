-- ������ ���� ����
--CREATE USER (C##+������) IDENTIFIED BY ��й�ȣ;
CREATE USER C##KH_WORKBOOK IDENTIFIED BY 1234;

--���Ѻο�
--GRANT ����, ����, ... TO (C##+������);
GRANT RESOURCE, CONNECT TO C##KH_WORKBOOK;

--���� ����
--REVOKE ���� �̸� FROM ������̸� 
--REVOKE RESOURCE FROM C##KH_WORKBOOK;

--���� Ȯ��
--SELECT * FROM role_sys_privs;

--USERS ���� �ο� 
alter user C##KH_WORKBOOK quota 100M on users;
