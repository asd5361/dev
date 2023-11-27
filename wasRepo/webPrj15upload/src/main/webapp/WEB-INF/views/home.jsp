<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>업로드 페이지</h1>
	<form action="/app15/file/insert" method="post" enctype="multipart/form-data">
		<input type="file" name="f"><br></br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>