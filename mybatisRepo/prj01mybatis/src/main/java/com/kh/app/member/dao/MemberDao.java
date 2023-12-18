package com.kh.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	public MemberVo login(SqlSession session, MemberVo vo) {
		
		return session.selectOne("BoardMapper.loginMember",vo);
		
	}

	public int insert(SqlSession session, MemberVo vo) {
		
		return session.insert("BoardMapper.insertMember",vo);
	}

}
