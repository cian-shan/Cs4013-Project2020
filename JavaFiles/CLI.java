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
		UserActions userActions = new UserActions();
		
		while(more) {
			
			System.out.println("(1.)Add (2.)Show (3.)Payment (4.)Quit")
			String command = scan.nextLine().toUpperCase();
			
			switch(command){
			
				//Add
				case "1":
					System.out.println("(1.)Property (2.)Payment");
					String command2 = scan.nextLine();
	/*Property*/		if(command2.equals("1")) {
						
							System.out.println("Enter Property Details: owner(s), estvalue, location, PPR, yearsowned, eircode, address");
							String line = scan.nextLine();
						
							StringTokenizer string = new StringTokenizer(line);
							String owners = string.nextToken();
							int estValue = Integer.parseInt(string.nextToken());
							String location = string.nextToken();
				        		char PPR = string.nextToken().charAt(0);
				        		String yearsowned = string.nextToken();
				        		String eircode = string.nextToken();
				        		String address = string.nextToken();
						
				        		properties.addproperty(owners, estValue, location, PPR, yearsowned, eircode, address);
				        		break;
				        	
	/*Payment*/			}else if(command2.equals("2")) {
						
							System.out.println("Enter Payment Details: owner, address, status, taxowed, yeardue, eircode, balance" );
							String line = scan.nextLine();
						
							StringTokenizer string = new StringTokenizer(line);
							String owner = string.nextToken();
							String address = string.nextToken();
							char status = string.nextToken().charAt(0);
							double taxowed = Double.parseDouble(string.nextToken());
							String yeardue = string.nextToken();
							String eircode = string.nextToken();
							String balance = string.nextToken();
							
							paymentlist.addpayment(owner, address, status, taxowed, yeardue, eircode, balance);
							break;
					}
					
				//Show	
				case "2":
					
					System.out.println("(1.)Owners Propertys + Tax  (2.)Tax for a Property  (3.)Tax Due for an Area");
					String command3 = scan.nextLine();
					
					if(command3.equals("1")) {
						
						System.out.println("Owner");
						String line = scan.nextLine();
						System.out.println("Properties for " + line + ": " + properties.getPropertysForAOwner(line) + " " + line + "'s taxes: " + properties.gettotaltaxforaowner(line));
						
					}else if(command3.equals("2")) {
						
						System.out.println("Address");
						String line = scan.nextLine();
						System.out.println("Tax due for " + line + " " + properties.gettotaltaxforaProperty(line));
						
					}else if(command3.equals("3")) {
						
						System.out.println("Eircode");
						String line = scan.nextLine();
						System.out.println("Tax due for " + line + ": " + properties.taxDueForaArea(line));
						
					}
					
				//Payment
				case "3":
					
						System.out.println("Pay tax, Enter: Amount, Owner name, Address");
						String pay = scan.nextLine();
						
						StringTokenizer string = new StringTokenizer(pay);
						int ammount = Integer.parseInt(string.nextToken());
						String owner = string.nextToken();
						String address = string.nextToken();
						
						paymentlist.PayTax(ammount, owner, address);
						
				case "4":	
						more = false;
					
					
		}
			
		}
	}
}
