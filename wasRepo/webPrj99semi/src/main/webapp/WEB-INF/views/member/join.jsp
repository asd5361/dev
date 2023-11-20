<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/common/header.jsp"%>
    
        <h1 align="center">회원가입</h1>

        <form action="/app99/member/join" method="post" onsubmit="checkValidate();">
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>* 비밀번호</td>
                    <td><input type="password" name="pwd"></td>
                </tr>
                <tr>
                    <td>* 비밀번호확인</td>
                    <td><input type="password" name="pwd2"></td>
                </tr>
                <tr>
                    <td>* 닉네임</td>
                    <td><input type="text" name="nick"></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="tel" name="ohone"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="addr"></td>
                </tr>
                <tr>
                    <td>취미</td>
                    <td>
                        <label for="cb01">게임</label><input id ="cb01" type="checkbox" name="hobbys" value="game">
                        <label for="cb02">요리</label><input id ="cb02" type="checkbox" name="hobbys" value="cook">
                        <label for="cb03">운동</label><input id ="cb03" type="checkbox" name="hobbys" value="workout">
                        <br>
                        <label for="cb04">자바</label><input id ="cb04" type="checkbox" name="hobbys" value="JAVA">
                        <label for="cb05">자스</label><input id ="cb05" type="checkbox" name="hobbys" value="js">
                        <label for="cb06">쿼리</label><input id ="cb06" type="checkbox" name="hobbys" value="sql">
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2"><input type="submit" value="회원가입"></td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        function checkValidate(){

            //아이디 길이
            //패스워드 일치여부
            //패스워드 길이
            //닉네임 부적절한 단어 없는지
            //이메일 형식 맞는지 (졍규식)
            //전화번호 형식 맞는지 (정규식)

            if(문제있음){
                alert('!!!문제가 있음');
                return false;
            }
            return true;

        }
    </script>
</body>
</html>