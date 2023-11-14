package com.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;


@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet{
	
	//회원가입 화면
	//요청이 GET 방식일 때 동작
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	
	//회원가입 처리
	//요청이 POST 방식일 때 동작
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터
		String memberId =req.getParameter("memberId");
		String memberPwd =req.getParameter("memberPwd");
		String memberPwd2 =req.getParameter("memberPwd2");
		String memberNick =req.getParameter("memberNick");
		
		
		//서비스
		int result = 0;
		if(memberPwd.equals(memberPwd2) && memberPwd != "") {
			System.out.println("회원가입 성공");
			result = 1;

		}
		req.setAttribute("str", "회원가입");
		//결과
		if(result == 1) {
			req.getRequestDispatcher("/WEB-INF/views/member/success.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/WEB-INF/views/member/fail.jsp").forward(req, resp);
		}
		
		
	}
	
}
