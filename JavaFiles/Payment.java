//author:Calvin Power
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
    String owner;
    String address;
    double Balance;
    char status; //D/P (DUE OR PAID)
    double taxowed;
    String yeardue;
    String eircode;
    private ArrayList<Property> PropertyList = new ArrayList<Property>();

    public Payment(String owner,String address,char status,double taxowed,String yeardue,String eircode){
         this.owner = owner;
         this.address = address;
         this.taxowed = taxowed;
         this.yeardue = yeardue;
         this.status = status;
         this.eircode = eircode;
    }

    public void passproplist(ArrayList<Property> list){
        this.PropertyList = list;
    }

    public void paytax(int ammount) throws IOException {
        this.Balance = taxowed - ammount;
        this.taxowed = Balance;
        if (Balance == 0){
            this.status = 'P';
            
        	String[] payment = new String[2];
        	Scanner scan = new Scanner(new File("JavaFiles/Properties.csv"));
        	while(scan.hasNext())
        	{
        		
        	payment = scan.nextLine().split(",");
        	if (payment[0].equals(owner)) {
        		FileOutputStream fos = new FileOutputStream("Properties.csv");
        		PrintWriter pw = new PrintWriter(fos);
        	  
        	    pw.print(owner  + "," + address + "," + taxowed + "," + yeardue + "," + 'P' + "," + eircode);
        	    pw.flush();
        	    pw.close();
        	    } 
        	    else {
        	    	
        	} 
        }
       }
    }

    public String getOwners(){
        return this.owner;
    }
    public String getAddress(){
        return this.address;
    }
    public String getEircode(){
        return this.eircode;
    }
    public int getEstValue(){
        return this.status;
    }
    public String getYeardue(){
        return this.yeardue;
    }
    public double getBalance (){ return this.Balance; }
    public double getTaxowed(){ return this.taxowed;};
    public char getStatus(){return this.status;};

}
