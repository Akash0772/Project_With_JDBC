package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M39 {
	public static void main(String[] args) {
		String sql = ("CREATE TABLE BOOK2(SNO NUMBER)");
		try(Connection con = Util.getConnection();
				PreparedStatement psmt = con.prepareCall(sql)) {
			psmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Create Table in DataBase");
	}
}
