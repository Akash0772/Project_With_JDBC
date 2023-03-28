package com.akash;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;
//import java.sql.Statement;
class Util {
	public static Connection getConnection() throws SQLException {
		Properties pr = new Properties();
		try (FileReader fin = new FileReader("data.properties")){
			pr.load(fin);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String driver = pr.getProperty("driverClassName");
		String url = pr.getProperty("url");
		String un = pr.getProperty("userName");
		String psw = pr.getProperty("password");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ex1) {
			ex1.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, un, psw);
		System.out.println("con : " + con);
//		Statement stmt = con.createStatement();
		return con;
	}
}
