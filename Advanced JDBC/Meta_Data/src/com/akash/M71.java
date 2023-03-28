package com.akash;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class M71 {
	public static void main(String[] args) {
		String s1 = "INSERT INTO BOOK1 VALUES(?, ?, ?, ?)";
		try (Connection con = Util.getConnection();
			PreparedStatement pstmt = con.prepareStatement(s1)){
			ParameterMetaData pmd = pstmt.getParameterMetaData();
			int count = pmd.getParameterCount();
			System.out.println(count);
			pstmt.setInt(1, 5000);
			pstmt.setString(2, "Java");
			pstmt.setString(3, "MOHAN");
			pstmt.setInt(4, 5000);
			pstmt.executeUpdate();
			System.out.println("Successfully Update in DataBase");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
