package com.akash;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class M24 {
	public static void main(String[] args) {
		
		Properties pr = new Properties();
		try(FileReader fin = new FileReader("db.properties")) {
			pr.load(fin);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String driver = pr.getProperty("driverClassName");
		String url = pr.getProperty("url");
		String un = pr.getProperty("userName");
		String psw = pr.getProperty("password");
//		1. try registering driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		String sql = ("SELECT * FROM TEST");
		try (Connection con = DriverManager.getConnection(url, un, psw);
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
