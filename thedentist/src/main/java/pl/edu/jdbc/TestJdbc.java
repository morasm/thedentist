package pl.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://psql.serwer1905034.home.pl:5432/29624990_zpo_gs2019?serverTimezone=UTC";
		String user = "29624990_zpo_gs2019";
		String pass = "ThdB_gs_112019@edu";
		
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
