package com.akash;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class M48 {
	public static void main(String[] args) {
		String sql = ("{ CALL P5(?, ?, ?) }");
		try (Connection con = Util.getConnection();
				CallableStatement cstmt = con.prepareCall(sql)){
			cstmt.setInt(1, 901);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.execute();
			String title = cstmt.getString(2);
			String author = cstmt.getString(3);
			System.out.println(title + ", " + author);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Find Value Table in Database");
	}
}