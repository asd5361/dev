package com.kh.mini.member.service;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

import com.kh.jdbc.JDBCTemplate;
import com.kh.mini.main.Main;
import com.kh.mini.member.dao.MemberDao;
import com.kh.mini.member.vo.MemberVo;

public class MemberService {

	private final MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

	//회원가입
	public int join(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		int result = dao.join(conn,vo);
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//로그인
	public MemberVo login(MemberVo vo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberVo dbvo = dao.login(conn, vo);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbvo;
	}

	//회원탈퇴
	public int quit(String no) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		int result = dao.quit(conn, no);
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		return result;
	}

	//비밀번호 수정
	public int changePwd(HashMap<String, String> map) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		int result = dao.changePwd(conn,map);
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//닉네임 수정
	public int changeNick(MemberVo vo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		int result = dao.changeNick(conn,vo);
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}
	//강제 탈퇴 미완성
	public int adminQuit() {
		
		return 0;
	}
	//회원 전체 조회
	public List<MemberVo> memberList() throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		List<MemberVo> list = dao.memberList(conn);
		//close
		JDBCTemplate.close(conn);
		return list;
	}



	

}
