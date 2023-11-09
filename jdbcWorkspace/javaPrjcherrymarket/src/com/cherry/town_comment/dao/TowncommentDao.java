package com.cherry.town_comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.town.vo.TownVo;
import com.cherry.town_comment.vo.TowncommentVo;

public class TowncommentDao {

	//----------댓글 작성-----------------------------
	public int commentwrite(Connection conn, TowncommentVo vo, TownVo tvo) throws Exception {
		
		String sql = "INSERT INTO TOWN_COMMENT(COMMENT_NO, TOWN_NO,CONTENT, MEMBER_NO) VALUES(SEQ_TOWN_COMMENT_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tvo.getTownNO());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, Main.loginMember.getMemberNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);

		return result;
	}



}
