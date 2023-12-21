<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	
	<form action="/app/board/write" method="post">
      <input type="text" name="title" placeholder="제목">
      <br>
      <textarea name="content" placeholder="내용"></textarea>
      <br>
      <input type="text" name="writer" placeholder="작성자">
      <br>
      <input type="submit" value="게시글 작성">
   </form>
   
   <a href="/app/home">홈</a>
</body>
</html>