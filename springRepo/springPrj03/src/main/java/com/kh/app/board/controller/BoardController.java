package com.kh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;

	@GetMapping("board/list")
	public String getBoardList() {
		
		List<BoardVo> voList = bs.getBoardList();
		System.out.println(voList);
		return "board/list";
	}
	
	@GetMapping("board/write")
	public String showInsertBoard() {
		return "board/write";
	}
	
	@PostMapping("board/write")
	public String insertBoard(BoardVo vo) {
		System.out.println(vo);
		return "redirect:list";
	}
}

