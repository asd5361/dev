package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	//회원가입
	public int join(Connection conn, MemberVo vo) throws SQLException {
		//sql
		String sql = "INSERT INTO MEMBER (NO,ID,PWD,NICK,PHONE,EMAIL,ADDRESS,HOBBYS) VALUES (SEQ_MEMBER_NO.NEXTVAL,?,?,?,?,?,?,?) ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getMemberNick());
		pstmt.setString(4, vo.getPhone());
		pstmt.setString(5, vo.getEmail());
		pstmt.setString(6, vo.getAddr());		
		pstmt.setString(7, vo.getHobbyStr());
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	//로그인
	public MemberVo login(Connection conn, MemberVo vo) throws SQLException {
		//sql
		String sql ="SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		MemberVo loginMember = null;
		if(rs.next()) {
			loginMember = new MemberVo();
			loginMember.setMemberNo(rs.getString("NO"));
			loginMember.setMemberId(rs.getString("ID"));
			loginMember.setMemberPwd(rs.getString("PWD"));
			loginMember.setMemberNick(rs.getString("NICK"));
			loginMember.setPhone(rs.getString("PHONE"));
			loginMember.setEmail(rs.getString("EMAIL"));
			loginMember.setAddr(rs.getString("ADDRESS"));
			loginMember.setHobbyStr(rs.getString("HOBBYS"));
			loginMember.setAddr(rs.getString("ENROLL_DATE"));
			loginMember.setAddr(rs.getString("MODIFY_DATE"));
			loginMember.setAddr(rs.getString("STATUS"));
			
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}
}
