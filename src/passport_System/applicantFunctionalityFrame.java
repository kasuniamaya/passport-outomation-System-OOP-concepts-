package passport_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class applicantFunctionalityFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applicantFunctionalityFrame frame = new applicantFunctionalityFrame();
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
	public applicantFunctionalityFrame() {
		setTitle("Applicant Functionality\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton application = new JButton("Fill Application\r\n");
		application.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicantFrame a1 = new ApplicantFrame();
				a1.show();
				dispose();
			}
		});
		application.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		application.setForeground(new Color(255, 255, 255));
		application.setBackground(new Color(0, 0, 102));
		application.setBounds(230, 115, 200, 40);
		contentPane.add(application);
		
		JButton status = new JButton("Check Status");
		status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkStatusFrame c = new checkStatusFrame();
				c.show();
				dispose();
			}
		});
		status.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		status.setForeground(new Color(255, 255, 255));
		status.setBackground(new Color(0, 0, 102));
		status.setBounds(230, 250, 200, 40);
		contentPane.add(status);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response =  JOptionPane.showConfirmDialog(null,
                        "Are you sure to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				//if click on yes,clear fields
				if(response ==JOptionPane.YES_OPTION ) {
					dispose();
					HomepageFrame b1 = new HomepageFrame();
					b1.show();
				}
			}
		});
		btnNewButton.setBackground(new Color(148, 0, 211));
		btnNewButton.setForeground(new Color(248, 248, 255));
		btnNewButton.setFont(new Font("Thibus29STru", Font.BOLD, 20));
		btnNewButton.setBounds(265, 379, 100, 30);
		contentPane.add(btnNewButton);
	}
}
