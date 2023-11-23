<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% BoardVo boardVo = (BoardVo)request.getAttribute("boardVo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	textarea{
		min-height: 100px;
	}
</style>
</head>
<body>
	<div class="wrap">
        <%@ include file="/WEB-INF/views/common/header.jsp"%>
        <main>
        	<h1> 게시글 수정 </h1>
            <div class="tbl">
            	<form action="/app99/board/edite" method="post">
            		<table>
            			<tr>
            				<td><input type="hidden" name="bNo" value="<%=boardVo.getNo()%>"></td>
            			</tr>
            			<tr>
                            <th>카테고리</th><!-- js로 처리 selected -->
                            <td><select name="category">
                                <option value="1">자유</option>
                                <option value="2">게임</option>
                                <option value="3">요리</option>
                                <option value="4">운동</option>
                                <option value="5">자바</option>
                                <option value="6">자바스크립트</option>
                                <option value="7">쿼리</option>
                                <option value="8">기타</option>
                            </select></td>
                        </tr>
            			<tr>
            				<th>제목</th>
            				<td><input type="text" name="title" value="<%=boardVo.getTitle()%>"></td>
            			</tr>
            			<tr>
            				<th>내용</th>
            				<td><textarea  name="content"><%=boardVo.getContent()%></textarea></td>
            			</tr> 
            			<tr>
                            <td colspan="2" align="right"><input type="submit" value="수정완료"></td>
                        </tr>
            		</table>
            	</form>
            </div>
</body>
</html>