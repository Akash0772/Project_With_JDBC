package com.akash;
import java.sql.*;
public class M17 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		String sql = ("SELECT id p_id, age p_age FROM TEST");
		ResultSet rs = stmt.executeQuery(sql);
		int count = 0;
		while(rs.next()) {
			count++;
			System.out.print(rs.getString("p_id") + ", ");
			System.out.print(rs.getString("p_age"));
			System.out.println();
		}
		System.out.println("Successfully Show Database Table");
		System.out.println("Table Count " + count);
	}
}
