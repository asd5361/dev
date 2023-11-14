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
	
	<form action="../member/join/processor"><%--/app08/member/join/processor --%>
		<div>
			아이디 : <input type="text" name="memberId">
		</div>
		<div>
			비밀번호 : <input type="password" name="memberPwd">
		</div>
		<div>
			비밀번호 확인 : <input type="password" name="memberPwd2">
		</div>
		<div>
			닉네임 : <input type="text" name="memberNick">
		</div>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>