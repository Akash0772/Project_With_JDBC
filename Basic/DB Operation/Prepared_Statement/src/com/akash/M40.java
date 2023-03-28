package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M40 {
	public static void main(String[] args) {
		String sql = ("INSERT INTO BOOK2 VALUES(?)");
		try(Connection con = Util.getConnection();
				PreparedStatement psmt = con.prepareCall(sql)) {
			psmt.setInt(1, 100);
			psmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in DataBase");
	}
}
