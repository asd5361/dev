package member.controller;

import java.io.*;
import java.util.*;

public class MemberManager {
	
	private Scanner sc;
	private File f;
	private PrintWriter pw;
	private BufferedReader br;

	public MemberManager() throws Exception {
		sc =new Scanner(System.in);
		String x = File.separator;
		f = new File("D:"+ x +"dev"+ x +"data.txt");
		pw = new PrintWriter(new FileWriter(f, true), true);
//		br = new BufferedReader(new FileReader(f));

	}
	
	//메뉴
	public void showMenu() throws Exception {
		System.out.println("\n메뉴===========");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 전체 회원 조회");
		System.out.println("원하시는 메뉴 번호를 입력하세요");
		
		String menu = sc.nextLine();
		
		switch(menu) {
		case "1" :join(); break;
		case "2" :login(); break;
		case "3" :selectAllUser(); break; 
		default : System.out.println("잘못 입력했습니다.");
		}
	}
	
	//회원가입
	private void join() throws Exception {
		System.out.println("회원가입====================");
		
		//유저한테 데이터(아이디,비번,닉네임) 입력받기
		System.out.print("아이디 : " );
		String id = sc.nextLine();
		System.out.print("비밀번호 : " );
		String pwd = sc.nextLine();
		System.out.print("닉네임 : " );
		String nick = sc.nextLine();
		
		//데이터 검사
		boolean isError = id.contains("#");
		if(isError){
			throw new Exception("아이디에는 #을 사용할 수 없습니다.");
		}
		
		//파일(메모장)에 저장하기
		pw.println(id+"#"+pwd+"#"+nick);
		System.out.println("회원가입 완료");
		
	}//join end
	
	
	//로그인
	private void login() throws Exception {
		br = new BufferedReader(new FileReader(f));
		System.out.println("로그인 창====================");
		
		//유저한테 데이터(아이디,비번) 입력 받기
		System.out.print("아이디 : " );
		String id = sc.nextLine();
		System.out.print("비밀번호 : " );
		String pwd = sc.nextLine();
		boolean isOk =false;
		
		while(true) {
			//파일(메모장)에서 회원정보 조회
			String str = br.readLine();
			if(str == null) break;
			
			//회원정보 꺼내기
			int idx = str.indexOf("#");
			String memoId = str.substring(0,idx);
			String memoPwd = str.substring(idx+1,str.lastIndexOf("#"));
			String memonick = str.substring(str.lastIndexOf("#")+1);
			
			//일치 여부 확인
			isOk = id.equals(memoId)&& pwd.equals(memoPwd);
			if(isOk) break;
			
		}
			
			if(isOk) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패"); 
			}
	}
	//모든 회원 정보 조회
	private void selectAllUser() throws Exception {
		br = new BufferedReader(new FileReader(f));
		//파일(메모장)에서 모든 정보 읽기
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			System.out.println("\n아이디 :"+str.substring(0, str.indexOf("#")));
			System.out.println("닉네임 :"+str.substring(str.lastIndexOf("#"))+"");
		}
//		String[] arr = str.split("#",3);
//			String memoId = arr[0];
//			String memoPwd = arr[1];
//			String memoNick = arr[2];
//			System.out.println("아이디 :"+memoId+"\n비밀번호 :"+memoPwd+"\n닉네임 :"+memoNick);
	}
	
}
