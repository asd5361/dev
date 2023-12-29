<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	body{
		padding : 0px;
		margin : 0px;
		box-sizing : border-box;
	}
	.wrap{
		widows: 100vw;
		height: 100vh;
		display: grid;
		grid-template-columns: 1fr;
		grid-template-rows: 20vh 10vh 60vh 10vh;
		place-items: center center;
	}
	.header{
		width:60%;
		height:100%;
		background-color: gray;
		display: grid;
		grid-template-columns: 1fr 3fr 1fr;
		grid-template-rows: 1fr;
		
	}
	.nav{
		width: 100%;
		height: 60%;
		display: grid;
		grid-template-columns: repeat(4, 1fr);
		grid-template-rows: 1fr;
		place-items: center center;
	}
	.loginArea > form{
		width: 100%;
		height: 100%;
		display: grid;
		grid-template-columns:  1fr, 1fr;
		grid-template-rows: 1fr 1fr 1fr;
	}

	.loginArea >form > input:nth-child(1),
	.loginArea >form > input:nth-child(2){
		grid-column: span 2;
	}
</style>


<div class="header">
	<h1></h1>
	<h1>로고</h1>
<c:if test="${empty loginMember}">	
	<div class="loginArea">
		<form action="/app/member/login" method="post">
			<input type="text" name = "id" placeholder="아이디">
			<input type="password" name = "pwd" placeholder="패스워드">
			<input type="button" value="회원가입" onclick="location.href='/app/member/join'">
			<input type="submit" value="로그인">
		</form>
	</div>
</c:if>
<c:if test="${not empty loginMember}">
	<div class="loginArea">
		<h5>${loginMember.nick}님 환영합니다.</h5>
		<form action="/app/member/logout">
			<input type="button" value="로그아웃" onclick="location.href='/app/member/logout'">
		</form>
	</div>
</c:if>
</div>

<div class="nav">
	<div><a href="/app/board/list">게시판</a></div>
	<div><a>공지사항</a></div>
	<div>갤러리</div>
	<div>마이페이지</div>
</div>