<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVo boardVo = (BoardVo)request.getAttribute("boardVo");
	String currPage = (String)request.getAttribute("currPage");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app99/resources/css/detail.css">
</head>
<body>
	 <div class="wrap">
        <%@ include file="/WEB-INF/views/common/header.jsp"%>
        <main>
        	<h1> 게시글 상세 조회</h1>
            <div class="tbl">
            	<table>
            		<tr>
            			<th>글번호</th>
            			<td><%=boardVo.getNo() %></td>
            		</tr>
            		<tr>
            			<th>카테고리</th>
            			<td><%=boardVo.getCategoryName()%></td>
            		</tr>
            		<tr>
            			<th>제목</th>
            			<td><%=boardVo.getTitle() %></td>
            		</tr>
            		<tr>
            			<th>내용</th>
            			<td><%=boardVo.getContent()%></td>
            		</tr>
            		<tr>
            			<th>작성자</th>
            			<td><%=boardVo.getWriteNick() %></td>
            		</tr>
            		<tr>
            			<th>조회수</th>
            			<td><%=boardVo.getHit() %></td>
            		</tr>
            		<tr>
            			<th>작성일자</th>
            			<td><%=boardVo.getEnrollDate() %></td>
            		</tr>
            		<tr>
            			<th>수정일자</th>
            			<td><%=boardVo.getModifyDate() %></td>
            		</tr>
            		<tr>
            			<th>삭제여부</th>
            			<td><%=boardVo.getStatus() %></td>
            		</tr>
            		
            	</table>
            </div>
            <div class="btn">
            	<!-- <button type="button" onclick="history.back();">뒤로가기</button> -->
<% if(loginMember != null && loginMember.getMemberNo().equals(boardVo.getWriterNo())) { %>   		
        		<button type="button" onclick="location.href='/app99/board/edite?no=<%=boardVo.getNo()%>';">수정하기</button>
				<button type="button" onclick="location.href='/app99/board/delete?no=<%=boardVo.getNo()%>';">삭제하기</button>
<%}%>	
				<a href="/app99/board/list?pno=<%=currPage%>">목록 가기</a>
        	</div>
       	</main>
     </div>
</body>
</html>
