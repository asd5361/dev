package com.kh.app.member.join;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join/processor")
public class MemberJoinProcessorServlet extends HttpServlet{
	
	//회원가입을 진행하는 메소드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		//데이터
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberPwd2 = req.getParameter("memberPwd2");
		String memberNick = req.getParameter("memberNick");
		
		System.out.println(memberId);
		System.out.println(memberPwd);
		System.out.println(memberPwd2);
		System.out.println(memberNick);
		
		//서비스
		int result = 1; //memberService.join(memberVo);
		
		if(memberId.equals("ADMIN")) {
			result = 0;
		}
		
		//결과
		PrintWriter out = resp.getWriter();
		if(result == 1) {
			out.write("<h1>OK</h1>");
		}else {
			out.write("<h1>Fail..</h1>");
		}
	}
}
