package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;

public class MemberJoinDao {

	public int join(Connection conn, MemberVo vo) throws SQLException {
		
		String sql = "INSERT INTO MEMBER (ID,PWD,NICK) VALUES (?,?,?) ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getMemberNick());
		
		int result = pstmt.executeUpdate();
		
		return result;
	}

}
