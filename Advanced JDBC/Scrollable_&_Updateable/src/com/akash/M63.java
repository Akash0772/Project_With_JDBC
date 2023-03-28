package com.akash;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class M63 {
	public static void main(String[] args) {
		String sql = ("SELECT ID, NAME, Age, SALARY FROM EMP1");
		int i = ResultSet.TYPE_SCROLL_SENSITIVE;
		int j = ResultSet.CONCUR_UPDATABLE;
		try (Connection con = Util.getConnection();
			Statement stmt = con.createStatement(i, j);
			ResultSet rs = stmt.executeQuery(sql)){
			if(rs.absolute(3)) {
				rs.deleteRow();
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Deleted Row in Database");
	}
}
