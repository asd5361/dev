package com.kh.app.board.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@RequestMapping("api/board")
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class BoardApiController {

	private final BoardService service;
	
	//게시글 목록 조회
	@GetMapping("list")
	public List<BoardVo>list() throws InterruptedException{
		List<BoardVo> BoardVoList = service.list();
		
		for (BoardVo boardVo : BoardVoList) {
			System.out.println(boardVo);
		}
		return BoardVoList;
	}
	
	@PostMapping("write")
	public Map<String,String> write(@RequestBody BoardVo vo, HttpSession session){
		//writerNo 정보는 임의로 데이터 채움
		vo.setWriterNo("1");
		
		Map<String,String> map = new HashMap<String, String>();
		
		int result = service.insert(vo);
		if(result == 1) {
			map.put("msg","good");
		}else {
			map.put("msg","bad");			
		}
		return map;
	}
}
