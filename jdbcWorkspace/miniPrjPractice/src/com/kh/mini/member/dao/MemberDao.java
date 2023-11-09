package com.kh.mini.member.dao;

import java.sql.*;
import java.util.*;

import com.kh.mini.Trade.vo.TradeVo;
import com.kh.mini.jdbc.JDBCTemplate;
import com.kh.mini.member.vo.MemberVo;

import oracle.jdbc.proxy.annotation.Pre;

public class MemberDao {


	//회원가입
	public int join(Connection conn, MemberVo vo) throws Exception{
		
		String sql = "INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS)"
				+ "VALUES (SEQ_MEMBER.NEXTVAL,?,UPPER(?),?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAreasCode());
		pstmt.setString(2, vo.getId());
		pstmt.setString(3, vo.getPwd());
		pstmt.setString(4, vo.getNick());
		pstmt.setString(5, vo.getName());
		pstmt.setString(6, vo.getEmail());
		pstmt.setString(7, vo.getPhone());
		pstmt.setString(8, vo.getAddress());
		
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//회원가입에 쓸 주소 -> 동네코드 추출 (예)서울시강남구신사동 -> 신사동
	public String codeMake(Connection conn, String address) throws Exception{
		int f = address.indexOf("구");
		int e = address.indexOf("동");
		String code = address.substring(f+1);
		String sql = "SELECT AREAS_CODE FROM AREAS WHERE AREAS_NAME LIKE ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, code);
		ResultSet rs = pstmt.executeQuery();
		String areasCode = null;
		if(rs.next()) {
			areasCode = rs.getString("AREAS_CODE");			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return areasCode;
	}
	//로그인
	public MemberVo login(Connection conn, MemberVo vo) throws Exception{
		String sql = "SELECT * FROM MEMBER JOIN AREAS USING(AREAS_CODE) WHERE ID = UPPER(?) AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		MemberVo userVo= null;
		if(rs.next()) {
			userVo = new MemberVo();
			userVo.setMemberNo(rs.getString("MEMBER_NO"));
			userVo.setAreasCode(rs.getString("AREAS_CODE"));
			userVo.setAreasName(rs.getString("AREAS_NAME"));
			userVo.setId(rs.getString("ID"));
			userVo.setPwd(rs.getString("PWD"));
			userVo.setNick(rs.getString("NICK"));
			userVo.setName(rs.getString("NAME"));
			userVo.setEmail(rs.getString("EMAIL"));
			userVo.setPhone(rs.getString("PHONE"));
			userVo.setAddress(rs.getString("ADDRESS"));
			userVo.setJoinDate(rs.getString("JOIN_DATE"));
			userVo.setEditDate(rs.getString("EDIT_DATE"));
		}
		JDBCTemplate.close(pstmt);
		
		return userVo;
	}
	//회원탈퇴
	public int quit(Connection conn,String no) throws Exception{
		
		String sql = "UPDATE MEMBER SET QUIT_YN = 'Y' WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//비밀번호 변경
	public int changePwd(Connection conn, HashMap<String, String> map) throws Exception{
		
		String sql = "UPDATE MEMBER SET PWD = ? WHERE MEMBER_NO = ? AND PWD = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, map.get("newPwd"));
		pstmt.setString(2, map.get("memberNo"));
		pstmt.setString(3, map.get("oldPwd"));
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}
	//닉네임 변경
	public int changeNick(Connection conn, MemberVo vo) throws Exception{
		
		String sql ="UPDATE MEMBER SET NICK = ? WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNick());
		pstmt.setString(2, vo.getMemberNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//주소 변경
	public int changeAddress(Connection conn, MemberVo vo) throws Exception{
		String sql ="UPDATE MEMBER SET ADDRESS = ? WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAddress());
		pstmt.setString(2, vo.getMemberNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//전화번호 변경
	public int changePhone(Connection conn, MemberVo vo)  throws Exception{
		String sql ="UPDATE MEMBER SET PHONE = ? WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPhone());
		pstmt.setString(2, vo.getMemberNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//구매목록조회
	public List<TradeVo> purchaseList(Connection conn, String no) throws Exception{
		String sql ="SELECT H.PURCHASE_NO ,TO_CHAR(H.ENROLL_DATE,'YYYY-MM-DD') AS  ENROLL_DATE ,M.NICK ,T.TRADE_AREAS ,T.PRODUCT ,T.PRICE "
				+ "FROM PURCHASE_HISTORY H JOIN MEMBER M ON H.BUYER_NO = M.MEMBER_NO JOIN TRADE T USING (BOARD_NO) WHERE M.MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		List<TradeVo> voList = new ArrayList<TradeVo>();
		while(rs.next()) {
			TradeVo vo = new TradeVo();
			vo.setPurchaseNo(rs.getString("PURCHASE_NO"));
			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
			vo.setMemberNick(rs.getString("NICK"));
			vo.setTradeAreas(rs.getString("TRADE_AREAS"));
			vo.setProduct(rs.getString("PRODUCT"));
			vo.setPrice(rs.getString("PRICE"));
			voList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}
	//관심 목록 
	public List<TradeVo> wishList(Connection conn, String no) throws Exception{
		String sql ="SELECT BOARD_NO, COMPLETE_YN, TITLE, PRODUCT, PRICE "
				+ "FROM WISHLIST W JOIN MEMBER M ON M.MEMBER_NO = W.MEMBER_NO JOIN TRADE T USING (BOARD_NO) "
				+ "WHERE M.MEMBER_NO = ? ORDER BY WISHLIST_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		List<TradeVo> voList = new ArrayList<TradeVo>();
		while(rs.next()) {
			TradeVo vo = new TradeVo();
			vo.setBoardNo(rs.getString("BOARD_NO"));
			vo.setCompleteYn(rs.getString("COMPLETE_YN"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setProduct(rs.getString("PRODUCT"));
			vo.setPrice(rs.getString("PRICE"));
			voList.add(vo);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}
	//관심목록 지우기
	public int wishDelete(Connection conn, String memberNo, String boardNo) throws Exception{
		String sql = "DELETE FROM WISHLIST WHERE BOARD_NO = ? AND MEMBER_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,boardNo);
		pstmt.setString(2, memberNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//매너온도 조회
	public String score(Connection conn, String no) throws Exception{
		String sql = "SELECT SUM(SCORE) AS SCORE FROM REVIEW R JOIN purchase_history H USING (purchase_no) "
				+ "JOIN TRADE T ON T.BOARD_NO = H.BOARD_NO WHERE T.MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		String score = null;
		if(rs.next()) {
			score = rs.getString("SCORE");
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return score;
	}

}
