<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String x = (String) session.getAttribute("alertMsg");
    session.removeAttribute("alertMsg");
    MemberVo loginMember = (MemberVo) session.getAttribute("userData");
%>
<script>
<% if(x != null){ %>
    alert('<%= x %>');
<% } %>

</script>
<link rel="stylesheet" href="/app99/resources/css/header.css">

<header>
    <div></div>
    <div class="logo"><a href="/app99/home"><img width="300px" height="120px" src="/app99/resources/img/logo.png"alt="logo"></a></div>
    <div>
        <% if(loginMember == null){%>
        <form action="/app99/member/login" method="post">
            <div class="login-area">
                <input type="text" name="memberId" placeholder="아이디">
                <input type="password" name="memberPwd" placeholder="패스워드">
                <button type="button" onclick="location.href='/app99/member/join';">회원가입</button>
                <input type="submit" value="로그인">
            </div>
        </form>
        <%}else{%>
            <h3><%=loginMember.getMemberNick()%>님 환영합니다.</h3>
            <button type="button" onclick="location.href='/app99/member/logout';">로그아웃</button>
        <%}%>
    </div>
    <div>
        <nav>
            <a href="/app99/border/list">게시판</a>
            <a href="/app99/notice/list">공지사항</a>
            <a href="/app99/gallery/list">갤러리</a>
            <a href="/app99/member/edit">마이페이지</a>
        </nav>
    </div>
</header>
