package com.akash;
import java.sql.*;
import java.util.Scanner; 
public class M7 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		String id, name, age, sql;
		do {
			System.out.println("Please Enter Id");
			id = sc.next();
			System.out.println("Please Enter Name");
			name = sc.next();
			System.out.println("Please Enter Age");
			age = sc.next();
			sql = ("INSERT INTO TEST VALUES(" + id + ", '" + name + "', " + age + ")");
			stmt.execute(sql);
			System.out.println("Do You Want to Insert One More (yes/no)?");
		}
		while ("yes".equalsIgnoreCase(sc.next()));
		System.out.println("Successfully Insert in Database");
	}
}
