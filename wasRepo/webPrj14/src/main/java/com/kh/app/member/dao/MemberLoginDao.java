package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberLoginDao {

	public MemberVo login(Connection conn, MemberVo vo) throws SQLException {
		
		//sql
		String sql="SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		MemberVo memberVo = null;
		if(rs.next()) {
			memberVo = new MemberVo();
			memberVo.setMemberId(rs.getString("ID"));
			memberVo.setMemberPwd(rs.getString("PWd"));
			memberVo.setMemberNick(rs.getString("NICK"));
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return memberVo;
	}

}
