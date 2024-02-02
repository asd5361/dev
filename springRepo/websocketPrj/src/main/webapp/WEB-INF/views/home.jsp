<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	채팅~~!
</h1>
	<form id="formTag">
		<input type="text" name="msg">
		<input type="submit" value="전송">
	</form>
	<div id="msgArea"></div>
	
	<script>
		
		/*웹소켓 객체 생성*/ /*웹소켓 프로토콜 사용을 위해 http => ws */
		const ws = new WebSocket("ws://127.0.0.1:8888/app/chatServer");
		
		/*각 상황에 따라 함수로 역활 지정*/
		ws.onopen = () => { console.log("open~~!!!"); };
		ws.onclose = () => { console.log("close~~!!!"); };
		ws.onerror = () => { console.log("error~~!!!"); };
		ws.onmessage = (msg) => { 
			console.log("서버한테 메세지 받음 msg~~!!!");
			console.log(msg.data);
			const msgArea = document.querySelector("#msgArea");
			msgArea.innerHTML += "<h3>"+msg.data+"</h3>";
		};
		
		const formTag = document.querySelector("#formTag");
		
		formTag.addEventListener("submit",(event)=>{
			event.preventDefault();

			//웹소켓 이용해서 메세지 보내기
			const inputTag = document.querySelector("input[name=msg]");
			ws.send(inputTag.value);
		})
		
	</script>
</body>
</html>
