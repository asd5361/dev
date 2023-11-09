package com.kh.mini.member.dao;

import java.sql.*;
import java.util.*;

import com.kh.jdbc.JDBCTemplate;
import com.kh.mini.member.vo.MemberVo;

public class MemberDao {

	//회원가입
	public int join(Connection conn, MemberVo vo) throws Exception {

		//sql
		String sql = "INSERT INTO MEMBER (NO,ID,PWD,NICK) VALUES (SEQ_MEMBER.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//로그인
	public MemberVo login(Connection conn, MemberVo vo) throws Exception{

		//sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo dbvo = null;
		//rs -> vo
		if(rs.next()) {
			dbvo = new MemberVo();
			dbvo.setNo(rs.getString("NO"));
			dbvo.setId(rs.getString("ID"));
			dbvo.setPwd(rs.getString("PWD"));
			dbvo.setNick(rs.getString("NICK"));
			dbvo.setEnrollDate(rs.getString("ENROLL_DATE"));
			dbvo.setModifyDate(rs.getString("MODIFY_DATE"));
			dbvo.setDelYn(rs.getString("DEL_YN"));
		}

		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbvo;
	}

	//회원탈퇴
	public int quit(Connection conn, String no) throws Exception{
		//sql
		String sql = "UPDATE MEMBER SET DEL_YN = 'Y', MODIFY_DATE = SYSDATE WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//비밀번호 수정
	public int changePwd(Connection conn, HashMap<String, String> map) throws Exception{
		//sql
		String sql = "UPDATE MEMBER SET PWD = ? WHERE NO = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, map.get("newPwd"));
		pstmt.setString(2, map.get("no"));
		pstmt.setString(3, map.get("oldPwd"));
		int result = pstmt.executeUpdate();
		
		//cloes
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//닉네임 수정
	public int changeNick(Connection conn, MemberVo vo) throws Exception{
		//sql
		String sql = "UPDATE MEMBER SET NICK = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNick());
		pstmt.setString(2, vo.getNo());
		int result = pstmt.executeUpdate();
		
		//cloes
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//회원 전체 조회
	public List<MemberVo> memberList(Connection conn) throws Exception{
		//SQL
		String sql = "SELECT ID, NICK, ENROLL_DATE, MODIFY_DATE, DEL_YN FROM MEMBER";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo =null;
		while(rs.next()) {
			vo = new MemberVo();
			vo.setId(rs.getString("ID"));
			vo.setNick(rs.getString("NICK"));
			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
			vo.setModifyDate(rs.getString("MODIFY_DATE"));
			vo.setDelYn(rs.getString("DEL_YN"));
			
			list.add(vo);
		}
		//rs
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		//close
		return list;
	}

	

}
