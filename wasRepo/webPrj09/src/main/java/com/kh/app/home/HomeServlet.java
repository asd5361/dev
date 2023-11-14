package com.kh.app.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

//		resp.getWriter().write("<h1>home~~!!!</h1>");

		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
}
