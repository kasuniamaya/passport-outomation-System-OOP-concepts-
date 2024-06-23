package passport_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class AdminpanelFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField nic;
	private JTextField address;
	private JTextField contactno;
	private JTextField email;
	private JTextField document;
	private JTextField police;
	private JTable table;
	DefaultTableModel model;
	private JTextField searchId;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminpanelFrame frame = new AdminpanelFrame();
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
	public AdminpanelFrame() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 153));
		panel.setBounds(750, 0, 1060, 1080);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LIST OF CLIENTS");
		lblNewLabel_1.setBounds(300, 60, 300, 30);
		lblNewLabel_1.setFont(new Font("Thibus29STru", Font.BOLD, 25));
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 115, 730, 450);
		panel.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(224, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID","Name","NIC","Address","Con Num","Email","Document Verification","Police Verification","status"};
		  //Object row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Display Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 displayApplicantData();
			}
		});
		
		
		
		
		
		
		
		btnNewButton.setBounds(66, 658, 120, 35);
		btnNewButton.setBackground(new Color(204, 51, 204));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all data?", "Confirmation",
                        JOptionPane.YES_NO_OPTION);

				if(choice == JOptionPane.YES_OPTION) {
					 clearAllFields();
				}
			}

			private void clearAllFields() {
				// TODO Auto-generated method stub
				id.setText("");
				name.setText("");
				nic.setText("");
				address.setText("");
				contactno.setText("");
				email.setText("");
				document.setText("");
				police.setText("");
				status.setText("");
				
			}
		});
		
		JCheckBox documentVerificationCheckBox = new JCheckBox("Verified");
		documentVerificationCheckBox.setBounds(400, 580, 93, 21);
		contentPane.add(documentVerificationCheckBox);
		
		JCheckBox policeVerificationCheckBox = new JCheckBox("Verified");
		policeVerificationCheckBox.setBounds(400, 650, 93, 21);
		contentPane.add(policeVerificationCheckBox);
		
		btnNewButton_1.setBounds(270, 658, 120, 35);
		btnNewButton_1.setBackground(new Color(204, 51, 153));
		panel.add(btnNewButton_1);
		
		JButton btnUpdateData = new JButton("Update Data");
		btnUpdateData.setBounds(465, 658, 120, 35);
		btnUpdateData.setBackground(new Color(204, 51, 153));
		btnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 updateVerificationStatus();
				
				
			}

			private void updateVerificationStatus() {
				// TODO Auto-generated method stub
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1) {
					String documentVerificationStatus = documentVerificationCheckBox.isSelected() ? "Verified" : "" ;
					String policeVerificationStatus = policeVerificationCheckBox.isSelected() ? "Verified" : "" ;
					String 	updatedStatus = status.getText();
						int applicationNo = Integer.parseInt(id.getText());
					

			        dbConnection ob = new dbConnection();
			        Connection conn = ob.dbConnect();
			        
			        try {
			        	 String sql = "UPDATE applicant_Details SET DocumentVerification=?, PoliceVerification=?, status=? WHERE applicationNo=?";
			             PreparedStatement statement = conn.prepareStatement(sql);
			             statement.setString(1, documentVerificationStatus);
			             statement.setString(2, policeVerificationStatus);
			             statement.setString(3, updatedStatus); 
			             statement.setInt(4, applicationNo);
			             
			             int rowsUpdated = statement.executeUpdate();
			             if(rowsUpdated > 0 ) {
			            	 int response =  JOptionPane.showConfirmDialog(null,
			                         "Are you sure to update?", "update Confirmation",
			                         JOptionPane.YES_NO_OPTION);
			 				
			 				//if click on yes,clear fields
			 				if(response ==JOptionPane.YES_OPTION ) {
			 					 JOptionPane.showMessageDialog(null, "Data updated successfully!");
				                 displayApplicantData();}
			 				
			 				documentVerificationCheckBox.setSelected(false);
			 	            policeVerificationCheckBox.setSelected(false);
			            	
			             }else {
			            	 JOptionPane.showMessageDialog(null, "Failed to update data.");
			             }
			        	}catch(SQLException e) {
			                System.err.println("SQLException: " + e.getMessage());

			        	}finally {
			        		try {
			        			if(conn != null) {
			        				conn.close();
			        			}
			        		}catch(SQLException e) {
			        		       System.err.println("SQLException: " + e.getMessage());
			        		}
			        	}
			        }else {
			        	JOptionPane.showMessageDialog(null, "Please select a row to update.");
			        }
			}
		});
		panel.add(btnUpdateData);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1012, 115, 17, 450);
		panel.add(scrollBar);
		
		JButton btnNewButton_3 = new JButton("Exit\r\n");
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
		btnNewButton_3.setBackground(new Color(255, 51, 153));
		btnNewButton_3.setBounds(650, 658, 120, 35);
		panel.add(btnNewButton_3);
		
		searchId = new JTextField();
		searchId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 searchByIdAndDisplayData();
			}

			private void searchByIdAndDisplayData() {
				// TODO Auto-generated method stub
				
				 String applicationNoString = searchId.getText();
				 
				if(!applicationNoString.isEmpty()) {
					try {
						 int applicationNo = Integer.parseInt(applicationNoString);
						 
						 displayDataForApplicationNo(applicationNo);
					}catch(NumberFormatException e) {
						//  JOptionPane.showMessageDialog(null, "Invalid Application No. Please enter a valid number.");
					}
				}
			}

			private void displayDataForApplicationNo(int applicationNo) {
				// TODO Auto-generated method stub
				
				 model.setRowCount(0);

				    dbConnection ob = new dbConnection();
				    Connection conn = ob.dbConnect();
				    
				    try {
				    	 String sql = "SELECT * FROM applicant_Details WHERE applicationNo = ?";
				         PreparedStatement statement = conn.prepareStatement(sql);
				         statement.setInt(1, applicationNo);
				         
				         ResultSet resultSet = statement.executeQuery();
				         
				         while(resultSet.next()) {
				        	 Object[] rowData = {
				        			 resultSet.getInt("applicationNo"),
				                     resultSet.getString("ApplicantSName"),
				                     resultSet.getString("ApplicantNIC"),
				                     resultSet.getString("ApplicantAddress"),
				                     resultSet.getString("ApplicantConNumber"),
				                     resultSet.getString("ApplicantEmail"),
				                     resultSet.getString("DocumentVerification"),
				                     resultSet.getString("PoliceVerification") ,
				                     resultSet.getString("status")
				        	 };
				        	 model.addRow(rowData);
				         }
				    }catch(SQLException e) {
				    	  System.err.println("SQLException: " + e.getMessage());
				    }finally {
				    	try {
				    		if(conn != null) {
				    			conn.close();
				    		}
				    	}catch(SQLException ex) {
				    		  System.err.println("SQLException: " + ex.getMessage());
				    	}
				    	
				    }
			}
		});
		searchId.setBounds(674, 59, 96, 19);
		panel.add(searchId);
		searchId.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Application No:\r\n");
		lblNewLabel_16.setFont(new Font("Thibus29STru", Font.BOLD, 15));
		lblNewLabel_16.setBounds(562, 55, 150, 30);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel = new JLabel("ADMIN PANEL");
		lblNewLabel.setFont(new Font("Thibus29STru", Font.BOLD, 25));
		lblNewLabel.setBounds(280, 60, 200, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Application No\r\n");
		lblNewLabel_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(120, 113, 200, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(120, 170, 200, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NIC");
		lblNewLabel_4.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(120, 222, 200, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(120, 273, 200, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Contact No");
		lblNewLabel_6.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(120, 320, 200, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(120, 372, 200, 30);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Documnent Veri:");
		lblNewLabel_8.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(120, 420, 200, 30);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Police Veri:");
		lblNewLabel_9.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(120, 470, 200, 30);
		contentPane.add(lblNewLabel_9);
		
		id = new JTextField();
		id.setBounds(290, 115, 300, 25);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(290, 173, 300, 25);
		contentPane.add(name);
		name.setColumns(10);
		
		nic = new JTextField();
		nic.setBounds(290, 223, 300, 25);
		contentPane.add(nic);
		nic.setColumns(10);
		
		address = new JTextField();
		address.setBounds(290, 273, 300, 25);
		contentPane.add(address);
		address.setColumns(10);
		
		contactno = new JTextField();
		contactno.setBounds(290, 323, 300, 25);
		contentPane.add(contactno);
		contactno.setColumns(10);
		
		email = new JTextField();
		email.setBounds(290, 373, 300, 25);
		contentPane.add(email);
		email.setColumns(10);
		
		document = new JTextField();
		document.setBounds(290, 423, 300, 25);
		contentPane.add(document);
		document.setColumns(10);
		
		police = new JTextField();
		police.setBounds(290, 473, 300, 25);
		contentPane.add(police);
		police.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Document Verification");
		lblNewLabel_10.setFont(new Font("Thibus29STru", Font.BOLD, 20));
		lblNewLabel_10.setBounds(170, 573, 200, 30);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Police Verification");
		lblNewLabel_11.setFont(new Font("Thibus29STru", Font.BOLD, 20));
		lblNewLabel_11.setBounds(170, 643, 200, 30);
		contentPane.add(lblNewLabel_11);
		
		JLabel Status = new JLabel("status");
		Status.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		Status.setBounds(120, 532, 100, 13);
		contentPane.add(Status);
		
		status = new JTextField();
		status.setText("\r\n");
		status.setBounds(290, 532, 300, 25);
		contentPane.add(status);
		status.setColumns(10);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				 if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
	                    int selectedRow = table.getSelectedRow();
	                    fillFieldsFromSelectedRow(selectedRow);
				 }
			}

			private void fillFieldsFromSelectedRow(int selectedRow) {
				// TODO Auto-generated method stub
				id.setText(getValueAsString(selectedRow, 0)); // ID
			    name.setText(getValueAsString(selectedRow, 1)); // Name
			    nic.setText(getValueAsString(selectedRow, 2)); // NIC
			    address.setText(getValueAsString(selectedRow, 3)); // Address
			    contactno.setText(getValueAsString(selectedRow, 4)); // Contact Number
			    email.setText(getValueAsString(selectedRow, 5)); // Email
			    document.setText(getValueAsString(selectedRow, 6)); // Document Verification
			    police.setText(getValueAsString(selectedRow, 7));//police Verification
			    status.setText(getValueAsString(selectedRow, 8));

		
		
			}

			private String getValueAsString(int row, int column) {
				// TODO Auto-generated method stub
				Object value = table.getValueAt(row, column);
				return (value != null) ? value.toString() : "";
			}
		});
		
		
		    
		
	}
	
	private void displayApplicantData() {
		model.setRowCount(0); 
		
		dbConnection ob = new dbConnection();
        Connection conn = ob.dbConnect();
		
        
        try {
            String sql = "SELECT * FROM applicant_Details";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getInt("applicationNo"),
                        resultSet.getString("ApplicantSName"),
                        resultSet.getString("ApplicantNIC"),
                        resultSet.getString("ApplicantAddress"),
                        resultSet.getString("ApplicantConNumber"),
                        resultSet.getString("ApplicantEmail"),
                        resultSet.getString("DocumentVerification"),
                        resultSet.getString("PoliceVerification"),
                        resultSet.getString("status")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        } finally {
            // Close resources (e.g., close the connection)
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            	 System.err.println("SQLException: " + ex.getMessage());
            }
        }
        
       
	}
	
	
}
