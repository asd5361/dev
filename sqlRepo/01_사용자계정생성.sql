--����� ���� ����
/*
--����� ���� ���� (������ �������θ� ����)
--CREATE USER (C##+������) IDENTIFIED BY ��й�ȣ;
CREATE USER C##KH IDENTIFIED BY 1234;

--���Ѻο�
--GRANT ����, ����, ... TO (C##+������);
GRANT RESOURCE, CONNECT TO C##KH;

--���� ����
--REVOKE ���� �̸� FROM ������̸� 

REVOKE RESOURCE FROM C##KH;

--���� Ȯ��
SELECT * FROM role_sys_privs;
*/
