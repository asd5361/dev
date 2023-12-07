package com.kh.app.gallery.vo;

public class GalleryVo {
 
	private String galleryNo;
	private String title;
	private String content;
	private String writerNo;
	private String writerNick;
	private String hit;
	private String enrollDate;
	private String modifyDate;
	private String status;
	
	private String attachmentNo;
	private String refNo;
	private String originName;
	private String changeName;
	private String filePath;
	public GalleryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GalleryVo(String galleryNo, String title, String content, String writerNo, String writerNick, String hit,
			String enrollDate, String modifyDate, String status, String attachmentNo, String refNo, String originName,
			String changeName, String filePath) {
		super();
		this.galleryNo = galleryNo;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.writerNick = writerNick;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.attachmentNo = attachmentNo;
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}
	public String getGalleryNo() {
		return galleryNo;
	}
	public void setGalleryNo(String galleryNo) {
		this.galleryNo = galleryNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getWriterNick() {
		return writerNick;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAttachmentNo() {
		return attachmentNo;
	}
	public void setAttachmentNo(String attachmentNo) {
		this.attachmentNo = attachmentNo;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getSrc() {
		return filePath + changeName;
	}
	@Override
	public String toString() {
		return "GalleryVo [galleryNo=" + galleryNo + ", title=" + title + ", content=" + content + ", writerNo="
				+ writerNo + ", writerNick=" + writerNick + ", hit=" + hit + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", status=" + status + ", attachmentNo=" + attachmentNo + ", refNo="
				+ refNo + ", originName=" + originName + ", changeName=" + changeName + ", filePath=" + filePath + "]";
	}
}