package com.kh.app.member.service;

import java.sql.*;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {

	//회원가입
	public int join(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//business logic
		//아이디 4~12 영문소문자+ 숫자
		if(!vo.getMemberId().matches("[a-z0-9]{4,12}")) {
			throw new Exception("아이디 값 에러 발생");
		}
		//비밀번호 일치여부체크
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호 일치 에러 발생");
		}
		//비밀번호 4글자 이상
		if(vo.getMemberPwd().length()<4) {
			throw new Exception("비밀번호 글자 수 에러 발생");
		}
		//닉네임에 admin 글자
		if(vo.getMemberNick().toLowerCase().contains("admin")) {
			throw new Exception("닉네임 admin 포함 에러 발생");
		}
		//dao
		MemberDao dao = new MemberDao();
		int result = dao.join(conn,vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	//로그인
	public MemberVo login(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn,vo);
		
		//close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}	
	
}
