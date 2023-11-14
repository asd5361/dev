package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mul")
public class MultipleServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("n1");
		String num2 = req.getParameter("n2");
		
		int mul = Integer.parseInt(num) * Integer.parseInt(num2);
		
		PrintWriter pw = resp.getWriter();
		
		pw.write("<h1>mul::"+mul+"</h1>");
	}
}
