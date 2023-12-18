package com.kh.app.board.vo;

public class BoardVo {

	
	private String Title;
	private String Content;
	private String enrollDate;
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(String title, String content) {
		super();
		Title = title;
		Content = content;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "BoardVo [Title=" + Title + ", Content=" + Content + ", enrollDate=" + enrollDate + "]";
	}
	
}
