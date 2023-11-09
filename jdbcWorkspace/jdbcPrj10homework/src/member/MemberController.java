package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import util.JDBCTemplate;

public class MemberController {
	
	// 필드 (멤버변수)
	private Scanner sc;
	
	//기본 생성자
	public MemberController() {
		sc = new Scanner(System.in);
	}
	
	// 메뉴 선택
	public void selectMenu() {
		System.out.println("=====회원 관리 프로그램=====");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 전체 회원 목록");
		String n = sc.nextLine();
		
		switch(n) {
		case "1" :	join(); break; 
		case "2" :	login(); break; 
		case "3" :	printMemberList(); break; 
		}
	}//selectMenu
	
	// 회원가입
	private void join() {
		System.out.println("-----회원가입-----");
		
		// 데이터 입력받기
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// conn 얻기
			conn = JDBCTemplate.getConnection();
			
			// 쿼리 실행
			String sql = "INSERT INTO MEMBER(ID, PWD) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			int result = pstmt.executeUpdate();
			
			// 결과처리
			if(result == 1) {
				conn.commit();
				System.out.println("회원가입 성공 !!!");
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			JDBCTemplate.rollback(conn);
			System.out.println("회원가입 실패 ...");
			e.printStackTrace();
		}finally {
			// 자원반납
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		
	}
	
	// 로그인
	private void login() {
		System.out.println("-----로그인-----");
		
		// 데이터 입력받기
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// conn 얻기
			conn = JDBCTemplate.getConnection();
			
			// 쿼리 실행
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {
				System.out.println("로그인 성공 !!!");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("로그인 실패 ...");
			e.printStackTrace();
		}finally {
			// 자원반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		
	}//login
	
	// 전체 회원 목록 조회
	private void printMemberList() {
		System.out.println("-----전체 회원 목록 조회-----");
		
		// 데이터 입력받기
		// 전부 다 조회하면 되니까 입력받을 건 없음 ,,,
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// conn 얻기
			conn = JDBCTemplate.getConnection();
			
			// 쿼리 실행
			String sql = "SELECT * FROM MEMBER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 결과처리
			while(rs.next()) {
				//rs 의 모든 행을 읽어오기
				String dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				
				System.out.println(dbId + " / " + dbPwd);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 자원반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
	}//getMemberList

}//class

























