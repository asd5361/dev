--커뮤니티 사이트

--MEMBER
DROP TABLE MEMBER;
CREATE TABLE MEMBER (
    MEMBER_NO NUMBER PRIMARY KEY
    ,ID VARCHAR2(100)
    ,PWD VARCHAR2(100)
    ,NICK VARCHAR2(100)
    ,ENROLL_DATE TIMESTAMP
    ,QUIT_YN CHAR(1)
);

--BOARD
DROP TABLE BOARD;
CREATE TABLE BOARD(
    BOARD_NO NUMBER PRIMARY KEY
    ,TITLE VARCHAR2(100)
    ,CONTENT VARCHAR2(4000)
    ,WRITER_NO NUMBER
    ,ENROLL_DATE TIMESTAMP
    ,DEL_YN CHAR(1)
);

--회원가입
INSERT INTO MEMBER (MEMBER_NO,ID,PWD,NICK,ENROLL_DATE,QUIT_YN) 
VALUES (1,'USER01','1234','HONG',SYSDATE,'N');
--로그인
SELECT * FROM MEMBER WHERE ID ='USER01' AND PWD = '1234';
--비밀번호 변경
UPDATE MEMBER SET PWD = '0000' WHERE ID = 'USER01' AND PWD= '1234';
--닉네임 변경
UPDATE MEMBER SET NICK = 'LEE' WHERE ID = 'USER01' AND PWD = '1234';
--탈퇴
UPDATE MEMBER SET QUIT_TN = 'Y' WHERE ID = 'USER01' AND PWD='1234';
--마이페이지 조회
SELECT * FROM MEMBER WHERE ID ='USER01' AND PWD = '1234';
--게시글 작성
INSERT INTO BOARD(BOARD_NO,TITLE,CONTENT,WRITER_NO,ENROLL_DATE,DEL_YN) 
VALUES (1,'제목이지롱','내용이지롱',1,SYSDATE,'N');
--게시글 전체 조회 (게시글 제목, 작성일시, 작성자)
SELECT TITLE,ENROLL_DATE,(SELECT NICK FROM MEMBER WHERE member.member_nO=board.WRITER_NO) WRITER
FROM board ORDER BY ENROLL_DATE DESC;
--게시글 상세 조회
SELECT TITLE,ENROLL_DATE,(SELECT NICK FROM MEMBER WHERE member.member_nO=board.WRITER_NO) WRITER
FROM board WHERE BOAR_NO = 1;
--게시글 제목 및 내용 수정
UPDATE BOARD SET
    TITLE = '제목입니다만'
    ,CONTENT = '내용입니다만' 
WHERE BOARD_NO = 1;

--게시글 삭제
DELETE board WHERE BOARD_NO = '1';
