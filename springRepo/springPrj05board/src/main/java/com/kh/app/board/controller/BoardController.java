package com.kh.app.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	
	//�Խñ� �ۼ�
	@PostMapping("insert")
	public void insert(BoardVo vo) {
		
		int result = service.insert(vo);
		
		System.out.println("insert > result :::"+ result );
	}
	//�Խñ� ���
	@GetMapping("list")
	public void selectList() {
		List<BoardVo> voList = service.selectList();
		for (BoardVo boardVo : voList) {
			System.out.println(boardVo);
		}
	}
	//�Խñ� ����ȸ
	@GetMapping("detail")
	public void selectOne(String no) {
		BoardVo selectVo = service.selectOne(no);
		System.out.println(selectVo);
	}
	
	//�Խñ� ����
	@GetMapping("delete")
	public void delete(String no) {
		int result =  service.delete(no);
		System.out.println("delete > result :::"+ result );
	}
	
	//�Խñ� ����
	@PostMapping("edit")
	public void edit(BoardVo vo) {
		int result =  service.edit(vo);
		System.out.println("edit > result :::"+ result );
	}
	
	
}
