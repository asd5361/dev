<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�Խñ� �ۼ�</h1>
	
	<form action="/app/board/write" method="post">
      <input type="text" name="title" placeholder="����">
      <br>
      <textarea name="content" placeholder="����"></textarea>
      <br>
      <input type="text" name="writer" placeholder="�ۼ���">
      <br>
      <input type="submit" value="�Խñ� �ۼ�">
   </form>
   
   <a href="/app/home">Ȩ</a>
</body>
</html>