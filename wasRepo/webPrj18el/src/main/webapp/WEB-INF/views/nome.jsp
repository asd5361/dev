<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% String x = (String)request.getAttribute("x"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	
	<h2 style="text-align:center;"> ${x}
<%-- 	<%= x %> --%>
	</h2>
	<hr>
	<c:if test="${not empty loginMember}">
		<h3>로그인한 유저의 프로필 사진</h3>
	</c:if>
	
	<hr>
	
	<c:forEach begin="0" end="9" step="1" var="i">
		<spen><strong>${i}</strong></spen>
	</c:forEach>
	
	<table>
		<tr>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${voList}" var="vo">
		<tr>
			<th>${vo.title}</th>
			<th>${vo.writer}</th>
			<th>${vo.hit}</th>
		</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>