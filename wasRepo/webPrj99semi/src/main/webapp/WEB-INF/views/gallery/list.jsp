<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.gallery.vo.GalleryVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app99/resources/css/list.css">
<style>
	main{
		width: 100%;
		height: 800px;
		display: grid;
		grid-template-rows: 1fr 7fr 2fr;
		grid-template-columns: 1fr;
		place-items: center center;
	}
	#gallery-area{
		width: 100%;
		height: 100%;
		display: grid;
		grid-template-rows: 1fr 1fr;
		grid-template-columns: 1fr 1fr 1fr;
		place-items: center center;
	}
	#gallery-box{
      display: flex;
      flex-direction: column;
      justify-content: center;
      text-align: center;
   }

</style>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<div id="top-area">
				<button onclick="location.href='/app99/gallery/write'">작성하기</button>
			</div>
			<div id = "gallery-area">
			
<c:forEach items="${galleryVoList}" var="vo">
				<div id = "gallery-box">
					<img src="https://dummyimage.com/100x100/000000/fff.png&text=sample" alt ="${vo.changeName}">
<%-- 					<img src="${vo.Src}" alt ="${vo.changeName}"> --%>
					<span>${vo.title}</span>
				</div>
</c:forEach>
			<div id = "page-area">
				<a href="">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href="">6</a>
			</div>

		</main>
	</div>


</body>
</html>