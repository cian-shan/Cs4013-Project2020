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
			
			System.out.println("(1.)Add (2.)Show (3.)Payment (4.)Quit")
			String command = scan.nextLine().toUpperCase();
			
			switch(command){
			
				//Add
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
				case "2":
					
					System.out.println("(1.)Owners Propertys + Tax  (2.)Tax for a Property  (3.)Tax Due for an Area");
					String command3 = scan.nextLine();
					
					if(command3.equals("1")) {
						
						System.out.println("Owner");
						String name = scan.nextLine();
						System.out.println("Properties for " + name + ": " + properties.getPropertysForAOwner(name) + " " + name + "'s taxes: " + properties.gettotaltaxforaowner(name));
						
					}else if(command3.equals("2")) {
						
						System.out.println("Address");
						String address = scan.nextLine();
						System.out.println("Tax due for " + address + " " + properties.gettotaltaxforaProperty(address));
						
					}else if(command3.equals("3")) {
						
						System.out.println("Eircode");
						String eircode = scan.nextLine();
						System.out.println("Tax due for " + eircode + ": " + properties.taxDueForaArea(eircode));
						
					}
					
				//Payment
				case "3":
					
					System.out.println("Pay tax, Enter: Amount/Owner name/Address");
						String pay = scan.nextLine();
						String[] payTax = pay.split("/");
						paymentlist.PayTax(Integer.parseInt(payTax[0]), payTax[1], payTax[2]);	
					
				case "4":	
						more = false;
					
					
		}
			
		}
	}
}
