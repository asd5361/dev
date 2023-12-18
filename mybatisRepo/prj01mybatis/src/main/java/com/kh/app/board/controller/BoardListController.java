package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BoardService bs = new BoardService();
			List<BoardVo> boardVoList = bs.boardList();
			
			if(boardVoList == null) {
				throw new Exception();
			}
			for (BoardVo boardVo : boardVoList) {
				System.out.println(boardVo);
			}
			
		}catch(Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
		
	}
}
