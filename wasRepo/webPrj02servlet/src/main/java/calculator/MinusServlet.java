package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minus")
public class MinusServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String num = req.getParameter("n1");
		String num2 = req.getParameter("n2");
		
		int a = Integer.parseInt(num);
		int b = Integer.parseInt(num2);
		int minus = 0;
		if(a<b) minus= b-a; else minus=a-b;
		
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>minus::"+minus+"</h1>");
		
	}
}
