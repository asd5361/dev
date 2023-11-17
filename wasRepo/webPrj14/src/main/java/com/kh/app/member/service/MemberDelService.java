package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberDelDao;
import com.kh.app.member.vo.MemberVo;

public class MemberDelService {

	public int del(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDelDao dao = new MemberDelDao();
		int result = dao.del(conn,vo);
		
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

}
