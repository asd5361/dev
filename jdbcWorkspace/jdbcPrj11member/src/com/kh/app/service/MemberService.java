package com.kh.app.service;

import com.kh.app.dao.MemberDao;
import com.kh.app.jdbc.JDBCTemplate;
import com.kh.app.vo.MemberVo;
import java.sql.*;
import java.util.*;


public class MemberService {

	MemberDao dao = null;
	
	public MemberService() {
		
		dao = new MemberDao();
	}

	public int join(MemberVo vo) throws Exception {
		
			//conn
			Connection conn =  JDBCTemplate.getConnection();
			
			//DAO 호출 (SQL)
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

	public MemberVo login(MemberVo vo) throws Exception{

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO 호출(SQL)
		MemberVo dbVo = dao.login(conn,vo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}

	public ArrayList<MemberVo> getMemberList() throws Exception{
		
		//conn
		Connection conn =JDBCTemplate.getConnection();
		
		//DAO 호출(SQL)
		ArrayList<MemberVo> voList = dao.getMemberList(conn);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public int update() {
		return 0;
	}
	
	//rs : DAO 호출
}
