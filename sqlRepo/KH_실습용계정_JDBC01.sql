--���̺� �����
/*
    [����]
    CREATE TABLE ���̺��(
        Į���� Ÿ��
        ,Į���� Ÿ�� 
        ...
    );
    [Ÿ�� ����]
    CHAR (SIZE)
    VARCHAR (SIZE)
    NUMBER
    TIMESTAMP
*/
CREATE TABLE MEMBER(
    ID VARCHAR2(100)
    ,PWD VARCHAR2(100)
    ,NICK VARCHAR2(100)
);

--������ ����ֱ�
INSERT INTO MEMBER(ID,PWD,NICK) 
VALUES ('USER01','1234','NICK01');
INSERT INTO MEMBER(ID,PWD) 
VALUES('USER02','1234');
/*
    [����]
    INSERT INTO ���̺��(Į����,Į����, ...) VALUES (��1,��2,...);
    INSERT INTO ���̺�� VALUSE('��1','��2',...);
*/
--������ �����ϱ�
/*
    [����]
    UPDATE ���̺�� SET Į���� = ��, Į���� = ��, Į���� = ��, ...
*/
UPDATE MEMBER SET NICK ='NICK01', PWD = '0000';

--������ �����ϱ�
/*
    [����]
    DELETE ���̺��
*/
DELETE MEMBER WHERE ID = 'USER02';
--������ ��ȸ�ϱ�
SELECT * FROM MEMBER;
--���̺� �����ϱ�
/* 
    [����]
    DROP TABLE ���̺� ��
*/
DROP TABLE MEMBER;

--COMMIT

