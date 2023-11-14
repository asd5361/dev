<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	int a = Integer.parseInt(request.getParameter("a"));
    	int b = Integer.parseInt(request.getParameter("b"));
    	int result = (int)(Math.random() * (b-a+1) + a);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<%= a%> ~ <%=b %> 사이의 랜덤 숫자 : <%= result%>
		
</body>
</html>