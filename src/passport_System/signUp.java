package passport_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class signUp {
	private String Sname;
	private String Snic;
	private String Susername;
	private String Spassword;
	private String SCpassword;
	
	public signUp(String Sname,String Snic,String Susername, String Spassword,String SCpassword) {
		this.Sname = Sname;
		this.Snic = Snic;
		this.Susername = Susername;
		this.Spassword = Spassword;
		this.SCpassword = SCpassword;
		
	}
	
	public signUp() {}
	
	//query for sign up 
	public void ApplicantSignUp(String name, String nic, String username, String Password, String Cpassword) {
		dbConnection ob = new dbConnection();
		Connection conn = ob.dbConnect();
		
		//check if passwords are empty
		try {
			//check whether passwords are matching
			if(!Password.equals(Cpassword)) {
				JOptionPane.showMessageDialog(null, "Sign up failed. Passwords do not match.");
                return; // Exit method if passwords don't match
			}else if (Password.isEmpty()){
				JOptionPane.showMessageDialog(null, "Sign up failed. Password cannot be Epmty");
                return;
			}else if(Cpassword.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Sign up failed.You must comfirm your Password");
                return;
			}else if(Password.isEmpty()&& Cpassword.isEmpty()){
				JOptionPane.showMessageDialog(null, "Sign up failed.You must enter password");
                return;
			}else if (username.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Sign up failed.You must enter a username");
                return;
			}
			
			if(isUsernameExists(username,conn)) {
				 JOptionPane.showMessageDialog(null, "Sign up failed. Username already exists.");
	                return; // Exit method if username exists
	                
			}
			
			//insert details into database
			String sql = "INSERT INTO Signup_Details(Sname,Snic,Susername,Spassword,SCpassword) VALUES (?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1,name);
			statement.setString(2, nic);
			statement.setString(3,username);
			statement.setString(4,Password);
			statement.setString(5, Cpassword);
			
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				 System.out.println("Inserted Successfully");
	                JOptionPane.showMessageDialog(null, "Sign up successful");
	                
	                LoginFrame Login = new LoginFrame();
	                Login.setVisible(true);
	                
			}else {
				System.out.println("Insered Failed");
			}
		}catch(SQLException e) {
			System.out.println(e);
            JOptionPane.showMessageDialog(null, "Sign up failed. See console for details.");
		}
	}
	
	//Check if the username already exists in the database
	private boolean isUsernameExists(String username,Connection conn)throws SQLException {
		String query  = "SELECT * FROM Signup_Details WHERE Susername = ?";
		try(PreparedStatement checkStatement = conn.prepareStatement(query)){
				checkStatement.setString(1,username);
				ResultSet resultSet = checkStatement.executeQuery();
				return resultSet.next();
		}
	}
	public void clearFields(){
		this.Sname="";
		this.Snic="";
		this.Susername="";
		this.Spassword="";
		this.SCpassword="";
		
		
	}

}
