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
		//데이터
		String nick = req.getParameter("nick");
		
		//비즈니스 로직 == 서비스
		
		//결과 == 문자열 내보내기
//		resp.setContentType("text/html; charset=UTF-8;");
//		resp.getWriter().write("<h1>"+nick+"님 환영합니다</h1>");
		
		req.getRequestDispatcher("WEB-INF/views/abc.jsp").forward(req, resp);
		
	}
}
