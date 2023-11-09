package member;

public class MemberData {
	
	//기본생성자
	public MemberData() {
		
	}
	
	//생성자 (id,pwd)
	public MemberData(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	//모든 필드를 파라미터로 받는 생성자
	public MemberData(String id, String pwd, String nick) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
	}
	
	//필드
	private String id;
	private String pwd;
	private String nick;
	
	//getter/setter
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwd() {
		return this.pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getNick() {
		return this.nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	//toString
	@Override
	public String toString() {
		return "클래스명 : MemberData, ID : "+ id  +" , PWD : "+pwd+" , NICK : "+ nick;
	}

}