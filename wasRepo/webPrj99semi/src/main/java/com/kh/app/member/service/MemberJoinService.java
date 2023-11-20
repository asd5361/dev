package com.kh.app.member.service;

import java.sql.*;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberJoinDao;
import com.kh.app.member.vo.MemberVo;

public class MemberJoinService {

	public int join(MemberVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberJoinDao dao = new MemberJoinDao();
		int result = dao.join(conn,vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

}
