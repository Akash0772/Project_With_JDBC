package com.akash;
import java.sql.*;
public class M12 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		String sql = ("SELECT * FROM TEST");
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.print(rs.getInt(1) + ", ");
			System.out.print(rs.getString(2) + ", ");
			System.out.print(rs.getInt(3));
			System.out.println();
		}
		System.out.println("Successfully Show in Database Table");
	}
}
