<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		MemberVo vo = (MemberVo) session.getAttribute("userData");
		String x;
	if(vo != null){
			x = vo.getMemberNick()+"님 환영합니다. ";		
		}else{
			x = "로그인을 진행하세요";
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	
	<h2><%=x %> </h2>
	
	<h2><a href="/app13/member/join">회원가입</a></h2>
	<h2><a href="/app13/member/login">로그인</a></h2>
	<h2><a href="">로그아웃</a></h2>
	<h2><a href="">회원탈퇴</a></h2>
</body>
</html>