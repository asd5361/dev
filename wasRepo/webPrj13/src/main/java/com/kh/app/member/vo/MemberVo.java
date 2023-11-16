package com.kh.app.member.vo;

public class MemberVo {

	private String memberId;
	private String memberPwd;
	private String memberPWd2;
	private String memberNick;
	
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String memberId, String memberPwd, String memberPWd2, String memberNick) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberPWd2 = memberPWd2;
		this.memberNick = memberNick;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberPWd2() {
		return memberPWd2;
	}
	public void setMemberPWd2(String memberPWd2) {
		this.memberPWd2 = memberPWd2;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberPWd2=" + memberPWd2
				+ ", memberNick=" + memberNick + "]";
	}
	
}
