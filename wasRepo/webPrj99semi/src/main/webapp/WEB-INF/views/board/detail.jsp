<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.kh.app.reply.vo.ReplyVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVo boardVo = (BoardVo)request.getAttribute("boardVo");
	String currPage = (String)request.getAttribute("currPage");
	List<ReplyVo> replyVoList = (List<ReplyVo>)request.getAttribute("replyVoList");
	if(currPage == null) currPage = "1";
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
        		<button type="button" onclick="location.href='/app99/board/edit?no=<%=boardVo.getNo()%>';">수정하기</button>
				<button type="button" onclick="location.href='/app99/board/delete?no=<%=boardVo.getNo()%>';">삭제하기</button>
<%}%>
				<a href="/app99/board/list?pno=<%=currPage%>">목록 가기</a>
				<h3>댓글 내용 :::${replyVoList}</h3>
				<div id ="replyArea" ></div>
				
				</div>
        	</div>
       	</main>
     </div>
     
<script>
	const urlStr = location.href;
	const idx = urlStr.indexOf("no=");
	const boardNo = urlStr.substr(idx);	//no=123
	const aTag = document.querySelector("main div a");
	aTag.href = aTag.href.replace("no=null" , no);

	//ajax를 이용하여 댓글 목록 조회
	function getReplyList(refNo){
		fetch("/app99/board/reply/list?no=1")
		.then((resp)=>{ return resp.json() })
		.then((data)=>{ console.log(replyVoList) })
		.catch(()=>{ alert("댓글 불러오기 실패"); });
	}
	
	//댓글 목록들을 화면에 보여주기
	function setReplyArea() {
		const divTap = document.querySelector("#replyArea");
		const replyVoList = getReplyList(1);
		divTap.innerHTML = replyVoList;
	}
	
</script>
</body>
</html>
