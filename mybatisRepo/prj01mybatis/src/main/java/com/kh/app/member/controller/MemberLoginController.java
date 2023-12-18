package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/login")
public class MemberLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			MemberService ms = new MemberService();
			
			MemberVo loginVo = ms.login(vo);
			
			if(loginVo == null) {
				throw new Exception();
			}
			
			System.out.println(loginVo);
			
		}catch(Exception e) {
			System.out.println("에러 발생");
			e.printStackTrace();
		}
		
	}
}
