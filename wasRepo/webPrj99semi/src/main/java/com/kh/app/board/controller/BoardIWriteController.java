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

@WebServlet("/board/write")
public class BoardIWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			HttpSession session = req.getSession();
			//데이터
//			req.setCharacterEncoding("UTF-8");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String categoryNo = req.getParameter("category");
			
			MemberVo loginMember = (MemberVo)session.getAttribute("userData");
			if(loginMember == null) {
				throw new Exception("로그인 안됨");
			}
			String writerNo = loginMember.getMemberNo();
			
			BoardVo vo = new BoardVo();
			vo.setCategoryNo(categoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			
			//서비스
			BoardService bs = new BoardService();
			int result = bs.write(vo);
			
			//결과
			if(result != 1) {
				throw new Exception("result가 1이 아님");
			}
			req.getSession().setAttribute("errorMsg", "게시글이 작성되었습니다.");
			resp.sendRedirect("/app99/board/list");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 작성 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
