package com.akash;
import java.sql.*;
public class M51 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		String sql = ("CREATE TABLE TEST1(SBO NUMBER)");
		stmt.execute(sql);
		System.out.println("Successfully Created Table in Database");
	}
}
