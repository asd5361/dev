<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <div class="wrap">
      <%@ include file="/WEB-INF/views/common/header.jsp" %>
      
      <div class="main">
         <form action="/app/member/join" method="post">
            
            <input type="text" name="id" placeholder="아이디">
            <br>
            <input type="password" name="pwd" placeholder="패스워드">
            <br>
            <input type="text" name="nick" placeholder="닉네임">
            <br>
            <input type="submit" value="회원가입">
            
         </form>
      </div>
      <div> <a href="/app/home">홈으로 돌아가기</a></div>
   </div>

</body>
</html>