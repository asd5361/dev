package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{

	//로그인 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			req.setCharacterEncoding("UTF-8");
			
			//data
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			
			//service
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			//result (==view)
			if(loginMember == null) {
				throw new Exception("로그인 실패");
			}
			HttpSession session = req.getSession();
			session.setAttribute("alertMsg", "로그인 성공");
			session.setAttribute("userData", loginMember);
			resp.sendRedirect("/app99/home");
			
		}catch(Exception e) {
			System.out.println("[ERROR-M002] 로그인 중 예외 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
