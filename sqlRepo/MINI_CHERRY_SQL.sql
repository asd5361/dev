/* 
 *  
 *  
 *  
 *  
 */
 
 --���̺� ���� ����
DROP TABLE MEMBER CASCADE CONSTRAINTS;          --MEMBER
DROP TABLE AREAS CASCADE CONSTRAINTS;           --AREAS
DROP TABLE MANAGER CASCADE CONSTRAINTS;         --MENAGER //
DROP TABLE NOTICE CASCADE CONSTRAINTS;          --NOTICE
DROP TABLE FAQ CASCADE CONSTRAINTS;             --FAQ
DROP TABLE QNA CASCADE CONSTRAINTS;             --QNA
DROP TABLE TRADE CASCADE CONSTRAINTS;           --TRADE
DROP TABLE REVIEW CASCADE CONSTRAINTS;          --REVIEW
DROP TABLE WISHLIST CASCADE CONSTRAINTS;        --WISHLIST
DROP TABLE PURCHASE_HISTORY CASCADE CONSTRAINTS;--PURCHASE_HISTORY
DROP TABLE TOWN CASCADE CONSTRAINTS;            --TOWN
DROP TABLE TOWN_COMMENT CASCADE CONSTRAINTS;    --TOWN_COMMENT


---------------------MEMBER---------------------
CREATE TABLE MEMBER (
	MEMBER_NO	    NUMBER		        PRIMARY KEY
	,AREAS_CODE	    NUMBER		        NOT NULL
	,ID	            VARCHAR2(100)		NOT NULL    UNIQUE
	,PWD	        VARCHAR2(100)		NOT NULL
	,NAME	        VARCHAR2(10)		NOT NULL   
	,EMALE	        VARCHAR2(100)		NOT NULL    UNIQUE
	,PHONE	        CHAR(12)		    NOT NULL    UNIQUE
	,ADDRESS	    VARCHAR2(100)		NOT NULL
	,JOIN_DATE	    TIMESTAMP	        DEFAULT SYSDATE
	,EDIT_DATE	    TIMESTAMP		    
	,QUIT_YN	    CHAR(1)	            DEFAULT 'N'	CHECK(QUIT_YN IN ('Y','N'))
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '����ڹ�ȣ';
COMMENT ON COLUMN "MEMBER"."AREAS_CODE" IS '���׹�ȣ';
COMMENT ON COLUMN "MEMBER"."ID" IS '���̵�';
COMMENT ON COLUMN "MEMBER"."PWD" IS '��й�ȣ';
COMMENT ON COLUMN "MEMBER"."NAME" IS '����ڸ�';
COMMENT ON COLUMN "MEMBER"."EMALE" IS '�̸���';
COMMENT ON COLUMN "MEMBER"."PHONE" IS '��ȭ��ȣ';
COMMENT ON COLUMN "MEMBER"."ADDRESS" IS '�ּ�';
COMMENT ON COLUMN "MEMBER"."JOIN_DATE" IS '��������';
COMMENT ON COLUMN "MEMBER"."EDIT_DATE" IS '��������������';
COMMENT ON COLUMN "MEMBER"."QUIT_YN" IS 'Ż�𿩺�';

---------------------AREAS---------------------
CREATE TABLE AREAS (
	AREAS_CODE	    NUMBER		 PRIMARY KEY
	,AREAS_NAME	    VARCHAR2(100) NOT NULL
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "AREAS"."AREAS_CODE" IS '���׹�ȣ';
COMMENT ON COLUMN "AREAS"."AREAS_NAME" IS '�����̸�';

---------------------MANAGER---------------------
CREATE TABLE MANAGER (
	MANAGER_NO	    NUMBER		    PRIMARY KEY
	,MANAGER_ID	    VARCHAR2(100)	NOT NULL    UNIQUE
	,PWD	        VARCHAR2(100)	NOT NULL
	,NAME	        VARCHAR2(100)	NOT NULL
	,JOIN_DATE	    TIMESTAMP	    DEFAULT SYSDATE
	,QUIT_YN	    CHAR(1)	        DEFAULT 'N' CHECK(QUIT_YN IN ('Y','N')) 
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "MANAGER"."MANAGER_NO" IS '�����ڹ�ȣ';
COMMENT ON COLUMN "MANAGER"."MANAGER_ID" IS '�����ھ��̵�';
COMMENT ON COLUMN "MANAGER"."PWD" IS '��й�ȣ';
COMMENT ON COLUMN "MANAGER"."NAME" IS '�����ڸ�';
COMMENT ON COLUMN "MANAGER"."JOIN_DATE" IS '��������';
COMMENT ON COLUMN "MANAGER"."QUIT_YN" IS 'Ż�𿩺�';

---------------------NOTICE---------------------
CREATE TABLE NOTICE (
	"NOTICE_NO"	NUMBER		        NOT NULL,
	"MANAGER_NO"	NUMBER		    NOT NULL,
	"TITLE"	VARCHAR2(1000)		    NOT NULL,
	"CONTENT"	VARCHAR2(4000)		NOT NULL,
	"ENROLL_DATE"	TIMESTAMP	    DEFAULT SYSDATE,
	"SECRET_YN"	CHAR(1)	            DEFAULT 'Y'	 CHECK(SECRET_YN IN('Y','N')), 
	"EDIT_DATE"	TIMESTAMP		
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "NOTICE"."NOTICE_NO" IS '�Խñ۹�ȣ';
COMMENT ON COLUMN "NOTICE"."MANAGER_NO" IS '�ۼ��ڹ�ȣ';
COMMENT ON COLUMN "NOTICE"."TITLE" IS '����';
COMMENT ON COLUMN "NOTICE"."CONTENT" IS '����';
COMMENT ON COLUMN "NOTICE"."ENROLL_DATE" IS '�ۼ���';
COMMENT ON COLUMN "NOTICE"."SECRET_YN" IS '��������';
COMMENT ON COLUMN "NOTICE"."EDIT_DATE" IS '��������������';

---------------------FAQ---------------------
CREATE TABLE FAQ (
	FAQ_NO	        NUMBER		    NOT NULL
	,MANAGER_NO	    NUMBER		    NOT NULL
	,TITLE	        VARCHAR2(100)	NOT NULL
    ,CONTENT	    VARCHAR2(4000)	NOT NULL,
	ENROLL_DATE	    TIMESTAMP	    DEFAULT SYSDATE
    ,SECRET_YN	    CHAR(1)	        DEFAULT 'Y'
    ,EDIT_DATE	    TIMESTAMP		
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "FAQ"."FAQ_NO" IS '������ȣ PK';
COMMENT ON COLUMN "FAQ"."MANAGER_NO" IS '�����ڹ�ȣ FK';
COMMENT ON COLUMN "FAQ"."TITLE" IS '��������';
COMMENT ON COLUMN "FAQ"."CONTENT" IS '��������';
COMMENT ON COLUMN "FAQ"."ENROLL_DATE" IS '�Խñ��ۼ���';
COMMENT ON COLUMN "FAQ"."SECRET_YN" IS '��������';
COMMENT ON COLUMN "FAQ"."EDIT_DATE" IS '��������������';

---------------------QNA---------------------
CREATE TABLE QNA (
    QNA_NO                  NUMBER              PRIMARY KEY         
    , MEMBER_NO             NUMBER             
    , MANAGER_NO            NUMBER              
    , TITLE                 VARCHAR2(1000)      NOT NULL
    , CONTENT               VARCHAR2(4000)      NOT NULL
    , MEMBER_ENROLL_DATE    TIMESTAMP           DEFAULT SYSDATE
    , SECRET_YN             CHAR(1)             DEFAULT 'Y' CHECK(SECRET_YN IN('Y', 'N'))
    , ANSWER                VARCHAR2(4000)
    , MANAGER_ENROLL_DATE   TIMESTAMP           DEFAULT SYSDATE
    , MANAGER_EDIT_DATE     TIMESTAMP           DEFAULT SYSDATE
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "QNA"."QNA_NO" IS '�Խñ۹�ȣPK';
COMMENT ON COLUMN "QNA"."MEMBER_NO" IS '����ڹ�ȣFK';
COMMENT ON COLUMN "QNA"."MANAGER_NO" IS '�����ڹ�ȣFK';
COMMENT ON COLUMN "QNA"."TITLE" IS '����';
COMMENT ON COLUMN "QNA"."CONTENT" IS '����';
COMMENT ON COLUMN "QNA"."MEMBER_ENROLL_DATE" IS '������� �Խñ��ۼ���';
COMMENT ON COLUMN "QNA"."SECRET_YN" IS '��������';
COMMENT ON COLUMN "QNA"."ANSWER" IS '�������� �亯';
COMMENT ON COLUMN "QNA"."MANAGER_ENROLL_DATE" IS '�������� �亯 �ۼ���';
COMMENT ON COLUMN "QNA"."MANAGER_EDIT_DATE" IS '������ �亯 ���� ����';

---------------------TRADE---------------------
CREATE TABLE TRADE (
	BOARD_NO	        NUMBER		        PRIMARY KEY
	,MEMBER_NO	        NUMBER		        NOT NULL
	,AREAS_CODE	        NUMBER		        NOT NULL
	,TITLE	            VARCHAR2(100)		NOT NULL
	,TRADE_AREAS	    VARCHAR2(100)		NOT NULL
	,CONTENT	        VARCHAR2(4000)		NOT NULL
	,COMPLETE_YN	    CHAR(1)	            DEFAULT 'N'	CHECK(COMPLETE_YN IN('Y', 'N'))
	,DELETE_POST_YN	    CHAR(1)         	DEFAULT 'N'	CHECK(DELETE_POST_YN IN('Y', 'N'))
	,PRODUCT	        VARCHAR2(100)		NOT NULL
	,PRICE	            NUMBER		        NOT NULL
	,ENROLL_DATE	    TIMESTAMP	        DEFAULT SYSDATE
	,EDIT_DATE	        TIMESTAMP		    
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "TRADE"."BOARD_NO" IS '�Խñ� ��ȣ';
COMMENT ON COLUMN "TRADE"."MEMBER_NO" IS '�ۼ��� ��ȣ';
COMMENT ON COLUMN "TRADE"."AREAS_CODE" IS '���� �ڵ�';
COMMENT ON COLUMN "TRADE"."TITLE" IS '����';
COMMENT ON COLUMN "TRADE"."TRADE_AREAS" IS '�ŷ� ���';
COMMENT ON COLUMN "TRADE"."CONTENT" IS '����';
COMMENT ON COLUMN "TRADE"."COMPLETE_YN" IS '�ŷ� ����';
COMMENT ON COLUMN "TRADE"."DELETE_POST_YN" IS '�Խñ� ���� ����';
COMMENT ON COLUMN "TRADE"."PRODUCT" IS '��ǰ��';
COMMENT ON COLUMN "TRADE"."PRICE" IS '����';
COMMENT ON COLUMN "TRADE"."ENROLL_DATE" IS '�ۼ���';
COMMENT ON COLUMN "TRADE"."EDIT_DATE" IS '������ ��������';

---------------------REVIEW---------------------
CREATE TABLE REVIEW (
	REVIEW_NO	    NUMBER		        PRIMARY KEY
	,PURCHASE_NO	NUMBER		        NOT NULL
	,SCORE	        NUMBER		        NOT NULL
	,CONTENT	    VARCHAR2(100)		NOT NULL
	,ENROLL_DATE	TIMESTAMP	        DEFAULT SYSDATE
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "REVIEW"."REVIEW_NO" IS '�ı� ��ȣ';
COMMENT ON COLUMN "REVIEW"."PURCHASE_NO" IS '���ų��� ��ȣ';
COMMENT ON COLUMN "REVIEW"."SCORE" IS '�ųʿµ� ��';
COMMENT ON COLUMN "REVIEW"."CONTENT" IS '����';
COMMENT ON COLUMN "REVIEW"."ENROLL_DATE" IS '�ۼ���';

---------------------WISHLIST---------------------
CREATE TABLE WISHLIST (
	WISHLIST_NO	    NUMBER		PRIMARY KEY
	,BOARD_NO	    NUMBER		NOT NULL
	,MEMBER_NO	    NUMBER		NOT NULL
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "WISHLIST"."WISHLIST_NO" IS '���ɸ�Ϲ�ȣ';
COMMENT ON COLUMN "WISHLIST"."BOARD_NO" IS '�Խñ۹�ȣ';
COMMENT ON COLUMN "WISHLIST"."MEMBER_NO" IS '������ȣ';

---------------------PURCHASE_HISTORY---------------------
CREATE TABLE PURCHASE_HISTORY (
	PURCHASE_NO	    NUMBER		PRIMARY KEY
	,BUYER_NO	    NUMBER		NOT NULL
	,BOARD_NO	    NUMBER		NOT NULL
	,ENROLL_DATE	TIMESTAMP	DEFAULT SYSDATE
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "PURCHASE_HISTORY"."PURCHASE_NO" IS '���ų�����ȣ';
COMMENT ON COLUMN "PURCHASE_HISTORY"."BUYER_NO" IS '������';
COMMENT ON COLUMN "PURCHASE_HISTORY"."BOARD_NO" IS '������ �Խñ� ��ȣ';
COMMENT ON COLUMN "PURCHASE_HISTORY"."ENROLL_DATE" IS '�����Ͻ�';

---------------------TOWN---------------------
CREATE TABLE TOWN (
	TOWN_NO	        NUMBER		        PRIMARY KEY
	,MEMBER_NO	    NUMBER		        NOT NULL
	,TITLE	        VARCHAR2(100)		NOT NULL
	,CONTENT	    VARCHAR2(1000)		NOT NULL
	,ENROLL_DATE	TIMESTAMP	        DEFAULT SYSDATE
	,DELETE_YN	    CHAR(1)	            DEFAULT 'N'	CHECK(DELETE_YN IN('Y', 'N'))
	,EDIT_DATE	    TIMESTAMP		    
	,CATEGORY	    VARCHAR2(100)		NOT NULL CHECK(CATEGORY IN('��������', '���׸���', '��Ȱ����', '�����ϻ�'))
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "TOWN"."TOWN_NO" IS '�Խ��ǹ�ȣ';
COMMENT ON COLUMN "TOWN"."MEMBER_NO" IS '����ڹ�ȣ';
COMMENT ON COLUMN "TOWN"."TITLE" IS '����';
COMMENT ON COLUMN "TOWN"."CONTENT" IS '����';
COMMENT ON COLUMN "TOWN"."ENROLL_DATE" IS '�ۼ���';
COMMENT ON COLUMN "TOWN"."DELETE_YN" IS '��������';
COMMENT ON COLUMN "TOWN"."EDIT_DATE" IS '������ ��������';
COMMENT ON COLUMN "TOWN"."CATEGORY" IS 'ī�װ���';

---------------------TOWN_COMMENT---------------------
CREATE TABLE TOWN_COMMENT (
	COMMENT_NO	    NUMBER		    PRIMARY KEY
	,TOWN_NO	    NUMBER		    NOT NULL
	,MEMBER_NO	    NUMBER		    NOT NULL
	,ENROLL_DATE	TIMESTAMP	    DEFAULT SYSDATE
    ,CONTENT	    VARCHAR2(100)	NOT NULL
);
---------------------�ڸ�Ʈ--------------------
COMMENT ON COLUMN "TOWN_COMMENT"."COMMENT_NO" IS '��� ��ȣ';
COMMENT ON COLUMN "TOWN_COMMENT"."TOWN_NO" IS '�Խñ� ��ȣ';
COMMENT ON COLUMN "TOWN_COMMENT"."MEMBER_NO" IS '�ۼ��� ��ȣ';
COMMENT ON COLUMN "TOWN_COMMENT"."ENROLL_DATE" IS '�ۼ���';
COMMENT ON COLUMN "TOWN_COMMENT"."CONTENT" IS '��� ����';




---------------------������--------------------
--MEMBER
DROP SEQUENCE SEQ_MEMBER;
CREATE SEQUENCE SEQ_MEMBER NOCYCLE NOCACHE;
--SEQ_MEMBER.NEXTVAL;

--AREAS
DROP SEQUENCE SEQ_AREAS;
CREATE SEQUENCE SEQ_AREAS NOCYCLE NOCACHE;
--SEQ_AREAS.NEXTVAL;

--MANAGER
DROP SEQUENCE SEQ_MANAGER;
CREATE SEQUENCE SEQ_MANAGER NOCYCLE NOCACHE;
--SEQ_MANAGER.NEXTVAL;

--NOTICE
DROP SEQUENCE SEQ_NOTICE_NO;
CREATE SEQUENCE SEQ_NOTICE_NO NOCYCLE NOCACHE;
COMMIT;

--FAQ
DROP SEQUENCE SEQ_FAQ_NO;
CREATE SEQUENCE SEQ_FAQ_NO NOCYCLE NOCACHE;

--QNA
DROP SEQUENCE SEQ_QNA_NO;
CREATE SEQUENCE SEQ_QNA_NO NOCYCLE NOCACHE;

--BOARD
DROP SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;

--REVIEW
DROP SEQUENCE SEQ_REVIEW_NO;
CREATE SEQUENCE SEQ_REVIEW_NO NOCACHE NOCYCLE;

--WISHLIST
DROP SEQUENCE SEQ_WISHLIST_NO;
CREATE SEQUENCE SEQ_WISHLIST_NO NOCACHE NOCYCLE;

--PURCHASE
DROP SEQUENCE SEQ_PURCHASE_NO;
CREATE SEQUENCE SEQ_PURCHASE_NO NOCACHE NOCYCLE;

--TOWN
DROP SEQUENCE SEQ_TOWN_NO;
CREATE SEQUENCE SEQ_TOWN_NO NOCACHE NOCYCLE;

--TOWN
DROP SEQUENCE SEQ_TOWN_COMMENT_NO;
CREATE SEQUENCE SEQ_TOWN_COMMENT_NO NOCACHE NOCYCLE;

-------------------�ܷ�Ű----------------------
--MEMBER
ALTER TABLE MEMBER 
ADD CONSTRAINT FK_AREAS_MEMBER
FOREIGN KEY (AREAS_CODE) REFERENCES AREAS(AREAS_CODE);
COMMIT;

--NOTICE
ALTER TABLE NOTICE 
ADD CONSTRAINT FK_NOTICE_MANAGER 
FOREIGN KEY(MANAGER_NO)REFERENCES MANAGER(MANAGER_NO);

--FK_QNA_MEMBER
ALTER TABLE QNA
ADD CONSTRAINT FK_QNA_MEMBER 
FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER (MEMBER_NO);

--FK_QNA_MANAGER
ALTER TABLE QNA
ADD CONSTRAINT FK_QNA_MANAGER 
FOREIGN KEY(MANAGER_NO) REFERENCES MANAGER (MANAGER_NO);

-- FK_MEMBER_TO_TRADE_1
ALTER TABLE TRADE 
ADD CONSTRAINT FK_MEMBER_TO_TRADE_1 
FOREIGN KEY (MEMBER_NO)
REFERENCES MEMBER (MEMBER_NO);

-- FK_AREAS_TO_TRADE_1
ALTER TABLE TRADE 
ADD CONSTRAINT FK_AREAS_TO_TRADE_1 
FOREIGN KEY (AREAS_CODE)
REFERENCES AREAS (AREAS_CODE);

--FK_PURCHASE_HISTORY_TO_REVIEW_1
ALTER TABLE REVIEW 
ADD CONSTRAINT FK_PURCHASE_HISTORY_TO_REVIEW_1 
FOREIGN KEY (PURCHASE_NO)
REFERENCES PURCHASE_HISTORY (PURCHASE_NO);

--FK_TRADE_TO_WISHLIST_1 
ALTER TABLE WISHLIST 
ADD CONSTRAINT FK_TRADE_TO_WISHLIST_1 
FOREIGN KEY (BOARD_NO)
REFERENCES TRADE (BOARD_NO);

--FK_MEMBER_TO_WISHLIST_1
ALTER TABLE WISHLIST 
ADD CONSTRAINT FK_MEMBER_TO_WISHLIST_1 
FOREIGN KEY (MEMBER_NO)
REFERENCES MEMBER (MEMBER_NO);

--FK_MEMBER_TO_PURCHASE_HISTORY_1
ALTER TABLE PURCHASE_HISTORY 
ADD CONSTRAINT FK_MEMBER_TO_PURCHASE_HISTORY_1 
FOREIGN KEY (BUYER_NO)
REFERENCES MEMBER (MEMBER_NO);

-- FK_TRADE_TO_PURCHASE_HISTORY_1
ALTER TABLE PURCHASE_HISTORY 
ADD CONSTRAINT FK_TRADE_TO_PURCHASE_HISTORY_1 
FOREIGN KEY (BOARD_NO)
REFERENCES TRADE (BOARD_NO);

--FK_MEMBER_TO_TOWN_1
ALTER TABLE TOWN 
ADD CONSTRAINT FK_MEMBER_TO_TOWN_1 
FOREIGN KEY (MEMBER_NO)
REFERENCES MEMBER (MEMBER_NO);

--FK_TOWN_TO_TOWN_COMMENT_1 
ALTER TABLE TOWN_COMMENT 
ADD CONSTRAINT FK_TOWN_TO_TOWN_COMMENT_1 
FOREIGN KEY (TOWN_NO)
REFERENCES TOWN (TOWN_NO);

--FK_MEMBER_TO_TOWN_COMMENT_1 
ALTER TABLE TOWN_COMMENT 
ADD CONSTRAINT FK_MEMBER_TO_TOWN_COMMENT_1 
FOREIGN KEY (MEMBER_NO)
REFERENCES MEMBER (MEMBER_NO);

