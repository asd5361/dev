package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.db.JDBCTemplate;

import oracle.jdbc.proxy.annotation.Pre;

public class BoardDao {

	public ArrayList<BoardVo> list(Connection conn) throws Exception{

		//sql
		String sql = "SELECT * FROM J_BOARD B JOIN J_MEMBER J ON J.MEMBER_NO = B.BOARD_NO WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//rs
		ResultSet rs = pstmt.executeQuery(); 
		ArrayList<BoardVo> boardList = new ArrayList<BoardVo>(); 
		while(rs.next()) {
			BoardVo vo = new BoardVo();
			vo.setNo(rs.getString("BOARD_NO"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setContent(rs.getString("CONTENT"));
			vo.setWriter(rs.getString("NICK"));
			vo.setDate(rs.getString("ENROLL_DATE"));
			vo.setDel(rs.getString("DEL_YN"));
			boardList.add(vo);
		}
		//close
		JDBCTemplate.Close(rs);
		JDBCTemplate.Close(pstmt);
		
		return boardList;
	}

	public int write(Connection conn,BoardVo vo) throws Exception{
		//sql
		String sql = "INSERT INTO J_BOARD (BOARD_NO,TITLE,CONTENT,WRITER_NO,ENROLL_DATE,DEL_YN) VALUES "
				+ "(SEQ_MEMBER.NEXTVAL,?,?,?,SYSDATE,'N')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,vo.getTitle());
		pstmt.setString(2,vo.getContent());
		pstmt.setString(3, vo.getWriter());
		int result = pstmt.executeUpdate();
		//rs
		
		//close
		return result;
	}

	public ArrayList<BoardVo> printDetail(Connection conn, String key) throws Exception{

		//sql
		String keyword = "%"+key + "%";
		String sql = "SELECT * FROM J_BOARD B JOIN J_MEMBER M ON M.MEMBER_NO = B.WRITER_NO WHERE TITLE LIKE ? OR CONTENT LIKE ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, keyword);
		pstmt.setString(2, keyword);
		
		//rs
		ResultSet rs=pstmt.executeQuery();
		ArrayList<BoardVo> boardList = new ArrayList<BoardVo>();
		while(rs.next()) {
			BoardVo vo = new BoardVo();
			vo.setNo(rs.getString("BOARD_NO"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setContent(rs.getString("CONTENT"));
			vo.setWriter(rs.getString("ID")); 
			vo.setDate(rs.getString("ENROLL_DATE"));
			vo.setDel(rs.getString("DEL_YN"));
			boardList.add(vo);
		}
		
		//close
		JDBCTemplate.Close(rs);
		JDBCTemplate.Close(pstmt);
		
		return boardList;
	}

	public int edit(Connection conn, BoardVo vo) throws Exception{
		
		//sql
		String sql;
		PreparedStatement pstmt;
		if(vo.getTitle()==null) {
			sql = "UPDATE J_BOARD SET CONTENT = ? WHERE BOARD_NO = ? AND DEL_YN = 'N'";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getNo());
		}else if(vo.getContent()==null) {
			sql = "UPDATE J_BOARD SET TITLE = ? WHERE BOARD_NO = ? AND DEL_YN = 'N'";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getNo());
		}else{
			sql = "UPDATE J_BOARD SET TITLE = ? ,CONTENT = ? WHERE BOARD_NO = ? AND DEL_YN = 'N'";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNo());
		}
		int result = pstmt.executeUpdate();
		//rs
		
		//close
		JDBCTemplate.Close(pstmt);
		
		return result;
	}

	public int delete(Connection conn, String num) throws Exception{
		//sql
		String sql = "UPDATE J_BOARD SET DEL_YN = 'Y' WHERE BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		int result = pstmt.executeUpdate();
		//rs
		
		//close
		JDBCTemplate.Close(pstmt);
		return result;
	}

}
