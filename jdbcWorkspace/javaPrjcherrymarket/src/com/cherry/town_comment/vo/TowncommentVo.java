package com.cherry.town_comment.vo;

public class TowncommentVo {

	
	@Override
	public String toString() {
		return "TowncommentVo [commentNo=" + commentNo + ", townNo=" + townNo + ", memberNo=" + memberNo
				+ ", enrollDate=" + enrollDate + ", content=" + content + "]";
	}
	public TowncommentVo(String commentNo, String townNo, String memberNo, String enrollDate, String content) {
		super();
		this.commentNo = commentNo;
		this.townNo = townNo;
		this.memberNo = memberNo;
		this.enrollDate = enrollDate;
		this.content = content;
		
	}
	public TowncommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(String commentNo) {
		this.commentNo = commentNo;
	}
	public String getTownNo() {
		return townNo;
	}
	public void setTownNo(String townNo) {
		this.townNo = townNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	private String townNo;
	private String memberNo;
	private String commentNo;
	private String enrollDate;
	private String content;
	
	
}
