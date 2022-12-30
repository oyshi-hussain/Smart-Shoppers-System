import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemsGui {

	JFrame frame;
	private JTextField addItemsField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public ItemsGui() {
		initialize();
	}
	
	
	DefaultListModel<String> itemListModel;
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 504, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		//Items from the text file item.txt
//		try {
//			FileReader reader = new FileReader("item.txt");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		
		JList<String> itemList = new JList<String>();
		itemList.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton loadItemButton = new JButton("Load your items");
		loadItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addItem = addItemsField.getText();
				
				if(!addItem.equals("")) {
					itemListModel.addElement(addItem);	//adding item to JList.
					
					//add the added item to the .txt file too
					
					itemList.setModel(itemListModel);	//setting itemListModel to JList.
					addItemsField.setText("");			//clearing the text field.
				}
				else {
					JOptionPane.showMessageDialog(loadItemButton, "Field cannot be empty");
				}
			}
		});
		loadItemButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton addItemButton = new JButton("Add Item");
		addItemButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		addItemsField = new JTextField();
		addItemsField.setFont(new Font("Cambria", Font.PLAIN, 12));
		addItemsField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove Item");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		
		JButton homePageButtonItem = new JButton("Home Page");
		homePageButtonItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
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
		homePageButtonItem.setFont(new Font("Cambria", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(addItemsField)
									.addComponent(addItemButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(loadItemButton, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(homePageButtonItem)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(itemList, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(itemList, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(loadItemButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(addItemButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(addItemsField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(homePageButtonItem)))
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Modify your items here");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
