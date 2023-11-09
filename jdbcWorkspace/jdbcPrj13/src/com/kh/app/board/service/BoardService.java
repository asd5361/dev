package com.kh.app.board.service;

import java.sql.*;
import java.util.ArrayList;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.db.JDBCTemplate;

public class BoardService {
	
	private final BoardDao dao;
	
	public BoardService() {
		dao = new BoardDao();
	}

	public ArrayList<BoardVo> list() throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		ArrayList<BoardVo> boardList = dao.list(conn);
		//tx
		
		//close
		JDBCTemplate.Close(conn);
		return boardList;
	}

	public int write(BoardVo vo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.write(conn,vo);
		//tx
		if(result == 1){
			JDBCTemplate.Commit(conn);
		}else {
			JDBCTemplate.Rollback(conn);
		}
		//close
		JDBCTemplate.Close(conn);
		
		return result;
	}

	public ArrayList<BoardVo> printDetail(String key) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		ArrayList<BoardVo> boardList = dao.printDetail(conn,key);
		//tx
		//close
		JDBCTemplate.Close(conn);
		return boardList;
	}

	public int edit(BoardVo vo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.edit(conn,vo);
		//tx
		if(result == 1) {
			JDBCTemplate.Commit(conn);
		}else {
			JDBCTemplate.Rollback(conn);
		}
		//close
		JDBCTemplate.Close(conn);
		
		return result;
	}

	public int delete(String num) throws Exception{
		//conn
		Connection conn =JDBCTemplate.getConnection();
		//sql
		int result = dao.delete(conn,num);
		//tx
		if(result == 1 ) {
			JDBCTemplate.Commit(conn);
		}else {
			JDBCTemplate.Rollback(conn);
		}
		//close
		JDBCTemplate.Close(conn);
		return result;
		
	}

}
