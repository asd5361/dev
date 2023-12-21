package com.kh.app.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final SqlSessionTemplate sst; 
	private final BoardDao dao;
	
	
	public int insert(BoardVo vo) {
		return dao.insertBoard(sst,vo);
	}

	public List<BoardVo> selectList() {
		return dao.getBoardList(sst);
	}

	public BoardVo selectOne(String no) {
		return dao.getBoardByNo(sst, no);
	}

	public int delete(String no) {
		return dao.deleteBoardByNo(sst, no);
	}

	public int edit(BoardVo vo) {
		return dao.setBoardByNo(sst, vo);
	}

	
	
	
}
