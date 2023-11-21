package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			req.setCharacterEncoding("UTF-8");
			
			//데이터
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
			String phone =req.getParameter("phone") ;
			String email =req.getParameter("email");
			String addr = req.getParameter("addr");
			String[] hobbys = req.getParameterValues("hobbys");
			
			MemberVo vo = new MemberVo();
			
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberPwd2(memberPwd2);
			vo.setMemberNick(memberNick);
			vo.setPhone(phone);
			vo.setEmail(email);
			vo.setAddr(addr);
			vo.setHobbys(hobbys);
			
			//서비스
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			
			//result (==view)
			if(result == 1) {
				HttpSession session = req.getSession();
				session.setAttribute("alertMsg", "회원가입 성공");
				resp.sendRedirect("/app99/home");
			}else {
				throw new Exception("result 값이 1이 아님");
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR-M001] 회언가입 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "회원가입");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}
