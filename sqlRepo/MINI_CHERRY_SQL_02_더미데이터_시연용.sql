--���̵����� 

--AREAS (�����ڵ�)
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�Ż絿');--1
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'������');--2
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�б�����');--3
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'û�㵿');--4
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�Ｚ��');--5
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'��ġ��');--6
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�Ͽ���');--7
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'���ﵿ');--8
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'������');--9
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'���');--10
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'������');--11
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'������');--12
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'�ڰ');--13
INSERT INTO AREAS(AREAS_CODE,AREAS_NAME) VALUES (SEQ_AREAS.NEXTVAL,'���');--14

COMMIT;

--MANAGER (������)
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN01','1234','������');
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN02','1234','������');
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN03','1234','������');
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN04','1234','������');
INSERT INTO MANAGER(MANAGER_NO,MANAGER_ID,PWD,NAME) VALUES (SEQ_MANAGER.NEXTVAL,'ADMIN05','1234','������');
COMMIT;

--MEMBER ( �����)
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'8','USER01','1234','��������','������','KH01@KH.COM','01000000000','����ð��������ﵿ');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'2','USER02','1234','�����ֹ�','���̳�','KH02@KH.COM','01011111111','����ð�����������');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'10','USER03','1234','�Ĺ��Ĺ�','�豤Ǫ','KH03@KH.COM','01022222222','����ð��������');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'1','USER04','1234','���ξƿ�','�̹���','KH04@KH.COM','01033333333','����ð������Ż絿');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'5','USER05','1234','�����۱�','���翵','KH05@KH.COM','01044444444','����ð������Ｚ��');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'9','USER06','1234','��������','������','KH06@KH.COM','01055555555','����ð�����������');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'6','USER07','1234','�躯����','������','KH07@KH.COM','01066666666','����ð�������ġ��');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS,QUIT_YN) VALUES (SEQ_MEMBER.NEXTVAL,'8','USER08','1234','�����ΰ�','�����','KH08@KH.COM','01077777777','����ð��������ﵿ','Y');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'4','USER09','1234','��������','�ѹα�','KH09@KH.COM','01088888888','����ð�����û�㵿');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'5','USER10','1234','��ũ��ũ','�ϳ���','KH10@KH.COM','01099999999','����ð������Ｚ��');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'6','USER11','1234','�����̳�','����','KH11@KH.COM','01012121212','����ð�������ġ��');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS,QUIT_YN) VALUES (SEQ_MEMBER.NEXTVAL,'2','USER12','1234','ȫ�ﺸ��','���̽�','KH12@KH.COM','01013131313','����ð�����������','Y');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'7','USER13','1234','���׾���','��̸�','KH13@KH.COM','01014141414','����ð������Ͽ���');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS) VALUES (SEQ_MEMBER.NEXTVAL,'9','USER14','1234','�渶����','������','KH14KH.COM','01015151515','����ð�����������');
INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS,QUIT_YN) VALUES (SEQ_MEMBER.NEXTVAL,'11','USER15','1234','Ŀ��Ǫ��','ȫ����','KH15KH.COM','01016161616','����ð�����������','Y');
COMMIT;

--NOTICE (��������) ������
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry������ �Ұ��մϴ�','<Cherry���� >�� �߰�ŷ� �÷����Դϴ�. ��ǰ�� ��Ȱ���� ���� �Һ� ����ϴ� ������ �մϴ� ȸ���е��� ���Ǹ� ���� ����ϴ� Cherry������ �ǰڽ��ϴ�. ���� �̿� ��Ź�帳�ϴ�.');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry���� ��������ó��','��� ȸ���е��� ���������� �����ϰ� ����ǰ� {�޴���ȭ��ȣ, �ֹε�Ϲ�ȣ, �̸���(��ϵǾ����� ��)},  Ż�� �� 1�� �� ���������� �����˴ϴ�. �� �� �̿뿡 ���� ��Ź�帳�ϴ�.');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry���� �޸հ��� ����','���� Cherry������ ȸ���Ե��� ������ �������� ��ȣ�� ���Ͽ� ������Ÿ� �̿����� �� ������ȣ � ���� ������ ���� �ֱ� 1�� ���� �̿� ����� ���� ȸ���� �޸���·� ��ȯ �˴ϴ�');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'��� �ŷ��� ���� ��������','���� Cherry������ ��ü �̿밡�̱� ������ �̼����ںе鵵 �ŷ��� �� �� �־� ���(���ڴ���ǰ),�ַ����� 19���̸� �Ǹ� ��ǰ�� �ŷ��Ͻ� �� �����ϴ�.�� �� �̿뿡 ���� ��Ź�帳�ϴ�.');
INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,1,'Cherry���� � ���� �ȳ�','�ȳ��ϼ��� Cherry�����Դϴ�.���ݱ��� ���� Cherry������ �̿��� �ּ��� �����մϴ� ���� ���� ���񽺸� ���� Cherry���Ͻ���2�� ã�� �˰ڽ��ϴ� �̿뿡 ������ ��� �˼��մϴ�.');

--FAQ ������
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, 'ȸ�������� ��� �ϳ���?', '���α׷� ���� -> ���� -> ȸ������  ������ �����Ͻø� �˴ϴ�.');
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '��й�ȣ�� ã�� �;��!', '���α׷� ���� -> ���� -> ��й�ȣ ã�� ������ �����Ͻø� �˴ϴ�.');
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '�� ������ ��� �ϳ���?', '���α׷� ���� -> ���� -> �α��� -> ���ϴ� �Խ��� -> �Խ��� ���� ������ �����Ͻø� �˴ϴ�.');
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '���ɸ���� Ȯ���ϰ� �;��', '���α׷� ���� -> ���� -> �α��� -> ���������� -> ���ɸ�� ��ȸ ������ �����Ͻø� �˴ϴ�.');
INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, 1, '�ųʿµ��� ��� Ȯ���ϳ���', '���α׷� ���� -> ���� -> �α��� -> ���������� -> �ųʿµ� ������ �����Ͻø� �˴ϴ�.');


--QNA (������ �ۼ��� ������)
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 5, '�Խñ� ������ ������ �ֳ���?', '�Ǹ��ϰ� ���� ��ǰ�� ������ �Խñ��� � �ۼ��� �� �ִ��� �ñ��մϴ�.');
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 3, '�ù� �ŷ��� �����Ѱ���?', '�Ǹ��ڰ� ȸ�翡 �ǸŹ�ǰ�� �ΰ�ͼ� ���ŷ��� ��ƴٰ� �ù�� �ŷ����ڴµ� �����ұ��?');
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, 7, '�� �Խñ��� �Ⱥ�����.', '�Ǹű��� �ۼ��ߴµ� �Խñ��� �Ⱥ��Դϴ�.');
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT, SECRET_YN) VALUES(SEQ_QNA_NO.NEXTVAL, 1, '�ųʿµ��� �ø��� �;��!!', '�ųʿµ��� �������� �ø��� ������ ��� �ؾ��ұ��?', 'Y');
INSERT INTO QNA(QNA_NO, MEMBER_NO, TITLE, CONTENT, SECRET_YN) VALUES(SEQ_QNA_NO.NEXTVAL, 3, '�ڽ�Ƭ �Ǹű��� �����ƾ��.', '�ҷ��� �ڽ�Ƭ���� �������� �Ǹ��ϴ� �Խñ��� ���� �ƴµ� �ֱ׷�����??', 'Y');

--QNA (�����ڰ� �ۼ��� ���)
UPDATE QNA SET ANSWER = '�Ϸ翡 20���� �Խñ��� �ۼ� �� �� �ְ�, �� ����� 300���� �Խñ��� �ۼ��� �� �ֽ��ϴ�.' WHERE QNA_NO = 1;
UPDATE QNA SET ANSWER = '�ߺ��Խñ��� �ۼ��ϼ̰ų� �����Ǹž��� ���縦 ���� ��� �Խñ��� �Ⱥ��� �� �ֽ��ϴ�.' WHERE QNA_NO = 3;
UPDATE QNA SET ANSWER = '������������ 9���� ���� ��������?���� �����������?��� ����?�Ǹ�?�뿩 ���� �� �Ǹ� �뿩 ���� ���������� �ŷ��� �Ұ����� ��ǰ�̶� ���� ������ ���Դϴ�.' WHERE QNA_NO = 5;
COMMIT;

--TRADE
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 1, 9, '�ٶ����� �˴ϴ�', '���￪', '������� 95, m ������� ���� �����ϴ�. ���ϰ� #ó���ϴ°Ŷ� �������� ���ø� 4������ �Ǹ��ϰڽ��ϴ�', '�Ƿ�', 50000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 2, 3, '������ ���������� �Ⱦƿ�', '���� ��ó', '���屳ü(��ð� Ÿ�� ������), �׸���ü(��轺 ���ΰ�#���, ������), �߰����͸�, ������ �ְ�� �׳� ����#�� ���� �ް� �Ǹ��մϴ�. �ۿ� ���������� �ʿ��� ����#�� Ŀ���� ���� �帱�Կ�', '������', 1000000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 3, 1, 'R2 ��Ʈ �˴ϴ�', '������4���ⱸ', '2022�� 9���� ���� �� 2ȸ ��Ī�� ����� R2 ��#���մϴ�. ����ǰ�� ��Ʈ,�׶����Ʈ ��� ����� ����# �ʹ� ������ ���� ���� �һ� �ϳ� �־ �����ϰ� ��#�ϴ�. �������ܿ� ����ϱ� ������ ������ �±� ���ǰ� #�־� ���ŷ� ���մϴ�.', '��Ȱ��ǰ', 700000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 4, 10, '������ �˴ϴ�', '������', '������ ����(Apple AirPods# Pro)�� ������ ������ ���� �̾�#������, 2019�⿡ ��õǾ����ϴ�.# ������ ���δ� ������ �����̰� ��#�� ���� ����, �ֺ� ���� ����, ��#ƽ ��ġ ��Ʈ��, �׸��� ���������� #�Ϳ� �� �� �´� �������� Ư¡���� #�մϴ�.', '����������', 50000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 5, 14, '��ġ �˴ϴ�', '�츮��', '��ġ�� ��ǥ���� �ѱ� �丮�μ� ��ȿ��# ����߳� �ٸ� ä�Ҹ� �ַ� ���߰���#�� �پ��� ���̷�� �Բ� ��ȿ���� ��#�� ��ȿ ��ǰ�Դϴ�. ��ġ�� �ѱ� ��#���� �߿��� �κ��̸� �ѱ��� ��Ź����# ���� �� ���� ���� �� �ϳ��Դϴ�.#', '��ġ', 5000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 6, 1, '��õ ��� �絵�ؿ�', '���ͳ�', '��õ�� ��ġ�� ��ä����Դϴ�. ������ ����Ǿ� �ε�����#�� �絵�մϴ� 11��10��~11��11�� 1�� �����ο� #4��, �߰��ο��� �ݾ� �߻��մϴ�. �� 10����� ����# �����ϰ� ��3�� �տ� �ٺ�ť �ü��� �־��. �����ߴ�# �ݾ��� 50�����Դϴ�.', 'Ƽ��', 350000);
INSERT INTO TRADE (BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, TRADE_AREAS, CONTENT, PRODUCT, PRICE)
VALUES (SEQ_BOARD_NO.NEXTVAL, 7, 4, '�ƺ����� M1 14��ġ', '���', '�ƺ����� 14��ġ M1 (21����) SSD 500 RA#M 16�Ⱑ ���͸� ����Ŭ�� 26, �����̽� �׷��� ��#���Դϴ� �����ϰ� ����߰� ������ ���Ե��־��. �ʿ���#�ø� ����ߴ� ���� ��Ƽ��Ʈ ����� ���� �帱�Կ� ���#���� 10���� �װ��ص帳�ϴ�!', '�ƺ�', 1900000);
COMMIT;

--WISHLIST - ���̵����� ���� ���
--PURCHASE_HISTORY - ���̵����� ���� ���
--REVIEW (�� ������ ����) - ���� ������ ��
--TOWN (���׻�Ȱ)
INSERT INTO TOWN(TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,1,'�������� ã���ϴ�.','���ø� ���� �ּ���..��','����');
INSERT INTO TOWN(TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,2,'���� ã�ư�����. ','�������� �����ֿ����ϴ�!','����' );
INSERT INTO TOWN(TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,3,'�ܱ�˹� ���մϴ�.','�Ϸ�4�ð��ϽǺ�ã�ƿ�..', '�˹�');
INSERT INTO TOWN(TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,2,'�ؾ ã�ƿ�!!! ','���ﵿ �ؾ ����ֳ���?', '����');
INSERT INTO TOWN(TOWN_NO, MEMBER_NO, TITLE, CONTENT, CATEGORY) VALUES (SEQ_TOWN_NO.NEXTVAL,1,'ī�� ��õ���ּ���.','���￪ ��ó ��õ���ּ���.', '����');


--TOWN_COMMENT (���׻�Ȱ ���)
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 1,2,'���� ������ ���ƿ�̤�');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 2,3,'���� ���� �ɱ��!!!!');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 3,1,'�ñ��� ���ΰ���???');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 4,3,'3�� �ⱸ �տ� �־��.');
INSERT INTO TOWN_COMMENT (COMMENT_NO, TOWN_NO, MEMBER_NO, CONTENT) VALUES (SEQ_TOWN_COMMENT_NO.NEXTVAL, 5,2,'3�� �ⱸ�� ���� �־��!');
