package com.kh.app.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	private final MemberDao dao;
	
	public MemberService() {
		dao =new MemberDao();
	}

	public int join(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.join(conn,vo);
		//tx
		if(result == 1) {
			JDBCTemplate.Commit(conn);
		}else {
			JDBCTemplate.Rollback(conn);
		}
		//close
		JDBCTemplate.Close(conn);
		return result;
	}
	
	public MemberVo login(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		MemberVo dbVo = dao.login(conn,vo);
		
		//close
		JDBCTemplate.Close(conn);
		
		return dbVo;

	}

	public ArrayList<MemberVo> getMemberList() throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		ArrayList<MemberVo> memberList = dao.getMemberList(conn);
		
		//tx
		
		//close
		JDBCTemplate.Close(conn);
		
		return memberList;
	}



}
