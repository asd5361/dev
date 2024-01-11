package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

public class BoardDaoMysql implements BoardDaoImpl{

	@Override
	public int insert(SqlSessionTemplate sst, BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVo> list(SqlSessionTemplate sst) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo detail(SqlSessionTemplate sst, BoardVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(SqlSessionTemplate sst, BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(SqlSessionTemplate sst, BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
