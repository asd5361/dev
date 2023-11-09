package com.cherry.manager.vo;

public class ManagerVo {
	
	private String managerNo;	//관리자번호
	private String managerId;	//아이디
	private String pwd;			//비밀번호
	private String name;		//관리자명
	private String joinDate;	//가입일시
	private String quitYn;		//탈퇴여부
	
	public ManagerVo() {
	}
	
	public ManagerVo(String managerNo, String managerId, String pwd, String name, String joinDate, String quitYn) {
		super();
		this.managerNo = managerNo;
		this.managerId = managerId;
		this.pwd = pwd;
		this.name = name;
		this.joinDate = joinDate;
		this.quitYn = quitYn;
	}
	
	public String getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getQuitYn() {
		return quitYn;
	}
	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}
	
	@Override
	public String toString() {
		return "ManagerVo [managerNo=" + managerNo + ", managerId=" + managerId + ", pwd=" + pwd + ", name=" + name
				+ ", joinDate=" + joinDate + ", quitYn=" + quitYn + "]";
	}
}
