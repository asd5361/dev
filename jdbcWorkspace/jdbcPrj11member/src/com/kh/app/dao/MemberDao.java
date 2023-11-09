package com.kh.app.dao;

import java.sql.*;
import java.util.*;

import com.kh.app.jdbc.JDBCTemplate;
import com.kh.app.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception {
		
		//SQL
		String sql = "INSERT INTO MEMBER (ID,PWD) VALUES (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception{

		//SQL
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs =pstmt.executeQuery();

		//rs
		MemberVo dbVo = null;
		
		if(rs.next()) {
			String dbid = rs.getString("ID");
			String dbpwd = rs.getString("PWD");
			dbVo = new MemberVo();
			dbVo.setId(dbid);
			dbVo.setPwd(dbpwd);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbVo;
	}

	public ArrayList<MemberVo> getMemberList(Connection conn) throws Exception {

		//SQL
		String sql = "SELECT * FROM MEMBER ORDER BY UPPER(ID)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		ArrayList<MemberVo> voList = new ArrayList<MemberVo>();
		while(rs.next()) {
			String dbId = rs.getString("ID");
			String dbPwd = rs.getString("PWD");
			
			MemberVo dbVo = new MemberVo();
			dbVo.setId(dbId);
			dbVo.setPwd(dbPwd);
			
			voList.add(dbVo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}
	
	
}
