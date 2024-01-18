package com.kh.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.msg.controller.MsgController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("api/board")
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@Slf4j
public class BoardApiController {

	private final BoardService service;
	
	//게시글 목록 조회 + logger (로거) 예제로 사용
	@GetMapping("list")
	public List<BoardVo>list() throws InterruptedException{
		String str = ":"; 
		log.info("BoardController 클래스의 list 메소드 호출됨. {}", str); //이런 방식으로 사용 가능
//		service.list();
		return null;
	}
	
	@PostMapping("write")
	public Map<String,String> write(@RequestBody BoardVo vo, HttpSession session){
		
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
