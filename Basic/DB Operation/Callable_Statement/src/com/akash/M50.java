package com.akash;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class M50 {
	public static void main(String[] args) {
		String sql = ("{ CALL P7(?, ?) }");
		try (Connection con = Util.getConnection();
				CallableStatement cstmt = con.prepareCall(sql)){
			cstmt.setInt(1, 903);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.execute();
			String title = cstmt.getString(2);
			System.out.println(title);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Find Value Table in Database");
	}
}