package com.kh.app.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
	// 게시글 작성
	@PostMapping("insert")
	public String insert(BoardVo vo) throws Exception {
		int result = service.insert(vo);
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/board/list";
	}
	// 게시글 목록 조회 (data 를 JSP 에게 넘겨서 화면(data+view) 다 만들어줌)
	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<BoardVo> voList = service.list();
		if(voList == null) {
			throw new Exception();
		}
		model.addAttribute("boardVoList",voList);
		return "board/list";
	}
	// 게시글 목록 조회 (data 만 응답해줌)
	@GetMapping("rest/list")
	@ResponseBody
	public List<BoardVo> restlist(){
		List<BoardVo> voList = service.list();
		return voList;
	}
	
	// 게시글 상세 조회 (번호)
	@GetMapping("detail")
	public String detail(BoardVo vo ,Model model) throws Exception {
		BoardVo boardVo = service.detail(vo);
		if(boardVo == null) {
			throw new Exception();
		}
		model.addAttribute("boardVo",boardVo);
		return "board/detail";
	}
	// 게시글 삭제 (번호)
	@GetMapping("delete")
	public String delete(BoardVo vo) throws Exception {
		int result = service.delete(vo);
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/board/list";
	}
	// 게시글 수정 (제목, 내용)
	@PostMapping("edit")
	public String edit(BoardVo vo) throws Exception {
		int result = service.edit(vo);
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/board/detail?no="+vo.getNo();
	}
}
