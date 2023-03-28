package com.akash;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


public class M76 {
	public static void main(String[] args) {
		String s1 = "INSERT INTO BOOK1(ID, TITLE) VALUES(901, 'ABC')";
		String s2 = "INSERT INTO BOOK1(ID, TITLE) VALUES(902, 'XYZ')";
		String s3 = "INSERT INTO BOOK1(ID, TITLE) VALUES(903, 'test)";
		String s4 = "INSERT INTO BOOK1(ID, TITLE) VALUES(904, 'java')";
		Connection con = null;
		Statement stmt = null;
		Savepoint sp = null;
		try{
			con = Util.getConnection();
			stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.executeUpdate(s1);
			System.out.println("------------");
			sp = con.setSavepoint("firstSavePoint");
			System.out.println("after save point");
			stmt.executeUpdate(s2);
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
					con.rollback(sp);
//					con.commit();
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
