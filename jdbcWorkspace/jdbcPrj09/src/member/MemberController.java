package member;

import java.sql.*;
import java.util.Scanner;

import db.JDBCTemplate;

public class MemberController {
	
	private Scanner sc = null;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberController() {
		sc = new Scanner(System.in);
	}
	
	//메뉴선택
	public void selecmenu() {
		//데이터 입력 받기
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		String menu = sc.nextLine();
		
		switch(menu) {
		case "1" : join(); break;
		case "2" : login(); break;
		}
	}
	

	//회원가입
	public void join() {
		
		//데이터 입력 받기
		System.out.print("아이디 :");
		String userId = sc.nextLine();
		System.out.print("비밀번호 :");
		String userPwd = sc.nextLine();
		
		//예외처리문
		try{
			//conn연결
			conn = JDBCTemplate.getConnection();
			
			//쿼리 실행
			String sql ="INSERT INTO MEMBER (ID,PWD)VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			int result = pstmt.executeUpdate();
			
			//실행 결과
			if(result == 1) {
				JDBCTemplate.commit(conn);
//				conn.commit();
				System.out.println("회원가입 완료");
			}else { throw new Exception();}
			
			
		}catch(Exception e){
			
			//예외 처리
			JDBCTemplate.rollback(conn);
			System.out.println("회원가입 실패");
			e.printStackTrace();
			
			
		}finally {
			
			//자원 반납
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
			
		}
		
	}
	
	//로그인
	public void login() {
		
		//데이터 입력 받기
		System.out.print("아이디 :");
		String userId = sc.nextLine();
		System.out.print("비밀번호 :");
		String userPwd = sc.nextLine();
		
		try {
			
			//conn연결
			conn = JDBCTemplate.getConnection();
			
			//쿼리 실행
			String sql = "SELECT * FROM MEMBER WHERE ID =? AND PWD = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,userId);
			pstmt.setString(2,userPwd);
			
			rs = pstmt.executeQuery();
			
			//실행 결과
			if(rs.next()) {
				System.out.println("로그인 완료");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			
			//예외 처리
			System.out.println("로그인 실패");
			e.printStackTrace();
			
			
		}finally{
			
			//자원 반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		
		
	}

	
}
