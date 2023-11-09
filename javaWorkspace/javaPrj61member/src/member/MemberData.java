package member;

public class MemberData {
	
	//기본생성자
//	public MemberData() {
//		
//	}
	
	//생성자(id,pwd)
	public MemberData(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	//모든 필드채우는 생성자
	public MemberData(String id, String pwd, String nick) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
	}
	
	//필드 == 멤버변수
	private String id;
	private String pwd;
	private String nick;
	
	//getter/setter
	public String getId() {
		return id;
	}
	
//	public void setId(String id) {
//		this.id = id;
//	}
	
	public String getPwd() {
		return pwd;
	}
	
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
	
	public String getNick() {
		return nick;
	}
	
//	public void setNick(String nick) {
//		this.nick = nick;
//	}
	
	//toString (형식 자유롭게, 모든필드 확인)
	@Override
	public String toString() {
		return id + " / " + pwd + " / " + nick;
	}

}