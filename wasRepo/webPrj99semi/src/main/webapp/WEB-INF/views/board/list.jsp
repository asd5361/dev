<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList");
	PageVo pvo = (PageVo)request.getAttribute("pageVo"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/app99/resources/css/list.css">

</head>
<body>

    <div class="wrap">
        <%@ include file="/WEB-INF/views/common/header.jsp"%>
        <main>
        	<h1> 게시글 목록</h1>
            <div class="tbl">
                <table>
	                <thead>
	                    <tr>
	                        <th>번호</th>
	                        <th>제목</th>
	                        <th>내용</th>
	                        <th>작성자</th>
	                        <th>조회수</th>
	                        <th>작성일시</th>
	                        <th>카테고리</th>
	                    </tr>
	                </thead>
                    <tbody>
<%for(BoardVo vo : boardVoList){ %> 
	                    <tr>
	                        <td><%=vo.getNo()%></td>
	                        <td><%=vo.getTitle()%></td>
	                        <td><%=vo.getContent()%></td>
	                        <td><%=vo.getWriteNick()%></td>
	                        <td><%=vo.getHit()%></td>
	                        <td><%=vo.getEnrollDate()%></td>
	                        <td><%=vo.getCategoryName()%></td>
	                    </tr>
<% } %>
                    </tbody>
                </table>
            </div>
            <div class="btn">
<% if(loginMember != null) {%>
        		<button type="button" onclick="location.href='/app99/board/write';">작성하기</button>
<%}%>
        	</div>
			<div class="page-area">
            	<a href="/app99/board/list?pno=1">1</a>
            	<a href="/app99/board/list?pno=2">2</a>
           		<a href="/app99/board/list?pno=3">3</a>
            	<a href="/app99/board/list?pno=4">4</a>
            	<a href="/app99/board/list?pno=5">5</a>
         	</div>            	
        </main>
    </div>
    <script>
        
        const trArr = document.querySelectorAll("main div table tbody tr");
        for(let i=0; i<trArr.length; i++){
            trArr[i].addEventListener('click',handleClick);
        }
        function handleClick(event){
            const tr = event.currentTarget;
            const no = tr.children[0].innerText;
        
            location.href='/app99/board/detail?no='+no;
        };
    
    </script>
</body>
</html>
