package com.kh.app.reply.vo;

public class ReplyVo {
	
	String no;
	String refNo;
	String content;
	String writerNo;
	String enrollDate;
	String status;
	
	public ReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReplyVo(String no, String refNo, String content, String writerNo, String enrollDate, String status) {
		super();
		this.no = no;
		this.refNo = refNo;
		this.content = content;
		this.writerNo = writerNo;
		this.enrollDate = enrollDate;
		this.status = status;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
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

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReplyVo [no=" + no + ", refNo=" + refNo + ", content=" + content + ", writerNo=" + writerNo
				+ ", enrollDate=" + enrollDate + ", status=" + status + "]";
	}
	
}