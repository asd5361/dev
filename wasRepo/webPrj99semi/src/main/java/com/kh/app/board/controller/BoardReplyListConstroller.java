package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.service.BoardService;
import com.kh.app.reply.vo.ReplyVo;

/*
 * 컨트롤러 : 요청을 받고, 응답한다.
 * 
 * 현재 컨트롤러는 ajax 방식으로 요청을 받게 될 것이다.
 * 그래서, 응답 또한 그에 맞춰서 처리 할 예정
 * (==JSON 으로 을답하겠다.)
 * 
 * 기존방식 : 화면에 보여줄 모든 문자열 내보냄.
 * 왜냐하면, 응답받은 내용을 화면에 그대로 보여주니까
 * 
 * 근데 ajax 에서는 응답받은 내용을 JS 변수에 담음
 * 그러므로 데이터만 보낸다. //JSON 형식으로
 * (화면에 보여줄 태그는 JS 보고 알아서 만들라고 하면 됨)
 */

@WebServlet("/board/reply/list")
public class BoardReplyListConstroller extends HttpServlet{
	
	//댓글 목록 조회하여 JSON형태로 문자열 내보내기
	// select 쿼리 실행 결과 응답하기
	// SELECT * FROM REPLY WHERE REF_NO = ?
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data (데이터 꺼내기, 데이터 뭉치기)
			String refNo = req.getParameter("refNo");
			
			//service 
			BoardService bs = new BoardService();
			List<ReplyVo> replyVoList = bs.getReplyList(refNo);
			
			Gson gson = new Gson();
			String str = gson.toJson(replyVoList);
					//객체를 JSON문자열로 바꾸는 메소드(객체)
			
			//result (replyVoList 를 JSON 문자열로 바꿔서 내보내기 - GSON 활용 예정)
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(str);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "댓글 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
