package com.kh.app.gallery.vo;

import java.util.*;

public class GalleryVo {
 
	private String galleryNo;
	private String title;
	private String content;
	private String writerNo;
	private String hit;
	private String enrollDate;
	private String modifyDate;
	private String status;
	
	private String writerNick;
	
	// att 관련 필드는, rs 에서 꺼낸 데이터를 임시로 담기 위해서만 사용
	private String attachmentNo;
	private String refNo;
	private String originName;
	private String changeName;
	private String filePath;	
	private String thumbnailYn;
	
	private List<AttachmentVo> attachmentVoList = new ArrayList<AttachmentVo>();
	private AttachmentVo thumbnailVo;
	
	public String getSrc() {
		return thumbnailVo.getFilePath() + thumbnailVo.getChangeName();
	}	
	
	public GalleryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GalleryVo(String galleryNo, String title, String content, String writerNo, String hit, String enrollDate,
			String modifyDate, String status, String writerNick, String attachmentNo, String refNo, String originName,
			String changeName, String filePath, String thumbnailYn, List<AttachmentVo> attachmentVoList,
			AttachmentVo thumbnailVo) {
		super();
		this.galleryNo = galleryNo;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.writerNick = writerNick;
		this.attachmentNo = attachmentNo;
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.thumbnailYn = thumbnailYn;
		this.attachmentVoList = attachmentVoList;
		this.thumbnailVo = thumbnailVo;
	}
	public GalleryVo(String galleryNo, String title, String content, String writerNo, String hit, String enrollDate,
			String modifyDate, String status, String writerNick, String attachmentNo, String refNo, String originName,
			String changeName, String filePath, String thumbnailYn) {
		super();
		this.galleryNo = galleryNo;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.writerNick = writerNick;
		this.attachmentNo = attachmentNo;
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.thumbnailYn = thumbnailYn;
	}


	public final String getGalleryNo() {
		return galleryNo;
	}
	public final void setGalleryNo(String galleryNo) {
		this.galleryNo = galleryNo;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final String getWriterNo() {
		return writerNo;
	}
	public final void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public final String getHit() {
		return hit;
	}
	public final void setHit(String hit) {
		this.hit = hit;
	}
	public final String getEnrollDate() {
		return enrollDate;
	}
	public final void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public final String getModifyDate() {
		return modifyDate;
	}
	public final void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public final String getStatus() {
		return status;
	}
	public final void setStatus(String status) {
		this.status = status;
	}
	public final String getWriterNick() {
		return writerNick;
	}
	public final void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	public final String getAttachmentNo() {
		return attachmentNo;
	}
	public final void setAttachmentNo(String attachmentNo) {
		this.attachmentNo = attachmentNo;
	}
	public final String getRefNo() {
		return refNo;
	}
	public final void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public final String getOriginName() {
		return originName;
	}
	public final void setOriginName(String originName) {
		this.originName = originName;
	}
	public final String getChangeName() {
		return changeName;
	}
	public final void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public final String getFilePath() {
		return filePath;
	}
	public final void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public final String getThumbnailYn() {
		return thumbnailYn;
	}
	public final void setThumbnailYn(String thumbnailYn) {
		this.thumbnailYn = thumbnailYn;
	}

	public final List<AttachmentVo> getAttachmentVoList() {
		return attachmentVoList;
	}
	public final void setAttachmentVoList(List<AttachmentVo> attachmentVoList) {
		this.attachmentVoList = attachmentVoList;
	}
	public final AttachmentVo getThumbnailVo() {
		return thumbnailVo;
	}
	public final void setThumbnailVo(AttachmentVo thumbnailVo) {
		this.thumbnailVo = thumbnailVo;
	}

	@Override
	public String toString() {
		return "GalleryVo [galleryNo=" + galleryNo + ", title=" + title + ", content=" + content + ", writerNo="
				+ writerNo + ", hit=" + hit + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
				+ status + ", writerNick=" + writerNick + ", attachmentNo=" + attachmentNo + ", refNo=" + refNo
				+ ", originName=" + originName + ", changeName=" + changeName + ", filePath=" + filePath
				+ ", thumbnailYn=" + thumbnailYn + ", attachmentVoList=" + attachmentVoList + ", thumbnailVo="
				+ thumbnailVo + "]";
	}
	
}