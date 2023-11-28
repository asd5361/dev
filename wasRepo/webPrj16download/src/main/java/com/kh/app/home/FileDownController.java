package com.kh.app.home;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/download")
public class FileDownController extends HttpServlet{

	//다운로드 요청 처리할 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//파일경로
		String path = req.getServletContext().getRealPath("/resources/profile");
		String fileName = "/abc.png";
		
		//파일 객체 준비
		File f = new File(path+fileName);
		
		//다운로드 하라고 header한테 말함 + 파일 이름 , 파일 길이 알려줌 
		resp.setHeader("Content-Type", "application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=zzz.png");
		resp.setHeader("Content-Length", String.valueOf(f.length()));
		
		
		//내보내기
		FileInputStream is = new FileInputStream(f);
		ServletOutputStream out =resp.getOutputStream();
		
		//파일 크기만큼 한번에 읽어서 내보내기
		byte[] buf = new byte[1024] ;
		int size=0;
		
		while((size = is.read(buf)) != -1) {
			out.write(buf, 0 ,size);
		}
		
		//close
		is.close();
		out.close();
		
		
	}
}
/*
 @WebServlet("/file/download")
public class FileDownController extends HttpServlet {
	
	//다운로드 요청 처리할 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletContext().getRealPath("/resources/profile");
		String fileName = "/abc.png";
		File f = new File(path + fileName);
		
		resp.setHeader("Content-Type", "application/octet-stream");	
		resp.setHeader("Content-Disposition", "attachment; filename=zzz.png");
		resp.setHeader("Content-Length", String.valueOf(f.length()));
		
		FileInputStream is = new FileInputStream(f);
		 
		ServletOutputStream out = resp.getOutputStream();
		
		byte[] buf = new byte[1024];
		int size = 0;
		while( (size = is.read(buf)) != -1) {
			out.write(buf , 0 , size);
		}
		
	}

}
*/
