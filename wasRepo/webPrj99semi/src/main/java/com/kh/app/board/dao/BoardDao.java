package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.page.vo.PageVo;
import com.kh.app.reply.vo.ReplyVo;

public class BoardDao {
	//게시글 작성하기
	public int write(Connection conn, BoardVo vo) throws SQLException {
		
		String sql = "INSERT INTO BOARD (NO,CATEGORY_NO,TITLE,CONTENT,WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getCategoryNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, vo.getWriterNo());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}
	//게시글 전체 목록 조회
	public List<BoardVo> selectBoardList(Connection conn, PageVo pvo) throws SQLException {
		
		//sql
//		String sql = "SELECT * FROM BOARD WHERE STATUS = 'O' ORDER BY NO DESC";
//		String sql = "SELECT B.*, M.NICK FROM BOARD B JOIN MEMBER M ON (B.WRITER_NO= M.NO) WHERE B.STATUS = 'O' ORDER BY B.NO DESC";
//		String sql ="SELECT * FROM BOARD JOIN(SELECT NO AS M_NO, NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO WHERE STATUS = 'O' ORDER BY NO DESC";
//		String sql ="SELECT * FROM BOARD JOIN(SELECT NO AS M_NO, NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO JOIN (SELECT NO AS C_NO,NAME AS NAME FROM CATEGORY) ON  CATEGORY_NO = C_NO WHERE STATUS = 'O' ORDER BY NO DESC";
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM( SELECT * FROM BOARD JOIN(SELECT NO AS M_NO, NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO JOIN (SELECT NO AS C_NO,NAME AS NAME FROM CATEGORY) ON  CATEGORY_NO = C_NO WHERE STATUS = 'O' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		
		//rs
		while(rs.next()) {
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setCategoryNo(categoryNo);
			vo.setCategoryName(categoryName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setWriteNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setStatus(status);
			
			boardVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return boardVoList;
	}

	//게시글 번호로 1개 조회
	public BoardVo selectBoardByNo(Connection conn, String boardNo) throws SQLException {
		
		//sql
//		String sql = "SELECT * FROM BOARD JOIN (SELECT NO AS M_NO,NICK AS WRITER_NICK FROM MEMBER)ON M_NO = WRITER_NO WHERE NO = ? AND STATUS = 'O'";
		String sql = "SELECT * FROM BOARD JOIN (SELECT NO AS M_NO,NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO JOIN (SELECT NO AS C_NO,NAME FROM CATEGORY) ON  CATEGORY_NO = C_NO WHERE NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		BoardVo vo = null;
		
		//rs
		if(rs.next()) {
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setCategoryNo(categoryNo);
			vo.setCategoryName(categoryName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setWriteNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setStatus(status);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}
	
	//조회수 중가
	public int increaesHit(Connection conn, String boardNo) throws SQLException {
		//sql
		String sql="UPDATE BOARD SET HIT = HIT+1 WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//게시글 수정 
	public int updateBoardByNo(Connection conn, BoardVo vo) throws SQLException {
		
		//sql
		String sql = "UPDATE BOARD SET CATEGORY_NO = ?, TITLE = ?, CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ? AND STATUS = 'O' ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getCategoryNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, vo.getNo());
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int delete(Connection conn, String no, String writerNo) throws SQLException {
		//sql
		String sql = "UPDATE BOARD SET STATUS ='X' WHERE NO = ? AND WRITER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, writerNo);
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//게시글 갯수 조회
	public int selectBoardCount(Connection conn) throws SQLException {
		
		//sql
		String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt ; 
	}
	
	//카테고리 리스트 조회
	public List<CategoryVo> getCategoryList(Connection conn) throws SQLException {
		
		//sql
		String sql = "SELECT * FROM CATEGORY ORDER BY NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<CategoryVo> voList = new ArrayList<CategoryVo>();
		while(rs.next()) {
			CategoryVo vo = new CategoryVo();
			vo.setNo(rs.getString("NO"));
			vo.setName(rs.getString("NAME"));
			
			voList.add(vo); 
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList; 
	}
	//게시글 검색 기능
	public List<BoardVo> search(Connection conn, Map<String, String> m, PageVo pvo) throws SQLException {
		String searchType = m.get("searchType");
		//sql '값' == sql문의 문자열이라는 속성 title = 문자 (sql 문의 글자)
//		String sql ="SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM( SELECT * FROM BOARD JOIN(SELECT NO AS M_NO, NICK AS WRITER_NICK FROM MEMBER) ON M_NO = WRITER_NO JOIN (SELECT NO AS C_NO,NAME AS NAME FROM CATEGORY) ON  CATEGORY_NO = C_NO WHERE STATUS = 'O' AND \"+searchType+\" LIKE '%'||?||'%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		String sql ="SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.NO , B.CATEGORY_NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.HIT , B.ENROLL_DATE , B.MODIFY_DATE , B.STATUS , M.NICK AS WRITER_NICK , C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.STATUS = 'O' AND "+searchType+" LIKE '%' || ?|| '%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.get("searchValue"));
		pstmt.setInt(2, pvo.getStartRow());
		pstmt.setInt(3, pvo.getLastRow());
		
		ResultSet rs = pstmt.executeQuery();
		List<BoardVo> volist = new ArrayList<BoardVo>();
		
		//rs

		while(rs.next()) {
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			String writerNick = rs.getString("WRITER_NICK");
			String categoryName = rs.getString("CATEGORY_NAME");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setCategoryNo(categoryNo);
			vo.setCategoryName(categoryName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setWriteNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setStatus(status);
			
			volist.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return volist;
		
	}
	
	//게시글 갯수 조회 (검색값에 따라)
	public int getBoardCountBySearch(Connection conn, Map<String, String> m) throws SQLException {
		
		String searchType = m.get("searchType"); 
		
		//sql
		String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS = 'O' AND "+ searchType +" LIKE '%'||?||'%' ORDER BY MODIFY_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.get("searchValue"));
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}
	
	//댓글 목록 조회
	public List<ReplyVo> getReList(Connection conn, String num) throws SQLException{
		
		//sql
		String sql = "SELECT REF_NO ,CONTENT ,WRITER_NO ,ENROLL_DATE ,STATUS FROM REPLY WHERE REF_NO = ? AND STATUS = 'O' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		
		ResultSet rs = pstmt.executeQuery();
		List<ReplyVo> ReplyVoList = new ArrayList<ReplyVo>();
		//rs
		while(rs.next()){

			String no = rs.getString("NO");
			String refNo = rs.getString("REF_NO");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status =	 rs.getString("STATUS");
			
			ReplyVo vo = new ReplyVo(no, refNo, content, writerNo, enrollDate, status);
			ReplyVoList.add(vo);
		}

		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return ReplyVoList;
		
	}
	
	//댓글 작성 기능
	public int writeReply(Connection conn, ReplyVo vo) throws SQLException {
		
		//sql
		String sql = "INSERT INTO REPLY(NO, REF_NO, CONTENT, WRITER_NO) VALUES(SEQ_REPLY_NO.NEXTVAL, ?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getRefNo());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getWriterNo());
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	//댓글 조회 기능
	public List<ReplyVo> getReplyList(Connection conn, String refNo) throws SQLException {
		
		//sql
		String sql ="SELECT * FROM REPLY WHERE REF_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, refNo);
		ResultSet rs = pstmt.executeQuery();
		List<ReplyVo> replyVoList = new ArrayList<ReplyVo>();
		
		while(rs.next()) {
			ReplyVo vo = new ReplyVo();
			vo.setNo(rs.getString("NO"));
			vo.setRefNo(rs.getString("REF_NO"));
			vo.setContent(rs.getString("CONTENT"));
			vo.setWriterNo(rs.getString("WRITER_NO"));
			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
			vo.setStatus(rs.getString("STATUS"));
			
			replyVoList.add(vo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return replyVoList;
	}

}
