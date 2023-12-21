package com.kh.app.board.vo;

public class BoardVo {

	
	private String title;
	private String content;
	private String writer;
	public BoardVo(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public BoardVo() {
		super();
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
	
}
