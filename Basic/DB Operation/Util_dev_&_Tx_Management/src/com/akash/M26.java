package com.akash;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class M26 {
	public static void main(String[] args) {
		String sql = ("INSERT INTO BOOK1 VALUES(1, 'JAVA', 'VIJAY', 500)");
		try (Connection con = Util.getConnection();
				Statement stmt = con.createStatement()){
			stmt.execute(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in Database");
	}
}
