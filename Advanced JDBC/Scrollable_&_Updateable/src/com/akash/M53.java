package com.akash;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class M53 {
	public static void main(String[] args) {
		String sql = ("CREATE TABLE EMP1(ID NUMBER PRIMARY KEY," +
						"NAME VARCHAR2(90), AGE NUMBER, SALARY NUMBER, " +
						"PIC BLOB)");
		try (Connection con = Util.getConnection();
			Statement stmt = con.createStatement()){
			stmt.execute(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Create Table in Database");
	}
}
