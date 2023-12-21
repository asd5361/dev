package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	public int insertBoard(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("boardMapper.insertBoard",vo);
	}

	public List<BoardVo> getBoardList(SqlSessionTemplate sst) {
		return sst.selectList("boardMapper.getBoardList");
	}

	public BoardVo getBoardByNo(SqlSessionTemplate sst, String no) {
		return sst.selectOne("boardMapper.getBoardByNo",no);
	}

	public int deleteBoardByNo(SqlSessionTemplate sst, String no) {
		return sst.delete("boardMapper.deleteBoardByNo",no);
	}

	public int setBoardByNo(SqlSessionTemplate sst, BoardVo vo) {
		return sst.update("boardMapper.setBoardByNo",vo);
	}

	
	
}
