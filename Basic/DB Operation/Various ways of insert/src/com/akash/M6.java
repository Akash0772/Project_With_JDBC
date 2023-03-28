package com.akash;
import java.sql.*;
import java.util.Scanner; 
public class M6 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Id");
		String id = sc.next();
		System.out.println("Please Enter Name");
		String name = sc.next();
		System.out.println("Please Enter Age");
		String age = sc.next();
		String sql = ("INSERT INTO TEST VALUES(" + id + ", '" + name + "', " + age + ")");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		System.out.println("Successfully Insert in Database");
	}
}
