package com.akash;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class M74 {
	public static void main(String[] args) {
		String s1 = "INSERT INTO BOOK1(ID, TITLE) VALUES(900, 'ABC')";
		try (Connection con = Util.getConnection();
			Statement stmt = con.createStatement()){
			stmt.executeUpdate(s1, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
				for(int i = 1; i <= rsmd.getColumnCount(); i++) {
					System.out.println(rs.getString(i));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Show Return Key in Database");
	}
}
