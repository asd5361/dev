package com.kh.app.board.contrtoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardControler {
	
	
	@GetMapping("board/list")
	public String getBoardList() {
		return "board/list";
	}
	
	@GetMapping("board/write")
	public String showBoardWrite() {
		return "board/write";
	}
	
	@PostMapping("board/write")
	public String insertBoard(BoardVo vo) {
		
		int result = 1;
		if(result == 1) {
			return "redirect:/board/list";			
		}else {
			return "error";	//WEB-INF/views/error.jsp로 이동			
		}
	}
	//게시글 수정 *화면
	@GetMapping("board/edit")
	public String getBoardEdti() {
		return "board/edit";
	}
	//게시글 수정
	@PostMapping("board/edit")
	public String editBoardEdti() {
		return "redirect:board/list";
		
	}
	//게시글 삭제
	@GetMapping("board/delete")
	public String deleteBoard() {
		return "board/list";
	}
	//게시글 상세조회
	@GetMapping("board/detail")
	public String detailBoard() {
		return "board/detail";
	}

}
