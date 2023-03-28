package com.akash;
import java.sql.*;
public class M11 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		String sql = ("SELECT * FROM TEST");
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.print(rs.getInt("id") + ", ");
			System.out.print(rs.getString("name") + ", ");
			System.out.print(rs.getInt("age"));
			System.out.println();
		}
		System.out.println("Successfully Show in Database Table");
	}
}
