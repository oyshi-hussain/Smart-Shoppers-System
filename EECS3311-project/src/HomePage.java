import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;


public class HomePage {

	JFrame frmAdminHomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}
	
	//Creating SIGN IN PAGE object.
	SignInPage logIn = new SignInPage();
	SystemDataClass dataAdmin = new SystemDataClass();
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminHomePage = new JFrame();
		frmAdminHomePage.setTitle("Admin Home Page");
		frmAdminHomePage.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmAdminHomePage.setBounds(100, 100, 450, 300);
		frmAdminHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("User Profile");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminHomePage.setVisible(false);
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
		});
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int out = JOptionPane.showConfirmDialog(logOutButton, "You want to log out?");
				if(out == JOptionPane.YES_OPTION) {
					frmAdminHomePage.dispose();
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
				else {
					frmAdminHomePage.setVisible(true);
				}
			}
		});
		logOutButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton viewItemButton = new JButton("View Items");
		viewItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminHomePage.dispose();
				
				//When viewing the items, we go to ItemsGui.
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ItemsGui window = new ItemsGui();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		viewItemButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(null);
		panel.setBackground(new Color(70, 130, 180));
		
		JButton viewStoreAdmin = new JButton("View Store");
		viewStoreAdmin.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton viewManagerButton = new JButton("View Manager");
		viewManagerButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		
		GroupLayout groupLayout = new GroupLayout(frmAdminHomePage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(viewManagerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(viewStoreAdmin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(viewItemButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(logOutButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(viewItemButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(viewStoreAdmin)
					.addGap(18)
					.addComponent(viewManagerButton)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(logOutButton)
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel_1 = new JLabel("<html><p>Welcome to SmartShoppers!<p><html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		frmAdminHomePage.getContentPane().setLayout(groupLayout);
	}
}
