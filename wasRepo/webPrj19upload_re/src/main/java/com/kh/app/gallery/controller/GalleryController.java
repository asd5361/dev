package com.kh.app.gallery.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10			//파일 하나당 크기
		, maxRequestSize = 1024 * 1024 * 50		//리퀘스트 전체 크기
		)
@WebServlet("/gallery/insert")
public class GalleryController extends HttpServlet{

	//사진 업로드 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/gallery/insert.jsp").forward(req, resp);
	}
	
	//사진 업로드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			Part f = req.getPart("f");
			
			//읽기 준비
		     InputStream in = f.getInputStream();
		      
		    //내보내기 준비
		    String sep = File.separator;	// 역슬래쉬 처리
		    String path = req.getServletContext().getRealPath(sep + "resources" + sep + "upload" + sep + "img");
		    String randomName = System.nanoTime()+ "_" + UUID.randomUUID();
		    String submittedFileName = f.getSubmittedFileName();
		    int index = submittedFileName.lastIndexOf(".");
		    String ext = submittedFileName.substring(index);
		    String fileName = sep + randomName + ext;
		    File target = new File(path + fileName);
		    FileOutputStream out = new FileOutputStream(target);
		    
		    byte[] buf = new byte[1024];
		    int size = 0;
		    while( (size = in.read(buf)) != -1) {
		       out.write(buf, 0, size);
		    }
		    
		    // 정리
		    in.close();
		    out.close();
		    
		
	}
	
	
}
