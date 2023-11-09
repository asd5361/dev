package com.cherry.town.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.town.vo.TownVo;
import com.cherry.town_comment.vo.TowncommentVo;

public class TownDao {
	
	//---------------------게시글목록 조회(관리자)---------------------------------
	public List<TownVo> townlistAll(Connection conn, String num) throws Exception {
		
		//SQL
		String sql = "SELECT T.TOWN_NO,CATEGORY, T.TITLE, M.MEMBER_NO AS WRITER_NICK, T.HIT , TO_CHAR(T.ENROLL_DATE , 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE, DELETE_YN FROM TOWN T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO ORDER BY T.TOWN_NO ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<TownVo> voList = new ArrayList<TownVo>();
		while(rs.next()) {
			String no = rs.getString("TOWN_NO");
			String category = rs.getString("CATEGORY");
			String title = rs.getString("TITLE");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			
			TownVo vo = new TownVo();
			vo.setTownNO(no);
			vo.setCategory(category);
			vo.setTitle(title);
			vo.setWirterNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setDelYn(deleteYn);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}


	//---------------------게시글 상세조회(관리자)---------------------------------
	public TownVo townDetailbynoAll(Connection conn, String searchValue) throws Exception {
		//SQL
		String sql = "SELECT T.TOWN_NO, T.TITLE, T.CONTENT,T.MEMBER_NO AS WRITER_NICK, T.HIT , TO_CHAR(T.ENROLL_DATE , 'YYYY\"년 \"MM\"월 \"DD\"일\" HH24\":\"MI') AS ENROLL_DATE , TC.CONTENT AS TCCOMMENT , EDIT_DATE FROM TOWN T LEFT JOIN TOWN_COMMENT TC ON T.TOWN_NO = TC.COMMENT_NO WHERE T.TOWN_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		TownVo vo = null;
		if(rs.next()) {
			String no = rs.getString("TOWN_NO");
			String title = rs.getString("TITLE");
			String contnet = rs.getString("CONTENT");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String content_1 = rs.getString("TCCOMMENT");
			String editdate = rs.getString("EDIT_DATE");
			
			vo = new TownVo();
			vo.setTownNO(no);
			vo.setTitle(title);
			vo.setContent(contnet);
			vo.setWirterNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setTowncommentcont(content_1);
			vo.setEditdate(editdate);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
		
	}

	//-----------------------게시글 작성----------------------
	public int write(Connection conn, TownVo vo) throws Exception {
		
		//SQL
		String sql = "INSERT INTO TOWN(TOWN_NO, TITLE, CATEGORY, CONTENT, MEMBER_NO) VALUES(SEQ_TOWN_NO.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getCategory());
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, Main.loginMember.getMemberNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	
	//-----------------------게시글 삭제----------------------
	public int towndelete(Connection conn, HashMap<String, String>map) throws Exception {
		
		String sql = "UPDATE TOWN SET DELETE_YN = 'Y', ENROLL_DATE = SYSDATE WHERE TOWN_NO = ? AND MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, map.get("TOWN_NO"));
		pstmt.setString(2, map.get("loginMemberNo"));
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}
	
	
	
	//-----------------------게시글 목록----------------------
	public List<TownVo> townList(Connection conn) throws Exception {
		
		//SQL
		String sql = "SELECT T.TOWN_NO, T.CATEGORY, T.TITLE, M.MEMBER_NO AS WRITER_NICK, T.HIT , TO_CHAR(T.ENROLL_DATE , 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE FROM TOWN T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO WHERE T.DELETE_YN = 'N' ORDER BY T.TOWN_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<TownVo> voList = new ArrayList<TownVo>();
		while(rs.next()) {
			String no = rs.getString("TOWN_NO");
			String category = rs.getString("CATEGORY");
			String title = rs.getString("TITLE");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			TownVo vo = new TownVo();
			vo.setTownNO(no);
			vo.setCategory(category);
			vo.setTitle(title);
			vo.setWirterNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	
	
	//-----------------------게시글 조회----------------------
	public TownVo townDetailByNo(Connection conn, String searchValue) throws Exception {
		//SQL
		String sql = "SELECT T.TOWN_NO , T.TITLE , T.CONTENT , M.MEMBER_NO AS WRITER_NICK , T.HIT , TO_CHAR(T.ENROLL_DATE , 'YYYY\"년 \"MM\"월 \"DD\"일\" HH24\":\"MI') AS ENROLL_DATE , TC.CONTENT AS TCCOMMENT FROM TOWN T JOIN MEMBER M ON T.MEMBER_NO = M.MEMBER_NO LEFT OUTER JOIN TOWN_COMMENT TC ON T.TOWN_NO = TC.TOWN_NO WHERE T.TOWN_NO = ? AND T.DELETE_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		TownVo vo = null;
		if(rs.next()) {
			String no = rs.getString("TOWN_NO");
			String title = rs.getString("TITLE");
			String contnet = rs.getString("CONTENT");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String content_1 = rs.getString("TCCOMMENT");
			
			vo = new TownVo();
			vo.setTownNO(no);
			vo.setTitle(title);
			vo.setContent(contnet);
			vo.setWirterNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setTowncommentcont(content_1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
		
	}
	
	//------------------------조회수----------------------
	public int increaseHit(Connection conn, String num)throws Exception {
		
		//SQL
		String sql = "UPDATE TOWN SET HIT = HIT+1 WHERE TOWN_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

//-----------------------------게시글 수정---------------
	public int townupdate(Connection conn, TownVo tvo) throws Exception {
		String sql = "UPDATE TOWN SET TITLE = ? , CONTENT = ? , EDIT_DATE = SYSDATE WHERE TOWN_NO = ? AND MEMBER_NO = ? AND DELETE_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tvo.getTitle());
		pstmt.setString(2, tvo.getContent());
		pstmt.setString(3, tvo.getTownNO());
		pstmt.setString(4, tvo.getWirterNick());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	
}
