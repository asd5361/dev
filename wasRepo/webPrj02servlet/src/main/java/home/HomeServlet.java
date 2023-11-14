package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a = req.getParameter("num");
		String b = req.getParameter("num2");
		
		System.out.println(a);
		System.out.println(b);
		
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter pw = resp.getWriter();
		pw.write("<!DOCTYPE HTML><head><title>app02HOME</title></head><body><h1>home~~!</h1></body></html>");
		
	}
	
}
