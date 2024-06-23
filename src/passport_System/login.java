package passport_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class login {
	private String username;
	private String password;
	
	
	// Parameterized constructor to set username and password
	public login (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	//default constructor
	public login(){}
	
	//check if login details exist in the database
	public boolean validateLogin() {
		dbConnection ob = new dbConnection();
		Connection conn = ob.dbConnect();
		
		try {
			String sql = "SELECT * FROM Signup_Details where Susername =? AND Spassword = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, this.username);
			statement.setString(2, this.password);
			
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next(); //Return true if credentials exist, false otherwise
			}catch(SQLException e) {
				System.err.println("SQLException: "+e.getMessage());
				e.printStackTrace();
				return false; //Return false in case of an exception or other error
			}finally {
				
			}
	}
	
	//insert new login details into the database
	public void insertLoginDetails(String username,String password) {
		dbConnection ob = new dbConnection();
		Connection conn = ob.dbConnect();
		
		try {
			String sql = "INSERT INTO Applicant_login_Details(username,password) VALUES (?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1,username);
			statement.setString(2,password);
			
			int rowsInserted = statement.executeUpdate();
			
			
			if(rowsInserted > 0) {
				System.out.println("Inserted Success ");
				
				
			}else {
				System.out.println("Inserted Failed");
                JOptionPane.showMessageDialog(null, "Insert Failed");
			}
		}catch(SQLException e ) {
			  System.err.println("SQLException: " + e.getMessage());
	            
		}finally {}
				
	}
	
	//method to clear the fields
	public void clearFields() {
		this.username ="";
		this.password = "";
	}

}
