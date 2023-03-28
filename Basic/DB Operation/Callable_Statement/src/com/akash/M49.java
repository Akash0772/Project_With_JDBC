package com.akash;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class M49 {
	public static void main(String[] args) {
		String sql = ("{ CALL P6(?) }");
		try (Connection con = Util.getConnection();
				CallableStatement cstmt = con.prepareCall(sql)){
			cstmt.setInt(1, 2006);
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			int age = cstmt.getInt(1);
			System.out.println(age);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Find Value Table in Database");
	}
}