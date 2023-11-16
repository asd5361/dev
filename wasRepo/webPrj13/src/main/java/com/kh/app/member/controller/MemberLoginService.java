package com.kh.app.member.controller;

import java.sql.*;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberLoginService {

	public MemberVo login(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnetion();
		
		//dao
		MemberLoginDao dao = new MemberLoginDao();
		MemberVo loginMember = dao.login(conn,vo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

}
