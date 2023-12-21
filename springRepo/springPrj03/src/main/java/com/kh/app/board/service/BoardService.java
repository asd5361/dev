package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;
	
//	@Autowired
//	public BoardService(BoardDao d, SqlSessionTemplate s) {
//		dao = d;
//		sst = s;
//	}
	
	//게시글 목록 조회
	public List<BoardVo> getBoardList(){
		
		return dao.getBoardList(sst);
		
	}
}
