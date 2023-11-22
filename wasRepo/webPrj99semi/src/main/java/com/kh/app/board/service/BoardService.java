package com.kh.app.board.service;

import java.sql.*;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.util.JDBCTemplate;

public class BoardService {

	public int write(BoardVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();

		BoardDao dao = new BoardDao();
		
		int result = dao.write(conn,vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<BoardVo> selectBoardList() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		BoardDao dao = new BoardDao();
		List<BoardVo> boardVoList = dao.selectBoardList(conn);
		
		
		//close
		JDBCTemplate.close(conn);
		
		return boardVoList;
	}

}
