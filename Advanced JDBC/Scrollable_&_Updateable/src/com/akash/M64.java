package com.akash;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class M64 {
	public static void main(String[] args) {
		String sql = ("SELECT ID, NAME, Age, SALARY FROM EMP1");
		int i = ResultSet.TYPE_SCROLL_SENSITIVE;
		int j = ResultSet.CONCUR_UPDATABLE;
		try (Connection con = Util.getConnection();
			Statement stmt = con.createStatement(i, j);
			ResultSet rs = stmt.executeQuery(sql)){
			rs.moveToInsertRow();
			rs.updateInt(1, 7);
			rs.updateString(2, "NARESH");
			rs.updateInt(3, 33);
			rs.updateInt(4, 45000);
			rs.insertRow();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Row in Database");
	}
}
