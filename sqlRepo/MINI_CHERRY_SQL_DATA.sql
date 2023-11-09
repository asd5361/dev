--더미데이터 

--AREAS (동네코드)
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'신사동');--1
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'논현동');--2
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'압구정동');--3
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'청담동');--4
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'삼성동');--5
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'대치동');--6
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'삼성동');--7
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'역삼동');--8
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'개포동');--9
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'세곡동');--10
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'수서동');--11
COMMIT;

--MANAGER (관리자)
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN01','1234','관리자01');
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN02','1234','관리자02');
COMMIT;

--MEMBER ( 사용자)
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NAME,EMALE,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'1','USER01','1234','유저01','KH01@KH.COM','01012341234','서울시강남구역삼동');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NAME,EMALE,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'2','USER02','1234','유저02','KH02@KH.COM','01023412341','서울시강남구논현동');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NAME,EMALE,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'8','USER03','1234','유저03','KH03@KH.COM','01034123412','서울시강남구역삼동');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NAME,EMALE,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'2','USER04','1234','유저04','KH04@KH.COM','01041234123','서울시강남구논현동');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NAME,EMALE,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'5','USER05','1234','유저05','KH05@KH.COM','01022342234','서울시강남구삼성동');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NAME,EMALE,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'9','USER06','1234','유저06','KH06@KH.COM','01013341334','서울시강남구개포동');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NAME,EMALE,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'6','USER07','1234','유저07','KH07@KH.COM','01013441344','서울시강남구대치동');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NAME,EMALE,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'8','USER08','1234','유저08','KH08@KH.COM','01013451345','서울시강남구역삼동');
COMMIT;

--NOTICE (공지사항) 현묵님
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'제발','되라');

--FAQ 광포님
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '동네인증이 안 돼요!', '동네인증을 하기 전에 내 위치가 인증하려는 동네에 있는지 확인해주세요');
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '가입한 적 없는데 계정이 있다고 나와요', '가입한 적이 없는데 계정이 있다고해서 많이 놀라셨죠?');
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '탈퇴는 어떻게 하나요?', '[나의 당근 > 오른쪽 위 톱니바퀴 모양 > 탈퇴하기]로 진행하시면 됩니다.');

--QNA (유저가 작성한 질문글)
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 5, '게시글 개수에 제한이 있나요?', '판매하고 싶은 제품이 많은데 게시글을 몇개 작성할 수 있는지 궁금합니다.');
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 3, '택배 거래도 가능한가요?', '판매자가 회사에 판매물품을 두고와서 직거래가 어렵다고 택배로 거래하자는데 가능할까요?');
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 7, '내 게시글이 안보여요.', '판매글을 작성했는데 게시글이 안보입니다.');


--QNA (관리자가 작성한 답글)
UPDATE QNA SET ANSWER = '하루에 20개의 게시글을 작성 할 수 있고, 한 사람당 300개의 게시글을 작성할 수 있습니다.' WHERE QNA_NO = 1;
UPDATE QNA SET ANSWER = '택배 거래는 가능합니다. 다만 택배거래는 항상 사기 위험이 있으니 유의하시길 바랍니다.' WHERE QNA_NO = 2;
UPDATE QNA SET ANSWER = '중복게시글을 작성하셨거나 전문판매없자 제재를 받은 경우 게시글이 안보일 수 있습니다.' WHERE QNA_NO = 3;
COMMIT;

--TRADE
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 1, 1, '노트북 팝니다', '역삼역 3번출구', '제곧내', 'M2맥북', 1000000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 2, 5, 'HTML 책 팝니다', '강남역 4번출구', '새거에요', '도서', 10000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 3, 2, '세탁물 찾아주실분', 'KH세탁소', '제곧내', '...', 5000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 4, 3, '에어팟 팝니다', '수서역 앞', '한쪽이 안들려요', '에어팟프로', 50000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 5, 6, '김치 팝니다', '우리집 앞', '맛있어요', '김치', 5000);

--WISHLIST
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 1, 1);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 2, 3);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 3, 2);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 5, 1);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 4, 5);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 4, 3);


--PURCHASE_HISTORY (구매내역)
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 1, 1);
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 2, 2);
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 4, 3);
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 4, 4);
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 3, 5);

--TOWN (동네생활)
INSERT INTO TOWN (TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,1, '붕어빵 어디서 파나요..', '먹고싶어요', '동네맛집');
INSERT INTO TOWN (TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,2, '리빙포인트', '음식이 싱거울땐 소금을 뿌리면 된다', '생활정보');
INSERT INTO TOWN (TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,3, '동네에 강아지가 돌아다녀요', 'ㅈㄱㄴ', '동네질문');
INSERT INTO TOWN (TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,4, '너무 춥다..', '정말', '동네일상');

--TOWN_COMMENT (동네생활 댓글)
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 1, 1, '강남역 앞에 팔아요..');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 1, 2, '저두 궁금해요');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 2, 3, '꿀팁 감사합니다');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 3, 2, '무서워');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 4, 4, 'ㅠㅠ');

--REVIEW (맨 밑으로 빼기)
INSERT INTO REVIEW (REVIEW_NO, PURCHASE_NO, SCORE, CONTENT) VALUES (SEQ_REVIEW_NO.NEXTVAL, 1, 5, '쿨거래 감사합니다');
INSERT INTO REVIEW (REVIEW_NO, PURCHASE_NO, SCORE, CONTENT) VALUES (SEQ_REVIEW_NO.NEXTVAL, 2, 4, '싸게 팔아주심');
INSERT INTO REVIEW (REVIEW_NO, PURCHASE_NO, SCORE, CONTENT) VALUES (SEQ_REVIEW_NO.NEXTVAL, 3, 1, '쓰레기를 팔았어요');
