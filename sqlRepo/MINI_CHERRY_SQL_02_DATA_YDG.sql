--���̵����� 

--AREAS (�����ڵ�)
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�Ż絿');--1
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'������');--2
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�б�����');--3
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'û�㵿');--4
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�Ｚ��');--5
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'��ġ��');--6
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�Ｚ��');--7
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'���ﵿ');--8
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'������');--9
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'���');--10
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'������');--11
COMMIT;

--MANAGER (������)
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN01','1234','������01');
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN02','1234','������02');
COMMIT;

--MEMBER ( �����)
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'1','USER01','1234','��������','������','KH01@KH.COM','01012341234','����ð������Ż絿');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'2','USER02','1234','�����ֹ�','�ڹ���','KH02@KH.COM','01023412341','����ð�����������');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'8','USER03','1234','�Ĺ��Ĺ�','�ֹ̹�','KH03@KH.COM','01034123412','����ð��������ﵿ');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'2','USER04','1234','����ũ����','�̴���','KH04@KH.COM','01041234123','����ð�����������');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'5','USER05','1234','��׻�','�̴���','KH05@KH.COM','01022342234','����ð������Ｚ��');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'9','USER06','1234','��������','�ֱ���','KH06@KH.COM','01013341334','����ð�����������');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'6','USER07','1234','ü������Ʈ','������','KH07@KH.COM','01013441344','����ð�������ġ��');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'8','USER08','1234','�õ����̸�','��̿�','KH08@KH.COM','01013451345','����ð��������ﵿ');
COMMIT;

--NOTICE (��������) ������
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry������ �Ұ��մϴ�','<Cherry���� >�� �߰�ŷ� �÷����Դϴ�. ����ڵ鿡�� ��ǰ �� ��Ȱ���� �����ϰ� �Һ� ����ϴ� ������ �մϴ�. ȸ���е��� ���Ǹ� ���� ���� ����ϴ� Cherry������ �ǰڽ��ϴ�. ���� �̿� ��Ź�帳�ϴ�. ');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry���� ��������ó����ġ','��� ȸ���� ���������� �����ϰ� ����ǰ� Ż�� �� 1�� �� ���������� �����˴ϴ�.');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry���� �޸հ��� ����','���� Cherry������ ȸ���Ե��� ������ �������� ��ȣ�� ���Ͽ� ������Ÿ� �̿����� �� ������ȣ � ���� ������ ���� �ֱ� 1�� ���� �̿� ����� ���� ȸ���� �޸���·� ��ȯ �˴ϴ� ');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry���� �� ���','�� Cherry���� ����Ʈ�� ���� ��� �˴ϴ�. �ȵ���̵� ���� ������ ���� �� �� ��� �����Դϴ�. ���� ���� ��Ź�帳�ϴ�.');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'���(���ڴ��) �ŷ��� ���� ��������','���� Cherry������ ��ü �̿밡�̱� ������ �̼����ںе鵵 �ŷ��� �� �� �־� ���(���ڴ���ǰ), �ַ����� �ŷ��Ͻ� �� �����ϴ�.');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry���� ���� ���� �ȳ�(10/31~)','�ȳ��ϼ��� Cherry�����Դϴ�.���� �������� ���񽺸� �����ϱ� ���� ���� ���� ������ ����Ǿ� �����帳�ϴ�. ���� �ð�- 8/17(��) AM 6:00~AM 10:00 ���� �̿뿡 ������ ��� �˼��մϴ�. ���� �� �������� ���� �������� �����ϰڽ��ϴ�.');

--FAQ ������
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '���������� �� �ſ�!', '���������� �ϱ� ���� �� ��ġ�� �����Ϸ��� ���׿� �ִ��� Ȯ�����ּ���');
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '������ �� ���µ� ������ �ִٰ� ���Ϳ�', '������ ���� ���µ� ������ �ִٰ��ؼ� ���� ������?');
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, 'Ż��� ��� �ϳ���?', '[���� ü�� > ������ �� ��Ϲ��� ��� > Ż���ϱ�]�� �����Ͻø� �˴ϴ�.');

--QNA (������ �ۼ��� ������)
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 5, '�Խñ� ������ ������ �ֳ���?', '�Ǹ��ϰ� ���� ��ǰ�� ������ �Խñ��� � �ۼ��� �� �ִ��� �ñ��մϴ�.');
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 3, '�ù� �ŷ��� �����Ѱ���?', '�Ǹ��ڰ� ȸ�翡 �ǸŹ�ǰ�� �ΰ�ͼ� ���ŷ��� ��ƴٰ� �ù�� �ŷ����ڴµ� �����ұ��?');
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 7, '�� �Խñ��� �Ⱥ�����.', '�Ǹű��� �ۼ��ߴµ� �Խñ��� �Ⱥ��Դϴ�.');
COMMIT;

--QNA (�����ڰ� �ۼ��� ���)
UPDATE QNA SET ANSWER = '�Ϸ翡 20���� �Խñ��� �ۼ� �� �� �ְ�, �� ����� 300���� �Խñ��� �ۼ��� �� �ֽ��ϴ�.' WHERE QNA_NO = 1;
UPDATE QNA SET ANSWER = '�ù� �ŷ��� �����մϴ�. �ٸ� �ù�ŷ��� �׻� ��� ������ ������ �����Ͻñ� �ٶ��ϴ�.' WHERE QNA_NO = 2;
UPDATE QNA SET ANSWER = '�ߺ��Խñ��� �ۼ��ϼ̰ų� �����Ǹž��� ���縦 ���� ��� �Խñ��� �Ⱥ��� �� �ֽ��ϴ�.' WHERE QNA_NO = 3;
COMMIT;

--TRADE
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 1, 1, '��Ʈ�� �˴ϴ�', '���￪ 3���ⱸ', '����', 'M2�ƺ�', 1000000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 2, 5, 'HTML å �˴ϴ�', '������ 4���ⱸ', 'The World Wide Web (W3) initiative links related information throughout the globe. HTML provides one simple format for providing linked information, and all W3 compatible programs are required to be capable of handling HTML. W3 uses an Internet protocol (Hypertext Transfer Protocol, HTTP), which allows transfer representations to be negotiated between client and server, the result being returned in an extended MIME message. HTML is therefore just one, but an important one, of the representations used with W3.', '����', 10000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 3, 2, '��Ź�� ã���ֽǺ�', 'KH��Ź��', '����', '...', 5000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 4, 3, '������ �˴ϴ�', '������ ��', '������ ����(Apple AirPods Pro)�� ������ ������ ���� �̾�������, 2019�⿡ ��õǾ����ϴ�. ������ ���δ� ������ �����̰� ���� ���� ����, �ֺ� ���� ����, ��ƽ ��ġ ��Ʈ��, �׸��� ���������� �Ϳ� �� �� �´� �������� Ư¡���� �մϴ�.', '����������', 50000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 5, 6, '��ġ �˴ϴ�', '�츮�� ��', '��ġ�� ��ǥ���� �ѱ� �丮�μ� ��ȿ�� ����߳� �ٸ� ä�Ҹ� �ַ� ���߰���� �پ��� ���̷�� �Բ� ��ȿ���� ���� ��ȿ ��ǰ�Դϴ�. ��ġ�� �ѱ� �丮�� �߿��� �κ��̸� �ѱ��� ��Ź���� ���� �� ���� ���� �� �ϳ��Դϴ�.', '��ġ', 5000);
COMMIT;

--WISHLIST
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 3, 1);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 2, 3);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 3, 2);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 5, 1);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 4, 5);
INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, 4, 3);
COMMIT;

--PURCHASE_HISTORY (���ų���)
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 1, 1);
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 2, 2);
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 4, 3);
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 4, 4);
INSERT INTO PURCHASE_HISTORY (PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, 3, 5);

--TOWN (���׻�Ȱ)
INSERT INTO TOWN(TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,1,'�������� ã���ϴ�.','���ø� ���� �ּ���..��','�����Խ���');
INSERT INTO TOWN(TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,2,'���� ã�ư�����~','�������� ������ �ֿ����ϴ�!!!!','�����Խ���' );
INSERT INTO TOWN(TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,3, '�ܱ�˹ٱ��մϴ�.', '�Ϸ�4�ð��ϽǺ�ã�ƿ�...', '�˹�');
COMMIT;

--TOWN_COMMENT (���׻�Ȱ ���)
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 1,1,'���񰭾������ƿ�̤̤�');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 2,2,'���ΰ���ɱ��!!!!');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 1,3,'�ñ������ΰ���?');

--REVIEW (�� ������ ����)
INSERT INTO REVIEW (REVIEW_NO, PURCHASE_NO, SCORE, CONTENT) VALUES (SEQ_REVIEW_NO.NEXTVAL, 1, 1, '��ŷ� �����մϴ�');
INSERT INTO REVIEW (REVIEW_NO, PURCHASE_NO, SCORE, CONTENT) VALUES (SEQ_REVIEW_NO.NEXTVAL, 2, 1, '�ΰ� �Ⱦ��ֽ�');
INSERT INTO REVIEW (REVIEW_NO, PURCHASE_NO, SCORE, CONTENT) VALUES (SEQ_REVIEW_NO.NEXTVAL, 3, -1, '�����⸦ �ȾҾ��');
COMMIT;
