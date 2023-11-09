package main;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("pstmt 사용");
		
		//연결준비
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm ="C##KH_JDBC";
		String pwd ="1234";
		Scanner sc = new Scanner(System.in);
		
		try {
			
			//디비연결 == conn 얻기
			Connection conn = DriverManager.getConnection(url, usernm, pwd);
			
			//입력 받기
			System.out.print("아이디 :");
			String userId = sc.nextLine();
			System.out.print("비밀번호 :");
			String userPwd = sc.nextLine();
			
			//쿼리 실행
			String sql = "INSERT INTO MEMBER (ID,PWD) VALUES (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			int result = pstmt.executeUpdate();
			if(result >0) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
			
			//결과 처리
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
