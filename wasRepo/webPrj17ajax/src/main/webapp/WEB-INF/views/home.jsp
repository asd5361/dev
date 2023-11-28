<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	
	<button type="button" onclick="f01();">버튼</button>

</body>
</html>

	<script>

	function f01(){
		/*설명
		fetch("요청 보낼 주소")
		.then(데이터를 가공 객체.text()) 
		.then(가공된 데이터로 원하는 작업 ㄱㄱ);
		*/
		
		
		//fetch(주소, 옵션);		
		fetch("http://localhost:8888/app17/test")
		.then((resp)=>{	return resp.json() }) 
		.then((x)=>{
			console.log(x.title);
			console.log(x.content);
		});
	}
</script>