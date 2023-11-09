package com.cherry.member.dao;

import java.sql.*;
import java.util.*;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.member.vo.MemberVo;
import com.cherry.trade.vo.TradeVo;

import oracle.jdbc.proxy.annotation.Pre;

public class MemberDao {


	//회원가입
	public int join(Connection conn, MemberVo vo) throws Exception{			//주석 달기 : 예외 발생 시 호출한 service 한테 던짐
		
		String sql = "INSERT INTO MEMBER(MEMBER_NO,AREAS_CODE,ID,PWD,NICK,NAME,EMAIL,PHONE,ADDRESS)"
				+ "VALUES (SEQ_MEMBER.NEXTVAL,?,UPPER(?),?,?,?,?,?,?)";		//주석 달기 : sql 변수에 sql문 대입 (sql insert문 실행 )	
		PreparedStatement pstmt = conn.prepareStatement(sql);				//주석 달기 : preparedStatement 객체를 생성해서 conn객체의 prepareStatment()메소드 실행 (sql문 담아서)
		pstmt.setString(1, vo.getAreasCode());
		pstmt.setString(2, vo.getId());
		pstmt.setString(3, vo.getPwd());
		pstmt.setString(4, vo.getNick());
		pstmt.setString(5, vo.getName());
		pstmt.setString(6, vo.getEmail());
		pstmt.setString(7, vo.getPhone());
		pstmt.setString(8, vo.getAddress());								//주석 달기 : psmtm객체의 setString() 메소드 실행, 각 번째의 ? 위치에 vo객체의 각 변수 대입
		
		int result = pstmt.executeUpdate();									//주석 달기 : ResultSet 객체 생성해서 psmtm.excuteQuery() 메소드 실행해서 대입. sql쿼리문 출력한 테이블 호출
		JDBCTemplate.close(pstmt);											//주석 달기 : 사용을 마친 pstmt 객체 close로 돌려주기
		
		return result;														//주석 달기 : result 변수를 반환 (호출한 service에 result 값 반환함)
	}
	//회원가입에 쓸 주소 -> 동네코드 추출 (예)서울시강남구신사동 -> 신사동
	public String codeMake(Connection conn, String address) throws Exception{	//주석 달기 : 예외 발생 시 호출한 service 한테 던짐
		int f = address.indexOf("구");											//주석 달기 : 파라미터로 받은 주소에서 '구' 가 적힌 위치 번호를 f 변수에 대입함
		int e = address.indexOf("동");											//주석 달기 : 파차미터로 받은 주소에서 '동' 이 적힌 위치 번호 를 e 변수에 대입함
		String code = address.substring(f+1);									//주석 달기 : 주소의 구위치 +1 부터의 문자열을 잘라서 code 변수에 대입
		String sql = "SELECT AREAS_CODE FROM AREAS WHERE AREAS_NAME LIKE ?";	//주석 달기 : sql 변수에 sql문 대입 ( 동네코드를 주소 이름에 맞게 출력)	
		PreparedStatement pstmt = conn.prepareStatement(sql);					//주석 달기 : preparedStatement 객체를 생성해서 conn객체의 prepareStatment()메소드 실행 (sql문 담아서)
		pstmt.setString(1, code);												//주석 달기 : psmtm객체의 setString() 메소드 실행, 1번째 ? 위치에 code 변수 대입
		ResultSet rs = pstmt.executeQuery();									//주석 달기 : ResultSet 객체 생성해서 psmtm.excuteQuery() 메소드 실행해서 대입. sql쿼리문 출력한 테이블 호출
		String areasCode = null;												//주석 달기 : 동네 코드를 담을 변수를 선언하고 null값 대입 ( 값의 유무를 따질 때 null 값으로 구분하기 위해)
		if(rs.next()) {															//주석 달기 : rs객체의 next() 실행했을 때 값이 있으면 rs객체의 getString()메소드를 실행하여 동네코드 칼럼의 값을 동네코드 변수의 대입 
			areasCode = rs.getString("AREAS_CODE");			
		}
		JDBCTemplate.close(rs);													//주석 달기 : 사용을 마친 rs 객체 close로 돌려주기
		JDBCTemplate.close(pstmt);												//주석 달기 : 사용을 마친 pstmt 객체 close로 돌려주기
		
		return areasCode;														//주석 달기 : 동네코드 변수를 반환 (호출한 service에 areasCode 값 반환함)
	}
	//로그인
	public MemberVo login(Connection conn, MemberVo vo) throws Exception{
		String sql = "SELECT MEMBER_NO ,AREAS_CODE ,AREAS_NAME ,ID ,PWD ,NICK ,NAME ,EMAIL ,PHONE ,ADDRESS ,TO_CHAR(JOIN_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS JOIN_DATE ,TO_CHAR(EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS EDIT_DATE "
				+ "FROM MEMBER JOIN AREAS USING(AREAS_CODE) WHERE ID = UPPER(?) AND PWD = ? AND QUIT_YN = 'N'";
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
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return userVo;
	}
	//회원탈퇴
	public int quit(Connection conn,String no) throws Exception{
		
		String sql = "UPDATE MEMBER SET QUIT_YN = 'Y', EDIT_DATE = SYSDATE WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//비밀번호 변경
	public int changePwd(Connection conn, HashMap<String, String> map) throws Exception{
		
		String sql = "UPDATE MEMBER SET PWD = ?, EDIT_DATE = SYSDATE WHERE MEMBER_NO = ? AND PWD = ?";
		
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
		
		String sql ="UPDATE MEMBER SET NICK = ?, EDIT_DATE = SYSDATE WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNick());
		pstmt.setString(2, vo.getMemberNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//주소 변경
	public int changeAddress(Connection conn, MemberVo vo) throws Exception{
		String sql ="UPDATE MEMBER SET ADDRESS = ?, AREAS_CODE = ?, EDIT_DATE = SYSDATE WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAddress());
		pstmt.setString(2, vo.getAreasCode());
		pstmt.setString(3, vo.getMemberNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//전화번호 변경
	public int changePhone(Connection conn, MemberVo vo)  throws Exception{
		String sql ="UPDATE MEMBER SET PHONE = ?, EDIT_DATE = SYSDATE WHERE MEMBER_NO = ?";
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
		String sql = "SELECT SUM(SCORE)+36 AS SCORE FROM REVIEW R JOIN purchase_history H USING (purchase_no) "
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
	//아이디찾기
	public String findId(Connection conn, MemberVo vo) throws Exception{
		String sql = "SELECT ID FROM MEMBER WHERE NAME = ? AND EMAIL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getEmail());
		ResultSet rs = pstmt.executeQuery();
		String userId = null;
		if(rs.next()) {
			userId = rs.getString("ID");
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return userId;
	}
	//비밀번호 찾기
	public MemberVo findPwd(Connection conn, MemberVo vo) throws Exception{
		String sql = "SELECT MEMBER_NO,PWD FROM MEMBER WHERE NAME = ? AND ID = UPPER(?) AND PHONE = ?";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getId());
		pstmt.setString(3, vo.getPhone());
		ResultSet rs =pstmt.executeQuery();
		MemberVo userVo =null;
		if(rs.next()) {
			userVo = new MemberVo();
			userVo.setMemberNo(rs.getString("MEMBER_NO"));
			userVo.setPwd(rs.getString("PWD"));
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return userVo;
	}
	// findPwd() -> pwdReset()
	public int pwdReset(Connection conn, MemberVo userVo) throws Exception {
		String sql="UPDATE MEMBER SET PWD = '1Q2W3E4R', EDIT_DATE = SYSDATE WHERE MEMBER_NO = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userVo.getMemberNo());
		pstmt.setString(2, userVo.getPwd());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//findPwd() -> pwdReset() -> newPwd()
	public String newPwd(Connection conn, MemberVo userVo) throws Exception{
		String sql="SELECT PWD FROM MEMBER WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userVo.getMemberNo());
		ResultSet rs = pstmt.executeQuery();
		String newPwd = null;
		if(rs.next()) {
			newPwd = rs.getString("PWD");
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return newPwd;
	}

	public int writeReview(String purchaseNo, String manner, String content, Connection conn) throws Exception {

		String sql = "INSERT INTO REVIEW(REVIEW_NO, PURCHASE_NO, SCORE, CONTENT) VALUES(SEQ_REVIEW_NO.NEXTVAL, ?, ?, ?) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, purchaseNo);
		switch(manner) {
			case "1" : pstmt.setString(2, "1"); break;
			case "2" : pstmt.setString(2, "0"); break;
			case "3" : pstmt.setString(2, "-1"); break;
		}
		pstmt.setString(3, content);

		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	public String ReviewValidation(String purchaseNo, Connection conn) throws Exception {
		
		String sql = "SELECT BUYER_NO FROM PURCHASE_HISTORY WHERE PURCHASE_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, purchaseNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		String rv = null;
		
		if(rs.next()) {
			rv = rs.getString("BUYER_NO");
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return rv;
	}

}
