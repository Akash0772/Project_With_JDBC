package com.akash;
import java.sql.*;
public class M2 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		String sql = ("INSERT INTO AKASH_TAB VALUES(1000)");
		stmt.execute(sql);
		System.out.println("Successfully Data Insert in Database");
	}
}
