package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberLoginService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			req.setCharacterEncoding("UTF-8");
			String memberId = req.getParameter("MemberId");
			String memberPwd = req.getParameter("memberPwd");
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			
			MemberLoginService ms = new MemberLoginService();
			MemberVo login = ms.login(vo);
			
			if(login == null) {
				throw new Exception("로그인 예외 발생");
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("userData", login);
			resp.sendRedirect("/app99/home");
		
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();	
		}
	}
}
