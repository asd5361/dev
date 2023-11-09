package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("JDBC");
	
		
		// 연결정보 준비
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String username = "C##KH";
		String pwd = "1234";
		
		// DB 연결해서 Connection 얻기

		Connection conn = DriverManager.getConnection(url,username,pwd);
		
		//쿼리문 실행 및 결과 받기		
		Statement stmt = conn.createStatement();
		
		String sql = "INSERT INTO MEMBER (MEMBER_NO,ID,PWD,NICK,ENROLL_DATE,QUIT_YN)"
				    + "VALUES (1,'JAVA','7777','JAVA',SYSDATE,'N')";
		
		int result = stmt.executeUpdate(sql); 
		
		System.out.println("result :"+ result);
		/*
			DML 구문들 실행 가능 (insert, update, delete)
			DML 구문들 같은 경우 실행 결과가 숫자로 나온다.
		*/
		
	}

}
