package com.akash;
import java.sql.*;
public class M18 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		String sql = ("SELECT id, age FROM TEST");
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next()) {
			System.out.print(rsmd.getColumnCount() + ", ");
			System.out.print(rsmd.getColumnName(1) + ", ");
			System.out.print(rsmd.getColumnName(2));
			System.out.println();
		}
		System.out.println("Successfully Show Database Table");
	}
}
