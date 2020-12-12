//Author : Evan McKie MacSweeney
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

//Command Line Interface
public class CLI {

	private Scanner scan;
	
	public CLI() {
		scan = new Scanner(System.in);
	}
	
	//Runs CLI
	public void run() throws IOException {
		
		boolean more = true;
		Properties properties = new Properties();
		Paymentlist paymentlist = new Paymentlist();
		
		while(more) {
			
			System.out.println("(1.)User (2.)Admin");
			String perms = scan.nextLine();

			if(perms == "1") {
			
			System.out.println("(1.)Add (2.)Show (3.)Payment (4.)Quit");
			String command = scan.nextLine().toUpperCase();
			
			
			switch(command){
			
				//Add
				case "Add":	
				case "1":
					System.out.println("(1.)Property (2.)Payment");
					String command2 = scan.nextLine();
					
	/*Property*/		if(command2.equals("1")) {
						
						System.out.println("Enter Property Details: owner(s)/estvalue/location/PPR/yearsowned/eircode/address");
						String line = scan.nextLine();
						String[] property = line.split("/");
						
				        	properties.addproperty(property[0], Integer.parseInt(property[1]),property[2], property[3].charAt(0), property[4], property[5], property[6]);
				        	break;
				        	
	/*Payment*/			}else if(command2.equals("2")) {
						
							System.out.println("Enter Payment Details: owner, address, status, taxowed, yeardue, eircode, balance" );
							String line = scan.nextLine();
							String[] payment = line.split("/");
							
							paymentlist.addpayment(payment[0], payment[1], payment[2].charAt(0), Double.parseDouble(payment[3]), payment[4], payment[5], payment[6]);
							break;
							
					}
					
				//Show
				case"Show":
				case "2":
					
					System.out.println("(1.)Owners Properties + Owners Due Tax  (2.)Due and Overdue Tax for a Specific Property (3.)Tax Due for an Area and Overdue Tax for an Area");
					String command3 = scan.nextLine();
					
					if(command3.equals("1")) {
						//Owners Properties + Tax 
						System.out.println("Input Owner's name");
						String name = scan.nextLine();
						System.out.println("Properties for " + name + ": " + properties.getPropertysForAOwner(name) + " || " + name + "'s taxes: " + properties.gettotaltaxdataforaOwner(name));
						
					}else if(command3.equals("2")) {
						//Tax for a Property
						System.out.println("Input Address");
						String address = scan.nextLine();
						System.out.println("Tax due for " + address + " " + properties.gettotaltaxdataforaProperty(address));
						
						
					}else if(command3.equals("3")) {
						//tax due for an area
						System.out.println("Input Eircode/Year");
						String eircode = scan.nextLine();
						String[] area = eircode.split("/");
						System.out.println("Tax due for " + eircode + ": " + properties.totaltaxDueForaArea(area[0]) + "/ Overdue tax for" + eircode + ": " + paymentlist.overduetaxDueForaArea(Integer.parseInt(area[0]), area[1]));
						
					}
					
				//Payment
				case "Payment":
				case "3":
					
					System.out.println("Pay tax, Enter: Amount/Owner name/Address");
						String pay = scan.nextLine();
						String[] payTax = pay.split("/");
						paymentlist.PayTax(Integer.parseInt(payTax[0]), payTax[1], payTax[2], 0);
						
				case"Quit":	
				case "4":	
						more = false;
				}
			
			}else if(perms == "2") {
				
				System.out.println("Please Enter Password: (password is 1234)");
				if(scan.nextLine() == "1234") {
				System.out.println("Password Succesful, Running Admin Mode");
				System.out.println("(1.)Property Tax Payment Data for a Property (2.)Property Tax Payment Data for a Property Owner (3.)All Overdue Property Tax for a Year (4.)Property Tax Statistics (5.)Quit");
				String command = scan.nextLine().toUpperCase();
				
				switch(command){
				
				case "1":
					
						System.out.println("Input Address");
						System.out.println(properties.gettotaltaxdataforaProperty(scan.nextLine()));
						break;
						
				case "2":
					
						System.out.println("Input Owner name");
						System.out.println(properties.gettotaltaxdataforaOwner(scan.nextLine()));
						break;
					
				case "3":
					
						
						break;
					
				case "4":
					
						System.out.println("Input Eircode");
						String eircode = scan.nextLine();
						System.out.println("Property Tax statistics for " + eircode + "// Total Tax Due: " + properties.totaltaxDueForaArea(eircode) + " // Average Tax Due: " + properties.averagetaxDueForaArea(eircode) + " // Percentage Tax Due: " + properties.percentagetaxDueForaArea(eircode));
						break;
					
				case "5":
					more = false;
				}
				
			}	
		}
	}
}
}

