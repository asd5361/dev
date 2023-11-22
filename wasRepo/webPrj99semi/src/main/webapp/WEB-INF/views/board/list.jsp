<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList");
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
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일시</th>
                    </tr>
    <%for(BoardVo vo : boardVoList){ %>
                    <tr>
                        <td><%=vo.getNo()%></td>
                        <td><%=vo.getTitle()%></td>
                        <td><%=vo.getContent()%></td>
                        <td><%=vo.getWriteNick()%></td>
                        <td><%=vo.getHit()%></td>
                        <td><%=vo.getEnrollDate()%></td>
                    </tr>
    <%}%>
                </table>
            </div>
            <div class="btn">
<% if(loginMember != null) {%>
        		<button type="button" onclick="location.href='/app99/board/write';">작성하기</button>
<%}else{%>
				<div></div>
<%} %>
        	</div>
			<div class="page-area">
            	<a href="">1</a>
            	<a href="">2</a>
           		<a href="">3</a>
            	<a href="">4</a>
            	<a href="">5</a>
         	</div>            	
        </main>
    </div>
</body>
</html>