package com.kh.app.member.db;

import java.sql.*;

public class JDBCTemplate {

	public static Connection getConnection() throws Exception{
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String usernm = "C##KH_JDBC";
		String userpw = "1234";
		
		Connection conn = DriverManager.getConnection(url,usernm,userpw);
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	public static void Commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {}
	}
	
	public static void Rollback(Connection conn){
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {}
	}
	
	public static void Close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		}catch(Exception e) {}
	}
	
	public static void Close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		}catch(Exception e) {}
	}
	public static void Close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed())
				rs.close();
		}catch(Exception e) {}
	}

}
