package main;

import java.util.*;

public class MemberManager {

	//멤버변수
	private Scanner sc = new Scanner(System.in);
	//멤버 객체 저장
	private Map<String,Member> memberMap = new HashMap<String,Member>();
	
	public void startWork() {
		showMember();
		String input= scanUserString();
		switch(input) {
		case "1": join(); break;
		case "2": login(); break;
		default : System.out.println("잘못 입력했습니다.");
		}
	}
	
	//메뉴 보여주기
	public void showMember() {
		System.out.println("\n 원하는 번호를 입력하세요");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
	}
	
	//입력받기
	public String scanUserString() {
		return sc.nextLine();
	}
	
	//회원가입
	public void join() {
		System.out.println("회원가입을 시작하자");
		
		System.out.print("아이디 :");
		String id = scanUserString();
		
		System.out.print("비밀번호 :");
		String pwd = scanUserString();
		
		System.out.print("닉네임 :");
		String nick = scanUserString();

		
//		memberMap.put(id,new Member(id,pwd,nick)); 
		Member m = new Member(id,pwd,nick);
		
//		//값 검증
//		try {
//			checkValidation(m);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return;
//		}
		
		memberMap.put(m.getId(),m); 
		
		System.out.println(m.getId()+"님 회원가입이 완료되었습니다.");
		
	}
	private void checkValidation(Member m) throws Exception {

			//아이디 검사
			checkId(m.getId());
			//비밀번호 검사
			
			//닉네임 검사
			Main.an = false;
	}
	
	//아이디 검사
	private void checkId(String id) throws Exception {
		//길이 검사
		if(id.length() < 4 && id.length() < 20) {
			throw new Exception("아이디의 길이는 4~20자만 가능합니다.");
		};
	}

	//로그인
	public void login() {
		System.out.println("로그인창을 띄우자");
		
		System.out.print("아이디 :");
		String userId = scanUserString();
		
		System.out.print("비밀번호 :");
		String userPwd = scanUserString();
		
		Member x = memberMap.get(userId);
		
		boolean result = userId.equals(x.getId())&&userPwd.equals(x.getPwd());
		
		if(result) {
			System.err.println(memberMap.get(userId).getNick()+"님 로그인 성공");
			Main.an = false;
		}else if(userId.equals(x.getId())){
			System.out.println("로그인 실패");
			System.out.println("비밀번호가 틀렸습니다. 다시 해주세요");
		}else{
		System.out.println("로그인 실패");
		System.out.println("아이디가 틀렸습니다. 다시 해주세요");
	}
				
		//		if(memberMap.get(id) != null) {
//			System.err.println(memberMap.get(id).getNick()+"님 로그인 성공");
//			Main.an = false;
//		}else{
//			System.out.println("로그인 실패");
//			Main.an = false;
//		}
		
	}
		
	
}
