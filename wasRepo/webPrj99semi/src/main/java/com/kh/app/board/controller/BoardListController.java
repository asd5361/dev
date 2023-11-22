package com.kh.app.board.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//data
			//service
			BoardService bs = new BoardService();
			List<BoardVo> boardVoList = bs.selectBoardList();
			
			if(boardVoList == null) {
				throw new Exception("[ERROR-B001]게시글 목록 조회 중 에러 발생");
			}
			//결과
			req.setAttribute("boardVoList", boardVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);

		}catch(Exception e) {
			System.out.println("[ERROR-B001]게시글 목록 조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 목록 조회 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
