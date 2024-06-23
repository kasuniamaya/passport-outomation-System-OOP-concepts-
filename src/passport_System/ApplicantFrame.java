package passport_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicantFrame extends JFrame implements UploadDocumentFrame.DocumentSubmissionCallback {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField nic;
	private JTextField address;
	private JTextField birthday;
	private JTextField contactNumber;
	private JTextField email;
	
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantFrame frame = new ApplicantFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the frame.
	 */
	
	public void onDocumentsSubmitted() {
		this.setVisible(true);
	}
	
	public void onBackButtonClicked() {
		this.setVisible(true);
	}
	public ApplicantFrame() {
		setTitle("Applicant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -2, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Application Form");
		lblNewLabel.setFont(new Font("Thibus29STru", Font.BOLD, 45));
		lblNewLabel.setBounds(620, 44, 400, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type Of Service");
		lblNewLabel_1.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(500, 130, 200, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(500, 190, 200, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NIC");
		lblNewLabel_3.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(500, 250, 200, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Permanent Address");
		lblNewLabel_4.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(500, 310, 200, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date Of Birth");
		lblNewLabel_5.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(500, 370, 200, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(500, 430, 200, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Contact Number");
		lblNewLabel_7.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(500, 490, 200, 33);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(500, 550, 200, 33);
		contentPane.add(lblNewLabel_8);
		
		/* JLabel lblNewLabel_9 = new JLabel("Documents");
		lblNewLabel_9.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(500, 610, 200, 33);
		contentPane.add(lblNewLabel_9); */
		
		name = new JTextField();
		name.setBounds(750, 199, 500, 25);
		contentPane.add(name);
		name.setColumns(10);
		
		nic = new JTextField();
		nic.setBounds(750, 259, 500, 25);
		contentPane.add(nic);
		nic.setColumns(10);
		
		address = new JTextField();
		address.setBounds(750, 319, 500, 25);
		contentPane.add(address);
		address.setColumns(10);
		
		birthday = new JTextField();
		birthday.setBounds(750, 379, 500, 25);
		contentPane.add(birthday);
		birthday.setColumns(10);
		
		contactNumber = new JTextField();
		contactNumber.setBounds(750, 499, 500, 25);
		contentPane.add(contactNumber);
		contactNumber.setColumns(10);
		
		email = new JTextField();
		email.setBounds(750, 559, 500, 25);
		contentPane.add(email);
		email.setColumns(10);
		
	
		
		JRadioButton redioButton1 = new JRadioButton("Normal");
		redioButton1.setBounds(751, 138, 103, 21);
		contentPane.add(redioButton1);
		
		JRadioButton radioButton2 = new JRadioButton("Imergency");
		radioButton2.setBounds(985, 138, 103, 21);
		contentPane.add(radioButton2);
		
		ButtonGroup typeOfServiceGroup  = new ButtonGroup();
		typeOfServiceGroup.add(redioButton1);
		typeOfServiceGroup.add(radioButton2);
		
		JRadioButton radioButton3 = new JRadioButton("Male");
		radioButton3.setBounds(751, 438, 103, 21);
		contentPane.add(radioButton3);
		
		JRadioButton radioButton4 = new JRadioButton("Female");
		radioButton4.setBounds(985, 438, 103, 21);
		contentPane.add(radioButton4);
		
		ButtonGroup GenderGroup = new ButtonGroup();
		 GenderGroup.add(radioButton3);
		 GenderGroup.add(radioButton4);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Applicant ob = new Applicant();
			
				String typeOfService = null;
				
				if(redioButton1.isSelected()) {
					typeOfService = "Normal";
				}else {
					typeOfService = "Imergency";
				}
				String ApplicantName = name.getText();
				String NIC = nic.getText();
				String ApplicantAddress = address.getText();
				String ApplicantBirthday = birthday.getText();
				String Gender = null;
				
				if( (radioButton3).isSelected()) {
					Gender = "Male";
				}else {
					Gender = "Female";
				}
				String ContactNumber = contactNumber.getText();
				String Email = email.getText();
				
				
				
				if(!typeOfService.isEmpty()  && !ApplicantName.isEmpty() && !NIC.isEmpty() && !ApplicantAddress.isEmpty() && !ApplicantBirthday.isEmpty() && !Gender.isEmpty() && !ContactNumber.isEmpty() && !Email.isEmpty()  ) {
					
					 JOptionPane.showMessageDialog(null,"Application was successfully Submitted");
					 JOptionPane.showMessageDialog(null,ob.InsertApplicantDetails(typeOfService, ApplicantName, NIC, ApplicantAddress, ApplicantBirthday, Gender, ContactNumber, Email));
					 
					 HomepageFrame a = new HomepageFrame();
					 a.show();
					 dispose();
					
					
				}else {
					 JOptionPane.showMessageDialog(null, "Submit Failed! Please fill Application Correct");
				}
				
				
				
				
				
				
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setBounds(500, 741, 120, 35);
		contentPane.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int response = JOptionPane.showConfirmDialog(null,
                        "Do you want to clear the Data?", "Clear Fields Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if user click yes
				if(response == JOptionPane.YES_OPTION) {
					typeOfServiceGroup.clearSelection();
					name.setText("");
					nic.setText("");
					address.setText("");
					birthday.setText("");
					GenderGroup.clearSelection();
					contactNumber.setText("");
					email.setText("");
			
				}  
			}
		});
		btnNewButton_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_2.setForeground(new Color(245, 255, 250));
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setBounds(739, 741, 120, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null,
                        "Do you want to Back ?", "Back  Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if user click yes
				if(response == JOptionPane.YES_OPTION) {
					applicantFunctionalityFrame p1 = new applicantFunctionalityFrame();
					p1.show();
					dispose();
				}	
				
			}
		});
		btnNewButton_3.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_3.setForeground(new Color(245, 255, 250));
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.setBounds(1021, 741, 120, 35);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_9 = new JLabel("Documents");
		lblNewLabel_9.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(498, 629, 100, 30);
		contentPane.add(lblNewLabel_9);
		
		JButton upload = new JButton("Upload");
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UploadDocumentFrame d1 = new UploadDocumentFrame();
				d1.show();
			
			}
		});
		upload.setBackground(new Color(148, 0, 211));
		upload.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		upload.setBounds(750, 636, 100, 30);
		contentPane.add(upload);
		
		
	}
	}

