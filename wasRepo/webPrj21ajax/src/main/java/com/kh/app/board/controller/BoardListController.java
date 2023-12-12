package com.kh.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{

	
	//게시글 목록 응답 (json 문자열로)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 꺼내기 + 데이터 뭉치기
		
		// 준비된 데이터로 서비스 호출
		
		//위 작업들 했다 치고 ,,,,, 만들어진 결과물 임시로 준비
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		boardVoList.add(new BoardVo("제목01" , "내용01"));
		boardVoList.add(new BoardVo("제목02" , "내용02"));
		boardVoList.add(new BoardVo("제목03" , "내용03"));
		boardVoList.add(new BoardVo("제목04" , "내용04"));
		boardVoList.add(new BoardVo("제목05" , "내용05"));
		
		
		// 서비스 호출 결과를 이용하여 문자열 내보내기
		Gson gson = new Gson();
		String str = gson.toJson(boardVoList);
		
		PrintWriter out = resp.getWriter();
		out.write(str);
		
	}
}
