package main;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("회원가입");
	
		//연결 준비
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm="C##KH_JDBC";
		String pwd="1234";
		
		//디비 연결 == conn 얻기
		Connection conn = DriverManager.getConnection(url, usernm, pwd);
	 	
		//데이터 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		//쿼리 실행
		String sql = "INSERT INTO MEMBER(ID,PWD) VALUES ('"+userId+"','"+userPwd+"')";
		String ssql = "SELECT * FROM MEMBER";
		Statement stmt = conn.createStatement();

	 	int result = stmt.executeUpdate(sql); //DML 처리 : insert, update, delete 가능

	 	System.out.println("result : "+result);
	 	

	}


}
