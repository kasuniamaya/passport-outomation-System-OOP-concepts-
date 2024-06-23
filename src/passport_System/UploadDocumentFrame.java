package passport_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.SystemColor;

public class UploadDocumentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	byte[] birthCertificateImage = null;
	private byte[] nicImage = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadDocumentFrame frame = new UploadDocumentFrame();
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
	
	 public interface DocumentSubmissionCallback {
	        void onDocumentsSubmitted();

			void onBackButtonClicked();
	    }
	 
	  private DocumentSubmissionCallback callback;
	  
	  public void setDocumentSubmissionCallback(DocumentSubmissionCallback callback) {
	        this.callback = callback;
	    } 
	  
	public UploadDocumentFrame() {
		setTitle("Upload Documents");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-9,-9, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DOCUMENTS");
		lblNewLabel.setBounds(630, 60, 300, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblNewLabel);
		

		JLabel ImageLabel = new JLabel("\r\n");
		ImageLabel.setBounds(480, 200, 200, 200);
		contentPane.add(ImageLabel);
		
		JLabel ImageLabel1 = new JLabel("\r\n");
		ImageLabel1.setBounds(800, 200, 200, 200);
		contentPane.add(ImageLabel1);
		
		JButton browse = new JButton("Browse");
		browse.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				JFileChooser picChooser = new JFileChooser();
				picChooser.showOpenDialog(null);
				
				File pic = picChooser.getSelectedFile();
				String path = pic.getAbsolutePath();
				
				try {
					FileInputStream fis = new FileInputStream(pic);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buff = new byte[1024];
					
					for(int readNum; (readNum = fis.read(buff)) != -1;) {
						bos.write(buff,0,readNum);
					}
					
					birthCertificateImage = bos.toByteArray();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
				
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
				ImageLabel.setIcon(imageIcon);
			}
		});
		browse.setFont(new Font("Thibus29STru", Font.PLAIN, 15));
		browse.setForeground(new Color(245, 255, 250));
		browse.setBackground(new Color(0, 0, 128));
		browse.setBounds(540, 428, 100, 30);
		contentPane.add(browse);
		
		JButton browse1 = new JButton("Browse");
		browse1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser picChooser = new JFileChooser();
				picChooser.showOpenDialog(null);
				
				File pic = picChooser.getSelectedFile();
				String path = pic.getAbsolutePath();
				
				try {
					FileInputStream fis = new FileInputStream(pic);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buff = new byte[1024];
					
					for(int readNum; (readNum = fis.read(buff)) != -1;) {
						bos.write(buff,0,readNum);
					}
					nicImage = bos.toByteArray();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
				
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
				ImageLabel1.setIcon(imageIcon);
		
				
			}
		});
		browse1.setFont(new Font("Thibus29STru", Font.PLAIN, 15));
		browse1.setForeground(new Color(255, 250, 250));
		browse1.setBackground(new Color(0, 0, 128));
		browse1.setBounds(850, 428, 100, 30);
		contentPane.add(browse1);
		
		JLabel lblNewLabel_1 = new JLabel("BirthCertificate Copy");
		lblNewLabel_1.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(500, 138, 300, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NIC Copy");
		lblNewLabel_2.setFont(new Font("Thibus29STru", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(859, 138, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(birthCertificateImage != null && nicImage != null ) {
					UploadDocuments uploader = new UploadDocuments();
					
					Applicant a1 = new Applicant();
					uploader.InsertImage(birthCertificateImage,nicImage);
					
                    JOptionPane.showMessageDialog(null, "Record successfully added");
                    
                    //Trigger call back to go back to ApplicantFrame
                    if(callback != null) {
                    	callback.onDocumentsSubmitted();
                    }
                    
                   

                    // clear image and reset byte arrays
                    ImageLabel.setIcon(null);
                    birthCertificateImage = null;
                    
                    dispose();
                    
				}else  {
					JOptionPane.showMessageDialog(null, "Please upload the required documents first.");

				}
			
				
				
				
			}
		});
		
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(173, 216, 230));
		btnNewButton.setFont(new Font("Thibus29STru", Font.BOLD, 25));
		btnNewButton.setBounds(500, 615, 150, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBackground(new Color(173, 216, 230));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(callback != null) {
					callback.onBackButtonClicked();
				}
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Thibus29STru", Font.BOLD, 25));
		btnNewButton_1.setBounds(825, 615, 150, 40);
		contentPane.add(btnNewButton_1);
		
	}
	
	
	
	
}
