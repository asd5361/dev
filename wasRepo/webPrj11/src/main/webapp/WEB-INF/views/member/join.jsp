<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/app11/member/join" method="POST">
		<table>
            <tbody>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="memberId"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="memberPwd"></td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="password" name="memberPwd2"></td>
                </tr>
                <tr>
                    <td>닉네임</td>
                    <td><input type="text" name="memberNick"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="회원가입"></td>
                </tr>
            </tbody>
        </table>
	</form>
</body>
</html>