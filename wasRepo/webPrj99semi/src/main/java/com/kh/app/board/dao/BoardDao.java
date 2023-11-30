package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.page.vo.PageVo;

public class BoardDao {
	//게시글 작성하기
	public int write(Connection conn, BoardVo vo) throws SQLException {
		
		String sql = "INSERT INTO BOARD (NO,CATEGORY_NO,TITLE,CONTENT,WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getCategoryNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, vo.getWriterNo());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}
	//게시글 전체 목록 조회
	public List<BoardVo> selectBoardList(Connection conn, PageVo pvo) throws SQLException {
		
		//sql
//		String sql = "SELECT * FROM BOARD WHERE STATUS = 'O' ORDER BY NO DESC";
//		String sql = "SELECT B.*, M.NICK FROM BOARD B JOIN MEMBER M ON (B.WRITER_NO= M.NO) WHERE B.STATUS = 'O' ORDER BY B.NO DESC";
//		String sql ="SELECT * FROM BOARD JOIN(SELECT NO AS M_NO, NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO WHERE STATUS = 'O' ORDER BY NO DESC";
//		String sql ="SELECT * FROM BOARD JOIN(SELECT NO AS M_NO, NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO JOIN (SELECT NO AS C_NO,NAME AS NAME FROM CATEGORY) ON  CATEGORY_NO = C_NO WHERE STATUS = 'O' ORDER BY NO DESC";
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM( SELECT * FROM BOARD JOIN(SELECT NO AS M_NO, NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO JOIN (SELECT NO AS C_NO,NAME AS NAME FROM CATEGORY) ON  CATEGORY_NO = C_NO WHERE STATUS = 'O' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		
		//rs
		while(rs.next()) {
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setCategoryNo(categoryNo);
			vo.setCategoryName(categoryName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setWriteNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setStatus(status);
			
			boardVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return boardVoList;
	}

	//게시글 번호로 1개 조회
	public BoardVo selectBoardByNo(Connection conn, String boardNo) throws SQLException {
		
		//sql
//		String sql = "SELECT * FROM BOARD JOIN (SELECT NO AS M_NO,NICK AS WRITER_NICK FROM MEMBER)ON M_NO = WRITER_NO WHERE NO = ? AND STATUS = 'O'";
		String sql = "SELECT * FROM BOARD JOIN (SELECT NO AS M_NO,NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO JOIN (SELECT NO AS C_NO,NAME FROM CATEGORY) ON  CATEGORY_NO = C_NO WHERE NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		BoardVo vo = null;
		
		//rs
		if(rs.next()) {
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setCategoryNo(categoryNo);
			vo.setCategoryName(categoryName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setWriteNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setStatus(status);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}
	
	//조회수 중가
	public int increaesHit(Connection conn, String boardNo) throws SQLException {
		//sql
		String sql="UPDATE BOARD SET HIT = HIT+1 WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//게시글 수정 
	public int updateBoardByNo(Connection conn, BoardVo vo) throws SQLException {
		
		//sql
		String sql = "UPDATE BOARD SET CATEGORY_NO = ?, TITLE = ?, CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ? AND STATUS = 'O' ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getCategoryNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, vo.getNo());
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int delete(Connection conn, String no, String writerNo) throws SQLException {
		//sql
		String sql = "UPDATE BOARD SET STATUS ='X' WHERE NO = ? AND WRITER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, writerNo);
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//게시글 갯수 조회
	public int selectBoardCount(Connection conn) throws SQLException {
		
		//sql
		String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt ; 
	}
	
	//카테고리 리스트 조회
	public List<CategoryVo> getCategoryList(Connection conn) throws SQLException {
		
		//sql
		String sql = "SELECT * FROM CATEGORY ORDER BY NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<CategoryVo> voList = new ArrayList<CategoryVo>();
		while(rs.next()) {
			CategoryVo vo = new CategoryVo();
			vo.setNo(rs.getString("NO"));
			vo.setName(rs.getString("NAME"));
			
			voList.add(vo); 
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList; 
	}

}
