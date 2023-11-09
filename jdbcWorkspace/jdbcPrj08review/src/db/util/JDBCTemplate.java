package db.util;

import java.sql.*;

public class JDBCTemplate {

	//연결 준비
	
	public static Connection getConnection() throws Exception {
		//연결 준비
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm = "C##KH_JDBC";
		String pwd = "1234";
		
		//디비 연결 == conn 얻기
		Connection conn = DriverManager.getConnection(url, usernm, pwd);
		conn.setAutoCommit(false);
		return conn;
		
	}

}
