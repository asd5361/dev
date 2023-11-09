package com.cherry.manager.dao;

import java.sql.*;
import java.util.*;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.manager.vo.ManagerVo;
import com.cherry.member.vo.MemberVo;

import oracle.jdbc.proxy.annotation.Pre;

public class ManagerDao {

	public ManagerVo loginManager(Connection conn, ManagerVo vo) throws Exception{
		String sql = "SELECT * FROM MANAGER WHERE MANAGER_ID = UPPER(?) AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getManagerId());
		pstmt.setString(2, vo.getPwd());
		
		ResultSet rs = pstmt.executeQuery();
		ManagerVo managerVo = null;
		if(rs.next()) {
			managerVo = new ManagerVo();
			managerVo.setManagerNo(rs.getString("MANAGER_NO"));
			managerVo.setManagerId(rs.getString("MANAGER_ID"));
			managerVo.setPwd(rs.getString("PWD"));
			managerVo.setName(rs.getString("NAME"));
			managerVo.setJoinDate(rs.getString("JOIN_DATE"));
			managerVo.setQuitYn(rs.getString("QUIT_YN"));
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return managerVo;
	}

	public List<MemberVo> userList(Connection conn) throws Exception{
//		String sql = "SELECT MEMBER_NO ,AREAS_NAME ,ID ,PWD ,NICK ,NAME ,EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE ,QUIT_YN FROM MEMBER JOIN AREAS USING (AREAS_CODE) ORDER BY MEMBER_NO";
//		String sql = "SELECT "
//				+ "LPAD(MEMBER_NO,4,'　') AS MEMBER_NO "
//				+ ",LPAD(AREAS_NAME,8,'　') AS AREAS_NAME"
//				+ ",LPAD(ID,6,'　') AS ID "
//				+ ",PWD "
//				+ ",NICK "
//				+ ",LPAD(NAME,8,'　') AS NAME "
//				+ ",LPAD(EMAIL,12,'　') AS EMAIL "
//				+ ",PHONE "
//				+ ",ADDRESS "
//				+ ",TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS JOIN_DATE "
//				+ ",TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE "
//				+ ",QUIT_YN "
//				+ "FROM MEMBER JOIN AREAS USING (AREAS_CODE) ORDER BY MEMBER_NO";
		
		String sql = "SELECT LPAD(MEMBER_NO,4,'　') AS MEMBER_NO ,LPAD(AREAS_NAME,8,'　') AS AREAS_NAME ,LPAD(ID,6,'　') AS ID ,PWD ,NICK ,LPAD(NAME,8,'　') AS NAME ,LPAD(EMAIL,12,'　') AS EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일\"') AS EDIT_DATE ,QUIT_YN FROM MEMBER JOIN AREAS USING (AREAS_CODE) ORDER BY MEMBER_NO";
		
//		LPAD(EMAIL,14,'　') AS EMAIL
		
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<MemberVo> userList = new ArrayList<MemberVo>();;
		
		while(rs.next()) {
			MemberVo vo = new MemberVo();
			vo.setMemberNo(rs.getString("MEMBER_NO"));
			vo.setAreasName(rs.getString("AREAS_NAME"));
			vo.setId(rs.getString("ID"));
			vo.setPwd(rs.getString("PWD"));
			vo.setNick(rs.getString("NICK"));
			vo.setName(rs.getString("NAME"));
			vo.setEmail(rs.getString("EMAIL"));
			vo.setPhone(rs.getString("PHONE"));
			vo.setAddress(rs.getString("ADDRESS"));
			vo.setJoinDate(rs.getString("JOIN_DATE"));
			vo.setEditDate(rs.getString("EDIT_DATE"));
			vo.setQuitYn(rs.getString("QUIT_YN"));
			userList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return userList;
	}

	public List<MemberVo> userDetile(Connection conn, String userChoice,String num) throws Exception{
		String sql = null;
		switch(num) {
//		case "1" : sql ="SELECT MEMBER_NO ,AREAS_NAME ,ID ,PWD ,NICK ,NAME ,EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS EDIT_DATE ,QUIT_YN FROM MEMBER JOIN AREAS USING (AREAS_CODE) WHERE MEMBER_NO = ? ORDER BY MEMBER_NO"; break;
//		case "2" : sql ="SELECT MEMBER_NO ,AREAS_NAME ,ID ,PWD ,NICK ,NAME ,EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS EDIT_DATE ,QUIT_YN FROM MEMBER JOIN AREAS USING (AREAS_CODE) WHERE ID LIKE '%'||UPPER(?)||'%' ORDER BY ID, MEMBER_NO"; break;
//		case "3" : sql ="SELECT MEMBER_NO ,AREAS_NAME ,ID ,PWD ,NICK ,NAME ,EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS EDIT_DATE ,QUIT_YN FROM MEMBER JOIN AREAS USING (AREAS_CODE) WHERE NICK LIKE '%'||?||'%' ORDER BY NICK, MEMBER_NO"; break;
		case "1" : sql ="SELECT LPAD(MEMBER_NO,4,' ') AS MEMBER_NO ,LPAD(AREAS_NAME,8,' ') AS AREAS_NAME ,LPAD(ID,6,' ') AS ID ,PWD ,NICK ,LPAD(NAME,8,' ') AS NAME ,LPAD(EMAIL,12,' ') AS EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS EDIT_DATE ,QUIT_YN FROM MEMBER JOIN AREAS USING (AREAS_CODE) WHERE MEMBER_NO = ? ORDER BY MEMBER_NO"; break;
		case "2" : sql ="SELECT LPAD(MEMBER_NO,4,' ') AS MEMBER_NO ,LPAD(AREAS_NAME,8,' ') AS AREAS_NAME ,LPAD(ID,6,' ') AS ID ,PWD ,NICK ,LPAD(NAME,8,' ') AS NAME ,LPAD(EMAIL,12,' ') AS EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS EDIT_DATE ,QUIT_YN FROM MEMBER JOIN AREAS USING (AREAS_CODE) WHERE ID LIKE '%'||UPPER(?)||'%' ORDER BY ID, MEMBER_NO"; break;
		case "3" : sql ="SELECT LPAD(MEMBER_NO,4,' ') AS MEMBER_NO ,LPAD(AREAS_NAME,8,' ') AS AREAS_NAME ,LPAD(ID,6,' ') AS ID ,PWD ,NICK ,LPAD(NAME,8,' ') AS NAME ,LPAD(EMAIL,12,' ') AS EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS EDIT_DATE ,QUIT_YN FROM MEMBER JOIN AREAS USING (AREAS_CODE) WHERE NICK LIKE '%'||?||'%' ORDER BY NICK, MEMBER_NO"; break;
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,userChoice);
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<MemberVo> voList = new ArrayList<MemberVo>();
		while(rs.next()) {
			MemberVo vo = new MemberVo();
			vo.setMemberNo(rs.getString("MEMBER_NO"));
			vo.setAreasName(rs.getString("AREAS_NAME"));
			vo.setId(rs.getString("ID"));
			vo.setPwd(rs.getString("PWD"));
			vo.setNick(rs.getString("NICK"));
			vo.setName(rs.getString("NAME"));
			vo.setEmail(rs.getString("EMAIL"));
			vo.setPhone(rs.getString("PHONE"));
			vo.setAddress(rs.getString("ADDRESS"));
			vo.setJoinDate(rs.getString("JOIN_DATE"));
			vo.setEditDate(rs.getString("EDIT_DATE"));
			vo.setQuitYn(rs.getString("QUIT_YN"));
			voList.add(vo);
		}
		
		return voList;
	}

	public int userKick(Connection conn, String userNo) throws Exception{
		String sql = "UPDATE MEMBER SET QUIT_YN = 'Y' WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

}
