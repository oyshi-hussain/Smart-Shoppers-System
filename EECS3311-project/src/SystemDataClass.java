import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;


//This class contains almost all the methods for admin, customer and manager.
public class SystemDataClass {
	
		//database informations
		protected String userName;
		protected String userid;
		protected String password;
		protected String email;
		protected String locationX;
		protected String locationY;
		
		private File customerData;
		private File managerData;
		
		
		//hardcoded admin credentials open up the Admin GUI
		private String adminUSERNAME = "Song";
		private String adminPASS = "song3311";

		
		
		
		private ArrayList<String> customerArray = new ArrayList<String>();
		private ArrayList<String> managerArray = new ArrayList<String>();
		
		//builder (always called on instantiation)
		public SystemDataClass() {
			customerData = new File("customer.txt");
			managerData = new File("manager.txt");
		}
		
	
		
		public boolean adminCheck (String id, String pass, JFrame signInframe) {
			if (id.equals(adminUSERNAME) && pass.equals(adminPASS)) {
				return true;
			}
			return false;
		}

		
		public boolean customerCheck(String id, String pass, JFrame signInframe) throws FileNotFoundException {
			
			this.userid = id;
			this.password = pass;
			
			//dataFiles();
			scanCustomer();
			
			for(String x: customerArray) {
				String[] splitCustomer = x.split(" ");
				
				if(splitCustomer[0].equals(id) && splitCustomer[1].equals(pass)) {
					return true;
				}
			}
//				JOptionPane.showMessageDialog(signInframe, "Invalid userID or password");	
			return false;	
		}
		
		public boolean managerCheck(String id, String pass, JFrame signInframe) throws FileNotFoundException {
			this.userid = id;
			this.password = pass;
			
			scanManager();
			
			for(String x: managerArray) {
				String[] splitManager = x.split(" ");
				
				if(splitManager[0].equals(id) && splitManager[1].equals(pass)) {
					return true;			
				}
			}
//				JOptionPane.showMessageDialog(signInframe, "Invalid userID or password");		
			return false;
		}
		
		public void scanCustomer() throws FileNotFoundException {
			//need to scan customer.txt
			Scanner c = new Scanner(customerData);
			
			customerArray.clear();
			while(c.hasNextLine()) {
				String cNext = c.nextLine();
				if(!cNext.equals("")) {
					customerArray.add(cNext);
				}
			}
			c.close();
		}
		
		public void scanManager() throws FileNotFoundException {
			//need to scan manager.txt
			Scanner c = new Scanner(managerData);
			
			managerArray.clear();
			while(c.hasNextLine()) {
				String cNext = c.nextLine();
				if(!cNext.equals("")) {
					managerArray.add(cNext);
				}
			}
			c.close();
		}
		
		
		public ArrayList<String> getCustomerArray() {
			return customerArray;
		}
		
		public ArrayList<String> getManagerArray() {
			return managerArray;
		}
	

}
