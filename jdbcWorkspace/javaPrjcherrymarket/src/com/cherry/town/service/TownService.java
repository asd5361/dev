package com.cherry.town.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.town.dao.TownDao;
import com.cherry.town.vo.TownVo;

public class TownService {

	
	//필드
	private final TownDao dao;
	
	//기본생성자
	public TownService() {
		dao = new TownDao();
	}
	//---------------------게시글목록 조회(관리자)---------------------------------
	public List<TownVo> townlistAll() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		List<TownVo> voList = dao.townlistAll(conn, null);
		
		//tx
	
		//close
		JDBCTemplate.close(conn);
		
	return voList;
	}


	//---------------------게시글 상세조회(관리자)---------------------------------
		public TownVo townDetailbynoAll(String num) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		int result = dao.increaseHit(conn , num);
		TownVo vo= dao.townDetailbynoAll(conn, num);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		return vo;
	}
	//---------------게시글작성----------------
	public int write(TownVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		int result = dao.write(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}

		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	//---------------게시글삭제----------------
	public int towndelete(HashMap<String, String> map) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		int result = dao.towndelete(conn, map);
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
		
	
	//---------------게시글목록----------------
	public List<TownVo> townList() throws Exception {
	
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		List<TownVo> voList = dao.townList(conn);
		
		//tx
	
		//close
		JDBCTemplate.close(conn);
		
	return voList;
	}
	//---------------게시글조회----------------
	public TownVo townDetailByNo(String num) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		int result = dao.increaseHit(conn , num);
		TownVo vo = dao.townDetailByNo(conn , num);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		return vo;
	}
	//-----------------------게시글 수정----------------
	public int townupdate(TownVo tvo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.townupdate(conn, tvo);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
	
}
