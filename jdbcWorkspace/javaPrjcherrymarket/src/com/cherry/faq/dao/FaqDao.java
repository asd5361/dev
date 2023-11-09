package com.cherry.faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cherry.faq.vo.FaqVo;
import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;

public class FaqDao {

	//게시판 작성
	public int write(Connection conn, FaqVo vo) throws Exception{
		
		//sql
		String sql = "INSERT INTO FAQ(FAQ_NO, MANAGER_NO, TITLE, CONTENT) VALUES(SEQ_FAQ_NO.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Main.loginManager.getManagerNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		
		int result = pstmt.executeUpdate();
		
		
		//close
		JDBCTemplate.close(pstmt);

		return result;
	}
	
	//게시글 수정
	public int edit(Connection conn, FaqVo vo) throws Exception {
		//SQL
		String sql = "UPDATE FAQ SET TITLE = ?, CONTENT = ? ,EDIT_DATE = SYSDATE WHERE FAQ_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getFaqNo());
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//게시판 삭제
	public int delete(Connection conn, String no) throws Exception {
		
		//SQL
		String sql = "UPDATE FAQ SET SECRET_YN = 'Y' WHERE FAQ_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);

		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//게시판 검색(게시판번호)
	public static FaqVo boardPrintByNo(Connection conn, String num) throws Exception {
		
		//SQL
		String sql;
		if(Main.loginMember != null) {  //회원일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE F.FAQ_NO = ? AND F.SECRET_YN = 'N'";
		}else {  //관리자일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE F.FAQ_NO = ? ";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		FaqVo vo = null;
		if(rs.next()) {
			
			String faqNo = rs.getString("FAQ_NO");
			String managerNo= rs.getString("MANAGER_NO");
			String managerName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String secretYn = rs.getString("SECRET_YN");
			String editDate = rs.getString("EDIT_DATE");
			String hit = rs.getString("HIT");
			
			
			vo = new FaqVo();
			vo.setFaqNo(faqNo);
			vo.setManagerNo(managerNo);
			vo.setManagerName(managerName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setSecretYn(secretYn);
			vo.setContent(editDate);
			vo.setHit(hit);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
	}
	
	//게시판 검색(제목)
	public FaqVo boardPrintByTitle(Connection conn, String boardTitle) throws Exception {
		
		//SQL
		String sql;
		if(Main.loginMember != null) {  //회원일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE F.TITLE LIKE '%' || ? || '%' AND F.SECRET_YN = 'N'";
		}else { //관리자일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE F.TITLE LIKE '%' || ? || '%'";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardTitle);
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		FaqVo vo = null;
		if(rs.next()) {
			String faqNo = rs.getString("FAQ_NO");
			String managerNo = rs.getString("MANAGER_NO");
			String managerName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String secretYn = rs.getString("SECRET_YN");
			String editDate = rs.getString("EDIT_DATE");
			String hit = rs.getString("HIT");
			
			vo = new FaqVo();
			
			vo.setFaqNo(faqNo);
			vo.setManagerNo(managerNo);
			vo.setManagerName(managerName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setSecretYn(secretYn);
			vo.setEditDate(editDate);
			vo.setHit(hit);
	
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
	}
	
	//게시판 검색(관리자 이름)
	public List<FaqVo> boardPrintByMno(Connection conn, String mName) throws Exception {
		
		
		//SQL
		String sql;
		if(Main.loginMember != null) {  //회원일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE M.NAME LIKE '%' || ? || '%' AND F.SECRET_YN = 'N'";
		}else {  //관리자일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE M.NAME LIKE '%' || ? || '%'";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mName);
		

		
		ResultSet rs = pstmt.executeQuery();
		
		//rs

		List<FaqVo> voList = new ArrayList<FaqVo>();
		
		while(rs.next()) {
			String faqNo = rs.getString("FAQ_NO");
			String managerNo = rs.getString("MANAGER_NO");
			String managerName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String secretYn = rs.getString("SECRET_YN");
			String editDate = rs.getString("EDIT_DATE");
			String hit = rs.getString("HIT");
			
			
			FaqVo vo = new FaqVo();
			
			vo.setFaqNo(faqNo);
			vo.setManagerNo(managerNo);
			vo.setManagerName(managerName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setSecretYn(secretYn);
			vo.setEditDate(editDate);
			vo.setHit(hit);
	
			voList.add(vo);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
		
	}
	
	

	//게시판 전체 조회
	public List<FaqVo> boardList(Connection conn) throws Exception {
		
		//SQL
		String sql;
		if(Main.loginMember != null) { //회원일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE F.SECRET_YN = 'N' ORDER BY F.ENROLL_DATE DESC, FAQ_NO DESC";
		}else { //관리자일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO ORDER BY F.ENROLL_DATE DESC, FAQ_NO DESC";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<FaqVo> voList = new ArrayList<FaqVo>();
		while(rs.next()) {
			
			String faqNo = rs.getString("FAQ_NO");
			String managerNo= rs.getString("MANAGER_NO");
			String managerName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String secretYn = rs.getString("SECRET_YN");
			String editDate = rs.getString("EDIT_DATE");
			String hit = rs.getString("HIT"); 
			
			FaqVo vo = new FaqVo();
			
			vo.setFaqNo(faqNo);
			vo.setManagerNo(managerNo);
			vo.setManagerName(managerName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setSecretYn(secretYn);
			vo.setEditDate(editDate);
			vo.setHit(hit);
			
			voList.add(vo);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
		
	}

	//게시판 상세 조회(게시판 번호)
	public FaqVo boardDetailByNo(Connection conn, String no) throws Exception {
		
		//SQL
		String sql;
		if(Main.loginMember != null) { //회원일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE SECRET_YN = 'N' AND FAQ_NO = ?";
		}else { //관리자일 때
			sql = "SELECT F.FAQ_NO , F.MANAGER_NO , M.NAME , F.TITLE , F.CONTENT , TO_CHAR(F.ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS ENROLL_DATE , F.SECRET_YN, TO_CHAR(F.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS EDIT_DATE , F.HIT FROM FAQ F JOIN MANAGER M ON F.MANAGER_NO = M.MANAGER_NO WHERE FAQ_NO = ?";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		
		
		FaqVo vo = null;
		if(rs.next()) {
			String faqNo = rs.getString("FAQ_NO");
			String managerNo = rs.getString("MANAGER_NO");
			String managerName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String secretYn = rs.getString("SECRET_YN");
			String editDate = rs.getString("EDIT_DATE");
			String hit = rs.getString("HIT");
			
			vo = new FaqVo();
			vo.setFaqNo(faqNo);
			vo.setManagerNo(managerNo);
			vo.setManagerName(managerName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setSecretYn(secretYn);
			vo.setEditDate(editDate);
			vo.setHit(hit);
			
		}
			
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return vo;	
		
	}

	//조회수 증가
	public int increaseHit(Connection conn, String no) throws Exception{
		//SQL
		String sql = "UPDATE FAQ SET HIT = HIT + 1 WHERE FAQ_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}
	
}//class
		
