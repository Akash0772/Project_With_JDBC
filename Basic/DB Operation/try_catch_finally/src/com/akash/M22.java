package com.akash;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
public class M22 {
	public static void main(String[] args) {
//		1. try registering driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "system";
			String password = "akash";
			
//			2. Establish DataBase Connection
			con = DriverManager.getConnection(url, userName, password);
			
//			3. Create Statement
			stmt = con.createStatement();
			
//			4. Composed SQL Command
			String sql = ("SELECT * FROM TEST");
			
//			5. triggering SQL Command
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for(int i = 1; i <= cols; i++) {
				System.out.print(rsmd.getColumnName(i) + " \\");
			}
			System.out.println();
			System.out.println("============================");
			while(rs.next()) {
				for(int i = 1; i <= cols; i++) {
					System.out.print(rs.getString(i) + " \\");
				}
				System.out.println();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
//			Close DataBase Resources
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
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
		System.out.println("Successfully Show in Database Table");
	}
}
