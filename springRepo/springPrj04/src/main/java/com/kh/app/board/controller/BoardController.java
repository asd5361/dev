package com.kh.app.board.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

//@Controller
//@ResponseBody
@RestController
public class BoardController {

	private final BoardService bs;
	
	@Autowired
	public BoardController(BoardService bs) {
		this.bs = bs;
	}
	//�Խñ� �ۼ� ȭ��
	@GetMapping("board/write")
	public String showBoard() {
		return "board/write";
	}
	
	
	//�Խñ� �ۼ�
	@PostMapping("board/write")
	public HashMap<String, String> insertBoard(BoardVo vo) {
		
		int result = bs.write(vo);
		System.out.println("result ::: "+result);
		
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("msg","gooooood~!!");
		
		return map;
	}
	
	//�Խñ� ���
	@GetMapping("board/list")
	public String getBoardList() {
		return "board/list";
	}
}
