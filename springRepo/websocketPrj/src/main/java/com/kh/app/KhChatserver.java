package com.kh.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//WebSocketHandler 인터페이스를 상속받아서 해도 되긴 함
public class KhChatserver extends TextWebSocketHandler{
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	//소켓 연결 되었을 떄 동작할 내용
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결됨~~~");
		sessionList.add(session);
	}

	//메세지 받았을 때 동작할 내용
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		
		TextMessage x = new TextMessage(message.getPayload().toString());
		//연결된 모든 세션에게 메세지를 보냄 broadCaset
		for (WebSocketSession webSocketSession : sessionList) {
			webSocketSession.sendMessage(x);			
		}
		
	}

	//소켓 연결 끊겼을 떄 동작할 내용
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 끊김");
		sessionList.remove(session);
	}

	
	
}
