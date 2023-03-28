package com.akash;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class M44 {
	public static void main(String[] args) {
		String sql = ("{ CALL P3(901, 'HADOOP', 'murali', 3000) }");
		try (Connection con = Util.getConnection();
				CallableStatement cstmt = con.prepareCall(sql)){
			cstmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Updates Table in Database");
	}
}
