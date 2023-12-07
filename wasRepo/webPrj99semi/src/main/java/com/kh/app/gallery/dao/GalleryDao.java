package com.kh.app.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.gallery.vo.GalleryVo;

public class GalleryDao {

	public List<GalleryVo> getGalleryList(Connection conn) throws SQLException {
		
		//sql
		String sql ="SELECT G.NO AS GALLERY_NO ,G.TITLE ,G.CONTENT ,G.WRITER_NO ,M.NICK AS WRITER_NICK ,G.HIT ,G.ENROLL_DATE ,G.MODIFY_DATE ,G.STATUS ,A.NO AS ATTACHMENT_NO ,A.REF_NO ,A.ORIGIN_NAME ,A.CHANGE_NAME ,A.FILE_PATH FROM GALLERY G JOIN MEMBER M ON G.WRITER_NO = M.NO JOIN ATTACHMENT A ON G.NO = A.REF_NO WHERE G.STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<GalleryVo> galleryVoList = new ArrayList<GalleryVo>();
		
		//rs
		while(rs.next()) {
			String galleryNo = rs.getString("GALLERY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String attachmentNo = rs.getString("ATTACHMENT_NO");
			String refNo = rs.getString("ORIGIN_NAME");
			String originName = rs.getString("REF_NO");
			String changeName = rs.getString("CHANGE_NAME");
			String filePath = rs.getString("FILE_PATH");
			
			GalleryVo vo = new GalleryVo();
			vo.setGalleryNo(galleryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setAttachmentNo(attachmentNo);
			vo.setRefNo(refNo);
			vo.setOriginName(originName);
			vo.setChangeName(changeName);
			vo.setFilePath(filePath);
			
			galleryVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return galleryVoList;
	}

}
