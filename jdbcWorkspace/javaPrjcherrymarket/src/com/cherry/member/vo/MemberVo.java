package com.cherry.member.vo;

public class MemberVo {
	
	private String memberNo;	//사용자번호
	private String areasCode;	//동네코드
	private String areasName;	//동네이름
	private String id;			//아이디
	private String pwd;			//비밀번호
	private String nick;		//닉네임
	private String name;		//이름
	private String email;		//이메일
	private String phone;		//전화번호
	private String address;		//주소
	private String joinDate;	//가입일시
	private String editDate;	//수정일시
	private String quitYn;		//탈퇴여부
	private String mannerScore; //매너온도
	
	public MemberVo() {
	}
	public MemberVo(String memberNo, String areasCode, String areasName, String id, String pwd, String nick,
			String name, String email, String phone, String address, String joinDate, String editDate, String quitYn,
			String mannerScore) {
		this.memberNo = memberNo;
		this.areasCode = areasCode;
		this.areasName = areasName;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.joinDate = joinDate;
		this.editDate = editDate;
		this.quitYn = quitYn;
		this.mannerScore = mannerScore;
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
	public String getAreasName() {
		return areasName;
	}
	public void setAreasName(String areasName) {
		this.areasName = areasName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getQuitYn() {
		return quitYn;
	}
	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}
	public String getMannerScore() {
		return mannerScore;
	}
	public void setMannerScore(String mannerScore) {
		this.mannerScore = mannerScore;
	}
	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", areasCode=" + areasCode + ", areasName=" + areasName + ", id=" + id
				+ ", pwd=" + pwd + ", nick=" + nick + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", joinDate=" + joinDate + ", editDate=" + editDate + ", quitYn=" + quitYn
				+ ", mannerScore=" + mannerScore + "]";
	}
}