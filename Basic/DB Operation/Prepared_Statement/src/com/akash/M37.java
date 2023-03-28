package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M37 {
	public static void main(String[] args) {
		String sql = ("UPDATE BOOK1 SET AUTHOR = ? WHERE ID = ?");
		try(Connection con = Util.getConnection();
				PreparedStatement psmt = con.prepareCall(sql)) {
			psmt.setString(1, "manohar");
			psmt.setInt(2, 653);
			psmt.executeUpdate();
			psmt.setString(1, "murali");
			psmt.setInt(2, 652);
			psmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in DataBase");
	}
}
