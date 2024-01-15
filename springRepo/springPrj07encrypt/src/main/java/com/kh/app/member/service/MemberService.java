package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberDao dao;
	private final SqlSessionTemplate sst;
	private final BCryptPasswordEncoder encoder;
	
	//회원가입 service
	public int join(MemberVo vo) {
		
		//vo에 담긴 pwd 를 암호화 하여서 저장할 것
		String newPwd = encoder.encode(vo.getPwd());
		vo.setPwd(newPwd);
		return dao.join(sst,vo);
	}

	public MemberVo login(MemberVo vo) {
		MemberVo dbVo = dao.login(sst,vo);
		//clientVo == dbVO ? 성공 : 실패;
		boolean isOk = encoder.matches(vo.getPwd(), dbVo.getPwd());
		
		if(!isOk) {
			return null;			
		}
		return dbVo;
		
	}
	
}
