package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M33 {
	public static void main(String[] args) {
		String sql = ("INSERT INTO BOOK1 VALUES(350, 'SPRING', 'MANU', 600)");
		try(Connection con = Util.getConnection();
				PreparedStatement psmt = con.prepareCall(sql)) {
			psmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in DataBase");
	}
}
