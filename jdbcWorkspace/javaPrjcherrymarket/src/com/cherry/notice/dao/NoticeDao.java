package com.cherry.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.member.vo.MemberVo;
import com.cherry.notice.vo.NoticeVo;

import oracle.net.aso.j;

public class NoticeDao {
	
	//공지글 작성
	public int write(Connection conn, NoticeVo vo) throws Exception  {
		//sql
		String sql="INSERT INTO NOTICE(NOTICE_NO,MANAGER_NO,TITLE,CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, Main.loginManager.getManagerNo()); 
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		
		int result=pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
		
	}//write(Connection conn, NoticeVo vo) end
	
	//공지글 조회(최신순)//유저
	public ArrayList<NoticeVo> noticeList(Connection conn) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE,M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS ENROLL_DATE FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO WHERE  SECRET_YN='N' ORDER BY N.NOTICE_NO DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs= pstmt.executeQuery();
		
		//rs
		ArrayList<NoticeVo> voList=new ArrayList();
		while(rs.next()) {
			String noticeNo=rs.getString("NOTICE_NO");
			String title=rs.getString("TITLE");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
			
			NoticeVo vo=new NoticeVo();
			vo.setNo(noticeNo);
			vo.setTitle(title);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
			
			voList.add(vo);
	
		}
	
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
		
	}//ArrayList<NoticeVo> noticeList(Connection conn) end
	
	//공지글 조회(최신순)//관리자
	public ArrayList<NoticeVo> adminNoticeList(Connection conn) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE,M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS ENROLL_DATE,SECRET_YN FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO ORDER BY N.NOTICE_NO DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs= pstmt.executeQuery();
				
		//rs
		ArrayList<NoticeVo> voList=new ArrayList();
		while(rs.next()) {
		String noticeNo=rs.getString("NOTICE_NO");
		String title=rs.getString("TITLE");
		String managerName=rs.getString("MANAGER_NAME");
		String hit=rs.getString("HIT");
		String enrollDate=rs.getString("ENROLL_DATE");
		String secretYn=rs.getString("SECRET_YN");
					
		NoticeVo vo=new NoticeVo();
		vo.setNo(noticeNo);
		vo.setTitle(title);
		vo.setManagerName(managerName);
		vo.setHit(hit);
		vo.setEnrolldate(enrollDate);
		vo.setSecretYn(secretYn);
				
		voList.add(vo);
			
		}
			
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}
	
	//공지글 상세 조회//유저
	public NoticeVo noticeDetailByNo(Connection conn, String num) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE,N.CONTENT,M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS ENROLL_DATE,TO_CHAR(N.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS EDIT_DATE FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO WHERE N.NOTICE_NO=? AND N.SECRET_YN='N'";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs=pstmt.executeQuery();
		
		//rs
		NoticeVo vo= null;
		if(rs.next()) {
			String no=rs.getString("NOTICE_NO");
			String title=rs.getString("TITLE");
			String content=rs.getString("CONTENT");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
			String editDate=rs.getString("EDIT_DATE");
			
			vo=new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
			vo.setEditDate(editDate);
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}//noticeDetailByNo(Connection conn, String num) end
	
	//공지글 상세 조회//관리자
	public NoticeVo adminNoticeDetailByNo(Connection conn, String num) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE,N.CONTENT,M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS ENROLL_DATE,TO_CHAR(N.EDIT_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS EDIT_DATE,SECRET_YN FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO WHERE N.NOTICE_NO=? ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs=pstmt.executeQuery();
				
		//rs
		NoticeVo vo= null;
		if(rs.next()) {
			String no=rs.getString("NOTICE_NO");
			String title=rs.getString("TITLE");
			String content=rs.getString("CONTENT");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
			String editDate=rs.getString("EDIT_DATE");
			String secretYn=rs.getString("SECRET_YN");
					
			vo=new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
			vo.setEditDate(editDate);
			vo.setSecretYn(secretYn);
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}
	
	//조회수
	public int Hit(Connection conn, String num) throws Exception {
		//sql
		String sql="UPDATE NOTICE SET HIT= HIT+1 WHERE NOTICE_NO =? AND SECRET_YN='N'";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, num);
		int result=pstmt.executeUpdate();
		
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
				
	}//Hit(Connection conn, String num) end
	
	//공지글 검색(제목)//유저
	public ArrayList<NoticeVo> searchNoticeByTitle(Connection conn, String search) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE,M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS ENROLL_DATE,N.EDIT_DATE FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO WHERE N.TITLE LIKE '%'||?||'%' AND SECRET_YN='N' ORDER BY N.NOTICE_NO DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, search);
		ResultSet rs=pstmt.executeQuery();
		
		//rs
		ArrayList<NoticeVo> voList=new ArrayList();
		while(rs.next()) {
			String no=rs.getString("NOTICE_NO");
			String title=rs.getString("TITLE");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
			String editDate=rs.getString("EDIT_DATE");
			
			NoticeVo vo=new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
			vo.setEditDate(editDate);
			
			voList.add(vo);
			
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
		

	}//ArrayList<NoticeVo> searchNoticeByTitle(Connection conn, String search) end
	
	//공지글 검색(제목)//관리자
	public ArrayList<NoticeVo> adminSearchNoticeByTitle(Connection conn, String search) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE,M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS ENROLL_DATE,N.EDIT_DATE FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO WHERE N.TITLE LIKE '%'||?||'%' ORDER BY N.NOTICE_NO DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, search);
		ResultSet rs=pstmt.executeQuery();
		
		//rs
		ArrayList<NoticeVo> voList=new ArrayList();
		while(rs.next()) {
			String no=rs.getString("NOTICE_NO");
			String title=rs.getString("TITLE");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
			String editDate=rs.getString("EDIT_DATE");
			
			NoticeVo vo=new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
			vo.setEditDate(editDate);
			
			voList.add(vo);
			
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	
	//공지글 감추기
	public int secret(Connection conn, HashMap<String, String> map) throws Exception {
		//sql
		String sql="UPDATE NOTICE SET SECRET_YN=UPPER(?), EDIT_DATE= SYSDATE WHERE NOTICE_NO=? ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, map.get("secretChoice"));
		pstmt.setString(2, map.get("noticeNum"));
		
		int result=pstmt.executeUpdate();
		
	
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
	}//secret(Connection conn, HashMap<String, String> map) end
	
	//공지글 수정
	public int modify(Connection conn, NoticeVo vo) throws Exception {
		//sql
		String sql="UPDATE NOTICE SET TITLE=?, CONTENT=?, EDIT_DATE= SYSDATE WHERE NOTICE_NO=? ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getNo());
		
		int result=pstmt.executeUpdate();
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
		
	}//modify(Connection conn, NoticeVo vo) end	
	
	
	//공지사항(조회수순)//유저
	public ArrayList<NoticeVo> noticeList2(Connection conn) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE,M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS ENROLL_DATE FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO WHERE  SECRET_YN='N' ORDER BY N.HIT DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		//rs
		ArrayList<NoticeVo> voList=new ArrayList<NoticeVo>();
		while(rs.next()) {
			String no=rs.getString("NOTICE_NO");
			String title=rs.getString("TITLE");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
			
			NoticeVo vo=new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
			
			voList.add(vo);
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return voList;
		
	}
	
	//공지사항(조회수순)//관리자
	public ArrayList<NoticeVo> adminNoticeList2(Connection conn) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE,M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS ENROLL_DATE FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO ORDER BY N.HIT DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		//rs
		ArrayList<NoticeVo> voList=new ArrayList<NoticeVo>();
		while(rs.next()) {
			String no=rs.getString("NOTICE_NO");
			String title=rs.getString("TITLE");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
					
			NoticeVo vo=new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
					
			voList.add(vo);
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return voList;
	}
	
	//공지글 검색(내용)//유저
	public ArrayList<NoticeVo> searchNoticeByContent(Connection conn, String content) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE, M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS ENROLL_DATE FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO WHERE N.CONTENT LIKE '%'||?||'%' AND SECRET_YN='N' ORDER BY N.NOTICE_NO DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, content);
		ResultSet rs=pstmt.executeQuery();
		
		//rs
		ArrayList<NoticeVo> voList=new ArrayList<NoticeVo>();
		while(rs.next()) {
			String no=rs.getString("Notice_NO");
			String title=rs.getString("TITLE");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
			
			NoticeVo vo=new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
			
			voList.add(vo);
			
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}
	
	//공지글 검색(내용)//관리자
	public ArrayList<NoticeVo> adminSearchNoticeByContent(Connection conn, String content) throws Exception {
		//sql
		String sql="SELECT N.NOTICE_NO,N.TITLE, M.NAME AS MANAGER_NAME,N.HIT,TO_CHAR(N.ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"') AS ENROLL_DATE FROM NOTICE N JOIN MANAGER M ON M.MANAGER_NO=N.MANAGER_NO WHERE N.CONTENT LIKE '%'||?||'%' ORDER BY N.NOTICE_NO DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, content);
		ResultSet rs=pstmt.executeQuery();
				
		//rs
		ArrayList<NoticeVo> voList=new ArrayList<NoticeVo>();
		while(rs.next()) {
			String no=rs.getString("Notice_NO");
			String title=rs.getString("TITLE");
			String managerName=rs.getString("MANAGER_NAME");
			String hit=rs.getString("HIT");
			String enrollDate=rs.getString("ENROLL_DATE");
					
			NoticeVo vo=new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setManagerName(managerName);
			vo.setHit(hit);
			vo.setEnrolldate(enrollDate);
					
			voList.add(vo);
					
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}


}//class
