package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.app.member.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

import oracle.jdbc.proxy.annotation.Pre;

public class MemberDao {
	

	public int join(Connection conn, MemberVo vo) throws Exception{
		
		//sql
		String sql = "INSERT INTO J_MEMBER (MEMBER_NO,ID,PWD,NICK,QUIT_YN) VALUES(NVL((SELECT J.MEMBER_NO FROM J_MEMBER J WHERE ROWNUM = 1), 0) + 1,?,?,?,'N')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();
		
		//rs
		
		//close
		JDBCTemplate.Close(pstmt);
		
		return result;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		//sql
		String sql = "SELECT * FROM J_MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo dbVo = null;
		//rs
		if(rs.next()) {
			String no = rs.getString("MEMBER_NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String quti = rs.getString("QUIT_YN");
			
			dbVo = new MemberVo();
			dbVo.setNo(no);
			dbVo.setId(id);
			dbVo.setPwd(pwd);
			dbVo.setNick(nick);
			dbVo.setQuit(quti);
			
		}
		
		//close
		JDBCTemplate.Close(rs);
		JDBCTemplate.Close(pstmt);
		
		return dbVo;
	}

	public ArrayList<MemberVo> getMemberList(Connection conn) throws Exception{
		//sql
		String sql = "SELECT * FROM J_MEMBER WHERE QUIT_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<MemberVo> memberList = new ArrayList<MemberVo>();
		//rs
		while(rs.next()) {
			MemberVo vo = new MemberVo();
			vo.setNo(rs.getString("MEMBER_NO"));
			vo.setId(rs.getString("ID"));
			vo.setNick(rs.getString("NICK"));
			memberList.add(vo);
		}
		//close
		JDBCTemplate.Close(rs);
		JDBCTemplate.Close(pstmt);
		
		return memberList;
	}

	

}
