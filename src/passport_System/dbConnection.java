package passport_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

	private String username;
	private String password;
	private String hostName;
	private String dbname;
	
	public dbConnection() {
		this.username = "root";
		this.password = "kasuni1234";
		this.hostName = "localhost";
		this.dbname = "PassportSystem";
		
	}


	Connection conn = null;
	public Connection dbConnect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/passport_Automation_System",username,password);
			System.out.println("connection done");
			return conn;
		}catch(SQLException e) {
			System.out.println("connection faild");
			return conn;
			
			
		}
	}
}
