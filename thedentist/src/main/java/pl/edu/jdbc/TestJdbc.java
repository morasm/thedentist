package pl.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://...?serverTimezone=UTC";
		String user = "...";
		String pass = "...";
		
		try {
			System.out.println("Connecting to: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Success!");
			
			myConn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
