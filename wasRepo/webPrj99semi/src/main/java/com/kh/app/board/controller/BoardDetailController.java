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
import com.kh.app.reply.vo.ReplyVo;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String boardNo = req.getParameter("no");
			
			//service
			BoardService bs = new BoardService();
			Map<String,Object> map = bs.selectBoardByNo(boardNo);
			BoardVo vo = (BoardVo) map.get("vo");
// ajax처리	List<ReplyVo> replyVoList = (List<ReplyVo>) map.get("replyVoList");
			
			//result == view
			
			req.setAttribute("boardVo", vo);
//			req.setAttribute("replyVoList", replyVoList);
			req.setAttribute("currPage", req.getParameter("currPage"));
			req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
		
		}catch(Exception e) {
			
			System.out.println("[ERROR-B002]게시글 상세 조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 상세 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		
		}
	}
	

}
