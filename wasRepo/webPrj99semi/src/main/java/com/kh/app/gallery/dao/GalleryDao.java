package com.kh.app.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.gallery.vo.AttachmentVo;
import com.kh.app.gallery.vo.GalleryVo;

public class GalleryDao {

	public List<GalleryVo> getGalleryList(Connection conn) throws SQLException {
		
		//sql
		String sql ="SELECT G.NO AS GALLERY_NO ,G.TITLE ,G.CONTENT ,G.WRITER_NO ,M.NICK AS WRITER_NICK ,G.HIT ,G.ENROLL_DATE ,G.MODIFY_DATE ,G.STATUS ,A.NO AS ATTACHMENT_NO ,A.REF_NO ,A.ORIGIN_NAME ,A.CHANGE_NAME ,A.FILE_PATH , A.THUMBNAIL_YN FROM GALLERY G JOIN MEMBER M ON G.WRITER_NO = M.NO JOIN ATTACHMENT A ON G.NO = A.REF_NO WHERE G.STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<GalleryVo> galleryVoList = new ArrayList<GalleryVo>();
		while(rs.next()) {
		   String galleryNo = rs.getString("GALLERY_NO");
		   String title = rs.getString("TITLE");
		   String content = rs.getString("CONTENT");
		   String writerNo = rs.getString("WRITER_NO");
		   String hit = rs.getString("HIT");
		   String enrollDate = rs.getString("ENROLL_DATE");
		   String modifyDate = rs.getString("MODIFY_DATE");
		   String status = rs.getString("STATUS");
		   String attachmentNo = rs.getString("ATTACHMENT_NO");
		   String refNo = rs.getString("REF_NO");
		   String originName = rs.getString("ORIGIN_NAME");
		   String changeName = rs.getString("CHANGE_NAME");
		   String filePath = rs.getString("FILE_PATH");
		   String writerNick = rs.getString("WRITER_NICK");
		   String thumbnailYn = rs.getString("THUMBNAIL_YN");
		   
		   GalleryVo galleryVo = new GalleryVo(galleryNo, title, content, writerNo, hit, enrollDate, modifyDate, status, writerNick, attachmentNo, refNo, originName, changeName, filePath, thumbnailYn);	   
		   galleryVoList.add(galleryVo);
		}
		
		
		
		
		// 조회한 데이터(galleryVoList)를 우리가 사용하기 편하게 가공
	    Map<String, GalleryVo> map = new HashMap<String, GalleryVo>();
	    for (GalleryVo galleryVo : galleryVoList) {
	       map.put(galleryVo.getGalleryNo(), galleryVo);
	    }
	      
	    for (GalleryVo galleryVo : galleryVoList) {
	         
	       String attNo = galleryVo.getAttachmentNo();
	       String changeName = galleryVo.getChangeName();
	       String originName = galleryVo.getOriginName();
	       String filePath = galleryVo.getFilePath();
	       String refNo = galleryVo.getRefNo();
	       String thumbnailYn = galleryVo.getThumbnailYn();
	       
	       AttachmentVo attVo = new AttachmentVo(attNo, refNo, originName, changeName, filePath,thumbnailYn);
	       GalleryVo target = map.get(attVo.getRefNo());
	       target.getAttachmentVoList().add(attVo);
	    }
	      
	    ArrayList<GalleryVo> result = new ArrayList<GalleryVo>(map.values());
		
	    
	    
	    
		//result 에서 썸네일 객체 셋팅
		for (GalleryVo galleryVo : result) {
		   List<AttachmentVo> attVoList = galleryVo.getAttachmentVoList();
		   for (AttachmentVo attVo : attVoList) {
		      String thumbnailYn = attVo.getThumbnailYn();
		      if(thumbnailYn.equals("Y")) {
		         galleryVo.setThumbnailVo(attVo);
		         break;
		      }
		   }
		}
	    
		
		
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
