package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M36 {
	public static void main(String[] args) {
		String sql = ("INSERT INTO BOOK1 VALUES(?, ?, ?, ?)");
		try(Connection con = Util.getConnection();
				PreparedStatement psmt = con.prepareCall(sql)) {
			psmt.setInt(1, 651);
			psmt.setString(2, "JS");
			psmt.setString(3, "Manu");
			psmt.setInt(4, 300);
			psmt.executeUpdate();
			psmt.setInt(1, 652);
			psmt.setString(2, "CORE JAVA");
			psmt.setString(3, "VIJAY");
			psmt.setInt(4, 500);
			psmt.executeUpdate();
			psmt.setInt(1, 653);
			psmt.setString(2, "Servlets");
			psmt.setString(3, "KIRAN");
			psmt.setInt(4, 550);
			psmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in DataBase");
	}
}
