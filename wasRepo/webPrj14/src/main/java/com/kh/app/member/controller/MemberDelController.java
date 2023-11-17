package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kh.app.member.service.MemberDelService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/del")
public class MemberDelController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setAttribute("str", "회원탈퇴");
			//데이터
			req.setCharacterEncoding("UTF-8");
			HttpSession session = req.getSession();
			MemberVo vo = (MemberVo) session.getAttribute("userData");
			
			//서비스
			MemberDelService service = new MemberDelService();
			int result = service.del(vo);
			
			//결과==문자열 내보내기
			if(result != 1) {
				throw new Exception("[EORROR] 회원탈퇴 예외 발생");
			}
			session.invalidate();
			req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);			
		}
	}
}
