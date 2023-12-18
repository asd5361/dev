package com.kh.app.board.service;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.util.JDBCTemplate;

public class BoardService {

	private BoardDao dao = new BoardDao();
	
	public List<BoardVo> boardList() throws Exception {
		
		//conn
//		Connection conn = JDBCTemplate.getConnection();
		
		//session (세션 얻어오기)
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		List<BoardVo> boardVoList = dao.boardList(ss);
		
//		JDBCTemplate.close(conn);
		ss.close();
		
		return boardVoList;
	}

	public int boardWrite(BoardVo vo) throws Exception {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		int result = dao.boardWrite(ss,vo);
		
//		Connection conn = JDBCTemplate.getConnection();
//		
//		int result = dao.boardWrite(conn, vo);
//		
		if(result == 1) {
//			JDBCTemplate.commit(conn);
			ss.commit();
		}else {
//			JDBCTemplate.rollback(conn);
			ss.rollback();
		}
		
//		JDBCTemplate.close(conn);
		ss.close();
		
		return result;
	}

}
