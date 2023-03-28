package com.akash;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class M66 {
	public static void main(String[] args) {
		String s1 = "INSERT INTO EMP1(ID, NAME, AGE, SALARY) VALUES(9, 'MOHAN', 22, 50000)";
		String s2 = "UPDATE EMP1 SET NAME = 'MOHAN' WHERE ID = 5";
		String s3 = "DELETE FROM EMP1 WHERE ID = 4";
 		String s4 = "INSERT INTO BOOK1 VALUES(100, 'J2EE', 'MOHAN', 500)";
		try (Connection con = Util.getConnection();
			Statement stmt = con.createStatement()){
			stmt.addBatch(s1);
			stmt.addBatch(s2);
			stmt.addBatch(s3);
			stmt.addBatch(s4);
			int[] results = stmt.executeBatch();
			System.out.println(Arrays.toString(results));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Successfully Batch Update in Database");
	}
}
