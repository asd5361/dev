package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")	//1. 어노테이션 추가 후 ("/home") 담당할 객체 작성
public class HomeController extends HttpServlet{	//2.httpservlet 상속 받기
	
	@Override		//3.자동완성으로 service 작성하고 파라미터가 http~ 시작하는 메소드 선택
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("home 이라는 요청받음");
		
		//클라이언트가 보낸 데이터 받기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");

		System.out.println(id+" / "+pwd+" / "+nick);
		
		
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter pw =resp.getWriter();
		
		pw.write("<!DOCTYPE HTML>");
		pw.write("<heed>");
		pw.write("<title>제목</title>");
		pw.write("<style>h1{background-color:lightgray;}</style>");
		
		pw.write("</head>");
		pw.write("<h1>home page~~</h1>");
		pw.write("<h3>"+nick+"님 환영합니다.</h3>");
		pw.write("<body>");
		
		if( id.equals("user01") && pwd.equals("1234")) {
			pw.write("<script>alert('"+nick+"님 환영합니다.');</script >");
		}
		pw.write("</body>");
		pw.write("</html>");
		
		
		
	}
	
}
