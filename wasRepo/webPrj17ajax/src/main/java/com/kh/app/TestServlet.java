package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardVo vo = new BoardVo();
		vo.setTitle("title 01 eeee");
		vo.setContent("content sssssss");
		
		System.out.println("요청 받음");
		PrintWriter out = resp.getWriter();
		
		String str = "{\"title\":\"ttt\",\"content\":\"ccc\"}";
		
		out.write(str);
	}
	
}
