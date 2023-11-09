package com.cherry.notice.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.member.dao.MemberDao;
import com.cherry.notice.dao.NoticeDao;
import com.cherry.notice.vo.NoticeVo;

public class NoticeService {
	//필드
	private final NoticeDao dao;
	
	//기본생성자
	public NoticeService() {
		dao=new NoticeDao();
	}
	
	//공지글 작성
	public int write(NoticeVo vo) throws Exception  {
		//conn
		Connection conn=JDBCTemplate.getConnection();
		
		//dao
		int result=dao.write(conn,vo);
		
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		return result;
	}//write(NoticeVo vo) end
	
	//공지글 조회(최신순)//유저
	public ArrayList<NoticeVo> noticeList() throws Exception  {
		//conn
		Connection conn=JDBCTemplate.getConnection();
		
		//dao
		ArrayList<NoticeVo> voList=dao.noticeList(conn);
		//tx
		
		//close
		JDBCTemplate.close(conn);
		return voList;
				
	}//ArrayList<NoticeVo> noticeList() end
	
	//공지글 조회(최신순)//관리자
	public ArrayList<NoticeVo> adminNoticeList() throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
				
		//dao
		ArrayList<NoticeVo> voList=dao.adminNoticeList(conn);
		//tx
				
		//close
		JDBCTemplate.close(conn);
		return voList;
	}//ArrayList<NoticeVo> adminNoticeList() end
	
	//공지글 상세 조회//유저
	public NoticeVo noticeDetailByNo(String num) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
		
		//dao
		int result=dao.Hit(conn,num);
		NoticeVo vo=dao.noticeDetailByNo(conn,num);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		return vo;

	}//NoticeVo noticeDetailByNo(String num)end
	
	//공지글 상세 조회//관리자
	public NoticeVo adminNoticeDetailByNo(String num) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
				
		//dao
		NoticeVo vo=dao.adminNoticeDetailByNo(conn,num);
				
		//tx
		
				
		//close
		JDBCTemplate.close(conn);
		return vo;

	}//NoticeVo noticeDetailByNo(String num) end
	
	//공지글 검색(제목)//유저
	public ArrayList<NoticeVo> searchNoticeByTitle(String search) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
		
		//dao
		ArrayList<NoticeVo> voList= dao.searchNoticeByTitle(conn,search);
		//tx
		
		//close
		JDBCTemplate.close(conn);
		return voList;
	}//ArrayList<NoticeVo> searchNoticeByTitle(String search) end
	
	//공지글 검색(제목)//관리자
	public ArrayList<NoticeVo> adminSearchNoticeByTitle(String search) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
				
		//dao
		ArrayList<NoticeVo> voList= dao.adminSearchNoticeByTitle(conn,search);
		//tx
				
		//close
		JDBCTemplate.close(conn);
		return voList;
	}////ArrayList<NoticeVo> adminSearchNoticeByTitle(String search) end
	
	//공지글 감추기
	public int secret(HashMap<String, String> map) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
		
		//dao
		int result=dao.secret(conn,map);
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		return result;
	
	}//secret(HashMap<String, String> map) end
	
	//공지글 수정
	public int modify(NoticeVo vo) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
		
		//dao
		int result=dao.modify(conn,vo);
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		return result;
				
	}//modify(NoticeVo vo) end
	
	//공지글(조회수순)//유저
	public ArrayList<NoticeVo> noticeList2() throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
				
		//dao
		ArrayList<NoticeVo> voList=dao.noticeList2(conn);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		return voList;
	}//ArrayList<NoticeVo> noticeList2() end
	
	//공지글(조회수순)//관리자
	public ArrayList<NoticeVo> adminNoticeList2() throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
						
		//dao
		ArrayList<NoticeVo> voList=dao.adminNoticeList2(conn);
				
		//tx
				
		//close
		JDBCTemplate.close(conn);
		return voList;
	}//adminNoticeList2 end
	
	//공지글 검색(내용)//유저
	public ArrayList<NoticeVo> searchNoticeByContent(String content) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
				
		//dao
		ArrayList<NoticeVo> voList=dao.searchNoticeByContent(conn, content);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		return voList;
	}
	
	//공지글 검색(내용)//관리자
	public ArrayList<NoticeVo> adminSearchNoticeByContent(String content) throws Exception {
		//conn
		Connection conn=JDBCTemplate.getConnection();
						
		//dao
		ArrayList<NoticeVo> voList=dao.adminSearchNoticeByContent(conn, content);
				
		//tx
				
		//close
		JDBCTemplate.close(conn);
		return voList;
	}

	

	

	

	
	

}//class
