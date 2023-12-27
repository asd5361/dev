package com.kh.app.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	
	public int join(MemberVo vo) throws Exception {
		
		String id = vo.getId();
		if(id.length() <4 ) {
			throw new Exception("아이디의 글자수가 너무 작습니다");
		}
		
		if("admin".equalsIgnoreCase(id)) {
			throw new Exception("사용 불가한 ID 입니다.");
		}
		
		return dao.join(sst,vo);
	}

	public MemberVo login(MemberVo vo) {
		return dao.login(sst,vo);
	}

	public int edit(MemberVo vo) {
		return dao.edit(sst,vo);
	}

	public int quit(MemberVo vo) {
		return dao.quit(sst,vo);
	}

	public List<MemberVo> list() {
		return dao.list(sst);
	}

}
