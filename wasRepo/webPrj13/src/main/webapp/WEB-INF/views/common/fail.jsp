<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String x = (String)request.getAttribute("str");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=x %>실패</h1>
	<h2><a href="/app13/home">홈으로 이동하기</a></h2>
</body>
</html>