package com.akash;
// Follow 7 step

// Import the package ( MOBILE )
import java.sql.*; // step-1
public class M1 {
	public static void main(String[] args) throws Exception {
		
//		Create sql database table query
		String sql = "CREATE TABLE AKASH_TAB(SNO NUMBER)"; // step-2

//		Load & Register driver ( Call & SIM Card )
		Class.forName("oracle.jdbc.driver.OracleDriver"); // step-3
		
//		Establish the Connection ( Call Dial a No. )
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "akash"); // step-4
//																URL							 UserName  Password
//		Create the Statement ( Call OUT & IN )
		Statement stmt = con.createStatement(); // step-5

//		Execute the Query ( SPEAK )
		stmt.execute(sql); // step-6
		
//		Process Result ( RESPONSE )
		System.out.println("Successfully Created Table in Database"); // step-7
		
	}
}
