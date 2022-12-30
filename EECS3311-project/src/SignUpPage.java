import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SignUpPage {

	JFrame frame;
	private JTextField nameField;
	private JTextField userIdField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JTextField locationFieldX;
	private JTextField locationFieldY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public SignUpPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 30));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 16));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNewLabel);
		
		JPanel SignUp_field = new JPanel();
		frame.getContentPane().add(SignUp_field, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		nameField = new JTextField();
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		nameField.setColumns(10);
		
		userIdField = new JTextField();
		userIdField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		userIdField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		emailField = new JTextField();
		emailField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblNewLabel_5 = new JLabel("Store's Location");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		locationFieldX = new JTextField();
		locationFieldX.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		locationFieldX.setColumns(10);
		
		
		locationFieldY = new JTextField();
		locationFieldY.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		locationFieldY.setColumns(10);
		
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		signUpButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				String userName = nameField.getText();
				String userid = userIdField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				String email = emailField.getText();
				
				//Taking location as x,y coordinate.
				String locationX = locationFieldX.getText();
				String locationY = locationFieldY.getText();
				
				
				if(!userid.equals("") && !password.equals("") && !userName.equals("") && !email.equals("") && !locationX.equals("") && !locationY.equals("")) {
					
//					if(password.equals(repeatPassword)) {
						
						//for registering customer name.
						String customerData = userid + " " + password + " " + userName + " " + email + " " + locationX + "," + locationY + '\n';
						try {
							FileWriter customerWriter = new FileWriter("customer.txt", true);
							customerWriter.write(customerData);
							customerWriter.close();
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(signUpButton, "You have successfully created an account!");
						frame.dispose();
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
//					}
//					else {
//						JOptionPane.showMessageDialog(signUpButton, "Password doesn't match");
//					}
				}
				else {
					JOptionPane.showMessageDialog(signUpButton, "Field cannot be empty");
				}
				
			}
		});
		
		JButton logInButton = new JButton("Log In");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
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
		});
		logInButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		
		
		GroupLayout gl_SignUp_field = new GroupLayout(SignUp_field);
		gl_SignUp_field.setHorizontalGroup(
			gl_SignUp_field.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SignUp_field.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_SignUp_field.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_SignUp_field.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(60)
							.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
						.addGroup(gl_SignUp_field.createSequentialGroup()
							.addGroup(gl_SignUp_field.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(41)
							.addGroup(gl_SignUp_field.createParallelGroup(Alignment.LEADING, false)
								.addComponent(nameField)
								.addComponent(userIdField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
								.addComponent(passwordField)))
						.addComponent(signUpButton, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_SignUp_field.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(locationFieldX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(locationFieldY, 0, 0, Short.MAX_VALUE)))
					.addGap(11)
					.addComponent(logInButton)
					.addGap(34))
		);
		gl_SignUp_field.setVerticalGroup(
			gl_SignUp_field.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SignUp_field.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_SignUp_field.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_SignUp_field.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(userIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_SignUp_field.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_SignUp_field.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_SignUp_field.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(locationFieldX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(locationFieldY, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(gl_SignUp_field.createParallelGroup(Alignment.BASELINE)
						.addComponent(signUpButton)
						.addComponent(logInButton))
					.addContainerGap())
		);
		SignUp_field.setLayout(gl_SignUp_field);
	}
}
