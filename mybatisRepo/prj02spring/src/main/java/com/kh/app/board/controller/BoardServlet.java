package com.kh.app.board.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uri = req.getRequestURI();
		String method = req.getMethod();
		
		//톰켓을 통해 모든 문자열을 받아서 map에 담은 후 컨트롤러에게 전달한다.
		String data1 = req.getParameter("~");
		String data2 = req.getParameter("~");
		/* ... */
		
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("title", data1);
		dataMap.put("content", data2);
		/* ... */
		
		//포워딩할 위치 반환시켜 받아오기
		String result = "";
		
		if(uri.equals("/board/list") && method.equals("GET")) {
			result = new BoardController().selectList();
		}else if(uri.equals("/board/write") && method.equals("GET")) {
			result = new BoardController().showBoardWritePage();
		}else if(uri.equals("/board/write") && method.equals("POST")) {
			result = new BoardController().insertBoard();
		}/* ... */
		
		//view resolve
		if(result.startsWith("redirect:")) {
			resp.sendRedirect(result);
		}else {
			String a = "/WEB-INF/views";
			String b = ".jsp";
			req.getRequestDispatcher(a+result+b).forward(req, resp);			
		}
		
	}
	
}
