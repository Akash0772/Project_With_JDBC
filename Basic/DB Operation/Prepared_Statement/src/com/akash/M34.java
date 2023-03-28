package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M34 {
	public static void main(String[] args) {
		String sql = ("INSERT INTO BOOK1 VALUES(450, 'SPRING', 'MANU', 600)");
		try(Connection con = Util.getConnection();
				PreparedStatement psmt = con.prepareCall(sql)) {
			psmt.executeUpdate();
			psmt.executeUpdate();
			psmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in DataBase");
	}
}
