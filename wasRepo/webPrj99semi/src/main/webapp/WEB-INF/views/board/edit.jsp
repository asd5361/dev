<%@page import="com.kh.app.board.vo.CategoryVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% BoardVo boardVo = (BoardVo)request.getAttribute("boardVo"); %>
<% List<CategoryVo> categoryVoList = (List<CategoryVo>)request.getAttribute("categoryVoList"); %>
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
            	<form action="/app99/board/edit" method="post">
            		<table>
            			<tr>
            				<td><input type="hidden" name="bNo" value="<%=boardVo.getNo()%>"></td>
            			</tr>
            			<tr>
                            <th>카테고리</th><!-- js로 처리 selected -->
                            <td><select name="category">
<%for(CategoryVo vo :categoryVoList) {%>
	<%-- jsp 방식 ::: 현재 카테고리에 selected 처리 --%>
	<%--if(vo.getNo().equals(boardVo.getCategoryNo())) {--%>
	<!-- 						<option value=<%=vo.getNo()%> selected><%=vo.getName()%></option>
	 -->
	<%--}else{ --%>
							<option value=<%=vo.getNo()%>><%=vo.getName()%></option>
	<%--} --%>
<%} %>
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
                            <td colspan="2" align="right"><input type="submit" value="수정하기"></td>
                        </tr>
            		</table>
            	</form>
            </div>
</body>
</html>
<script>
	function setOptionSelected(){
		const optionTagArr = document.querySelectorAll("main select option");
		for(let i=0; i<optionTagArr.length; i++){
			const optionTag = optionTagArr[i];
			if(optionTag.value == <%= boardVo.getCategoryNo() %>){
				optionTag.selected = true;
			}
		}
	}
	setOptionSelected();

</script>