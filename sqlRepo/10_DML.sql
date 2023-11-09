/*
    <DML(Data Manipulation Language)>
        ������ ���� ���� ���̺� ���� ����(INSERT)�ϰų�, ����(UPDATE), ����(DELETE)�ϴ� �����̴�.
    
    <INSERT>
        ���̺� ���ο� ���� �߰��ϴ� �����̴�.
        
        [����]
            1) INSERT INTO ���̺�� VALUES(��, ��, ��, ..., ��);
                ���̺� ��� Į���� ���� INSERT �ϰ��� �� �� ����Ѵ�.
                Į�� ������ ���Ѽ� VALUES�� ���� �����ؾ� �Ѵ�.
            2) INSERT INTO ���̺��(Į����, Į����, ..., Į����) VALUES(��, ��, ..., ��);
                ���̺� ���� ������ Į���� ���� ���� INSERT �ϰ��� �� �� ����Ѵ�.
                ������ �ȵ� Į������ �⺻������ NULL ���� ����. (NOT NULL ���������� �ɷ��ִ� Į���� �ݵ�� �����ؼ� ���� �����ؾ� �Ѵ�.)
                ��, �⺻��(DEFAULT)�� �����Ǿ� ������ NULL�� �ƴ� �⺻���� ����.
            3) INSERT INTO ���̺�� (��������);
                VALUES�� ����ؼ� ���� ������ ��ȸ�� ������� ��ä�� INSERT �Ѵ�.(��, �������� INSERT ��ų �� �ִ�.)
                ���� ������ ������� INSERT ���� ������ Į���� ������ ������ Ÿ���� ���ƾ� �Ѵ�.
*/

/*
    <INSERT ALL>
        �� �� �̻��� ���̺� INSERT �ϴµ� ������ ���� ������ ���Ǵ� ���
        INSERT ALL�� �̿��ؼ� ���� ���̺� �� ���� ������ ������ �����ϴ�.
        
        [����]
            1) INSERT ALL
               INTO ���̺��1[(Į��, Į��, ...)] VALUES(��, ��, ...)
               INTO ���̺��2[(Į��, Į��, Į��, ...)] VALUES(��, ��, ��, ...)
               ���� ����;
               
            2) INSERT ALL
               WHEN ����1 THEN 
                   INTO ���̺��1[(Į��, Į��, ...)] VALUES(��, ��, ...)
               WHEN ����2 THEN     
                   INTO ���̺��2[(Į��, Į��, ...)] VALUES(��, ��, ...)
               ���� ����;
*/

CREATE TABLE TEMP(
    TITLE VARCHAR2(1000)
    ,CONTENT VARCHAR2(1000)
);
INSERT ALL 
    INTO TEMP(TITLE, CONTENT) VALUES ('T01','C01')
    INTO TEMP(TITLE, CONTENT) VALUES ('T02','C02')
    INTO TEMP(TITLE, CONTENT) VALUES ('T03','C03')
SELECT 1 FROM DUAL --�ǹ� ���� ���� ���� (���� ���߱� ����)
;
SELECT * FROM TEMP;
-------------------------------------------------------
CREATE TABLE TEMP_A(
    ABC VARCHAR2(1000)  --TITLE ������ ���� ��ȹ
);

CREATE TABLE TEMP_B(
    ASD VARCHAR2(1000)  --TEMP���̺��� CONTENT �����͸� ���� ��ȹ
);
INSERT ALL
        INTO TEMP_A(ABC) VALUES (TITLE)
        INTO TEMP_B(ASD) VALUES (CONTENT)
SELECT TITLE,CONTENT 
FROM TEMP
;
SELECT * FROM TEMP_A;
SELECT * FROM TEMP_B;

/*
    <UPDATE>
        ���̺� ��ϵ� �����͸� �����ϴ� �����̴�.
         
        [����]
            UPDATE ���̺��
            SET Į���� = �����Ϸ��� ��,
                Į���� = �����Ϸ��� ��,
                ...
            [WHERE ����];

            UPDATE ���̺��
            SET Į���� = (���� ����),
                Į���� = (���� ����),
                ...
            [WHERE ����];

        - SET ������ ���� ���� Į���� �޸�(,)�� �����ؼ� ���� ���ÿ� ������ �� �ִ�.
        - WHERE ���� �����ϸ� ��� ���� �����Ͱ� ����ȴ�.
        - UPDATE �ÿ� ���� ������ ����ؼ� ���� ������ ������ ��������� Į���� ���� ������ �� �ִ�.
*/

/*
    <DELETE>
        ���̺� ��� �� �����͸� �����ϴ� �����̴�. (�� ������ �����Ѵ�.)
        
        [����]
            DELETE FROM ���̺��
            [WHERE ���ǽ�];
            
        - WHERE ���� �������� ������ ��ü ���� �����ȴ�.
*/

/*
    <TRUNCATE>
        ���̺��� ��ü ���� ������ �� ����ϴ� �������� DELETE ���� ���� �ӵ��� �� ������.
        ������ ���� ���ð� �Ұ����ϰ� ROLLBACK�� �Ұ����ϴ�.
        
        [����]
            TRUNCATE TABLE ���̺��;
*/