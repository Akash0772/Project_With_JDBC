package com.akash;
import java.sql.*;
import java.io.*;
public class M8 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akash");
		Statement stmt = con.createStatement();
		FileReader fin = new FileReader("data.txt");
		BufferedReader bin = new BufferedReader(fin);
		String record = bin.readLine();
		String id, name, age, sql, data[];
		while(record != null) {
			data = record.split("; ");
			id = data[0].trim();
			name = data[1].trim();
			age = data[2].trim();
			sql = ("INSERT INTO TEST VALUES( " + id + ", '" + name + "', " + age + ")");
			stmt.execute(sql);
			record = bin.readLine();
		}
		System.out.println("Successfully Insert in Database");
	}
}
