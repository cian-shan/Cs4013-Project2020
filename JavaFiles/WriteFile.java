//author:Jack Boland
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class WriteFile{
	
	public void WriteProperty(String owners,int estvalue, String location,char PPR,String yearsowned,String eircode,String address) throws FileNotFoundException {

	String filename = "properties.csv";
					
	FileOutputStream fos = new FileOutputStream(filename, true);
	PrintWriter pw = new PrintWriter(fos);
  
    pw.println(owners + "," + eircode + "," + address + "," + estvalue + "," + location  + ","  + PPR + "," + yearsowned);
    pw.flush();
    pw.close();
    
	
}
	public void WritePayments(String owner, String address, char status, double taxowed, String yeardue, String eircode) throws FileNotFoundException {

	String filename = "payments.csv";
					
	FileOutputStream fos = new FileOutputStream(filename, true);
	PrintWriter pw = new PrintWriter(fos);
  
    pw.println(owner  + "," + address + "," + status + "," + taxowed + "," + yeardue + "," + eircode);
    pw.flush();
    pw.close();
    
	
}
}