package com.akash;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class M61 {
	public static void main(String[] args) {
		String sql = ("SELECT ID, NAME, Age, SALARY FROM EMP1");
		int i = ResultSet.TYPE_SCROLL_SENSITIVE;
		int j = ResultSet.CONCUR_UPDATABLE;
		try (Connection con = Util.getConnection();
			Statement stmt = con.createStatement(i, j);
			ResultSet rs = stmt.executeQuery(sql)){
			rs.afterLast();
			System.out.println("Reading 5nd Record");
			if(rs.absolute(5)) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\t");
				System.out.print(rs.getInt(4));
				System.out.println();
			}
			System.out.println("Reading 3rd Record");
			if(rs.relative(-2)) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\t");
				System.out.print(rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Show Table in Database");
	}
}
