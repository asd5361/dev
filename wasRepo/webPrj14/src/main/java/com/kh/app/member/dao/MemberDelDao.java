package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDelDao {

	public int del(Connection conn, MemberVo vo) throws SQLException {
		//sql
		String sql ="UPDATE MEMBER SET DEL_YN = 'Y' WHERE ID= ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		int result = pstmt.executeUpdate();
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
