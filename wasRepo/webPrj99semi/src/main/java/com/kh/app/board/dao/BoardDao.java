package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.util.JDBCTemplate;

public class BoardDao {

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

	public List<BoardVo> selectBoardList(Connection conn) throws SQLException {
		
		//sql
//		String sql = "SELECT * FROM BOARD WHERE STATUS = 'O' ORDER BY NO DESC";
//		String sql = "SELECT B.*, M.NICK FROM BOARD B JOIN MEMBER M ON (B.WRITER_NO= M.NO) WHERE B.STATUS = 'O' ORDER BY B.NO DESC";
		String sql ="SELECT * FROM BOARD JOIN(SELECT NO AS M_NO, NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO WHERE STATUS = 'O' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		
		//rs
		while(rs.next()) {
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
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

}
