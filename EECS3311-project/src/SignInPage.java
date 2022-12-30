import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInPage {

	JFrame frmSignInPage;
	private JTextField userIdField;
	private JPasswordField passwordField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInPage window = new SignInPage();
					window.frmSignInPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	//builder method
	public SignInPage() {
		initialize();
	}
	
		//initiates SystemDataClass to check for login details for each case
		public SystemDataClass systemdata = new SystemDataClass();

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignInPage = new JFrame();
		frmSignInPage.setTitle("Sign In Window");
		frmSignInPage.setBounds(100, 100, 450, 300);
		frmSignInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmSignInPage.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Sign In");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		userIdField = new JTextField();
		userIdField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JButton CreateNewAccButton = new JButton("Create New Account");
		CreateNewAccButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Will dispose the SignInPage and go to SignUpPage when CreateNewAccButton clicked.
				frmSignInPage.dispose();	
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignUpPage window = new SignUpPage();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		CreateNewAccButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		
		
		//When logIn button is pressed.
		JButton logInButton = new JButton("Log In");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				String userid = userIdField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				
				if(!userid.equals("") && !password.equals("")) {
					
				try {			
					if(systemdata.adminCheck(userid, password, frmSignInPage)) {
						JOptionPane.showMessageDialog(frmSignInPage, "Admin Login successful");
						frmSignInPage.setVisible(false);
						//Run Admin Home Page
						HomePage window = new HomePage();
						window.frmAdminHomePage.setVisible(true);
						
					} 
							else if(systemdata.customerCheck(userid, password, frmSignInPage)) {
												frmSignInPage.setVisible(false);	
												JOptionPane.showMessageDialog(frmSignInPage, "Login Successful");
												//Run the Customer Home Page
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
							
							else if(systemdata.managerCheck(userid, password, frmSignInPage)) {
												JOptionPane.showMessageDialog(frmSignInPage, "Manager Login Successful");
												frmSignInPage.dispose();
												//Run the Manager Home Page
												EventQueue.invokeLater(new Runnable() {
													public void run() {
														try {
															ManagerHomePage window = new ManagerHomePage();
															window.frmManagerHomePage.setVisible(true);
														} catch (Exception e) {
															e.printStackTrace();
														}
													}
												});
													}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
				else {
					JOptionPane.showMessageDialog(logInButton, "Field cannot be empty");
				}
			}
		});
		logInButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(191)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField)
										.addComponent(userIdField)))
								.addComponent(logInButton))))
					.addGap(204))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(271, Short.MAX_VALUE)
					.addComponent(CreateNewAccButton)
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(51)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(CreateNewAccButton)
						.addComponent(logInButton))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
