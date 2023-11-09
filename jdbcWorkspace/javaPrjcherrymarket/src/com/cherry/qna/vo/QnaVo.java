package com.cherry.qna.vo;

public class QnaVo {
	
	private String qnaNo;
	private String memberNo;
	private String managerNo;
	private String title;
	private String content;
	private String memberEnrollDate;
	private String secretYn;
	private String answer;
	private String managerEnrollDate;
	private String managerEditDate;
	private String writerNick;
	private String hit;
	
	public QnaVo(String qnaNo, String memberNo, String managerNo, String title, String content, String memberEnrollDate,
			String secretYn, String answer, String managerEnrollDate, String managerEditDate, String writerNick,
			String hit) {
		super();
		this.qnaNo = qnaNo;
		this.memberNo = memberNo;
		this.managerNo = managerNo;
		this.title = title;
		this.content = content;
		this.memberEnrollDate = memberEnrollDate;
		this.secretYn = secretYn;
		this.answer = answer;
		this.managerEnrollDate = managerEnrollDate;
		this.managerEditDate = managerEditDate;
		this.writerNick = writerNick;
		this.hit = hit;
	}

	public QnaVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(String qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
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

	public String getMemberEnrollDate() {
		return memberEnrollDate;
	}

	public void setMemberEnrollDate(String memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}

	public String getSecretYn() {
		return secretYn;
	}

	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getManagerEnrollDate() {
		return managerEnrollDate;
	}

	public void setManagerEnrollDate(String managerEnrollDate) {
		this.managerEnrollDate = managerEnrollDate;
	}

	public String getManagerEditDate() {
		return managerEditDate;
	}

	public void setManagerEditDate(String managerEditDate) {
		this.managerEditDate = managerEditDate;
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

	@Override
	public String toString() {
		return "QnaVo [qnaNo=" + qnaNo + ", memberNo=" + memberNo + ", managerNo=" + managerNo + ", title=" + title
				+ ", content=" + content + ", memberEnrollDate=" + memberEnrollDate + ", secretYn=" + secretYn
				+ ", answer=" + answer + ", managerEnrollDate=" + managerEnrollDate + ", managerEditDate="
				+ managerEditDate + ", writerNick=" + writerNick + ", hit=" + hit + "]";
	}
	
	
	

}
