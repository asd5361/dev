package com.cherry.trade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.trade.vo.TradeVo;


public class TradeDao {

	// 게시글 목록 (중고거래 메인)
	public List<TradeVo> printPost(Connection conn) throws Exception {
		String sql = "SELECT RPAD(T.BOARD_NO, 10, 'ㅤ') BOARD_NO, RPAD(T.TITLE, 30, 'ㅤ') TITLE, RPAD(T.PRODUCT, 15, 'ㅤ') PRODUCT, RPAD(T.PRICE, 15, 'ㅤ') PRICE, RPAD(M.NICK, 15, 'ㅤ') NICK, RPAD(TO_CHAR(T.ENROLL_DATE, 'YYYY\"년\"MM\"월\"DD\"일\"'), 20, 'ㅤ') ENROLL_DATE , RPAD(T.HIT, 3, 'ㅤ') HIT, T.MEMBER_NO, T.DEL_YN FROM TRADE T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO WHERE T.DEL_YN = 'N' AND T.COMPLETE_YN = 'N' ORDER BY ENROLL_DATE DESC";
//		String sql2 = "SELECT RPAD(T.BOARD_NO, 5, 'ㅤ') BOARD_NO ,RPAD(T.TITLE, 20, 'ㅤ') TITLE ,RPAD(T.PRODUCT, 15, 'ㅤ') PRODUCT ,RPAD(T.PRICE, 15, 'ㅤ') PRICE ,RPAD(M.NICK, 10, 'ㅤ') NICK ,RPAD(TO_CHAR(T.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"'), 15, 'ㅤ') ENROLL_DATE ,T.PRODUCT ,T.PRICE FROM TRADE T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO ORDER BY BOARD_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<TradeVo> voList = new ArrayList<TradeVo>();
		
		while(rs.next()) {
			
			String no = rs.getString("BOARD_NO");
			String title = rs.getString("TITLE");
			String product = rs.getString("PRODUCT");
			String price = rs.getString("PRICE");
			String nick = rs.getString("NICK");
			String date = rs.getString("ENROLL_DATE");
			String hit = rs.getString("HIT");
			String memberNo = rs.getString("MEMBER_NO");
			String delYn = rs.getString("DEL_YN");
			
			TradeVo vo = new TradeVo();
			vo.setBoardNo(no);
			vo.setTitle(title);
			vo.setProduct(product);
			vo.setPrice(price);
			vo.setMemberNick(nick);
			vo.setEnrollDate(date);
			vo.setHit(hit);
			vo.setMemberNo(memberNo);
			vo.setDelYn(delYn);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

	// 게시글 조회
	public TradeVo showContent(String select, Connection conn) throws Exception {
		
		String sql = "SELECT T.BOARD_NO ,T.TITLE ,T.CONTENT ,T.TRADE_AREAS ,T.PRODUCT ,T.PRICE ,TO_CHAR(T.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\" HH24:MI') ENROLL_DATE ,TO_CHAR(T.EDIT_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\" HH24:MI') EDIT_DATE, M.NICK, A.AREAS_NAME, T.HIT FROM TRADE T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO JOIN AREAS A ON M.AREAS_CODE = A.AREAS_CODE WHERE T.BOARD_NO = ? AND T.COMPLETE_YN = 'N' AND T.DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, select);
		
		ResultSet rs = pstmt.executeQuery();
		
		TradeVo vo = null;
		if(rs.next()) {
			String boardNo = rs.getString("BOARD_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String nick = rs.getString("NICK");
			String tradeArea = rs.getString("TRADE_AREAS");
			String areaName = rs.getString("AREAS_NAME");
			String product = rs.getString("PRODUCT");
			String price = rs.getString("PRICE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String editDate = rs.getString("EDIT_DATE");
			String hit = rs.getString("HIT");
			
			vo = new TradeVo();
			vo.setBoardNo(boardNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMemberNick(nick);
			vo.setTradeAreas(tradeArea);
			vo.setAreasName(areaName);
			vo.setProduct(product);
			vo.setPrice(price);
			vo.setEnrollDate(enrollDate);
			vo.setEditDate(editDate);
			vo.setHit(hit);
		}
			
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
	}

	// 조회수 증가
	public int increaseHit(String select, Connection conn) throws Exception {
		
		String sql = "UPDATE TRADE SET HIT = HIT + 1 WHERE BOARD_NO = ? AND MEMBER_NO != ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, select);
		
		if(Main.loginMember != null) {
			pstmt.setString(2, Main.loginMember.getMemberNo());
		} else {
			pstmt.setString(2, "0");
		}
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	// 게시글 수정
	public int editPost(TradeVo vo, Connection conn) throws Exception {
		
		String sql = "UPDATE TRADE SET TITLE = ? ,PRODUCT = ? ,PRICE = ? ,TRADE_AREAS = ? ,CONTENT = ? ,EDIT_DATE = SYSDATE WHERE BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getProduct());
		pstmt.setString(3, vo.getPrice());
		pstmt.setString(4, vo.getTradeAreas());
		pstmt.setString(6, vo.getBoardNo());

		
		String content = vo.getContent();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < content.length(); i++) {
			char ch = content.charAt(i);
			sb.append(ch);
			if((i+1) % 30 == 0 && i != 0) {
				sb.append("#");
			}
		}
		
		content = sb.toString();
		
		pstmt.setString(5, content);
		
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 게시글 작성
	public int writePost(TradeVo vo, Connection conn) throws Exception {
		
		String sql = "INSERT INTO TRADE(BOARD_NO, MEMBER_NO, AREAS_CODE, TITLE, PRODUCT, PRICE, TRADE_AREAS, CONTENT) VALUES(SEQ_BOARD_NO.NEXTVAL,?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);	
		pstmt.setString(1, Main.loginMember.getMemberNo());
		pstmt.setString(2, Main.loginMember.getAreasCode());
		pstmt.setString(3, vo.getTitle());
		pstmt.setString(4, vo.getProduct());
		pstmt.setString(5, vo.getPrice());
		pstmt.setString(6, vo.getTradeAreas());
		
        String content = vo.getContent();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < content.length(); i++) {
            char ch = content.charAt(i);
            sb.append(ch);

            if ((i + 1) % 30 == 0 && i != 0) {
                sb.append("#");
            }
        }
        
        content = sb.toString();
  
        pstmt.setString(7, content);
		
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 게시글 삭제 
	public int delPost(String boardNo, Connection conn) throws Exception {
		
		String sql ="UPDATE TRADE SET DEL_YN = 'Y' WHERE BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 관심목록 추가 
	public int addWishList(String boardNo, Connection conn) throws Exception {

		// 본인 게시물인지 확인
		String z = "SELECT MEMBER_NO FROM TRADE WHERE BOARD_NO = ?"; 
		PreparedStatement ps = conn.prepareStatement(z);
		ps.setString(1, boardNo);
		ResultSet rs = ps.executeQuery();
		String x = null;
		if(rs.next()) {
			x = rs.getString("MEMBER_NO");
		}
		
		JDBCTemplate.close(ps);
		JDBCTemplate.close(rs);
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 본인 게시글이 아니면 위시리스트에 추가
		if(!x.equals(Main.loginMember.getMemberNo())) {
			String sql = "INSERT INTO WISHLIST (WISHLIST_NO, BOARD_NO, MEMBER_NO) VALUES (SEQ_WISHLIST_NO.NEXTVAL, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardNo);
			pstmt.setString(2, Main.loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}
		
		JDBCTemplate.close(pstmt);

		return result;
	}

	// 게시글 정보 조회
	public TradeVo searchPostInfo(String boardNo, Connection conn) throws Exception {
		
		String sql = "SELECT T.* ,M.NICK ,A.AREAS_NAME FROM TRADE T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO JOIN AREAS A ON M.AREAS_CODE = A.AREAS_CODE WHERE BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
	
		TradeVo vo = null;
		if(rs.next()) {
			String memberNo = rs.getString("MEMBER_NO");
			String nick = rs.getString("NICK");
			String areaName = rs.getString("AREAS_NAME");
			String boardNum = rs.getString("BOARD_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String tradeArea = rs.getString("TRADE_AREAS");
			String product = rs.getString("PRODUCT");
			String price = rs.getString("PRICE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String editDate = rs.getString("EDIT_DATE");
			
			vo = new TradeVo();
			vo.setMemberNo(memberNo);
			vo.setMemberNick(nick);
			vo.setAreasName(areaName);
			vo.setBoardNo(boardNum);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setTradeAreas(tradeArea);
			vo.setProduct(product);
			vo.setPrice(price);
			vo.setEnrollDate(enrollDate);
			vo.setEditDate(editDate);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	// 구매 확정 - 히스토리 남기기
	public int confirmPurchase(TradeVo vo, Connection conn) throws Exception {
		
		int purchaseNo = 0;
		String[] getKey = {"PURCHASE_NO"};
		
		String sql = "INSERT INTO PURCHASE_HISTORY(PURCHASE_NO, BUYER_NO, BOARD_NO) VALUES (SEQ_PURCHASE_NO.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql, getKey);
		pstmt.setString(1, Main.loginMember.getMemberNo());
		pstmt.setString(2, vo.getBoardNo());
		
		int result = pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		
		if(rs.next()){
           purchaseNo = rs.getInt(1); 
        }
		
		if(result == 1) {
			
			String sql2 = "UPDATE TRADE SET COMPLETE_YN = 'Y' WHERE BOARD_NO = ?";
			
			PreparedStatement pstmt2= conn.prepareStatement(sql2);

			pstmt2.setString(1, vo.getBoardNo());
			
			pstmt2.executeUpdate();
			
			JDBCTemplate.close(pstmt2);
		}
		
		JDBCTemplate.close(pstmt);
		
		return purchaseNo;
	}
	
	
//	// 구매 후기 작성  (매너온도 포함)  -- 미완성
//	public int writeReview(String content, Connection conn, int purchaseNo, String manner) throws Exception {
//		String sql = "INSERT INTO REVIEW (REVIEW_NO, PURCHASE_NO, SCORE, CONTENT) VALUES (SEQ_REVIEW_NO.NEXTVAL, ? , ?, ?)";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, purchaseNo);
//		switch(manner) {
//			case "1" : pstmt.setString(2, "1"); break;
//			case "2" : pstmt.setString(2, "0"); break;
//			case "3" : pstmt.setString(2, "-1"); break;
//		}
//		pstmt.setString(3, content);
//		
//		
//		int result = pstmt.executeUpdate();
//		
//		JDBCTemplate.close(pstmt);
//		
//		return result;
//	}

	public List<TradeVo> searchPostByTitle(String searchTitle, Connection conn) throws Exception {
		
		String sql = "SELECT RPAD(T.BOARD_NO, 10, 'ㅤ') BOARD_NO, RPAD(T.TITLE, 30, 'ㅤ') TITLE, RPAD(T.PRODUCT, 15, 'ㅤ') PRODUCT, RPAD(T.PRICE, 15, 'ㅤ') PRICE, RPAD(M.NICK, 15, 'ㅤ') NICK, RPAD(TO_CHAR(T.ENROLL_DATE, 'YYYY\"년\"MM\"월\"DD\"일\"'), 20, 'ㅤ') ENROLL_DATE , RPAD(T.HIT, 3, 'ㅤ') HIT, T.MEMBER_NO FROM TRADE T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO WHERE T.TITLE LIKE ? AND T.DEL_YN = 'N' AND T.COMPLETE_YN = 'N' ORDER BY ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + searchTitle + "%");
		
		ResultSet rs = pstmt.executeQuery();
	
		List<TradeVo> voList = new ArrayList<TradeVo>();
		while(rs.next()) {
			String no = rs.getString("BOARD_NO");
			String title = rs.getString("TITLE");
			String product = rs.getString("PRODUCT");
			String price = rs.getString("PRICE");
			String nick = rs.getString("NICK");
			String date = rs.getString("ENROLL_DATE");
			String hit = rs.getString("HIT");
			String memberNo = rs.getString("MEMBER_NO");
			
			TradeVo vo = new TradeVo();
			vo.setBoardNo(no);
			vo.setTitle(title);
			vo.setProduct(product);
			vo.setPrice(price);
			vo.setMemberNick(nick);
			vo.setEnrollDate(date);
			vo.setHit(hit);
			vo.setMemberNo(memberNo);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

	public List<TradeVo> searchPostByProduct(String searchProduct, Connection conn) throws Exception {
		
		String sql = "SELECT RPAD(T.BOARD_NO, 10, 'ㅤ') BOARD_NO, RPAD(T.TITLE, 30, 'ㅤ') TITLE, RPAD(T.PRODUCT, 15, 'ㅤ') PRODUCT, RPAD(T.PRICE, 15, 'ㅤ') PRICE, RPAD(M.NICK, 15, 'ㅤ') NICK, RPAD(TO_CHAR(T.ENROLL_DATE, 'YYYY\"년\"MM\"월\"DD\"일\"'), 20, 'ㅤ') ENROLL_DATE , RPAD(T.HIT, 3, 'ㅤ') HIT, T.MEMBER_NO FROM TRADE T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO WHERE T.PRODUCT LIKE ? AND T.DEL_YN = 'N' AND T.COMPLETE_YN = 'N' ORDER BY ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + searchProduct + "%");
		
		ResultSet rs = pstmt.executeQuery();
	
		List<TradeVo> voList = new ArrayList<TradeVo>();
		
		while(rs.next()) {
			String no = rs.getString("BOARD_NO");
			String title = rs.getString("TITLE");
			String product = rs.getString("PRODUCT");
			String price = rs.getString("PRICE");
			String nick = rs.getString("NICK");
			String date = rs.getString("ENROLL_DATE");
			String hit = rs.getString("HIT");
			String memberNo = rs.getString("MEMBER_NO");
			
			TradeVo vo = new TradeVo();
			vo.setBoardNo(no);
			vo.setTitle(title);
			vo.setProduct(product);
			vo.setPrice(price);
			vo.setMemberNick(nick);
			vo.setEnrollDate(date);
			vo.setHit(hit);
			vo.setMemberNo(memberNo);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

}
