<%@page import="com.kh.app.board.vo.CategoryVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CategoryVo> categoryVoList = (List<CategoryVo>)request.getAttribute("categoryVoList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app99/resources/css/write.css">
<style>
    main{
        display: grid;
        grid-template-rows: 100px 500px 100px;
        grid-template-columns: 300px 400px;
        place-items: center center;
        
    }
    main div{
        grid-column:1/span2;
    }
    .tbl_f td input[type=text]{
        min-width: 300px;
    }
    .tbl_f textarea{
        min-width: 300px;
        min-height: 300px;
    }
    .tbl_f input[type=submit]{
        width: 100px;
        height: 30px;
    }
</style>
</head>
<body>

    <div class="wrap">
        <%@ include file="/WEB-INF/views/common/header.jsp"%>
        <main>
            <div>
                <h1>게시글 작성</h1>
            </div>

            <div class="tbl_f">
                <form action="/app99/board/write" method="post">
                    <table>
                        <tr>
                            <th>카테고리</th>
                            <td><select name="category">
<%for(CategoryVo vo :categoryVoList) {%>
							<option value=<%=vo.getNo()%>><%=vo.getName()%></option>
<%} %>
                            </select></td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td><input type="text" name="title"></td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td><textarea name="content"></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right"><input type="submit" value="작성완료"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </main>
    </div>
</body>
</html>