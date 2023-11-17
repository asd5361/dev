package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberLoginDao;
import com.kh.app.member.vo.MemberVo;

public class MemberLoginService {

	public MemberVo login(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberLoginDao dao = new MemberLoginDao();
		MemberVo memberVo = dao.login(conn,vo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return memberVo;
	}

}
