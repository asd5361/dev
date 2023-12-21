package com.kh.app.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {

	// 게시글 목록
//	@RequestMapping(value = "board/list",method = RequestMethod.GET)
	@GetMapping("board/list")
	public String getBoardList() {
		System.out.println("m01 called~~~!!");
		return "board/list";
	}
	
	//게시글 작성하기 화면
	@GetMapping("board/write")
	public String insertBoard() {
		return "board/write";
	}
	
	//게시글 작성하기 처리
	@PostMapping("board/write")
	public String insertBoard(BoardVo vo) {
//		String title = req.getParameter("title");
//		String content = req.getParameter("content");
//		String writer = req.getParameter("writer");
		
//		BoardVo vo = new BoardVo(title,content,writer);
		
		System.out.println(vo);
		
		return "redirect:list";
	}
}
