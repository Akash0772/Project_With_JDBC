package com.akash;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class M21 {
	public static void main(String[] args) {
//		1. try registering driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "system";
			String password = "akash";
			
//			2. Establish DataBase Connection
			con = DriverManager.getConnection(url, userName, password);
			
//			3. Create Statement
			stmt = con.createStatement();
			
//			4. Composed SQL Command
			String sql = ("INSERT INTO TEST VALUES(21, 'MAN', 35)");
			
//			5. triggering SQL Command
			stmt.execute(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
//			Close DataBase Resources
			try {
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				if(con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} // End of finally
		System.out.println("Successfully Insert in Database");
	}
}
