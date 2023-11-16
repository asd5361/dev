package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.home.HomeServlet;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{

	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	//로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("str","로그인");
			
			//데이터
			req.setCharacterEncoding("UTF-8");
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			
			//서비스
			MemberLoginService ms = new MemberLoginService();
			MemberVo loginMember = ms.login(vo);
			
			//결과(==문자열 내보내기)
			if(loginMember != null) {
				HttpSession session = req.getSession();
				session.setAttribute("userData", loginMember);
				req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			}else {
				throw new Exception("[ERROR-L001] 로그인 LoginVo null 발생");
			}
		}catch(Exception e) {
			System.out.println("[ERROR-L001] 로그인 예외 발생");
			e.getMessage();
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
		
	}
}
