package com.cherry.town.vo;



public class TownVo {
	
	
	
	public TownVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TownVo(String townNO, String title, String content, String wirterNick, String hit, String enrollDate,
			String delYn, String category, String towncommentcont, String editdate) {
		super();
		this.townNO = townNO;
		this.title = title;
		this.content = content;
		this.wirterNick = wirterNick;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
		this.category = category;
		this.towncommentcont = towncommentcont;
		this.editdate = editdate;
	}
	public String getTownNO() {
		return townNO;
	}
	public void setTownNO(String townNO) {
		this.townNO = townNO;
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
	public String getWirterNick() {
		return wirterNick;
	}
	public void setWirterNick(String wirterNick) {
		this.wirterNick = wirterNick;
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTowncommentcont() {
		return towncommentcont;
	}
	public void setTowncommentcont(String towncommentcont) {
		this.towncommentcont = towncommentcont;
	}
	public String getEditdate() {
		return editdate;
	}
	public void setEditdate(String editdate) {
		this.editdate = editdate;
	}
	@Override
	public String toString() {
		return "TownVo [townNO=" + townNO + ", title=" + title + ", content=" + content + ", wirterNick=" + wirterNick
				+ ", hit=" + hit + ", enrollDate=" + enrollDate + ", delYn=" + delYn + ", category=" + category
				+ ", towncommentcont=" + towncommentcont + ", editdate=" + editdate + "]";
	}
	private String townNO;
	private String title;
	private String content;
	private String wirterNick;
	private String hit;
	private String enrollDate;
	private String delYn;
	private String category;
	private String towncommentcont;
	private String editdate;
	
}
