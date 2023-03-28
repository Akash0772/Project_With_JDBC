package com.akash;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class M72 {
	public static void main(String[] args) {
		try (Connection con = Util.getConnection()){
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverMajorVersion());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
