/*
    <PL/SQL>
        ����Ŭ ��ü�� ����Ǿ� �ִ� ������ ���� SQL ���� ������ ������ ����, ���� ó��(IF), �ݺ� ó��(LOOP, FOR, WHILE) ���� �����Ѵ�.
        (�ټ��� SQL ���� �� ���� ������ �����ϴ�.)
        
        [PL/SQL�� ����]
            1) �����(DECLAER SECTION) : DECLARE�� ����, ������ ����� ���� �� �ʱ�ȭ�ϴ� �κ��̴�.
            2) �����(EXECUTABLE SECTION) : BEGIN�� ����, SQL ��, ���(����, �ݺ���) ���� ������ ����ϴ� �κ��̴�.
            3) ���� ó����(EXCEPTION SECTION) : EXCEPTION�� ����, ���� �߻� �� �ذ��ϱ� ���� ������ ����ϴ� �κ��̴�.
            
        
    <PL/SQL �����(DECLAER SECTION)>
        ���� �� ����� ������ ���� �����̴�.(����� ���ÿ� �ʱ�ȭ�� ����)
        ���� �� ����� �Ϲ� Ÿ�� ����, ���۷��� Ÿ�� ����, ROW Ÿ�� ������ �����ؼ� ����� �� �ִ�.
        
        1) �Ϲ� Ÿ�� ������ ���� �� �ʱ�ȭ
            [����]
                ������ [CONSTANT] �ڷ���(ũ��) [:= ��];
                
        2) ���۷��� Ÿ�� ���� ���� �� �ʱ�ȭ
            [����]
                ������ ���̺��.Į����%TYPE;
            
            - �ش��ϴ� ���̺��� Į���� ������ Ÿ���� �����ؼ� �� Ÿ������ ������ �����Ѵ�.
            
        3) ROW Ÿ�� ���� ���� �� �ʱ�ȭ
            [����]
                ������ ���̺��%ROWTYPE;
                
            - �ϳ��� ���̺��� ���� Į���� ���� �Ѳ����� ������ �� �ִ� ������ �ǹ��Ѵ�.
            - ��� Į���� ��ȸ�ϴ� ��쿡 ����ϱ� ���ϴ�.        
*/
/*����
    DECLARE 
    BEGIN
    END;
    /
*/
--��� ��� Ȱ��ȭ
SET SERVEROUTPUT ON;

DECLARE 
    ABC NUMBER;
    SSS VARCHAR2(100);
    P   CONSTANT NUMBER :=3.14;
BEGIN
    ABC := 123;
    SSS := 'ȫ�浿';
--    P   := 123.456;   --������� �Ҵ� �Ұ���
    
    DBMS_OUTPUT.PUT_LINE('ABC : ' || ABC);  --���
    DBMS_OUTPUT.PUT_LINE('SSS : ' || SSS);
    DBMS_OUTPUT.PUT_LINE('P : ' || P);

END;
/

DECLARE
    STR EMPLOYEE.EMP_NAME%TYPE;
    MONEY EMPLOYEE.SALARY%TYPE;
BEGIN

    SELECT EMP_NAME,SALARY 
    INTO STR, MONEY
    FROM EMPLOYEE 
    WHERE EMP_ID ='&������Է��ϼ���';
    
    DBMS_OUTPUT.PUT_LINE(STR);
    DBMS_OUTPUT.PUT_LINE(MONEY);
END;
/


DECLARE
    X EMPLOYEE%ROWTYPE;
BEGIN
    SELECT * 
    INTO X
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE(X.EMP_ID);
    DBMS_OUTPUT.PUT_LINE(X.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(X.EMP_NO);
    DBMS_OUTPUT.PUT_LINE(X.SALARY);
    DBMS_OUTPUT.PUT_LINE(X.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE(X.JOB_CODE);
END;
/

/*
    <PL/SQL �����(EXECUTABLE SECTION)>
        1) ���ù�
          1-1) ���� IF ����
            [����]
                IF ���ǽ� THEN
                    ���� ����
                END IF;
                
        1-2) IF ~ ELSE ����
          [����]
            IF ���ǽ� THEN
                ���� ����
            ELSE 
                ���� ����
            END IF;
                
        1-3) IF ~ ELSIF ~ ELSE ����
          [����]
            IF ���ǽ� THEN
                ���� ����
            ELSIF ���ǽ� THEN
                ���� ����
            ...
            [ELSE
                ���� ����]
            END IF;
            
        1-4) CASE ����
          [����]
            CASE �� ���
                 WHEN �񱳰�1 THEN �����1
                 WHEN �񱳰�2 THEN �����2
                 ...
                 [ELSE �����]
            END;
*/
DECLARE
    MONEY EMPLOYEE.SALARY%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT SALARY , EMP_NAME
    INTO MONEY, ENAME
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('����� : '||ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||MONEY);
    IF MONEY>=8000000
        THEN DBMS_OUTPUT.PUT_LINE('����' );
    ELSIF MONEY>=5000000
        THEN DBMS_OUTPUT.PUT_LINE('�߼�');
    ELSE
        DBMS_OUTPUT.PUT_LINE('����');
    END IF;
END;
/

DECLARE
    X NUMBER;
   -- MONEY NUMBER EMPYOLEE.SALARY%TYPE
BEGIN
    X := 10;
    CASE X
        WHEN 3 THEN DBMS_OUTPUT.PUT_LINE('3');
        WHEN 10 THEN DBMS_OUTPUT.PUT_LINE('10');
        ELSE DBMS_OUTPUT.PUT_LINE('����');
    END CASE;
END;
/

/*
        2) �ݺ���
        
        2-1) BASIC LOOP
            [����]
                LOOP
                    �ݺ������� �����ų ����
                    
                    [�ݺ����� �������� ���ǹ� �ۼ�]
                        1) IF ���ǽ� THEN 
                              EXIT;
                           END IF
                           
                        2) EXIT WHEN ���ǽ�;
                END LOOP;
                
        2-2) WHILE LOOP
          [����]
            WHILE ���ǽ�
            LOOP
                �ݺ������� ������ ����;
            END LOOP;
            
        3) FOR LOOP
          [����]
            FOR ���� IN [REVERSE] �ʱⰪ..������
            LOOP
                �ݺ������� ������ ����;
            END LOOP;
            
*/

DECLARE
    X NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(X);
        X:= X+1;
        
--        IF X >5 
--            THEN EXIT; 
--        END IF;
        
        EXIT WHEN X>5;
    
    END LOOP;
END;
/


DECLARE
    X NUMBER := 1;
BEGIN
    WHILE X <= 5 
    LOOP
        DBMS_OUTPUT.PUT_LINE(X);
        X := X+1;
    END LOOP;
END;
/

DECLARE --���� ����

BEGIN
    --FOR X IN 1..5 
    FOR X IN REVERSE 1..7 --�Ųٷ� ���
    LOOP
        DBMS_OUTPUT.PUT_LINE(X);
    END LOOP;
END;
/

--������
DECLARE
BEGIN
    FOR DAN IN 2..9
    LOOP
        IF MOD(DAN,2) = 0
            THEN
                FOR X IN 1..9
                LOOP
                    DBMS_OUTPUT.PUT_LINE(DAN||' *'||X||' ='||DAN*X);
                END LOOP;      
        END IF;
    END LOOP;
END;
/

/*
    <PL/SQL ����ó����(EXCEPTION SECTION)>
        ���ܶ� ���� �� �߻��ϴ� ������ ���ϰ� PL/SQL ������ �߻��� ���ܸ� ����ó���ο��� �ڵ�� ó���� �����ϴ�.

        [����]
            DECLARE
                ...
            BEGIN
                ...
            EXCEPTION
                WHEN ���ܸ� 1 THEN ����ó������ 1;
                WHEN ���ܸ� 2 THEN ����ó������ 2;
                ...
                WHEN OTHERS THEN ����ó������;
                
        * ����Ŭ���� �̸� ���ǵǾ� �ִ� ����
          - NO_DATA_FOUND : SELECT ���� ���� ����� �� �൵ ���� ��쿡 �߻��Ѵ�.
          - TOO_MANY_ROWS : �� ���� ���ϵǾ�� �ϴµ� SELECT ������ ���� ���� ���� ������ �� �߻��Ѵ�. 
          - ZERO_DIVIDE   : ���ڸ� 0���� ���� �� �߻��Ѵ�.
          - DUP_VAL_ON_INDEX : UNIQUE ���� ������ ���� �÷��� �ߺ��� �����Ͱ� INSERT �� �� �߻��Ѵ�.
*/
DECLARE

BEGIN
    DBMS_OUTPUT.PUT_LINE(1/0);
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('���� �߻�') ;
END;
/