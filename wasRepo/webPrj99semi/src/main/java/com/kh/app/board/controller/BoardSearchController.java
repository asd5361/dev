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
import com.kh.app.page.vo.PageVo;

@WebServlet("/board/search")
public class BoardSearchController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			BoardService bs = new BoardService();
			
			//data
			
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			Map<String,String> m = new HashMap<String,String>();
			m.put("searchType", searchType);
			m.put("searchValue", searchValue);
			
			
			
			int listCount = bs.selectSearchBoardCount(m);	//전체 게시글 갯수 
			String currentPage_ = "1";
			if(req.getParameter("pno") != null) {
				currentPage_ = req.getParameter("pno");
			}
			int currentPage = Integer.parseInt(currentPage_);	//현제 페이지
			int pageLimit = 5;
			int boardLimit = 10;
			
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			//service
			List<BoardVo> voList = bs.search(m,pvo);
			
			
			//result == view
			if(voList == null) {
				throw new Exception();
			}
			
			req.setAttribute("boardVoList", voList);
			req.setAttribute("pageVo", pvo);
			req.setAttribute("searchMap", m);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "[ERROR-B123] 게시판 검색 중 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
		
	}
}
