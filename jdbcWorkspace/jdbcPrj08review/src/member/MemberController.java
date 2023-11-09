package member;

import java.sql.*;
import java.util.Scanner;

import db.util.JDBCTemplate;

public class MemberController {
	
	private Scanner sc;
	public MemberController() {
		this.sc = new Scanner(System.in);
	}
	
	public void selectMenu() {
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		
		String menu = sc.nextLine();
		
		switch(menu) {
			case "1" : join(); break;
			case "2" : login(); break;
			default : System.out.println("잘못 입력함");
		}
	}

	public void join(){
		System.out.println("회원가입");
		//연결 준비
		//db연결
		
		//입력 받기
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			
			//쿼리 실행
			String sql = "INSERT INTO MEMBER (ID,PWD) VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			int result = pstmt.executeUpdate();
			
			//결과 처리
			if(result == 1) {
				conn.commit();
				System.out.println("회원가입 성공");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			try {if(conn !=null && !conn.isClosed()) conn.rollback();} catch(Exception x) {}
			System.out.println("회원가입 실패");
			e.printStackTrace();
		}finally {
			
			// 자원 반납 다음은 try 문 + catch 문에 롤백과 회원가입 실패 문구 넣기
			try{if(pstmt !=null && !pstmt.isClosed()) pstmt.close();}catch(Exception e){}
			try{if(conn !=null && !conn.isClosed()) conn.close();}catch(Exception e) {} 		
			
		}//try~catch
	
	}//join
	
	public void login() {
		System.out.println("로그인");
		//연결 준비
		
		//db연결
		
		//입력 받기
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//conn얻기
			conn = JDBCTemplate.getConnection();
			
			//쿼리 실행
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			
			//결과 처리
			if(rs.next()) {
				String dbid = rs.getString("ID");
				System.out.println("로그인 완료 "+dbid+"님 환영합니다.");
			}else {
				throw new Exception(); //예외가 발생 했을 때 로그인 실패 문구가 뜨게 하기 위해서 발생시킴.
			}
			
		}catch(Exception e) {
			System.out.println("로그인 실패");
			
		}finally {
			// 자원 반납
			try{ if(rs != null && !rs.isClosed()) rs.close();}catch(Exception e) {}
			try{ if(pstmt != null && !pstmt.isClosed()) pstmt.close(); }catch(Exception e){}
			try{ if(conn != null && conn.isClosed())conn.close();}catch(Exception e){}
			
		}
		
		
		
		
	}
	
	
}
