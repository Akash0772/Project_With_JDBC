package com.akash;
import java.sql.*;
import java.util.Scanner;
public class M19 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Table Name");
		String tableName = sc.next();
		String sql = ("SELECT * FROM TEST " + tableName);
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		while(rs.next()) {
			for(int i = 1; i <= cols; i++) {
				System.out.print(rs.getString(i) + ", ");
			}
			System.out.println();
		}
		System.out.println("Successfully Show Database Table");
	}
}
