/*
    <PROCEDURE>
        PL/SQL ���� �����ϴ� ��ü�̴�.
        �ʿ��� ������ ������ ������ �ٽ� �Է��� �ʿ� ���� �����ϰ� ȣ���ؼ� ���� ����� ���� �� �ִ�.
        Ư�� ������ ó���ϱ⸸ �ϰ� ������� ��ȯ���� �ʴ´�.
        
        [����]
            CREATE PROCEDURE ���ν�����
            (
                �Ű����� 1 [IN/OUT] ������Ÿ�� [:=DEFAULT ��],
                �Ű����� 2 [IN/OUT] ������Ÿ�� [:=DEFAULT ��],
                ...
            )
            IS [AS]
                �����
            BEGIN
                �����
            EXCEPTION
                ����ó����
            END [���ν�����];
            /
            
        [������]
            EXECUTE(EXEC) ���ν�����[(�Ű���1, �Ű���2, ...)];
*/
DROP TABLE TEMP;
CREATE TABLE TEMP(
    DATA VARCHAR2(100)
);
SELECT * FROM TEMP;

CREATE OR REPLACE PROCEDURE ABC
IS
BEGIN
    INSERT INTO TEMP(DATA) VALUES ('HELLO');
    INSERT INTO TEMP(DATA) VALUES ('�ȳ�');
    INSERT INTO TEMP(DATA) VALUES ('�ȳ��ϼ���');
    INSERT INTO TEMP(DATA) VALUES ('HI');
END;
/
-- ���ν��� ����
EXECUTE ABC;

--���ν��� ����
DROP PROCEDURE ABC;

/*
    <FUNCTION>
        ���ν����� ��� �뵵�� ���������
        ���ν����� �ٸ��� OUT ������ ������� �ʾƵ� ���� ����� �ǵ��� ���� �� �ִ�.(RETURN )
        
        [����]
            CREATE FUNCTION �Լ���
            (
                �Ű����� 1 Ÿ��,
                �Ű����� 2 Ÿ��,
                ...
            )
            RETURN ������Ÿ��
            IS
                �����
            BEGIN
                �����
                
                RETRUN ��ȯ��; -- ���ν����� �ٸ��� RETURN ������ �߰��ȴ�.
            EXCEPTION
                ����ó����
            END [�Լ���];
            /
*/
--���ϰ� �ִ� ���ν���
CREATE OR REPLACE FUNCTION F01
RETURN NUMBER
IS
BEGIN
    RETURN 10+20;
END;
/

-- ���ν��� ����
SELECT F01 FROM DUAL;
