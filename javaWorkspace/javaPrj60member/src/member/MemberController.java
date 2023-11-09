package member;

import java.util.Scanner;

public class MemberController {
	
	//멤버변수 == 필드 == 객체변수 == 인스턴스 변수
		private Scanner sc;
		
		//기본생성자 (==매개변수가 없는 생성자)
		public MemberController(){
			sc = new Scanner(System.in);
		}
		

		//회원가입
		public void join() {
			System.out.println("-----회원가입-----");
			// 아이디 , 비번, 닉네임 입력받기
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("패스워드 : ");
			String pwd = sc.nextLine();
			System.out.print("닉네임 : ");
			String nick = sc.nextLine();
			
			// 저장
//			id,pwd,nick 이용해서 MemberData객체 만들기
			MemberData memberData = new MemberData(id,pwd,nick);
//			멤버DAO객체.join(MemberData객체);
			MemberDao dao = new MemberDao();
			boolean result = dao.join(memberData);
			 
			// 결과출력
			if(result) {
				System.out.println("회원가입 성공!!!");
			}else {
				System.out.println("회원가입 실패");
			}
		}
		
		//로그인
		public void login() {
			System.out.println("-----로그인-----");
			// 아이디 , 비번 입력받기
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			
			//입력받은 데이터 뭉치기
			MemberData memberData = new MemberData(id,pwd);
			
			// 저장된 데이터 꺼내기
			MemberDao dao = new MemberDao();
			boolean isSuccess = dao.login(memberData);
			// 결과 출력
			if(isSuccess) {
				System.out.println("로그인 성공 !!!");
			}else {
				System.out.println("로그인 실패 ...");
			}
		}
	
}
