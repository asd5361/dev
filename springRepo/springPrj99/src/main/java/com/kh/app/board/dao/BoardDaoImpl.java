package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.board.vo.BoardVo;

public interface BoardDaoImpl {

	int insert(SqlSessionTemplate sst, BoardVo vo);

	List<BoardVo> list(SqlSessionTemplate sst);

	BoardVo detail(SqlSessionTemplate sst, BoardVo vo);

	int delete(SqlSessionTemplate sst, BoardVo vo);

	int edit(SqlSessionTemplate sst, BoardVo vo);
	
}
