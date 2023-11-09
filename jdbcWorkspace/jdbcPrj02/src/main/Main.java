package main;

import java.sql.*;

public class Main {

	public static void main(String[] args)throws Exception {

		//연결정보 준비
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm ="C##KH";
		String pwd ="1234";
		//db 연결해서 connection 얻기
		Connection conn = DriverManager.getConnection(url, usernm, pwd);
		
		//쿼리문 실행 및 결과 받기
		String sql ="UPDATE MEMBER SET NICK = 'LEE' WHERE ID = 'JAVA'AND PWD='7777'";
		Statement stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		
		System.out.println("result : "+result);
	}

}
