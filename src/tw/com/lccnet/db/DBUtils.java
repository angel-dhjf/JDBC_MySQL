package tw.com.lccnet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC 四個結構
 * 
 * Connection   程式與資料庫驗證與連接
 * PreparedStatement 傳送SQL語法，使用暗碼
 * Statement 傳送SQL語法使用明碼，會被攻擊(有安全性的部分不見使用)
 * ResultSet 接收資料庫的搜尋結果
 * 
 * 檔案，資料庫，網路
 * port先開後關，皆會要求進行異常處理
 * 
 */

public class DBUtils {
	//常數
	//JDBC Driver
	private final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver"; 
	//連接資料庫位址
	private final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/guidb?serverTimezone=UTC&useSSL=false"; 
	//資料庫帳號
	private final String JDBC_USER="資料庫帳號"; 
	//資料庫密碼
	private final String JDBC_PASSWORD="資料庫密碼";
	//JDBC 
	private Connection conn=null;
	
	
	private DBUtils() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConn() {
		try {
			conn=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static DBUtils getDB() {
		
		return new DBUtils();
	}
	
	//方法的多載（傳入JDBC四個功能）
	public void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(PreparedStatement ps) {
		if(ps !=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	public void close(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
