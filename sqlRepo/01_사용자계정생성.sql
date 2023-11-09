--사용자 계정 생성
/*
--사용자 계정 생성 (관리자 계정으로만 가능)
--CREATE USER (C##+계정명) IDENTIFIED BY 비밀번호;
CREATE USER C##KH IDENTIFIED BY 1234;

--권한부여
--GRANT 권한, 권한, ... TO (C##+계정명);
GRANT RESOURCE, CONNECT TO C##KH;

--권한 해제
--REVOKE 권한 이름 FROM 사용자이름 

REVOKE RESOURCE FROM C##KH;

--권한 확인
SELECT * FROM role_sys_privs;
*/
