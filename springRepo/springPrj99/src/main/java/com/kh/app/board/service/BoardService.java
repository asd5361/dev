package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardDao dao;
	private final SqlSessionTemplate sst;
	
	public int insert(BoardVo vo) {
		return dao.insert(sst,vo);
	}

	public List<BoardVo> list() {
		return dao.list(sst);
	}

	public BoardVo detail(BoardVo vo) {
		return dao.detail(sst,vo);
	}

	public int delete(BoardVo vo) {
		return dao.delete(sst,vo);
	}

	public int edit(BoardVo vo) {
		return dao.edit(sst,vo);
	}

}
