<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�Խñ� �ۼ��ϱ�</h1>
	
	<form action="/app/board/write" method="post">
		<input type="text" name="title" placeholder="�����Է�"><br>
		<input type="text" name="content" placeholder="�����Է�"><br> 
		<input type="text" name="writer" placeholder="�ۼ���"><br>
		<input type="submit" value="�Խñ��ۼ�"> 
	</form>
</body>
</html>