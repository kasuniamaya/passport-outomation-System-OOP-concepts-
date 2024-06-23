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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField nic;
	private JTextField username;
	private JTextField password;
	private JTextField Cpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupFrame frame = new SignupFrame();
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
	public SignupFrame() {
		setTitle("SIGN UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 702);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 204));
		panel.setBounds(-5, -5, 800, 702);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setBounds(262, 30, 291, 45);
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(115, 105, 110, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NIC Number");
		lblNewLabel_2.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(115, 148, 160, 100);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(115, 250,130, 35);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Create Password");
		lblNewLabel_4.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(115, 325,170 ,20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password");
		lblNewLabel_5.setFont(new Font("Thibus29STru", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(115, 393,200, 25);
		panel.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(320, 114, 270, 25);
		panel.add(name);
		name.setColumns(10);
		
		nic = new JTextField();
		nic.setBounds(320,185,270, 25);
		panel.add(nic);
		nic.setColumns(10);
		
		username = new JTextField();
		username.setBounds(320,255,270, 25);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(320,320,270, 25);
		panel.add(password);
		password.setColumns(10);
		
		Cpassword = new JTextField();
		Cpassword.setBounds(320,390,270, 25);
		panel.add(Cpassword);
		Cpassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = name.getText();
				String NIC = nic.getText();
				String Username = username.getText();
				String Password = password.getText();
				String cPassword = Cpassword.getText();
				
				signUp ob = new signUp();
				ob.ApplicantSignUp(Name,NIC,Username,Password,cPassword);
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton.setBounds(83, 475,120,35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int response =  JOptionPane.showConfirmDialog(null,
                        "Do you want to clear the fields?", "Clear Fields Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if click on yes,clear fields
				if(response ==JOptionPane.YES_OPTION ) {
					name.setText("");
					nic.setText("");
					username.setText("");
					password.setText("");
					Cpassword.setText("");
				}
				
			
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_1.setBounds(273, 475,120,35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int response =  JOptionPane.showConfirmDialog(null,
                        "Are you sure to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if click on yes,clear fields
				if(response ==JOptionPane.YES_OPTION ) {
					dispose();
					LoginFrame b1 = new LoginFrame();
					b1.show();
				}
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_2.setBounds(461, 475,120,35);
		panel.add(btnNewButton_2);
	}
}
