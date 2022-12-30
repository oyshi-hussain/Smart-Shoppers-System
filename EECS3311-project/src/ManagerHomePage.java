import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerHomePage {

	JFrame frmManagerHomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public ManagerHomePage() {
		initialize();
	}
	
	SystemDataClass systemdataManager = new SystemDataClass();

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManagerHomePage = new JFrame();
		frmManagerHomePage.setTitle("Manager Home Page");
		frmManagerHomePage.setBounds(100, 100, 450, 318);
		frmManagerHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(null);
		panel.setBackground(new Color(95, 158, 160));
		
		JLabel lblNewLabel_1 = new JLabel("<html><p>Welcome to SmartShoppers!<p><html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 153, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 199, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(33))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		
		JButton managerLogout = new JButton("Log Out");
		managerLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int out = JOptionPane.showConfirmDialog(managerLogout, "You want to log out?");
				if(out == JOptionPane.YES_OPTION) {
					frmManagerHomePage.dispose();
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
					frmManagerHomePage.setVisible(true);
				}
			}
		});
		managerLogout.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton managerItem = new JButton("View Items");
		managerItem.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton managerStore = new JButton("View Store");
		managerStore.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton managerUserProfile = new JButton("User Profile");
		managerUserProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmManagerHomePage.setVisible(false);
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
		});
		managerUserProfile.setFont(new Font("Cambria", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(frmManagerHomePage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(managerStore, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
								.addComponent(managerLogout, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
								.addComponent(managerItem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
								.addComponent(managerUserProfile, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(managerUserProfile, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(managerStore, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(managerItem, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(managerLogout, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
		);
		frmManagerHomePage.getContentPane().setLayout(groupLayout);
	}
}
