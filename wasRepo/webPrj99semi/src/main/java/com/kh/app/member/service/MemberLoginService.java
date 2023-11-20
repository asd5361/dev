package com.kh.app.member.service;

import java.sql.*;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemerLoginDao;
import com.kh.app.member.vo.MemberVo;

public class MemberLoginService {

	public MemberVo login(MemberVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemerLoginDao dao = new MemerLoginDao();
		MemberVo loginVo = dao.login(conn,vo);
		
		JDBCTemplate.close(conn);
		
		return loginVo;
	}

}
