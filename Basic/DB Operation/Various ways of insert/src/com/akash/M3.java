package com.akash;
import java.sql.*;
public class M3 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		String sql1 = ("DROP TABLE test CASCADE CONSTRAINTS");
		String sql2 = ("CREATE TABLE test(ID NUMBER, NAME VARCHAR(90), AGE NUMBER)");
		stmt.execute(sql1);
		stmt.execute(sql2);
		System.out.println("Delet Table test Successfully");
		System.out.println("Create Table test Successfully");
	}
}
