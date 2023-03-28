package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M35 {
	public static void main(String[] args) {
		String sql = ("INSERT INTO BOOK1 VALUES(?, ?, ?, ?)");
		try(Connection con = Util.getConnection();
				PreparedStatement psmt = con.prepareCall(sql)) {
			psmt.setInt(1, 650);
			psmt.setString(2, "Angular");
			psmt.setString(3, "Manu");
			psmt.setInt(4, 600);
			psmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in DataBase");
	}
}
