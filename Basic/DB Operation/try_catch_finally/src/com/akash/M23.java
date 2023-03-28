package com.akash;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
public class M23 {
	public static void main(String[] args) {
//		1. try registering driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "system";
		String password = "akash";
		String sql = ("SELECT * FROM TEST");
		try (Connection con = DriverManager.getConnection(url, userName, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
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
		System.out.println("Successfully Show in Database Table");
	}
}
