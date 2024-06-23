package passport_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Applicant {
	private int applicationNo;
	private String typeOfservice;
	private String ApplicantSName;
	private String ApplicantNIC;
	private String ApplicantAddress;
	private String ApplicantBirthday;
	private String ApplicantGender;
	private String ApplicantConNumber;
	private String ApplicantEmail;
	
	public Applicant( String typeOfservice, String ApplicantSName,String ApplicantNIC,String ApplicantAddress,String ApplicantBirthday,String ApplicantGender,String ApplicantConNumber,String ApplicantEmail ) {
		
		this.typeOfservice = typeOfservice;
		this.ApplicantSName = ApplicantSName;
		this.ApplicantNIC = ApplicantNIC;
		this.ApplicantAddress = ApplicantAddress;
		this.ApplicantBirthday = ApplicantBirthday;
		this.ApplicantGender = ApplicantGender;
		this.ApplicantConNumber = ApplicantConNumber;
		this.ApplicantEmail = ApplicantEmail;
	}
	
	public Applicant(){}
	
	//Insert Applicant details into database
	public String InsertApplicantDetails( String typeOfservice, String ApplicantSName, String ApplicantNIC,String ApplicantAddress, String ApplicantBirthday,String ApplicantGender,String ApplicantConNumber , String ApplicantEmail  ) {
		dbConnection ob = new dbConnection();
		Connection conn = ob.dbConnect();
		
		try {
			String sql = "INSERT INTO applicant_Details(typeOfService,ApplicantSName,ApplicantNIC,ApplicantAddress,ApplicantBirthday,ApplicantGender,ApplicantConNumber,ApplicantEmail) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			
			statement.setString(1, typeOfservice);
			statement.setString(2, ApplicantSName);
			statement.setNString(3, ApplicantNIC);
			statement.setString(4, ApplicantAddress);
			statement.setString(5, ApplicantBirthday);
			statement.setString(6, ApplicantGender);
			statement.setString(7, ApplicantConNumber);
			statement.setString(8, ApplicantEmail);
			
			int rowsInserted = statement.executeUpdate();
			
			
			if(rowsInserted > 0  /*&&  !typeOfservice.isEmpty() && !ApplicantOthernames.isEmpty() && !ApplicantAddress.isEmpty() && !ApplicantBirthday.isEmpty() && !ApplicantGender.isEmpty() && !ApplicantConNumber.isEmpty() && !ApplicantEmail.isEmpty() */ ) {
				System.out.println("Inserted Success ");
				//JOptionPane.showMessageDialog(null, "Application was successfully submitted");
			return "Type of Service:  " +typeOfservice+ "\nApplicant Name:  " +ApplicantSName+ "\nNIC:  " +ApplicantNIC+ "\nAddress:  " +ApplicantAddress+ "\nBirthday:  " +ApplicantBirthday+ "\nGender:  "+ApplicantGender+"\nContact Number:  "+ApplicantConNumber+"\nEmail:  "+ApplicantEmail;
				
			}else {
				return null;
            
			}
		}catch(SQLException e ) {
			  System.err.println("SQLException: " + e.getMessage());
	           return null; 
		}finally {}
		
		
	}
	
	
	}

