package passport_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkStatus {
	private String ApplicantNIC;
	private String status;
	
	public checkStatus(String ApplicantNIC,String status ) {
		this.ApplicantNIC = ApplicantNIC;
		this.status = status;
		
		
	}
	
	public checkStatus() {}

	
	//check status from database
	public String validateStatus() {
		dbConnection ob = new dbConnection();
		Connection conn = ob.dbConnect();
		
		try {
			String sql = "SELECT * FROM applicant_Details WHERE ApplicantNIC =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
		
			statement.setString(1, ApplicantNIC);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				status = resultSet.getString("status");
				
				
			}
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
					
				
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		return status;
		
		
	}
}
