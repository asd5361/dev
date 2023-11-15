package com.kh.app.board;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;

public class BoardService {

	public int write(BoardVo vo) throws Exception {
		
		if(vo.getContent().length() < 2) {
			throw new Exception("굴자수가 1글자 보다 적습니다");
		}
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		BoardDao dao = new BoardDao();
		int result = dao.write(conn,vo);
		
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
}
