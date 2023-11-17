package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberJoinService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setAttribute("str","회원가입");
			//데이터
			req.setCharacterEncoding("UTF-8");
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberPwd2(memberPwd2);
			vo.setMemberNick(memberNick);
			
			//서비스
			MemberJoinService ms = new MemberJoinService();
			int result = ms.join(vo);
		
			//결과 == 문자열 내보내기
			if(result != 1) {
				throw new Exception("[ERROR] 회원가입 예외 발생");
			}
			
			req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
		
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			
		}
	}
}
