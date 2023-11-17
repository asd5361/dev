package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberJoinDao;
import com.kh.app.member.vo.MemberVo;

public class MemberJoinService {

	public int join(MemberVo vo) throws Exception {
		//비즈니스 로직
		if(vo.getMemberId().length() < 4 || vo.getMemberPwd().length() <4) {
			throw new Exception("아이디 및 비밀번호 글자 수 문제");
		}
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호 불일치");
		}
		if(vo.getMemberNick().toLowerCase().contains("admin") || vo.getMemberNick().contains("관리자")) {
			
		}
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberJoinDao dao = new MemberJoinDao();
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

}
