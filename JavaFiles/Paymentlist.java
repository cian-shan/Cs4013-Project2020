//author:Calvin Power
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Paymentlist {

    private ArrayList<Payment> paymentlist = new ArrayList<Payment>();
    private ArrayList<Property> PropertyList = new ArrayList<Property>();
    private Payment payment;

    public Paymentlist(ArrayList<Property> list) {
        read();//fill paymentlist
        this.PropertyList = list;
        paymentlist = read();
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

    public ArrayList<Payment> read() {
        return null;
    }
    public void write(String owner, String address, char status, double taxowed, String yeardue, String eircode) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WritePayments(owner,address,status,taxowed,yeardue,eircode);
    }
    public void refresh(){

    }

}
