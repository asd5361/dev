<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성하기</h1>
	
	<form action="/app/board/write" method="post">
		<input type="text" name="title" placeholder="제목입력"><br>
		<input type="text" name="content" placeholder="내용입력"><br> 
		<input type="text" name="writer" placeholder="작성자"><br>
		<input type="submit" value="게시글작성"> 
	</form>
</body>
</html>