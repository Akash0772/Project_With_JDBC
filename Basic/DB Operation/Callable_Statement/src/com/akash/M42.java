package com.akash;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class M42 {
	public static void main(String[] args) {
		String sql = ("{ CALL P1 }");
		try (Connection con = Util.getConnection();
				CallableStatement cstmt = con.prepareCall(sql)){
			cstmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Show Procedure Command");
	}
}
