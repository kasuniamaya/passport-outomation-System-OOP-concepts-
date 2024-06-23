package passport_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField LoginUsername;
	private JTextField LoginPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
				
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = 
				new JPanel();
		panel.setBackground(new Color(102, 153, 204));
		panel.setBounds(0, 0,1920,1080);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(290, 0, 150, 150);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(0, 51, 102));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(110, 95, 120, 120);
		lblNewLabel_1.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		panel.add(lblNewLabel_1);
		
		LoginUsername = new JTextField();
		LoginUsername.setBounds(260, 143, 315, 27);
		LoginUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(LoginUsername);
		LoginUsername.setColumns(10);
		
		LoginPassword = new JPasswordField();
		LoginPassword.setBounds(260, 223, 320, 27);
		LoginPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(LoginPassword);
		LoginPassword.setColumns(10);
		
		
		JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
		showPasswordCheckBox.setBounds(260, 253, 150, 20);
		showPasswordCheckBox.setFont(new Font("Tahoma",Font.PLAIN,15));
	        showPasswordCheckBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (showPasswordCheckBox.isSelected()) {
	                    ((JPasswordField) LoginPassword).setEchoChar((char) 0); // Display actual characters
	                } else {
	                    ((JPasswordField) LoginPassword).setEchoChar('*'); // Display '*' for each character
	                }
	            }
	        });
	        panel.add(showPasswordCheckBox);

		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(110, 170, 400, 130);
		lblNewLabel_2.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login\r\n");
		btnNewButton.setBounds(110, 310, 128, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
							
				String username = LoginUsername.getText();
				String password = new String(LoginPassword.getText());
				
				login Login = new login(username,password);
				
				if(Login.validateLogin()) {
		            JOptionPane.showMessageDialog(null, "Login Successful");
		            Login.insertLoginDetails(username,password);
		            dispose();

		           applicantFunctionalityFrame s = new applicantFunctionalityFrame();
		           s.show();
		           dispose();
				}else if(password.isEmpty()&&username.isEmpty()){
					JOptionPane.showMessageDialog(null, "Login Failed. username field and password field cannot be Empty!");
				}
				else if(username.isEmpty()){
					JOptionPane.showMessageDialog(null, "Login Failed.Username field cannot be Empty!");
				}else if(password.isEmpty()){
					JOptionPane.showMessageDialog(null, "Login Failed. password field cannot be Empty!");
				} else	
					 {
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
				}
				
				
				
			}
		});
		btnNewButton.setForeground(new Color(240, 248, 255));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Didn't have registered ?");
		lblNewLabel_3.setBounds(38, 305, 230, 140);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBounds(205, 362, 104, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignupFrame s1 = new SignupFrame();
				s1.show();
			}
		});
		btnNewButton_1.setForeground(new Color(128, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBounds(290, 310, 128, 42);
		btnNewButton_2.setForeground(new Color(240, 255, 240));
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int response = JOptionPane.showConfirmDialog(null,
                        "Do you want to clear the fields?", "Clear Fields Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if user click yes
				if(response == JOptionPane.YES_OPTION) {
					 LoginUsername.setText("");
					 LoginPassword.setText("");
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back\r\n");
		btnNewButton_3.setBounds(471, 310, 128, 42);
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int response =  JOptionPane.showConfirmDialog(null,
                        "Are you sure to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if click on yes,clear fields
				if(response ==JOptionPane.YES_OPTION ) {
					dispose();
					HomepageFrame h1 = new HomepageFrame();
					h1.show();
				}
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		panel.add(btnNewButton_3);
	}
}
