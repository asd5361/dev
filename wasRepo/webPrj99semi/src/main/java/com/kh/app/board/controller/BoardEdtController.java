package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.board.vo.CategoryVo;

@WebServlet("/board/edit")
public class BoardEdtController extends HttpServlet{
	
	//게시글 수정 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			BoardService bs = new BoardService();
			Map<String, Object> m = bs.edit(no);
			BoardVo vo = (BoardVo) m.get("vo");
			List<CategoryVo> categoryVoList = (List<CategoryVo>) m.get("categoryVoList");
			
			//result == view
			if(vo == null) {
				throw new Exception();
			}
			
			//카테고리 정보
			req.setAttribute("boardVo", vo); 
			
			//조회한 게시글 정보
			req.setAttribute("categoryVoList",categoryVoList ); 
			
			req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("게시글 수정하기 화면 조회 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 화면 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

	//게시글 수정
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
			int result = bs.updateBoardByNo(vo);
			
			if(result != 1 ) {
				throw new Exception("[ERROR-B002]게시글 수정 중 에러 발생");
			}
			//resutl == view
			resp.sendRedirect("/app99/board/detail?no="+no);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		
		}
	}
}
