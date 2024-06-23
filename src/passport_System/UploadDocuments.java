package passport_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UploadDocuments {
	private byte BirthCertificate;
	private byte nic;
	
	public UploadDocuments(byte BirthCertificate,byte nic ) {
		this.BirthCertificate = BirthCertificate;
		this.nic = nic;
	}
	
	public UploadDocuments() {}
	
	public void InsertImage(byte[] BirthCertificate, byte[] nic ) {
		dbConnection ob = new dbConnection();
		Connection conn = ob.dbConnect();
		
		try {
			String sql = "INSERT INTO documents(BirthCertificate,nic)VALUES (?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setBytes(1, BirthCertificate);
			statement.setBytes(2, nic);
			
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted >0) {
				System.out.println("insert success");
			}else {
				System.out.println("insert failed");
			}
			
		}catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}finally {
			//close the database connection
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
