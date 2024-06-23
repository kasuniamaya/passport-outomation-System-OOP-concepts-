package passport_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminLoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Ausername;
	private JTextField Apassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginFrame frame = new AdminLoginFrame();
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
	public AdminLoginFrame() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(210, 49, 300, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(140, 162, 200, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		password.setBounds(140, 259, 200, 25);
		contentPane.add(password);
		
		Ausername = new JTextField();
		Ausername.setBounds(310, 163, 250, 25);
		contentPane.add(Ausername);
		Ausername.setColumns(10);
		
		Apassword = new JPasswordField();
		Apassword.setBounds(310, 256,250, 25);
		contentPane.add(Apassword);
		Apassword.setColumns(10);
		
		  JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
	        showPasswordCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        showPasswordCheckBox.setBounds(310, 283, 165, 20);
	        showPasswordCheckBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                JPasswordField loginPassword;
	                if (showPasswordCheckBox.isSelected()) {
	                    ((JPasswordField) Apassword).setEchoChar((char) 0); // Display actual characters
	                } else {
	                    ((JPasswordField) Apassword).setEchoChar('*'); // Display '*' for each character
	                }
	            }
	        });
	        contentPane.add(showPasswordCheckBox);

		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = Ausername.getText();
				String password = new String(Apassword.getText());
				
				Adminlogin Login = new Adminlogin(username,password);
				
				if(Login.LoginAdmin()) {
		            JOptionPane.showMessageDialog(null, "Login Successful");
		            Login.InsertAdminDetails(username,password);
		            dispose();

		            AdminpanelFrame A1 = new AdminpanelFrame();
		            A1.setVisible(true);
				}else if(username.isEmpty()&& password.isEmpty()){
					
					JOptionPane.showMessageDialog(null, "Login Failed. Username and  Password cannot be empty!");
				}else if(username.isEmpty()){
					JOptionPane.showMessageDialog(null, "Login Failed! Username cannot be empty");
				}else if(password.isEmpty()){
					JOptionPane.showMessageDialog(null, "Login Failed!  password cannot be empty");
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
					
				}
				
				
				
				
			
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.setBounds(110, 398,100,30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response =  JOptionPane.showConfirmDialog(null,
                        "Do you want to clear the fields?", "Clear Fields Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if user clock on yes,clear the fieds
				 if (response == JOptionPane.YES_OPTION) {
	                    Ausername.setText("");
	                    Apassword.setText("");
	                }
			}
		});
		btnNewButton_1.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 102));
		btnNewButton_1.setBounds(301, 398, 100, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int response =  JOptionPane.showConfirmDialog(null,
                        "Are you sure to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if click on yes,clear fields
				if(response ==JOptionPane.YES_OPTION ) {
					dispose();
					HomepageFrame L1 = new HomepageFrame();
					L1.show();
				}
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 102));
		btnNewButton_2.setBounds(485, 398, 100, 30);
		contentPane.add(btnNewButton_2);
	}
}
