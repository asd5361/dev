DROP TABLE J_MEMBER;
CREATE TABLE J_MEMBER (
    MEMBER_NO NUMBER 
    ,ID VARCHAR2(100)
    ,PWD VARCHAR2(100)
    ,NICK VARCHAR2(100)
    ,QUIT_YN CHAR(1)
);
-- JOIN문
INSERT INTO J_MEMBER (MEMBER_NO,ID,PWD,NICK,QUIT_YN) VALUES(
SEQ_MEMBER.NEXTVAL,'USER01','1234','USER01','N'
);

DROP SEQUENCE SEQ_MEMBER;
CREATE SEQUENCE SEQ_MEMBER
NOCYCLE        
START WITH 1   --시작값
INCREMENT BY 1 --증가값
;
SEQ_MEMBER.CURRVAL;
SEQ_MEMBER.NEXTVAL;

-- LOGIN문
SELECT * FROM J_MEMBER WHERE ID = 'USER01' AND PWD = '1234' ;
SELECT * FROM J_MEMBER;

DROP TABLE J_BOARD;
CREATE TABLE J_BOARD(
    BOARD_NO NUMBER
    ,TITLE VARCHAR2(100)
    ,CONTENT VARCHAR2(4000)
    ,WRITER_NO NUMBER
    ,ENROLL_DATE TIMESTAMP
    ,DEL_YN CHAR(1)
);
--WRITE 문
INSERT INTO J_BOARD (BOARD_NO,TITLE,CONTENT,WRITER_NO,ENROLL_DATE,DEL_YN) 
VALUES (SEQ_BOARD.NEXTVAL
,'제목입니다','내용입니다',1,SYSDATE,'N');
CREATE SEQUENCE MYSEQ;

DROP SEQUENCE SEQ_BOARD;
CREATE SEQUENCE SEQ_BOARD
NOCYCLE        
START WITH 1   --시작값
INCREMENT BY 1 --증가값
;
SEQ_BOARD.CURRVAL;
SEQ_BOARD.NEXTVAL;

SELECT * FROM J_BOARD;
--READ 문
SELECT * FROM J_BOARD WHERE TITLE LIKE '%만%' OR CONTENT LIKE '%만%' AND DEL_YN = 'N';
--UPDATE 문
UPDATE J_BOARD SET TITLE = '제목입니다만' ,CONTENT = '내용입니다만' WHERE BOARD_NO = 1;

commit;