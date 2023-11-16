package com.kh.app.member.service;

import java.sql.*;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberJoinService {

	public int join(MemberVo vo) throws Exception {

		//business logic
		
		//아이디 4글자 미만
		if(vo.getMemberId().length() < 4) {
			throw new Exception("[ERROR-M002] 아이디 글자 수 에러");
		}
		//비번 일치 여부
		if(!vo.getMemberPwd().equals(vo.getMemberPWd2())) {
			throw new Exception("[ERROR-M003] 비밀번호 에러");
		}
		//비번 4글자 미만
		if(vo.getMemberPwd().length() < 4) {
			throw new Exception("[ERROR-M004] 비밀번호 글자 수 에러");
		}
		//닉네임에 관리자 불가능
		if(vo.getMemberNick().contains("관리자")
			||
			vo.getMemberNick().toLowerCase().contains("admin")
			) {
			throw new Exception("[ERROR-M005] 닉네임 admin 입력 에러");
		}
		
		//conn
		Connection conn = JDBCTemplate.getConnetion();
		
		//dao
		MemberJoinDao dao = new MemberJoinDao();
		int result = dao.join(conn,vo);
		
		//rx
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
