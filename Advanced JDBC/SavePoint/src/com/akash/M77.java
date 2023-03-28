package com.akash;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


public class M77 {
	public static void main(String[] args) {
		String s1 = "INSERT INTO BOOK1(ID, TITLE) VALUES(9011, 'ABC')";
		String s2 = "INSERT INTO BOOK1(ID, TITLE) VALUES(9021, 'XYZ')";
		String s3 = "INSERT INTO BOOK1(ID, TITLE) VALUES(9031, 'test)";
		String s4 = "INSERT INTO BOOK1(ID, TITLE) VALUES(9041, 'java')";
		Connection con = null;
		Statement stmt = null;
		Savepoint sp1 = null;
		Savepoint sp2 = null;
		try{
			con = Util.getConnection();
			stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.executeUpdate(s1);
			sp1 = con.setSavepoint("firstSavePoint");
			System.out.println("------------");
			stmt.executeUpdate(s2);
			sp2 = con.setSavepoint("SecondSavePoint");
			System.out.println("--------------");
			stmt.executeUpdate(s3);
			System.out.println("--------------");
			stmt.executeUpdate(s4);
			System.out.println("--------------");
			con.commit();
		} catch (SQLException ex) {
			System.out.println("some exception");
			try {
				if(con != null) {
					con.rollback(sp2);
					con.commit();
				}
			}
			catch(SQLException ex1) {
				ex1.printStackTrace();
			}
		}
		finally {
//			close stmt and con
		}
		System.out.println("Successfully Show Return Key in Database");
	}
}
