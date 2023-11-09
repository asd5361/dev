package com.cherry.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.qna.vo.QnaVo;

public class QnaDao {

	// 1.문의글 작성
	public int write(Connection conn, QnaVo vo) throws Exception {
		
		//sql
		String sql = "INSERT INTO QNA(QNA_NO, TITLE, CONTENT, MEMBER_NO, SECRET_YN) VALUES(SEQ_QNA_NO.NEXTVAL,?,?,?,UPPER(?))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, Main.loginMember.getMemberNo());
		pstmt.setString(4, vo.getSecretYn());
		int result = pstmt.executeUpdate();
		
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
		
	}//write end
	
	
	/**
	 * 2. 문의글 목록 (최신순) 
	 * 
	 * SELECT *
	 * FROM QNA
	 * ORDER BY QNA_NO DESC
	 */
	public List<QnaVo> qnaList(Connection conn) throws Exception {
		
		//sql
		String sql = "SELECT RPAD(Q.QNA_NO,12, 'ㅤ') AS QNA_NO , RPAD(Q.TITLE,35,'ㅤ') AS TITLE, RPAD(M.NICK,18,'ㅤ') AS WRITER_NICK , RPAD(Q.HIT,10,'ㅤ') AS HIT, TO_CHAR(Q.MEMBER_ENROLL_DATE, 'YYYY\"년\"MM\"월\"DD\"일\"') AS MEMBER_ENROLL_DATE FROM QNA Q JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO WHERE SECRET_YN = 'N' ORDER BY QNA_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<QnaVo> voList = new ArrayList<QnaVo>();
		while(rs.next()) {
			String qnaNo = rs.getString("QNA_NO");
			String title = rs.getString("TITLE");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("MEMBER_ENROLL_DATE");
			
			QnaVo vo = new QnaVo();
			vo.setQnaNo(qnaNo);
			vo.setTitle(title);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setMemberEnrollDate(enrollDate);
			
			voList.add(vo);
			
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return voList;
		
	}//qnaList end
	
	/**
	 * 3. 문의글 상세조회 (번호) 
	 * 
	 * SELECT
	 * FROM QNA
	 * WHERE QNA_NO = ?
	 */
	public QnaVo qnaDetailByNo(Connection conn, String num) throws Exception {
		
		//sql
		String sql = "SELECT Q.QNA_NO , Q.TITLE , Q.CONTENT , M.NICK AS WRITER_NICK , Q.HIT , TO_CHAR(Q.MEMBER_ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MEMBER_ENROLL_DATE , Q.ANSWER , TO_CHAR(Q.MANAGER_ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MANAGER_ENROLL_DATE , TO_CHAR(Q.MANAGER_EDIT_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MANAGER_EDIT_DATE FROM QNA Q JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO WHERE QNA_NO = ? AND SECRET_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		QnaVo vo = null;
		if(rs.next()) {
			String qnaNo = rs.getString("QNA_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("MEMBER_ENROLL_DATE");
			String answer = rs.getString("ANSWER");
			String managerEnrollDate = rs.getString("MANAGER_ENROLL_DATE");
			String managerEditDate = rs.getString("MANAGER_EDIT_DATE");
			
			vo = new QnaVo();
			vo.setQnaNo(qnaNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setMemberEnrollDate(enrollDate);
			vo.setAnswer(answer);
			vo.setManagerEnrollDate(managerEnrollDate);
			vo.setManagerEditDate(managerEditDate);
			
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return vo;

	}//qnaDetailByNo end
	
	// 3-2.조회수 증가
	public int increaseHit(Connection conn, String num) throws Exception {
		
		//sql
		String sql = "UPDATE QNA SET HIT = HIT + 1 WHERE QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		int result = pstmt.executeUpdate();
		
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
		
	}//increaseHit end
	
	// 4.문의글 검색 (제목)
	public List<QnaVo> searchQnaByTitle(Connection conn, String searchValue) throws Exception {
		
		//sql
		String sql = "SELECT Q.QNA_NO , Q.TITLE , M.NICK AS WRITER_NICK , Q.HIT , TO_CHAR(Q.MEMBER_ENROLL_DATE, 'YYYY\"년\"MM\"월\"DD\"일\"') AS ENROLL_DATE FROM QNA Q JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO WHERE Q.TITLE LIKE '%'||?||'%' AND Q.SECRET_YN = 'N' ORDER BY Q.QNA_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<QnaVo> voList = new ArrayList<QnaVo> ();
		while(rs.next()) {
			String no = rs.getString("QNA_NO");
			String title = rs.getString("TITLE");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			QnaVo vo = new QnaVo();
			vo.setQnaNo(no);
			vo.setTitle(title);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setMemberEnrollDate(enrollDate);
			
			voList.add(vo);
			
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return voList;
		
	}//searchQnaByTitle end

	// 5. 내가 작성한 문의글
	public List<QnaVo> qnaMyList(Connection conn, String loginMember) throws Exception {
		
		// sql
		String sql = "SELECT Q.QNA_NO , Q.TITLE , M.NICK AS WRITER_NICK , Q.HIT , TO_CHAR(Q.MEMBER_ENROLL_DATE, 'YYYY\"년\"MM\"월\"DD\"일\"') AS MEMBER_ENROLL_DATE, Q.SECRET_YN FROM QNA Q JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO WHERE Q.MEMBER_NO = ? ORDER BY Q.QNA_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<QnaVo> voList = new ArrayList<QnaVo>();
		while(rs.next()) {
			String no = rs.getString("QNA_NO");
			String title = rs.getString("TITLE");
			String nick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("MEMBER_ENROLL_DATE");
			String secret = rs.getString("SECRET_YN");
			
			QnaVo vo = new QnaVo();
			vo.setQnaNo(no);
			vo.setTitle(title);
			vo.setWriterNick(nick);
			vo.setHit(hit);
			vo.setMemberEnrollDate(enrollDate);
			vo.setSecretYn(secret);
			
			voList.add(vo);
			
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return voList;
		
	}//qnaMyList end
	
	
	// 6. 내가 작성한 문의글 상세보기   
	public List<QnaVo> qnaMyDetail(Connection conn, String loginMember) throws Exception {
		
		// sql
		String sql = "SELECT Q.QNA_NO , Q.TITLE , M.NICK AS WRITER_NICK , Q.HIT , TO_CHAR(Q.MEMBER_ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MEMBER_ENROLL_DATE , Q.CONTENT , Q.SECRET_YN , Q.ANSWER , TO_CHAR(Q.MANAGER_ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MANAGER_ENROLL_DATE , TO_CHAR(Q.MANAGER_EDIT_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MANAGER_EDIT_DATE FROM QNA Q JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO WHERE M.MEMBER_NO = ? ORDER BY Q.QNA_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember);
		ResultSet rs = pstmt.executeQuery();

		// rs
		List<QnaVo> voList = new ArrayList<QnaVo>();
		while (rs.next()) {
			String no = rs.getString("QNA_NO");
			String title = rs.getString("TITLE");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("MEMBER_ENROLL_DATE");
			String content = rs.getString("CONTENT");
			String secret = rs.getString("SECRET_YN");
			String answer = rs.getString("ANSWER");
			String managerEnrollDate = rs.getString("MANAGER_ENROLL_DATE");
			String managerEditDate = rs.getString("MANAGER_EDIT_DATE");

			QnaVo vo = new QnaVo();
			vo.setQnaNo(no);
			vo.setTitle(title);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setMemberEnrollDate(enrollDate);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setManagerEnrollDate(managerEnrollDate);
			vo.setManagerEditDate(managerEditDate);
			vo.setSecretYn(secret);

			voList.add(vo);

		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return voList;
	}//qnaMyDetail end
	
	
/////////////////////////////////////// 관리자용  /////////////////////////////////////////// 
	
	
	// 1. 문의글 목록 (관리자용)
	public List<QnaVo> qnaListManager(Connection conn) throws Exception {
		
		//sql
		String sql = "SELECT RPAD(Q.QNA_NO,12, 'ㅤ') AS QNA_NO , RPAD(Q.TITLE,35,'ㅤ') AS TITLE , RPAD(M.NICK,18,'ㅤ') AS WRITER_NICK , RPAD(Q.HIT,10,'ㅤ') AS HIT , RPAD(TO_CHAR(Q.MEMBER_ENROLL_DATE, 'YYYY\"년\"MM\"월\"DD\"일\"'), 25,'ㅤ') AS ENROLL_DATE, RPAD(Q.SECRET_YN,10,'ㅤ') AS SECRET_YN FROM QNA Q JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO ORDER BY QNA_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<QnaVo> voList = new ArrayList<QnaVo> ();
		while (rs.next()) {
			String no = rs.getString("QNA_NO");
			String title = rs.getString("TITLE");
			String nick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String secretYn = rs.getString("SECRET_YN");
			
			QnaVo vo = new QnaVo();
			vo.setQnaNo(no);
			vo.setTitle(title);
			vo.setWriterNick(nick);
			vo.setHit(hit);
			vo.setMemberEnrollDate(enrollDate);
			vo.setSecretYn(secretYn);
			
			voList.add(vo);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return voList;
		
	}//qnaListManager end
	
	
	// 2. 문의글 상세조회 (번호)
	public QnaVo qnaDetailByNoManager(Connection conn, String num) throws Exception {

		// sql
		String sql = "SELECT Q.QNA_NO , Q.TITLE , M.NICK AS WRITER_NICK , Q.HIT , TO_CHAR(Q.MEMBER_ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MEMBER_ENROLL_DATE , Q.CONTENT , Q.SECRET_YN , Q.ANSWER , TO_CHAR(Q.MANAGER_ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MANAGER_ENROLL_DATE , TO_CHAR(Q.MANAGER_EDIT_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MANAGER_EDIT_DATE FROM QNA Q JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO WHERE Q.QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();

		// rs
		QnaVo vo = null;
		if (rs.next()) {
			String qnaNo = rs.getString("QNA_NO");
			String title = rs.getString("TITLE");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("MEMBER_ENROLL_DATE");
			String content = rs.getString("CONTENT");
			String secret = rs.getString("SECRET_YN");
			String answer = rs.getString("ANSWER");
			String managerEnrollDate = rs.getString("MANAGER_ENROLL_DATE");
			String managerEditDate = rs.getString("MANAGER_EDIT_DATE");

			vo = new QnaVo();
			vo.setQnaNo(qnaNo);
			vo.setTitle(title);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setMemberEnrollDate(enrollDate);
			vo.setContent(content);
			vo.setSecretYn(secret);
			vo.setAnswer(answer);
			vo.setManagerEnrollDate(managerEnrollDate);
			vo.setManagerEditDate(managerEditDate);

		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return vo;

	}

	// 3. 관리자 답변작성
	public int answer(Connection conn, QnaVo vo) throws Exception {
		
		//sql
		String sql = "UPDATE QNA SET ANSWER = ? ,MANAGER_ENROLL_DATE = SYSDATE  WHERE QNA_NO = ? AND ANSWER IS NULL";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAnswer());
		pstmt.setString(2, vo.getQnaNo());
		int result = pstmt.executeUpdate();
		
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
		
	}//answer end
	
	// 3-2. 관리자 답변완료 후 출력
	public QnaVo answerPrint(Connection conn, String no) throws Exception {
		
		// sql
		String sql = "SELECT Q.QNA_NO , Q.TITLE , Q.CONTENT , M.NICK AS WRITER_NICK , Q.HIT , TO_CHAR(Q.MEMBER_ENROLL_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MEMBER_ENROLL_DATE , Q.ANSWER , TO_CHAR(Q.MANAGER_ENROLL_DATE,'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MANAGER_ENROLL_DATE , TO_CHAR(Q.MANAGER_EDIT_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일 \"HH24:MI') AS MANAGER_EDIT_DATE FROM QNA Q JOIN MEMBER M ON Q.MEMBER_NO = M.MEMBER_NO WHERE QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		QnaVo Mo = null;
		while(rs.next()) {
			String qnaNo = rs.getString("QNA_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String memberEnrollDate = rs.getString("MEMBER_ENROLL_DATE");
			String answer = rs.getString("ANSWER");
			String answerEnrollDate = rs.getString("MANAGER_ENROLL_DATE");
			String answerEditDate = rs.getString("MANAGER_EDIT_DATE");
//			System.out.println();
//			System.out.println("확인용" +answerEditDate);
			
			
			Mo = new QnaVo();
			Mo.setQnaNo(qnaNo);
			Mo.setTitle(title);
			Mo.setContent(content);
			Mo.setWriterNick(writerNick);
			Mo.setHit(hit);
			Mo.setMemberEnrollDate(memberEnrollDate);
			Mo.setAnswer(answer);
			Mo.setManagerEnrollDate(answerEnrollDate);
			Mo.setManagerEditDate(answerEditDate);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return Mo;
		
	} //answerPrint end
	
	// 4. 관리자 답변수정
	public int answerEdit(Connection conn, QnaVo vo) throws Exception {
		
		//sql
		String sql = "UPDATE QNA SET ANSWER =?, MANAGER_EDIT_DATE = SYSDATE WHERE QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAnswer());
		pstmt.setString(2, vo.getQnaNo());
		int result = pstmt.executeUpdate();
				
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
		
	}//answerEdit end
	
}
