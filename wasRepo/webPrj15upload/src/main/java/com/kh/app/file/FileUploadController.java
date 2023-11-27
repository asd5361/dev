package com.kh.app.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10			//파일 하나당 크기
		, maxRequestSize = 1024 * 1024 * 50		//리퀘스트 전체 크기
		)
@WebServlet("/file/insert")
public class FileUploadController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Part f = req.getPart("f");
		
		//읽기
		InputStream in = f.getInputStream();
		
		
		//내보내기
		String path =req.getServletContext().getRealPath("/resources/upload/img/");
		String fileName = "abc.png";
		File target = new File(path+fileName);
		FileOutputStream out = new FileOutputStream(target);
		
		//한 바이트씩 읽고 내보내기 반복문
//		int data = 0;
//		while((data = in.read()) != -1) {
//			out.write(data);
//		}

		//파일 크기만큼 한번에 읽어서 내보내기
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = in.read(buf)) != -1){
			out.write(buf, 0, size);
		}
		
		
		//close
		in.close();
		out.close();
		
	}
	
}
