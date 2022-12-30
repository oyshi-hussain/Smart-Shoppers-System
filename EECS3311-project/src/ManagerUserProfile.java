import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManagerUserProfile {

	JFrame frmManagerUserProfile;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUserProfile window = new ManagerUserProfile();
					window.frmManagerUserProfile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerUserProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManagerUserProfile = new JFrame();
		frmManagerUserProfile.getContentPane().setBackground(new Color(169, 169, 169));
		frmManagerUserProfile.setTitle("Manager User Profile");
		frmManagerUserProfile.setBounds(100, 100, 450, 300);
		frmManagerUserProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("User Profile");
		lblNewLabel.setFont(new Font("Cambria", Font.ITALIC, 20));
		
		JButton homePage = new JButton("Home Page");
		homePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmManagerUserProfile.setVisible(false);
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
		});
		homePage.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setText("Change your name here");
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("Cambria", Font.PLAIN, 12));
		textField.setDisabledTextColor(SystemColor.textInactiveText);
		textField.setColumns(10);
		
		JButton changeName = new JButton("Change your name");
		changeName.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setText("Change your password here");
		textField_1.setForeground(Color.GRAY);
		textField_1.setFont(new Font("Cambria", Font.PLAIN, 12));
		textField_1.setColumns(10);
		
		JButton changePassword = new JButton("Change your password");
		changePassword.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setText("location X");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.GRAY);
		textField_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("location Y");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.GRAY);
		textField_3.setFont(new Font("Cambria", Font.PLAIN, 12));
		textField_3.setColumns(10);
		
		JButton changeLocation = new JButton("Change your location");
		changeLocation.setFont(new Font("Cambria", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(frmManagerUserProfile.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(170)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
										.addComponent(changeName, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
									.addComponent(homePage))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(changePassword, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addComponent(changeLocation, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(homePage))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(changeName)
							.addGap(11)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(changePassword)
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(changeLocation))))
		);
		frmManagerUserProfile.getContentPane().setLayout(groupLayout);
	}
}
