package com.kh.app.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	//getConnection
	   public static Connection getConnection() throws Exception {
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String id = "C##SEMI";
	      String pwd = "1234";
	      
	      //JDBC 드라이버 로딩
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      
	      Connection conn = DriverManager.getConnection(url , id, pwd);
	      conn.setAutoCommit(false);
	      return conn;
	   }
	   
	   //commit
	   public static void commit(Connection conn) {
	      try {
	         if(conn != null && !conn.isClosed()) {
	            conn.commit();
	         }
	      } catch (SQLException e) {
	         
	      }
	   }
	   
	   //rollback
	   public static void rollback(Connection conn) {
	      try {
	         if(conn != null && !conn.isClosed()) {
	            conn.rollback();
	         }
	      } catch (SQLException e) {
	         
	      }
	   }
	   
	   //close (conn)
	   public static void close(Connection x) {
	      try {
	         if(x != null && !x.isClosed()) {
	            x.close();
	         }
	      } catch (SQLException e) {
	         
	      }
	   }
	   
	   //close (stmt)
	   public static void close(Statement x) {
	      try {
	         if(x != null && !x.isClosed()) {
	            x.close();
	         }
	      } catch (SQLException e) {
	         
	      }
	   }
	   
	   //close (rs)
	   public static void close(ResultSet x) {
	      try {
	         if(x != null && !x.isClosed()) {
	            x.close();
	         }
	      } catch (SQLException e) {
	         
	      }
	   }
}
