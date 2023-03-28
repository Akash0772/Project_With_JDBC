package com.akash;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class M47 {
	public static void main(String[] args) {
		String sql = ("{ CALL P4(?, ?) }");
		try (Connection con = Util.getConnection();
				CallableStatement cstmt = con.prepareCall(sql)){
			cstmt.setInt(1, 2002);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.execute();
			String s1 = cstmt.getString(2);
			System.out.println(s1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Find Value Table in Database");
	}
}

/*
  Three Types of Argument Procedure
  
  IN
  OUT
  IN OUT
*/
