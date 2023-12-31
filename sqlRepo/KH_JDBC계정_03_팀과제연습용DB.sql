DROP TABLE MEMBER_MINI CASCADE CONSTRAINTS;          --MEMBER
DROP TABLE AREAS_MINI CASCADE CONSTRAINTS;           --AREAS


---------------------MEMBER---------------------
CREATE TABLE MEMBER_MINI (
	 MEMBER_NO	    NUMBER		        PRIMARY KEY
	,AREAS_CODE	    NUMBER		        NOT NULL
	,ID	            VARCHAR2(100)		NOT NULL    UNIQUE
	,PWD	        VARCHAR2(100)		NOT NULL
	,NICK	        VARCHAR2(100)		NOT NULL    UNIQUE  
	,NAME	        VARCHAR2(10)		NOT NULL   
	,EMAIL 	        VARCHAR2(100)		NOT NULL    UNIQUE
	,PHONE	        CHAR(12)		    NOT NULL    UNIQUE
	,ADDRESS	    VARCHAR2(100)		NOT NULL
	,JOIN_DATE	    TIMESTAMP	        DEFAULT SYSDATE
	,EDIT_DATE	    TIMESTAMP		    
	,QUIT_YN	    CHAR(1)	            DEFAULT 'N'	CHECK(QUIT_YN IN ('Y','N'))
);
---------------------코멘트--------------------
COMMENT ON COLUMN "MEMBER_MINI"."MEMBER_NO" IS '사용자번호';
COMMENT ON COLUMN "MEMBER_MINI"."AREAS_CODE" IS '동네번호';
COMMENT ON COLUMN "MEMBER_MINI"."ID" IS '아이디';
COMMENT ON COLUMN "MEMBER_MINI"."PWD" IS '비밀번호';
COMMENT ON COLUMN "MEMBER_MINI"."NICK" IS '닉네임';
COMMENT ON COLUMN "MEMBER_MINI"."NAME" IS '사용자명';
COMMENT ON COLUMN "MEMBER_MINI"."EMAIL" IS '이메일';
COMMENT ON COLUMN "MEMBER_MINI"."PHONE" IS '전화번호';
COMMENT ON COLUMN "MEMBER_MINI"."ADDRESS" IS '주소';
COMMENT ON COLUMN "MEMBER_MINI"."JOIN_DATE" IS '가입일자';
COMMENT ON COLUMN "MEMBER_MINI"."EDIT_DATE" IS '마지막수정일자';
COMMENT ON COLUMN "MEMBER_MINI"."QUIT_YN" IS '탈퇴여부';

---------------------AREAS---------------------
CREATE TABLE AREAS_MINI (
	 AREAS_CODE	    NUMBER		 PRIMARY KEY
	,AREAS_NAME	    VARCHAR2(100) NOT NULL
);
---------------------코멘트--------------------
COMMENT ON COLUMN "AREAS_MINI"."AREAS_CODE" IS '동네번호';
COMMENT ON COLUMN "AREAS_MINI"."AREAS_NAME" IS '동네이름';

---------------------시퀀스--------------------
--MEMBER
DROP SEQUENCE SEQ_MEMBER_MINI;
CREATE SEQUENCE SEQ_MEMBER_MINI NOCYCLE NOCACHE;
--SEQ_MEMBER.NEXTVAL;

--AREAS
DROP SEQUENCE SEQ_AREAS_MINI;
CREATE SEQUENCE SEQ_AREAS_MINI NOCYCLE NOCACHE;
--SEQ_AREAS.NEXTVAL;

-------------------외래키----------------------
--MEMBER
ALTER TABLE MEMBER_MINI 
ADD CONSTRAINT FK_AREAS_MINI_MEMBER_MINI
FOREIGN KEY (AREAS_CODE) REFERENCES AREAS_MINI(AREAS_CODE);
COMMIT;

--AREAS (동네코드)
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'신사동');--1
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'논현동');--2
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'압구정동');--3
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'청담동');--4
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'삼성동');--5
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'대치동');--6
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'삼성동');--7
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'역삼동');--8
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'개포동');--9
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'세곡동');--10
INSERT INTO AREAS_MINI(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS_MINI.NEXTVAL,'수서동');--11
COMMIT;

--MEMBER ( 사용자)
INSERT INTO MEMBER_MINI(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER_MINI.NEXTVAL,'1','USER01','1234','새벽갬성','양종묵','KH01@KH.COM','01012341234','서울시강남구역삼동');
INSERT INTO MEMBER_MINI(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER_MINI.NEXTVAL,'2','USER02','1234','보마휘바','박미포','KH02@KH.COM','01023412341','서울시강남구논현동');
INSERT INTO MEMBER_MINI(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER_MINI.NEXTVAL,'8','USER03','1234','후바후바','최미범','KH03@KH.COM','01034123412','서울시강남구역삼동');
INSERT INTO MEMBER_MINI(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER_MINI.NEXTVAL,'2','USER04','1234','빵빵크림빵','이덕진','KH04@KH.COM','01041234123','서울시강남구논현동');
INSERT INTO MEMBER_MINI(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER_MINI.NEXTVAL,'5','USER05','1234','고뿡빵','이덕범','KH05@KH.COM','01022342234','서울시강남구삼성동');
INSERT INTO MEMBER_MINI(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER_MINI.NEXTVAL,'9','USER06','1234','히히잉힝','최광진','KH06@KH.COM','01013341334','서울시강남구개포동');
INSERT INTO MEMBER_MINI(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER_MINI.NEXTVAL,'6','USER07','1234','체리맛민트','최현범','KH07@KH.COM','01013441344','서울시강남구대치동');
INSERT INTO MEMBER_MINI(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER_MINI.NEXTVAL,'8','USER08','1234','냉동파이리','양미우','KH08@KH.COM','01013451345','서울시강남구역삼동');
COMMIT;