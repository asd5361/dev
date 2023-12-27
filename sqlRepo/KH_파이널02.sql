-----------------------------------------------------------
-- 기능
-----------------------------------------------------------
------------------------ <MEMBER> -------------------------
-- 회원가입
INSERT INTO MEMBER (NO,ID,PWD,NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL,'user','0000','최초유저');
INSERT INTO MEMBER (NO,ID,PWD,NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL,#{id},#{pwd},#{nick});
-- 로그인
SELECT * FROM MEMBER WHERE DEL_YN = 'N' AND ID = 'user' AND PWD = '0000';
SELECT * FROM MEMBER WHERE DEL_YN = 'N'  AND ID = #{id} AND PWD = #{pwd}
-- 회원 정보 수정 (비밀번호, 닉네임) <<<<<<<<<<
-- 회원 탈퇴
UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = 1;
UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = #{no};
-- 전체 회원 목록 조회 (관리자 전용)
SELECT * FROM MEMBER ORDER BY NO DESC;
------------------------ <BOARD> -------------------------
-- 게시글 작성
INSERT INTO BOARD(NO,TITLE,CONTENT, WRITER_NO)VALUES (SEQ_BOARD_NO.NEXTVAL,'초기 제목 입니다.','초기 내용 입니다.',1);
INSERT INTO BOARD(NO,TITLE,CONTENT, WRITER_NO)VALUES (SEQ_BOARD_NO.NEXTVAL,#{title},#{content},#{writerNo});

-- 게시글 목록 조회
SELECT * FROM BOARD ORDER BY NO DESC;
SELECT 
    B.NO
    ,TITLE
    ,CONTENT
    ,ENROLL_DATE
    ,DEL_YN
    ,WRITER_NO
    ,M.NICK AS WRITER_NICK
    FROM BOARD B
    JOIN (SELECT NO,NICK FROM MEMBER)M 
    ON M.NO = WRITER_NO
    ORDER BY B.NO DESC;

-- 게시글 상세 조회(글번호)
SELECT * FROM BOARD WHERE NO = 1;
SELECT * FROM BOARD WHERE NO = #{no};
-- 게시글 수정 (내용) <<<<<<<<<

-- 게시글 삭제 (글 번호)
UPDATE BOARD SET DEL_YN = 'Y' WHERE NO = 1;
-- 게시글 검색 (제목, 내용, 작성자) <<<<<<<<<<


