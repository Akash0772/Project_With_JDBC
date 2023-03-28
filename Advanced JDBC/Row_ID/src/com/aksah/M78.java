package com.aksah;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class M78 {
	public static void main(String[] args) {
		String s1 = "INSERT INTO EMP3(SNO, NAME) VALUES(1, 'ABC')";
		try (Connection con = Util.getConnection();
			Statement stmt = con.createStatement()){
			stmt.executeUpdate(s1, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			String rowId = null;
			if(rs.next()) {
				rowId = rs.getString(1);
			}
			s1 = "UPDATE EMP3 SET R_ID = '" + rowId +"' WHERE SNO = 1";
			stmt.executeUpdate(s1);
			System.out.println("done");
		} catch (SQLException ex) {
			for(Throwable t : ex) {
				System.out.println(t);
			}
		}
	}
}

/*
  CREATE TABLE EMP3(SNO NUMBER, NAME VARCHAR2(90), R_ID ROWID);
*/