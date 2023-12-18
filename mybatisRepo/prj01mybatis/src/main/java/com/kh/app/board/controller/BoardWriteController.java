package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVo vo = new BoardVo(title,content);
			
			BoardService bs = new BoardService();
			int result = bs.boardWrite(vo);
			
			if(result != 1) {
				throw new Exception();
			}
			
			System.out.println("결과 값 ::: "+result);
			
		}catch(Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		
		}
		
	}
}
