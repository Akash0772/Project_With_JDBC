package com.akash;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class M27 {
	public static void main(String[] args) {
		String sql = ("INSERT INTO BOOK1 VALUES(2, 'J2EE', 'RAMU', 600)");
		try (Connection con = Util.getConnection();
				Statement stmt = con.createStatement()){
			int i = stmt.executeUpdate(sql);
			System.out.println(i);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in Database");
	}
}
