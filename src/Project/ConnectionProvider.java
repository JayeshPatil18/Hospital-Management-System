package Project;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	public static Connection createCon() {
		try {
			// Load driver
			Class.forName("com.mysql.jdbc.Driver");
			
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:8080/phpmyadmin/hospital_managment_db";
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
