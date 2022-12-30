import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class UserProfile {

	JFrame frmCustomerUserProfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile window = new UserProfile();
					window.frmCustomerUserProfile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserProfile() {
		initialize();
	}
	
	//initiates SignInPage to check for login details.
	SystemDataClass userData = new SystemDataClass();

	
	
	
	private JTextField txtChangeYourName;
	private JTextField txtChangeYourPassword;
	private JTextField txtChangeYourLocationX;
	private JTextField txtChangeYourLocationY;
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerUserProfile = new JFrame();
		frmCustomerUserProfile.getContentPane().setBackground(new Color(112, 128, 144));
		frmCustomerUserProfile.setTitle("Customer User Profile");
		frmCustomerUserProfile.setBounds(100, 100, 450, 300);
		frmCustomerUserProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Welcome to your profile!");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		
		JButton changeName = new JButton("Change your name");
		changeName.addActionListener(new ActionListener() {
			
			//User Profile name changing action.
			public void actionPerformed(ActionEvent e) {
				
				String changeNameText = txtChangeYourName.getText();
				
				//BEFORE UPDATING ASK FOR CONFIRMATION
				int yes = JOptionPane.showConfirmDialog(changeName, "You want to change your name?");
				if(yes == JOptionPane.YES_OPTION) {
					
					if(changeName.getModel().isPressed()) {
						for(String a: userData.getCustomerArray()) {
							String[] aSplit = a.split(" ");
							//If the name matches, change the name.
							if(aSplit[2].equals(userData.userName)) {
								
								//index of the matched element
								int i = userData.getCustomerArray().indexOf(a);
								
								//make a new String to replace the old entry
								String j = "" + aSplit[0] + aSplit[1] + changeNameText +
										aSplit[3] + aSplit[4] + aSplit[5];
								//replace the edited record with new password
								userData.getCustomerArray().set(i, j);
								
								try {
									//overwriting the text file
									FileWriter editedName = new FileWriter("customer.txt");
									//I need to update the customer.txt with edited records
									String updatedCustomerData = "";
									for (String x: userData.getCustomerArray()) {
										updatedCustomerData = updatedCustomerData + x + "\n";
									}
									editedName.write(updatedCustomerData);
									editedName.close();

								} catch (IOException e1) {
									// Auto-generated catch block
									e1.printStackTrace();
								}
								
							}				
						}	
					}
					
				}
			}
		});
		changeName.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton changePassword = new JButton("Change your password");
		changePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String changePasswordText = txtChangeYourPassword.getText();
				
				int yes = JOptionPane.showConfirmDialog(changePassword, "You want to change your password?");
				if(yes == JOptionPane.YES_OPTION) {
					
					if(changePassword.getModel().isPressed()) {
						for(String a: userData.getCustomerArray()) {
							String[] aSplit = a.split(" ");
							//if the password matches, change the pass
							if(aSplit[1].equals(userData.password)) { 
								//aSplit[1] = changePasswordText;
								//index of the matched element
								int i = userData.getCustomerArray().indexOf(a);
								
								//make a new String to replace the old entry
								String j = "" + aSplit[0] + changePasswordText + aSplit[2]+
										aSplit[3] + aSplit[4] + aSplit[5];
								//replace the edited record with new password
								userData.getCustomerArray().set(i, j);
								
								try {
									//overwriting the text file
									FileWriter editedCust = new FileWriter("customer.txt");
									//I need to update the customer.txt with edited records
									String updatedCustomerData = "";
									for (String x: userData.getCustomerArray()) {
										updatedCustomerData = updatedCustomerData + x + "\n";
									}
									editedCust.write(updatedCustomerData);
									editedCust.close();

								} catch (IOException e1) {
									// Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}									
				}
			}
		});
		changePassword.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton changeLocation = new JButton("Change your location");
		changeLocation.setFont(new Font("Cambria", Font.PLAIN, 12));
		changeLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String changeLocationTextX = txtChangeYourLocationX.getText();
				String changeLocationTextY = txtChangeYourLocationY.getText();
				
				int yes = JOptionPane.showConfirmDialog(changeLocation, "You want to change your location?");
				if(yes == JOptionPane.YES_OPTION) {
					
					if(changeLocation.getModel().isPressed()) {
						for(String b: userData.getCustomerArray()) {
							String[] bSplit = b.split(" ");
							
							//If the location matches, change the location only.
							if(bSplit[4].equals(userData.locationX) && bSplit[5].equals(userData.locationY)) {
								
								//index of the matched element.
								int i = userData.getCustomerArray().indexOf(b);
								
								//make a new String to replace the old entry
								String j = "" + bSplit[0] + bSplit[1] + bSplit[2]+
										bSplit[3] + changeLocationTextX + changeLocationTextY;
								//replace the edited record with new password
								userData.getCustomerArray().set(i, j);
								
								try {
									//overwriting the text file
									FileWriter editedLoc = new FileWriter("customer.txt");
									//I need to update the customer.txt with edited records
									String updatedCustomerData = "";
									for (String x: userData.getCustomerArray()) {
										updatedCustomerData = updatedCustomerData + x + "\n";
									}
									editedLoc.write(updatedCustomerData);
									editedLoc.close();

								} catch (IOException e1) {
									// Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						}
					}
					
				}
			}
		});
		
		JButton deleteAccount = new JButton("Delete your account!");
		deleteAccount.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				// DELETE THE ACCOUNT BUTTON
				
			}
		});
		deleteAccount.setFont(new Font("Cambria", Font.BOLD, 12));
		
		txtChangeYourName = new JTextField();
		txtChangeYourName.setFont(new Font("Cambria", Font.PLAIN, 12));
		txtChangeYourName.setForeground(Color.GRAY);
		txtChangeYourName.setDisabledTextColor(new Color(109, 109, 109));
		txtChangeYourName.setText("Change your name here");
		txtChangeYourName.setColumns(10);
		
		txtChangeYourPassword = new JTextField();
		txtChangeYourPassword.setFont(new Font("Cambria", Font.PLAIN, 12));
		txtChangeYourPassword.setForeground(Color.GRAY);
		txtChangeYourPassword.setText("Change your password here");
		txtChangeYourPassword.setColumns(10);
		
		txtChangeYourLocationX = new JTextField();
		txtChangeYourLocationX.setHorizontalAlignment(SwingConstants.CENTER);
		txtChangeYourLocationX.setFont(new Font("Cambria", Font.PLAIN, 12));
		txtChangeYourLocationX.setForeground(Color.GRAY);
		txtChangeYourLocationX.setText("location X");
		txtChangeYourLocationX.setColumns(10);
		
		JButton homePageButton = new JButton("Home Page");
		homePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerUserProfile.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CustomerHomePage window = new CustomerHomePage();
							window.frmCustomerHomePage.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		homePageButton.setFont(new Font("Cambria", Font.BOLD, 12));
		
		txtChangeYourLocationY = new JTextField();
		txtChangeYourLocationY.setHorizontalAlignment(SwingConstants.CENTER);
		txtChangeYourLocationY.setText("location Y");
		txtChangeYourLocationY.setForeground(Color.GRAY);
		txtChangeYourLocationY.setFont(new Font("Cambria", Font.PLAIN, 12));
		txtChangeYourLocationY.setColumns(10);
		
		
		GroupLayout groupLayout = new GroupLayout(frmCustomerUserProfile.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(121))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtChangeYourLocationX, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtChangeYourLocationY, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
						.addComponent(txtChangeYourPassword)
						.addComponent(changePassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(changeName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtChangeYourName, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
						.addComponent(changeLocation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(deleteAccount)
						.addComponent(homePageButton))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(txtChangeYourName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(homePageButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(changeName)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtChangeYourPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(changePassword)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtChangeYourLocationX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtChangeYourLocationY, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(deleteAccount))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(changeLocation)))
					.addContainerGap())
		);
		frmCustomerUserProfile.getContentPane().setLayout(groupLayout);
	}
}
