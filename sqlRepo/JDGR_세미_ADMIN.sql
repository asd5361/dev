--����
DROP TABLE ADMIN CASCADE CONSTRAINTS;  
--����
CREATE TABLE ADMIN (
	ADMIN_NO	    NUMBER	        PRIMARY KEY
	,ADMIN_ID	    VARCHAR2(20)	NOT NULL	                
	,ADMIN_PWD	    VARCHAR2(20)	NOT NULL	                
	,ADMIN_NAME	    VARCHAR2(20)		                    
	,QUIT_YN	    CHAR(1)	        DEFAULT 'N'	        
    ,ENROLL_DATE	TIMESTAMP	    DEFAULT SYSDATE	    
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "ADMIN"."ADMIN_NO" IS '������ ��ȣ "PK"';
COMMENT ON COLUMN "ADMIN"."ADMIN_ID" IS '������ ���̵�';
COMMENT ON COLUMN "ADMIN"."ADMIN_PWD" IS '��й�ȣ';
COMMENT ON COLUMN "ADMIN"."ADMIN_NAME" IS '�����ڸ�';
COMMENT ON COLUMN "ADMIN"."QUIT_YN" IS 'Ż�𿩺�';
COMMENT ON COLUMN "ADMIN"."ENROLL_DATE" IS '��������';

---------------------������--------------------
--ADMIN
DROP SEQUENCE SEQ_ADMIN;
CREATE SEQUENCE SEQ_ADMIN NOCYCLE NOCACHE;
--SEQ_ADMIN.NEXTVAL;

---------------------���̵�����--------------------
INSERT INTO ADMIN(ADMIN_NO,ADMIN_ID,ADMIN_PWD,ADMIN_NAME) VALUES (SEQ_ADMIN.NEXTVAL,'ADMIN01','1234','�ʱ������');

commit;

