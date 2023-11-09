package main;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("로그인 창 만들기");
		
		//연결준비
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm ="C##KH_JDBC";
		String pwd ="1234";
		Scanner sc = new Scanner(System.in);
		//디비연결 == conn 얻기
		try {
			Connection conn = DriverManager.getConnection(url, usernm, pwd);
			Statement stmt = conn.createStatement();
			
			//입력 받기
			System.out.print("아이디 :");
			String userId = sc.nextLine();
			System.out.print("비밀번호 :");
			String userPwd = sc.nextLine();
			
			//쿼리 실행
			String sql = "SELECT * FROM MEMBER WHERE ID ='"+userId+"' AND PWD ='"+userPwd+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			//결과 처리
			if(rs.next()) {
				String dbID = rs.getString("ID");
				System.out.println("로그인에 성공하였습니다. "+dbID+"님 환영합니다.");

			}else {
				System.out.println("로그인 실패");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
