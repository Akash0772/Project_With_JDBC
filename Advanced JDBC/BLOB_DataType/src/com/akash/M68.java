package com.akash;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class M68 {
	public static void main(String[] args) throws Exception {
		String s1 = "INSERT INTO EMP1(ID, PIC) VALUES(?, ?)";
		File f1 = new File("C:\\Users\\akash\\OneDrive\\Pictures\\akash.jpg");
		int length = (int) f1.length();
		byte[] bytes = new byte[length];
		try (Connection con = Util.getConnection();
			PreparedStatement pstmt = con.prepareStatement(s1);
			FileInputStream fin = new FileInputStream(f1);
			BufferedInputStream bin = new BufferedInputStream(fin)){
				bin.read(bytes);
				pstmt.setInt(1, 201);
				pstmt.setObject(2, bytes);
				pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Upload img in Database");
	}
}
