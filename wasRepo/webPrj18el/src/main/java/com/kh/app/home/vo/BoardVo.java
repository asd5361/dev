package com.kh.app.home.vo;

public class BoardVo {

	private String title;
	private String writer;
	private String hit;
	public BoardVo(String title, String writer, String hit) {
		super();
		this.title = title;
		this.writer = writer;
		this.hit = hit;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", writer=" + writer + ", hit=" + hit + "]";
	}
	
}
