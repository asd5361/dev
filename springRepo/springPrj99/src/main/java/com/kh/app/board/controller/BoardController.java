package com.kh.app.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String insert(BoardVo vo) throws Exception {
		int result = service.insert(vo);
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/board/list";
	}
	//�Խñ� ��� ��ȸ
	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<BoardVo> voList = service.list();
		if(voList == null) {
			throw new Exception();
		}
		model.addAttribute("boardVoList",voList);
		return "board/list";
	}
	//�Խñ� �� ��ȸ (��ȣ)
	@GetMapping("detail")
	public String detail(BoardVo vo ,Model model) throws Exception {
		BoardVo boardVo = service.detail(vo);
		if(boardVo == null) {
			throw new Exception();
		}
		model.addAttribute("boardVo",boardVo);
		return "board/detail";
	}
	//�Խñ� ���� (��ȣ)
	@GetMapping("delete")
	public String delete(BoardVo vo) throws Exception {
		int result = service.delete(vo);
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/board/list";
	}
	//�Խñ� ���� (����, ����)
	@PostMapping("edit")
	public String edit(BoardVo vo) throws Exception {
		int result = service.edit(vo);
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/board/detail?no="+vo.getNo();
	}
}
