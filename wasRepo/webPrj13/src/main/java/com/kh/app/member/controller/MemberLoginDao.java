package com.kh.app.member.controller;

import java.sql.*;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberLoginDao {

	public MemberVo login(Connection conn, MemberVo vo) throws SQLException {

		//sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		MemberVo loginMember = null;
		
		if(rs.next()) {
			loginMember = new MemberVo();
			
			String id = rs.getString("ID");
			loginMember.setMemberId(id);
			String pwd = rs.getString("PWD");
			loginMember.setMemberPwd(pwd);
			String nick = rs.getString("NICK");
			loginMember.setMemberNick(nick);

		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}

}
