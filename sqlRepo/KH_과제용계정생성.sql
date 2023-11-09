-- 과제용 계정 생성
--CREATE USER (C##+계정명) IDENTIFIED BY 비밀번호;
CREATE USER C##KH_WORKBOOK IDENTIFIED BY 1234;

--권한부여
--GRANT 권한, 권한, ... TO (C##+계정명);
GRANT RESOURCE, CONNECT TO C##KH_WORKBOOK;

--권한 해제
--REVOKE 권한 이름 FROM 사용자이름 
--REVOKE RESOURCE FROM C##KH_WORKBOOK;

--권한 확인
--SELECT * FROM role_sys_privs;

--USERS 공간 부여 
alter user C##KH_WORKBOOK quota 100M on users;
