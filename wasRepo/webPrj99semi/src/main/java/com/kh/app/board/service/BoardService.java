package com.kh.app.board.service;

import java.sql.*;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.page.vo.PageVo;

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

	public List<BoardVo> selectBoardList(PageVo pvo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		BoardDao dao = new BoardDao();
		List<BoardVo> boardVoList = dao.selectBoardList(conn,pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return boardVoList;
	}

	public BoardVo selectBoardByNo(String boardNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		BoardDao dao = new BoardDao();
		int result = dao.increaesHit(conn, boardNo);
		
		BoardVo vo = null;
		if(result == 1) {
			vo = dao.selectBoardByNo(conn, boardNo);
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int edite(BoardVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		BoardDao dao = new BoardDao();
		int result = dao.edite(conn,vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int delete(String no, String writerNo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		BoardDao dao = new BoardDao();
		int result = dao.delete(conn,no,writerNo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(null);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int selectBoardCount() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		BoardDao dao = new BoardDao();
		int cnt = dao.selectBoardCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return cnt;
	}

}
