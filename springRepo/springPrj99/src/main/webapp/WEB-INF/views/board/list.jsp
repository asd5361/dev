<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		
		<main>
		</main>
	</div>
	<script>

		// const voList = [  
		// 	{
		// 		no : '1'
		// 		,title : '제목111'
		// 		,content : '내용111'
		// 	},
		// 	{
		// 		no : '2'
		// 		,title : '제목222'
		// 		,content : '내용222'
		// 	},
		// 	{
		// 		no : '3'
		// 		,title : '제목333'
		// 		,content : '내용333'
		// 	}					
		// 	];
		
		fetch('/app/board/rest/list')
		.then( resp =>resp.json() )
		.then( data => { 
			console.log(data);
			const voList= data;
				
			const mainDiv = document.querySelector("main");
			const str 
			= '<table>'
					+'<thead>'
						+'<tr>'
							+'<th>'+'번호'+'</th>'
							+'<th>'+'제목'+'</th>'
							+'<th>'+'작성자'+'</th>'
						+'</tr>'
					+'</thead>'
					+'<tbody>'
							+'<tr>'
								+'<td>'+voList[0].no+'</td>'
								+'<td>'+voList[0].title+'</td>'
								+'<td>'+voList[0].content+'</td>'
							+'</tr>'
							+'<tr>'
								+'<td>'+voList[1].no+'</td>'
								+'<td>'+voList[1].title+'</td>'
								+'<td>'+voList[1].content+'</td>'
							+'</tr>'
							+'<tr>'
								+'<td>'+voList[2].no+'</td>'
								+'<td>'+voList[2].title+'</td>'
								+'<td>'+voList[2].content+'</td>'
							+'</tr>'
					+'</tbody>'
			+'</table>'
			;
		mainDiv.innerHTML = str;
		} )
		;						
	</script>

</body>
</html>