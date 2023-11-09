package main;

public class User {
	
	private String id;
	private String pwd;
	
	public User() {
		super();
	}
	
	public User(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	String getId() {
		return id;
	}
	void setId(String id) {
		this.id = id;
	}
	String getPwd() {
		return pwd;
	}
	void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + "]";
	}
	
	
	
	

}
