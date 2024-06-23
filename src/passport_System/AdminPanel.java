package passport_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminPanel {

	private int applicationNo;
	private String DocumentVerification;
	private String PoliceVerification;
	
	public AdminPanel(int applicationNo, String DocumentVerification, String PoliceVerification ) {
		this.applicationNo = applicationNo;
		this.DocumentVerification = DocumentVerification;
		this.PoliceVerification = PoliceVerification;
	}
	
	public AdminPanel() {}
	

	
}
