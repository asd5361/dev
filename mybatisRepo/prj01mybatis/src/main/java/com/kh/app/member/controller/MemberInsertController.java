package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/insert")
public class MemberInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			String nick = req.getParameter("nick");
			
			MemberVo vo = new MemberVo(id,pwd,pwd2,nick);
			MemberService ms = new MemberService();
			int result = ms.memberInsert(vo);
			
			if(result != 1) {
				throw new Exception();
			}
			
			System.err.println("결과 :: "+result);
			
		}catch(Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
		
	}
	
}
