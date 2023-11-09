package com.cherry.faq.service;

import java.sql.Connection;
import java.util.List;

import com.cherry.faq.dao.FaqDao;
import com.cherry.faq.vo.FaqVo;
import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;

public class FaqService {

	//필드
	FaqDao dao;
	
	//기본 생성자
	public FaqService() {
		dao = new FaqDao();
	}
	
	//게시판 생성
	public int write(FaqVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		int result = dao.write(conn, vo);
		
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
	
	//게시판 수정

	public int edit(FaqVo vo) throws Exception {
	
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		int result = dao.edit(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.commit(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	//게시판 삭제
	public int delete(String no) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		int result = dao.delete(conn, no);
		
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
	
	//게시판 검색(번호)
	public static FaqVo boardPrintByNo(String num) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		FaqVo vo = FaqDao.boardPrintByNo(conn, num);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}
	
	//게시판 검색(제목)
	public FaqVo boardPrintByTitle(String boardTitle) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		FaqVo vo = dao.boardPrintByTitle(conn, boardTitle);
		
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//게시판 검색(관리자 번호)
	public List<FaqVo> boardPrintByMno(String mName) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		List<FaqVo> voList = dao.boardPrintByMno(conn, mName);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
		
		
	}
	//게시판 전체 조회
	public List<FaqVo> boardList() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		List<FaqVo> voList = dao.boardList(conn);
		
		//close 
		JDBCTemplate.close(conn);
		
		return voList;
	}
	
	//게시판 상세 조회(게시판 번호)
	public FaqVo boardDetailByNo(String no) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO
		int result = 0;
		if(Main.loginManager == null) {
			result = dao.increaseHit(conn, no);
		}
		FaqVo vo = dao.boardDetailByNo(conn, no);
		
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
	
}//class
