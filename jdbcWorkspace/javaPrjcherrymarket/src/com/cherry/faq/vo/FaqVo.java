package com.cherry.faq.vo;

public class FaqVo {

	private String faqNo;
	private String managerNo;
	private String managerName;
	private String title;
	private String content;
	private String enrollDate;
	private String secretYn;
	private String editDate;
	private String hit;
	
	//기본 생성자
	public FaqVo() {
		super();
	}
	
	//생성자
	public FaqVo(String faqNo, String managerNo, String managerName, String title, String content, String enrollDate, String secretYn,
			String editDate, String hit) {
		super();
		this.faqNo = faqNo;
		this.managerNo = managerNo;
		this.managerName = managerName;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.secretYn = secretYn;
		this.editDate = editDate;
		this.hit = hit;
	}
	
	public String getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}
	public String getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
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
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getSecretYn() {
		return secretYn;
	}
	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "FaqVo [faqNo=" + faqNo + ", managerNo=" + managerNo + ", managerName=" + managerName + ", title="
				+ title + ", content=" + content + ", enrollDate=" + enrollDate + ", secretYn=" + secretYn
				+ ", editDate=" + editDate + ", hit=" + hit + "]";
	}
	

	
}//class
