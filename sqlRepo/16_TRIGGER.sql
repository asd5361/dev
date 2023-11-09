/*
    <TRIGGER>
        ���̺��� INSERT, UPDATE, DELETE �� DML ������ ���ؼ� ����� ���
        �ڵ����� ����� ������ �����س��� ��ü�̴�.
        
        * Ʈ������ ����
          1) SQL ���� ���� �ñ⿡ ���� �з�
            - BEFORE TRIGGER : �ش� SQL ���� ���� ���� Ʈ���Ÿ� �����Ѵ�.
            - AFTER TRIGGER : �ش� SQL ���� ���� �Ŀ� Ʈ���Ÿ� �����Ѵ�.
          
          2) SQL ���� ���� ������ �޴� �࿡ ���� �з�
            - ���� Ʈ���� : �ش� SQL ���� �� ���� Ʈ���Ÿ� �����Ѵ�.
            - �� Ʈ���� : �ش� SQL ���� ������ �޴� �ึ�� Ʈ���Ÿ� �����Ѵ�.
            
        [����]
            CREATE OR REPLACE TRIGGER Ʈ���Ÿ�
            BEFORE|AFTER INSERT|UPDATE|DELETE ON ���̺��
            [FOR EACH ROW]
            DECLARE
                �����
            BEGIN
                �����
            EXCEPTION
                ����ó����
            END;
            /
*/
DROP TABLE TEMP;
CREATE TABLE TEMP(
    DATA VARCHAR2(100)
);

DROP TABLE TEMP_BACKUP;
CREATE TABLE TEMP_BACKUP(
    DATA_BACKUP VARCHAR2(100)    
);

SELECT * FROM TEMP;

-- TEMP ���̺� Ʈ���� ����
-- ���� : UPDATE ���� ����
-- ��� : ��� �� ���
-- ���೻�� : TEMP_BACKUP ���̺� ���� ROW �� INSERT

CREATE OR REPLACE TRIGGER T01
BEFORE UPDATE ON TEMP
FOR EACH ROW
BEGIN
    INSERT INTO TEMP_BACKUP (DATA_BACKUP) VALUES (:OLD.DATA);
END;
/
SELECT * FROM TEMP;
SELECT * FROM TEMP_BACKUP;

INSERT INTO TEMP(DATA) VALUES('HELLO');
UPDATE TEMP SET DATA = 'HI';


