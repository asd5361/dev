package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.storeconfig.CertificateStoreAppender;

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		resp.sendRedirect("/app14/home");
	}
}
