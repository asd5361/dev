package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	public int insert(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("BoardMapper.insert",vo);
	}

	public List<BoardVo> list(SqlSessionTemplate sst) {
		return sst.selectList("BoardMapper.list");
	}

	public BoardVo detail(SqlSessionTemplate sst, BoardVo vo) {
		return sst.selectOne("BoardMapper.detail",vo);
	}

	public int delete(SqlSessionTemplate sst, BoardVo vo) {
		return sst.update("BoardMapper.delete",vo);
	}

	public int edit(SqlSessionTemplate sst, BoardVo vo) {
		return sst.update("BoardMapper.edit",vo);
	}

}
