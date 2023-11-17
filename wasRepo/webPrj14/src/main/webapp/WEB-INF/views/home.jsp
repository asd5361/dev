<%@page import="javax.websocket.Session"%>
<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% MemberVo loginMember = (MemberVo)session.getAttribute("userData");
	String x = "";
	%>
<!DOCTYPE html>
<html>
<head>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	<%= x %>
<% if(loginMember == null){%>
	<h2><a href='/app14/member/join'>회원가입</a></h2>
	<h2><a href='/app14/member/login'>로그인</a></h2>
<% 	}else{ x ="<h3 style='color:red'>"+loginMember.getMemberNick()+"님 환영합니다.</h3>"; %>
	<h2><a href='/app14/member/del'>회원탈퇴</a></h2>
	<h2><a href='/app14/member/logout'>로그아웃</a></h2>
<% 	} %>
	
</body>
</html>