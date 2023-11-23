package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.service.BoardService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			//data
			String no = req.getParameter("no");
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("userData");
			if(loginMember == null) {
				throw new Exception("잘못된 접근입니다. 로그인 후 시도해주세요");
			}
			String writerNo = loginMember.getMemberNo();
			//service
			BoardService bs = new BoardService();
			int result = bs.delete(no,writerNo);
			
			//result == view
			if(result != 1) {
				throw new Exception("게시글 삭제 에러 발생");
			}
			
			req.getSession().setAttribute("alertMsg", "게시글 삭제 성공!");
			resp.sendRedirect("/app99/board/list");
			
		}catch(Exception e)  {
			System.out.println("[ERROR-B003]게시글 삭제 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 삭제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}
