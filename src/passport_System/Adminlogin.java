package passport_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Adminlogin {
	private String Ausername;
	private String Apassword;
	
	public Adminlogin(String Ausername, String Apassword) {
		this.Ausername = Ausername;  //to initialize username and password
		this.Apassword = Apassword;
	}

	public Adminlogin() {}
	
	//query for login
	public boolean LoginAdmin() {
		dbConnection ob = new dbConnection();
		Connection conn = ob.dbConnect();
		
		try {
			String sql = "SELECT * FROM AdminDetails WHERE aUsername=? AND aPassword=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, this.Ausername);
			statement.setString(2, this.Apassword);
			
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		}catch(SQLException e) {
			System.err.println("SQLException: "+e.getMessage());
			e.printStackTrace();
			return false;
		}finally{}
		
		
}
	

	//insert new login details into the database
	public void InsertAdminDetails(String Ausername,String Apassword) {
		dbConnection ob = new dbConnection();
		Connection conn = ob.dbConnect();
		
		try {
			String sql = "INSERT INTO Adminlogin_Details(Ausername,Apassword) VALUES (?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1,Ausername);
			statement.setString(2,Apassword);
			
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

	
	
	}

