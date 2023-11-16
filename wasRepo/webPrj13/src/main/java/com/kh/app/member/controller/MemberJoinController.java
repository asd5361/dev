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
	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
		
	}
	
	//회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			req.setAttribute("str", "회원가입");
			
			//데이터
			req.setCharacterEncoding("UTF-8");
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
			
			MemberVo vo = new MemberVo();
			
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberPWd2(memberPwd2);
			vo.setMemberNick(memberNick);
			
			//서비스
			MemberJoinService ms = new MemberJoinService();
			int result = ms.join(vo);
			
			//결과==문자열 내보내기
			if(result == 1) {
				req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			}else {
				throw new Exception("[ERROR-M001] 회원가입 result 가 1이 아님");
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR-M001] 회원가입 예외 발생");
			e.getMessage();
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
		
		
	}
}
