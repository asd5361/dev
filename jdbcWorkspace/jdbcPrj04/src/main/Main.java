package main;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//연결준비
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm = "C##KH_JDBC";
		String pwd = "1234";
		
		//db연결
		Connection conn = DriverManager.getConnection(url, usernm, pwd);
		
		//쿼리 실행
		String sql = "SELECT * FROM MEMBER ORDER BY ID";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
	 	
		//결과 처리
		while(rs.next()) { // 한줄씩
			String dbId = rs.getString("ID");//칼럼명
			String dbPwd = rs.getString("PWD");// 칼럼명
			System.out.println("ID :"+dbId+" PW :"+dbPwd);
	 		
	 	}
	}

}
