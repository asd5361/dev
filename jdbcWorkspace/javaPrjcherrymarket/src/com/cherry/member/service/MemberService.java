package com.cherry.member.service;

import java.sql.*;
import java.util.*;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.member.dao.MemberDao;
import com.cherry.member.vo.MemberVo;
import com.cherry.trade.vo.TradeVo;

public class MemberService {
	
	private final MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

	public int join(MemberVo vo) throws Exception{				// 주석 달기 : 예외 controller 로 던지는 것으로 예외 처리
		
		Connection conn = JDBCTemplate.getConnection();			// 주석 달기 : JDBCTmeplate 클래스의 getConnection()를 통해 Connection 타입의 conn 객체를 선언
		
		String code = dao.codeMake(conn,vo.getAddress());		//주석 달기 : dao 클래스의 conn 변수,Address 값을 넣은 vo변수를 담아서 codeMak() 메소드를 실행한 후 리턴값을 e문자열 타입의 code에 담기
		if(code == null) {												
			throw new Exception("주소를 잘못 입력하셨습니다. 다시 입력해주세요");		//주석 달기 : code 변수가 null값이면 예외 발생, 주소 값에 문제가 생겼을 경
		}
		vo.setAreasCode(code);									//주석 달기 : vo객체의 동네코드에 code 변수 값 (회원의 주소를 이용해 찾은 동네코드) set 하기
		int result = dao.join(conn,vo);							//주석 달기 : int result 변수에 dao 클래스의 join() 메소드 변환값 대입하기 , conn 객체와 vo 객체 매개변수로 지정
		
		if(result == 1) {										//주석 달기 : result 값이 1이면(1일 경우 dao에서 insert가 정상 처리된 것이다.) commit진행 아니면 rollback
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);								//주석 달기 : conn 객체 사용이 다 끝나서 close 시킴 (객체 반납)
		
		return result;											//주석 달기 : result 값 반환 (호출한 controller 한테 줌)
	}


	public MemberVo login(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		MemberVo userdb = dao.login(conn,vo);
		
		JDBCTemplate.close(conn);
		return userdb;
	}

	public int quit(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.quit(conn,no);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int changePwd(HashMap<String, String> map) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changePwd(conn,map);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	public int changeNick(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeNick(conn,vo);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int changeAddress(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		String code = dao.codeMake(conn,vo.getAddress());
		if(code == null) {
			throw new Exception("주소를 잘못 입력하셨습니다. 다시 입력해주세요");
		}
		vo.setAreasCode(code);
		int result = dao.changeAddress(conn,vo);
		vo = dao.login(conn,vo);
		Main.loginMember.setAreasName(vo.getAreasName());
		
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int changePhone(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changePhone(conn,vo);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<TradeVo> purchaseList(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		List<TradeVo> voList = dao.purchaseList(conn,no);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public List<TradeVo> wishList(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		List<TradeVo> voList = dao.wishList(conn,no);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public int wishDelete(String memberNo, String boardNo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.wishDelete(conn,memberNo,boardNo);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public String score(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		String score = dao.score(conn,no);
		
		JDBCTemplate.close(conn);
		
		return score;
	}

	public String findId(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		String userId = dao.findId(conn,vo);
		
		JDBCTemplate.close(conn);
		
		return userId;
	}

	public String findPwd(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		MemberVo userVo = dao.findPwd(conn,vo);
		if(userVo == null) {
			throw new Exception("값을 잘못 입력하셨습니다. 다시 시도해주세요");
		}
		
		int result = dao.pwdReset(conn,userVo);
		String newPwd = null;
		
		if(result == 1) {
			newPwd = dao.newPwd(conn,userVo);
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return newPwd;
	}

	public int writeReview(String purchaseNo,String manner, String content) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.writeReview(purchaseNo, manner, content, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public String ReviewValidation(String purchaseNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String rv = dao.ReviewValidation(purchaseNo, conn);
		
		JDBCTemplate.close(conn);
		
		return rv;
	}
}
