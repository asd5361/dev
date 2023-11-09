package com.kh.mini.member.controller;

import java.util.*;

import com.kh.mini.main.Main;
import com.kh.mini.member.service.MemberService;
import com.kh.mini.member.vo.MemberVo;


public class MemberController {
	
	private final MemberService service;
	
	public MemberController() {
		service = new MemberService();
	}
	public void selectMenu() {
		System.out.println("===== MEMBER =====");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 로그아웃");
		System.out.println("4. 회원 탈퇴");
		System.out.println("5: 전체회원조회 (관리자만)");
		System.out.println("6. 마이 페이지"); // + 닉네임 변경 + 비밀번호 변경
		
		
		String num = Main.SC.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		case "3" : logout(); break;
		case "4" : quit(); break;
		case "5" : memberList(); break;
		case "6" : mypage(); break;
		
			default : System.out.println("잘못 입력하였습니다.");
		}
	}
	private void logout() {
		if(Main.loginMember == null) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		Main.loginMember = null;
		System.out.println("로그아웃 되었습니다.");
	}
	/*
	 * 회원가입
	 * 클라이언트로부터 아이디, 패스워드, 닉네임을 입력 받아서 DB에 저장
	 * INSERT INTO MEMBER (NO,ID,PWD,NICK) VALUES (SEQ_MEMBER.NEXTVAL,?,?,?)
	 */
	public void join() {
		try {
			//데이터 준비
			System.out.print("ID : ");
			String id =Main.SC.nextLine();
			System.out.print("PWD : ");
			String pwd =Main.SC.nextLine();
			System.out.print("NICK : ");
			String nick =Main.SC.nextLine();
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			
			//서비스 호출
			int result = service.join(vo);
			
			//결과 처리
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("회원가입 완료");
		}catch(Exception e) {
			System.out.println("회원가입 실패");
			e.printStackTrace();
		}
	}
	
	/*
	 * 로그인
	 * 아이디, 비번 입력
	 * SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N' 
	 */
	public void login() {
		try {
			if(Main.loginMember != null) {
				System.out.println("이미 로그인 상태입니다");
				return;
			}
			//데이터
			System.out.print("ID : ");
			String id =Main.SC.nextLine();
			System.out.print("PWD : ");
			String pwd =Main.SC.nextLine();
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			//서비스
			MemberVo dbvo = service.login(vo);
			
			//결과
			if(dbvo == null) {
				throw new Exception();
			}
			System.out.println("로그인 성공");
			Main.loginMember = dbvo;
			System.out.println("로그인 유저 닉네임 : "+ dbvo.getNick());
		}catch(Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
		
	}
	/*
	 * 회원탈퇴
	 * UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = ? AND DEL_YN = 'N'
	 * 
	 */
	public void quit() {
		try {
			System.out.println("========== 회원 탈퇴 ==========");
			
			if(Main.loginMember == null) {
				throw new Exception("로그인 후 회원 탈퇴를 시도하세요.");
			}
			
			//데이터
			String no = Main.loginMember.getNo();
			
			//서비스
			int result = service.quit(no);
			
			//결과
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("회원 탈퇴 성공");
			logout();
		}catch(Exception e) {
			System.out.println("회원탈퇴 실패");
			e.printStackTrace();
		}
	}
	/* 마이페이지 조회 (현재 로그인한 본인 정보 조회)
	 * 
	 * SELECT * FROM MEMBER WHERE NO = ?
	 * 
	 */
	public void mypage() {
		try {
			//로그인 검사
			if(Main.loginMember == null) {
				throw new Exception("로그인부터 진행해주세요");
			}
			
			//결과
			System.out.println("========== 마이페이지 ==========");
			System.out.println("아이디 : "+Main.loginMember.getId());
			System.out.println("비밀번호 : "+Main.loginMember.getPwd());
			System.out.println("닉네임 : "+Main.loginMember.getNick());
			System.out.println("가입일시 : "+Main.loginMember.getEnrollDate());
			System.out.println("==============================");
			
			//정보변경
			System.out.println("1. 닉네임변경");
			System.out.println("2. 비밀번호변경");
			System.out.println("9. 이전으로 돌아가기");
			String num = Main.SC.nextLine();
			
			switch(num) {
			case "1" : changeNick(); break;
			case "2" : changePwd(); break;
			case "9" : return; 
			default : System.out.println("잘못 입력하였습니다.");
			}
			
		}catch(Exception e) {
			System.out.println("마이페이지 조회 실패");
			e.printStackTrace();
		}
	}
	/*비밀번호 수정
	 * UPDATE MEMBER SET PWD = ? WHERE NO = ?
	 * 
	 */
	private void changePwd() {
		System.out.println("========== 비밀번호 변경 ==========");
		try {
			System.out.println("현재 비밀번호 입력 : ");
			String oldPwd = Main.SC.nextLine();

			System.err.println("새 비밀번호 입력 : ");
			String newPwd = Main.SC.nextLine();
			
			String no = Main.loginMember.getNo();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("oldPwd",oldPwd);
			map.put("newPwd",newPwd);
			map.put("no",no);
			
			int result = service.changePwd(map);
			
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("비밀번호 변경 완료");
			logout();
			
		}catch(Exception e) {
			System.out.println("비밀번호 변경 실패");
			e.printStackTrace();
		}
	}
	/*닉네임 수정
	 * UPDATE MEMBER SET NICK = ? WHERE NO = ?
	 * 
	 */
	private void changeNick() {
		System.out.println("========== 닉네임 변경 ==========");
		try {
			//데이터
			System.out.print("새 닉네임을 입력해주세요 : ");
			String newNick = Main.SC.nextLine();
			MemberVo vo = new MemberVo();
			
			vo.setNick(newNick);
			vo.setNo(Main.loginMember.getNo());
			
			//서비스
			int result = service.changeNick(vo);
			
			//결과
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("닉네임 변경 성공!");
			logout();
			
		}catch(Exception e) {
			System.out.println("닉네임 변경 실패");
			e.printStackTrace();
		}
	}
	
	/*전체 회원 조회 (관리자만 가능)
	 * SELECT ID, NICK, ENROLL_DATE, MODIFY_DATE, DEL_YN FROM MEMBER
	 * 
	 */
	public void memberList() {
		try {
			//데이터
			if(!Main.loginMember.getNo().equals("1")) {
				throw new Exception("관리자만 가능합니다.");
			}
			//서비스
			List<MemberVo> list = service.memberList();
			
			//결과
			if(list == null) {
				throw new Exception();
			}
			System.out.printf("%-8s%-10s%-20s%-8s%-8s\n","| 아이디", "| 닉네임", "| 가입일자","| 수정일자", "| 탈퇴여부");
			for(MemberVo vo : list) {
				System.out.printf("%-10s%-10s%-10s%-10s%-10s\n","| "+vo.getId(),"| "+vo.getNick(),"| "+vo.getEnrollDate(),"| "
						+vo.getModifyDate(),"| "+vo.getDelYn());
			}
		}catch(Exception e) {
			System.out.println("회원 전체 조회 실패");
			e.printStackTrace();
		}
	}
	//회원 조회 - 번호 (관리자만 가능)
	//회원 조회 - 아이디(관리자만 가능)
	//회원 조회 - 닉네임(관리자만 가능)
	
	//회원 강제탈퇴 (관리자만 가능) 미완성함
	public void adminQuit() {
		try {
			if(!Main.loginMember.getId().equals("1")) {
				throw new Exception("관리자만 강제탈퇴를 할 수 있습니다.");
			}
			//서비스
			int result = service.adminQuit();
			//결과처리
			if(result != 1) {
				throw new Exception();
			}
		}catch(Exception e){
			System.out.println("강제탈퇴 실패");
			e.printStackTrace();
		}
	}
}
