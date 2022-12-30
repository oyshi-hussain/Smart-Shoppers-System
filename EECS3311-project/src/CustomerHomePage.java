import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CustomerHomePage {

	JFrame frmCustomerHomePage;
	
	SystemDataClass dataCustomer = new SystemDataClass();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public CustomerHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerHomePage = new JFrame();
		frmCustomerHomePage.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmCustomerHomePage.setTitle("Customer Home Page");
		frmCustomerHomePage.setBounds(100, 100, 450, 300);
		frmCustomerHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(188, 143, 143));
		
		JLabel lblNewLabel_1 = new JLabel("Home Page");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 20));
		
		JButton btnNewButton = new JButton("User Profile");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerHomePage.setVisible(false);
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
		});
		
		JButton logOutCus = new JButton("Log Out");
		logOutCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int out = JOptionPane.showConfirmDialog(logOutCus, "You want to log out?");
				if(out == JOptionPane.YES_OPTION) {
					frmCustomerHomePage.setVisible(false);
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
					frmCustomerHomePage.setVisible(true);
				}
			}
		});
		logOutCus.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton viewItemButton = new JButton("View Items");
		viewItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmCustomerHomePage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(229)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(viewItemButton, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
								.addComponent(logOutCus, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel_1)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(viewItemButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(logOutCus, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("<html><p>Welcome To SmartShoppers!<p><html>");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(54)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addGap(68))
		);
		panel.setLayout(gl_panel);
		frmCustomerHomePage.getContentPane().setLayout(groupLayout);
	}
}
