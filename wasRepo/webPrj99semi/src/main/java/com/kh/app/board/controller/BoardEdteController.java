package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/edite")
public class BoardEdteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			BoardService bs = new BoardService();
			BoardVo boardVo = bs.selectBoardByNo(no);
			
			//result == view
			req.setAttribute("boardVo", boardVo);
			req.getRequestDispatcher("/WEB-INF/views/board/edite.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR-B002]게시글 수정 데이터 조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 데이터 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			//date
			String no = req.getParameter("bNo");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String categoryNo = req.getParameter("category");
			BoardVo vo = new BoardVo();
			
			vo.setNo(no);
			vo.setTitle(title);
			vo.setCategoryNo(categoryNo);
			vo.setContent(content);
			
			
			//service
			BoardService bs = new BoardService();
			int result = bs.edite(vo);
			
			if(result != 1 ) {
				throw new Exception("[ERROR-B002]게시글 수정 중 에러 발생");
			}
			//resutl == view
			resp.sendRedirect("/app99/board/detail?no="+no);
			
		}catch(Exception e) {
			System.out.println("[ERROR-B002]게시글 수정 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		
		}
	}
}
