package passport_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomepageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomepageFrame frame = new HomepageFrame();
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
	public HomepageFrame() {
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -5, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Passport Automation System");
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_1.setBounds( 480,20, 800, 150);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Passports made Simple & Easy");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(300, 125, 500, 130);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("USER");
		btnNewButton.setForeground(new Color(51, 153, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame L1 = new LoginFrame();
				L1.show();
			}
		});
		btnNewButton.setBounds(680, 380, 130, 60);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("LOGIN as, ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_4.setBounds(550, 300, 300, 100);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("We facilitates Sri Lankan citizens to apply passports through online comfortably at their NIC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(300, 250, 1100, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLoginFrame a1 = new AdminLoginFrame();
				a1.show();			}
		});
		btnNewButton_1.setForeground(new Color(51, 102, 153));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(680, 476, 130, 60);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setBounds(5, 5, 1530, 855);
		lblNewLabel.setIcon(new ImageIcon("C:\\passport system\\resize1.jpg"));
		contentPane.add(lblNewLabel);
	}

}
