package db;

import java.sql.*;

public class JDBCTemplate {

	public static Connection getConnection() throws Exception {
		
		//연결 준비
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm ="C##KH_JDBC";
		String pwd = "1234";
		
		//디비연결
		Connection conn = DriverManager.getConnection(url, usernm, pwd);
		conn.setAutoCommit(false);
		
		return conn;
	}
	

	//conn close
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		}catch(Exception e) {
		}
	}
	
	
	//stmt or pstmt close
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		}catch(Exception e) {
		}
	}
	
	
	//rs close
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		}catch(Exception e) {
		}
	}
	
	
	//commit
	public static void commit(Connection conn) {
		try {
			if(conn != null) {
				conn.commit();
			}
		}catch(Exception e) {
		}
	}
	
	
	//rollback
	public static void rollback(Connection conn) {
		try {
			if(conn != null) {
				conn.rollback();
			}
		}catch(Exception e) {
		}
	}
}
