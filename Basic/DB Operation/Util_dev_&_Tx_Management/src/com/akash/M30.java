package com.akash;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class M30 {
	public static void main(String[] args) {
		String sql1 = ("INSERT INTO BOOK1 VALUES(30, 'SPRING', 'MANU', 600)");
		String sql2 = ("INSERT INTO BOOK1 VALUES(40, 'HIBERNATE', 'KUMAR', 600)");
		String sql3 = ("INSERT INTO BOOK1 VALUES(50, HADOOP', 'SWETHA', 600)");
		Connection con = null;
		try{
			con = Util.getConnection();
			Statement stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.executeUpdate(sql1);
			System.out.println("sql1 is triggered successfully");
			stmt.executeUpdate(sql2);
			System.out.println("sql2 is triggered successfully");
			stmt.executeUpdate(sql3);
			System.out.println("sql3 is triggered successfully");
			con.commit();
		} catch (SQLException ex) {
			try {
				con.rollback();
			} catch (SQLException ex1) {
				// TODO: handle exception
			}
			ex.printStackTrace();
		}
		System.out.println("Successfully Insert Table in Database");
	}
}
