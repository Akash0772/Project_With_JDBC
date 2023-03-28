package com.akash;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class M25 {
	public static void main(String[] args) {
		String sql = ("CREATE TABLE BOOK1 (ID NUMBER, TITLE VARCHAR2(90), AUTHOR VARCHAR2(90), PRICE NUMBER)");
		try (Connection con = Util.getConnection();
				Statement stmt = con.createStatement()){
			stmt.execute(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Create Table in Database");
	}
}
