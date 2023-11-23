package com.kh.app.board.vo;

public class BoardVo {

	private String no;
	private String categoryNo;
	private String categoryName;
	private String title;
	private String content;
	private String writerNo;
	private String writeNick;
	private String hit;
	private String enrollDate;
	private String modifyDate;
	private String status;
	
	public BoardVo(String no, String categoryNo, String categoryName, String title, String content, String writerNo,
			String writeNick, String hit, String enrollDate, String modifyDate, String status) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.writeNick = writeNick;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public String getWriteNick() {
		return writeNick;
	}
	public void setWriteNick(String writeNick) {
		this.writeNick = writeNick;
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
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", title="
				+ title + ", content=" + content + ", writerNo=" + writerNo + ", writeNick=" + writeNick + ", hit="
				+ hit + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	
}
