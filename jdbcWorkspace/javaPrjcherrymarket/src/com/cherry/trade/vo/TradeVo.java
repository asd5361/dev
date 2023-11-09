package com.cherry.trade.vo;

public class TradeVo {


	private String boardNo;
	private String memberNo;
	private String areasCode;
	private String title;
	private String tradeAreas;
	private String content;
	private String completeYn;
	private String delYn;
	private String product;
	private String price;
	private String enrollDate;
	private String editDate;
	private String memberName;
	private String areasName;
	private String memberNick;
	private String hit;
	
	// 구매 내역
	private String purchaseNo; // 구매 내역 번호 
	private String purchaseDate;  // 구매일시 , ENROLL_DATE
	private String buyerNo; // 구매자번호
	
	// 거래 후기
	private String reviewNo; // 후기 번호
	private String score; // 매너온도
	private String reviewContent ; // 리뷰 내용 , CONTENT
	private String reviewDate; // 리뷰일시 , ENROLL_DATE
	
	public TradeVo() {
		super();
	}
	public TradeVo(String boardNo, String memberNo, String areasCode, String title, String tradeAreas, String content,
			String completeYn, String delYn, String product, String price, String enrollDate, String editDate,
			String memberName, String areasName, String memberNick, String purchaseNo, String purchaseDate,
			String buyerNo, String reviewNo, String score, String reviewContent, String reviewDate, String hit) {
		super();
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.areasCode = areasCode;
		this.title = title;
		this.tradeAreas = tradeAreas;
		this.content = content;
		this.completeYn = completeYn;
		this.delYn = delYn;
		this.product = product;
		this.price = price;
		this.enrollDate = enrollDate;
		this.editDate = editDate;
		this.memberName = memberName;
		this.areasName = areasName;
		this.memberNick = memberNick;
		this.purchaseNo = purchaseNo;
		this.purchaseDate = purchaseDate;
		this.buyerNo = buyerNo;
		this.reviewNo = reviewNo;
		this.score = score;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.hit = hit;
	}
	
	
	
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getAreasCode() {
		return areasCode;
	}
	public void setAreasCode(String areasCode) {
		this.areasCode = areasCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTradeAreas() {
		return tradeAreas;
	}
	public void setTradeAreas(String tradeAreas) {
		this.tradeAreas = tradeAreas;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCompleteYn() {
		return completeYn;
	}
	public void setCompleteYn(String completeYn) {
		this.completeYn = completeYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getAreasName() {
		return areasName;
	}
	public void setAreasName(String areasName) {
		this.areasName = areasName;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getBuyerNo() {
		return buyerNo;
	}
	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public String toString() {
		return "TradeVo [boardNo=" + boardNo + ", memberNo=" + memberNo + ", areasCode=" + areasCode + ", title="
				+ title + ", tradeAreas=" + tradeAreas + ", content=" + content + ", completeYn=" + completeYn
				+ ", delYn=" + delYn + ", product=" + product + ", price=" + price + ", enrollDate=" + enrollDate
				+ ", editDate=" + editDate + ", memberName=" + memberName + ", areasName=" + areasName + ", memberNick="
				+ memberNick + ", hit=" + hit + ", purchaseNo=" + purchaseNo + ", purchaseDate=" + purchaseDate
				+ ", buyerNo=" + buyerNo + ", reviewNo=" + reviewNo + ", score=" + score + ", reviewContent="
				+ reviewContent + ", reviewDate=" + reviewDate + "]";
	}

	
	
	
	
	
	
}
