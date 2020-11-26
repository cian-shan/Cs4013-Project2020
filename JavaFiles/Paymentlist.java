//author:Calvin Power
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Paymentlist {

    private ArrayList<Payment> paymentlist = new ArrayList<Payment>();
    private ArrayList<Property> PropertyList = new ArrayList<Property>();
    private Payment payment;

    public Paymentlist() throws IOException {
        readprop();
        readpayment();
    }
    public void addpayment(String owner,String address,char status,double taxowed,String yeardue,String eircode) throws FileNotFoundException {
        paymentlist.add(new Payment(owner,address,status,taxowed,yeardue,eircode));
        write(owner,address,status,taxowed,yeardue,eircode);
    }
    public void PayTax(int ammount,String Owner,String Address){
        System.out.println(ammount);
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getOwners();
            String b = paymentlist.get(i).getAddress();
            if (b.equals(Address)) {
                  paymentlist.get(i).paytax(ammount);
            }
        }
    }
    public String[][] taxDueForaArea(String eircode) {
        String[][] taxDue = new String[paymentlist.size()][paymentlist.size()];
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getEircode();
            a = a.substring(0, 3);
            double b = paymentlist.get(i).getBalance();
            String eircodeKey = eircode;
            eircodeKey = eircodeKey.substring(0, 3);
            String c = paymentlist.get(i).getOwners();
            if (a.equals(eircode)) {
                taxDue[0][i] = String.valueOf(b);
                taxDue[1][i] = c;
            }
        }
        return taxDue;
    }

    public ArrayList<String> QueryTaxDueForAYear(String user, String YearDue){
        ArrayList<String> PropDue = new ArrayList<String>();
       for (int i = 0; i < paymentlist.size();i++){
           if (paymentlist.get(i).getOwners().equals(user)){
               if (paymentlist.get(i).getYeardue().equals(YearDue)){
                   PropDue.add("Address + balance:"+ paymentlist.get(i).getAddress() + "," +paymentlist.get(i).getBalance());
               }

           }
       }
       return PropDue;
    }


    public void write(String owner, String address, char status, double taxowed, String yeardue, String eircode) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WritePayments(owner,address,status,taxowed,yeardue,eircode);
    }
    public void readprop() throws IOException {
        ReadFile readFile = new ReadFile();
        PropertyList = readFile.ReadProperties();
    }
    public void readpayment() throws IOException {
        ReadFile readFile = new ReadFile();
        paymentlist = readFile.ReadPayment();
    }

}
