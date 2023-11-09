package com.cherry.trade.service;

import java.sql.Connection;
import java.util.List;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.trade.dao.TradeDao;
import com.cherry.trade.vo.TradeVo;

public class TradeService {
	
	private final TradeDao dao;

	public TradeService() {
		dao = new TradeDao();
	}

	// 게시글 목록 
	public List<TradeVo> printPost() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<TradeVo> voList = dao.printPost(conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	// 게시글 조회
	public TradeVo showContent(String select) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.increaseHit(select, conn);
		
		TradeVo vo = dao.showContent(select, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return vo;
	}
	
	// 게시글 수정
	public int editPost(TradeVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.editPost(vo, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 게시글 작성
	public int writePost(TradeVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.writePost(vo, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 게시글 삭제
	public int delPost(String boardNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.delPost(boardNo, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 관심목록 추가
	public int addWishList(String boardNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.addWishList(boardNo, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 게시글 정보 조회
	public TradeVo searchPostInfo(String boardNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		TradeVo vo = dao.searchPostInfo(boardNo, conn);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}
	
	// 구매 확정 - 히스토리 남기기
	public int confirmPurchase(TradeVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int purchaseNo  = dao.confirmPurchase(vo, conn);
		
		if(purchaseNo != -1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return purchaseNo;
	}
	
//	// 구매 후기 작성 (매너온도 포함)
//	public int writeReview(String content, TradeVo vo, int purchaseNo, String manner) throws Exception {
//		
//		Connection conn = JDBCTemplate.getConnection();
//		
//		int result = dao.writeReview(content, conn, purchaseNo, manner);
//		
//		if(result == 1) {
//			JDBCTemplate.commit(conn);
//		} else {
//			JDBCTemplate.rollback(conn);
//		}
//		
//		JDBCTemplate.close(conn);
//		
//		return result;
//	}

	public List<TradeVo> searchPostByTitle(String searchTitle) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<TradeVo> voList = dao.searchPostByTitle(searchTitle, conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public List<TradeVo> searchPostByProduct(String searchProduct) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<TradeVo> voList = dao.searchPostByProduct(searchProduct, conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

}
