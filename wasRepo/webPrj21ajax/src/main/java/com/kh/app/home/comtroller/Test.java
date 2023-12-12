package com.kh.app.home.comtroller;

import java.io.BufferedReader;
import java.io.IOException;import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/test")
public class Test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doget called ~~~ !!!");
		String str = req.getParameter("str");
		System.out.println("str :"+str);
		resp.getWriter().write("{\"msg\":\"good\"}");

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("dopost called ~~~ !!!");
		
		
		//BODY에 담근 사용한 데이터 읽기

		BufferedReader br =req.getReader();
		
		String bodyData = "";
		String temp="";
		
		while( (temp = br.readLine()) != null ) {
			bodyData += temp;
		}
		System.out.println("bodyData : " + bodyData);
		
		
		//읽어 드린 문자열 (JSON 형태 ) 가공하기
		Gson gson = new Gson();
		BoardVo vo = gson.fromJson(bodyData, BoardVo.class);
		System.out.println("JSON 문자열을 이용해서 만들어진 객체 :" + vo);
		
		resp.getWriter().write("{\"msg\":\"good\"}");
	}
	
}
