package com.cherry.manager.service;

import java.sql.*;
import java.util.List;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.manager.dao.ManagerDao;
import com.cherry.manager.vo.ManagerVo;
import com.cherry.member.vo.MemberVo;

public class ManagerService {

	private final ManagerDao dao;
	
	public ManagerService() {
		dao= new ManagerDao();
	}

	public ManagerVo loginManager(ManagerVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		ManagerVo managerVo = dao.loginManager(conn,vo);
		
		JDBCTemplate.close(conn);
		return managerVo;
	}

	public List<MemberVo> userList() throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> userList= dao.userList(conn);
		
		JDBCTemplate.close(conn);
		return userList;
	}

	public List<MemberVo> userDetile(String userChoice,String num) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> voList = dao.userDetile(conn,userChoice,num);
		
		JDBCTemplate.close(conn);
		return voList;
	}

	public int userKick(String userNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.userKick(conn,userNo);
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}	
		JDBCTemplate.close(conn);	
		return result;
	}

}
