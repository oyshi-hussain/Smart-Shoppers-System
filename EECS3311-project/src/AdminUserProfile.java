import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AdminUserProfile {

	JFrame frmAdminUserProfile;
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
					AdminUserProfile window = new AdminUserProfile();
					window.frmAdminUserProfile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminUserProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminUserProfile = new JFrame();
		frmAdminUserProfile.getContentPane().setBackground(new Color(238, 232, 170));
		frmAdminUserProfile.setTitle("Admin User Profile");
		frmAdminUserProfile.setBounds(100, 100, 450, 300);
		frmAdminUserProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("User Profile");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton homePage = new JButton("Home Page");
		homePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminUserProfile.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							HomePage window = new HomePage();
							window.frmAdminHomePage.setVisible(true);
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
		GroupLayout groupLayout = new GroupLayout(frmAdminUserProfile.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(lblNewLabel))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
									.addComponent(homePage))
								.addComponent(changeName, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
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
							.addComponent(changeLocation))
						.addComponent(homePage)))
		);
		frmAdminUserProfile.getContentPane().setLayout(groupLayout);
	}

}
