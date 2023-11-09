package com.kh.db.template;

import java.io.*;
import java.sql.*;

public class JDBCTemplate {
		
		//getConnetion
		public static Connection getConnetion() throws Exception {
			
			/*
			 * Info.txt 안에 접속 정보를 적어 사용한다.
			 */
			File f = new File("Info.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			/*
			 * 위 1줄 코드와 같은 의미
			 * FileReader fr = new FileReader(f);
			 * BufferedReader br = new BufferedReader(fr);
			 */
			String url = br.readLine();
			String userName = br.readLine();
			String userPwd = br.readLine();
			
			Connection conn = DriverManager.getConnection(url,userName,userPwd);
			conn.setAutoCommit(false);
			return conn;
		}
		
		//close (conn)
		public static void close(Connection conn) {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
				
			}catch(Exception e) {}
		}
		//close (stmt)
		public static void close(Statement stmt) {
			try {
				if(stmt != null && !stmt.isClosed())
					stmt.close();
				
			}catch(Exception e) {}
		}
		//close (rs)
		public static void close(ResultSet rs) {
			try {
				if(rs != null && !rs.isClosed())
					rs.close();
				
			}catch(Exception e) {}
		}
		
		//commit
		public static void commit(Connection conn) {
			try {
				if(conn != null && !conn.isClosed())
					conn.commit();
				
			}catch(Exception e) {}
		}
		
		//rollback
		public static void rollback(Connection conn) {
			try {
				if(conn != null && !conn.isClosed())
					conn.rollback();
				
			}catch(Exception e) {}
		}
	}
