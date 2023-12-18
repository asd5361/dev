package com.kh.app.board.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.util.JDBCTemplate;

public class BoardDao {

	public List<BoardVo> boardList(SqlSession ss) throws SQLException {
		
		return ss.selectList("BoardMapper.selectBoardList");
		
//		String sql = "SELECT * FROM BOARD_TEMP";
//		PreparedStatement pstmt = ss.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		
//		List<BoardVo> boardVoList = new ArrayList();
//		while(rs.next()) {
//			BoardVo vo = new BoardVo();
//			vo.setTitle(rs.getString("TITLE"));
//			vo.setContent(rs.getString("CONTENT"));
//			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
//			boardVoList.add(vo); 
//		}
//		
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(pstmt);
//		
//		return boardVoList;
	}

	public int boardWrite(SqlSession ss, BoardVo vo) throws SQLException {
		
		return ss.insert("BoardMapper.insertBoard",vo);
		
//		String sql = "INSERT INTO BOARD_TEMP (TITLE,CONTENT) VALUES (?,?)";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		
//		pstmt.setString(1,vo.getTitle());
//		pstmt.setString(2,vo.getContent());
//		
//		int result = pstmt.executeUpdate();
//		
//		JDBCTemplate.close(pstmt);
//		
//		return result;
	}

}
