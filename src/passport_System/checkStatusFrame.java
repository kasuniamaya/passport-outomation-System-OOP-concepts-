package passport_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class checkStatusFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nic;
	private JTextField Status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkStatusFrame frame = new checkStatusFrame();
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
	public checkStatusFrame() {
		setTitle("Check Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check Status");
		lblNewLabel.setFont(new Font("Thibus29STru", Font.BOLD, 30));
		lblNewLabel.setBounds(240, 48, 200, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NIC\r\n");
		lblNewLabel_1.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(158, 117, 150, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(158, 200, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		nic = new JTextField();
		nic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nic.setBounds(300, 120, 200, 25);
		contentPane.add(nic);
		nic.setColumns(10);
		
		Status = new JTextField();
		Status.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Status.setBounds(300, 197, 200, 25);
		contentPane.add(Status);
		Status.setColumns(10);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nic = nic.getText();
				
				
				
				checkStatus o = new checkStatus(Nic,null);
				String status = o.validateStatus();
				
				Status.setText(status);
			
			}
		});
		btnNewButton.setBounds(99, 329, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int response = JOptionPane.showConfirmDialog(null,
	                        "Do you want to clear the Data?", "Clear Fields Confirmation",
	                        JOptionPane.YES_NO_OPTION);
					
					//if user click yes
					if(response == JOptionPane.YES_OPTION) {
						nic.setText("");
						Status.setText("");
				
					}  
			}
		});
		btnNewButton_1.setBounds(283, 329, 100, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setForeground(new Color(255, 250, 250));
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setBounds(471, 329, 100, 30);
		contentPane.add(btnNewButton_2);
	}

}
