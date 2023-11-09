package main;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("로그인");
		
		//정보 준비
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm = "C##KH_JDBC";
		String pwd = "1234";
		Scanner sc = new Scanner(System.in);
		
		//DB 연결 
		Connection conn = DriverManager.getConnection(url, usernm, pwd);
		
		//입력받기
		System.out.print("아이디 :");
		String userID = sc.nextLine();
		System.out.print("비밀번호 :");
		String userPwd = sc.nextLine();
		
		//쿼리 실행
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, userID);
		pstmt.setString(2, userPwd);
		
		ResultSet rs = pstmt.executeQuery();
		
		//실행 결과
		if(rs.next()) {			
			String dbId = rs.getString("ID");
			String dbPwd = rs.getString("PWD");
			System.out.println("로그인에 성공하였습니다."+dbId+"님 환영합니다");
		}else {
			System.out.println("로그인에 실패하였습니다.");
		}
		
	}

}
