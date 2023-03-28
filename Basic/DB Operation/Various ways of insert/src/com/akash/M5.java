package com.akash;
import java.sql.*; 
public class M5 {
	public static void main(String[] args) throws Exception {
		if(args.length < 3) {
			System.out.println("Please Suplly 3 Command Line Argument");
			return;
		}
		String id = args[0];
		String name = args[1];
		String age = args[2];
		String sql = ("INSERT INTO TEST VALUES(" + id + ", '" + name + "', " + age + ")");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		System.out.println("Successfully Insert in Database");
	}
}
