package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemerLoginDao {

	public MemberVo login(Connection conn, MemberVo vo) throws SQLException {
		
		String sql ="SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo loginVo = null;
		
		if(rs.next()) {
			loginVo = new MemberVo();
			
			loginVo.setMemberId(rs.getString("ID"));
			loginVo.setMemberPwd(rs.getString("PWD"));
			loginVo.setMemberNick(rs.getString("NICK"));
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginVo;
	}

}
