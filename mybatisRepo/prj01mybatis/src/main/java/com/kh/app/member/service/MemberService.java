package com.kh.app.member.service;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {

	private MemberDao dao = new MemberDao();
	
	public MemberVo login(MemberVo vo) throws Exception {
		
		SqlSession session =  JDBCTemplate.getSqlSession();
		
		MemberVo loginVo = dao.login(session,vo);
		
		session.close();
		
		return loginVo;
	}

	public int memberInsert(MemberVo vo) throws Exception {
		
		SqlSession session = JDBCTemplate.getSqlSession();
		
		int result = dao.insert(session,vo);
		
		if(result == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		
		return result;
	}

}
