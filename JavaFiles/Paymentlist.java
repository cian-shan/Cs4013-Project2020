//author:Calvin Power
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Paymentlist {

    private int currentyear;
    private ArrayList<Payment> paymentlist = new ArrayList<Payment>();
    private ArrayList<Property> PropertyList = new ArrayList<Property>();
    private Payment payment;

    public Paymentlist() throws IOException {
        readprop();
        readpayment();
    }

    public void addpayment(String owner, String address, char status, double taxowed, String yeardue, String eircode,String balance) throws FileNotFoundException {
        paymentlist.add(new Payment(owner, address, status, taxowed, yeardue, eircode,balance));
        write(owner, address, status, taxowed, yeardue, eircode,balance);
    }
    public int getCurrentyear() throws IOException {
        for (int i = 1; i < paymentlist.size(); i++){
            currentyear = Integer.parseInt((paymentlist.get(1)).getYeardue());
            if(paymentlist.get(i) !=null){
                int temp = Integer.parseInt(paymentlist.get(i).getYeardue());
                if (currentyear < temp){
                   currentyear = temp;
                }
            }
            else {
                return currentyear;
            }
        }
        return currentyear;
    }

    public void PayTax(int ammount, String Owner, String Address) {
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
            double b = paymentlist.get(i).getTaxowed();
            String eircodeKey = eircode;
            eircodeKey = eircodeKey.substring(0, 3);
            String c = paymentlist.get(i).getOwners();
            if (a.equals(eircodeKey)) {
                taxDue[0][i] = String.valueOf(b);
                taxDue[1][i] = c;
            }
        }
        return taxDue;
    }

    public ArrayList<String> TaxDueForAProperty(String Address) {
        ArrayList<String> Prop = new ArrayList<String>();
        for (int i = 0; i < paymentlist.size(); i++) {
            if (paymentlist.get(i).getAddress().equals(Address)) {
                Prop.add("Address + balance:" + paymentlist.get(i).getAddress() + "," + paymentlist.get(i).getTaxowed());
            }

        }
        return Prop;
    }


    public ArrayList<String> QueryTaxDueForAYear(String user, String YearDue) {
        ArrayList<String> PropDue = new ArrayList<String>();
        for (int i = 0; i < paymentlist.size(); i++) {
            if (paymentlist.get(i).getOwners().equals(user)) {
                if (paymentlist.get(i).getYeardue().equals(YearDue)) {
                    PropDue.add("Address + balance:" + paymentlist.get(i).getAddress() + "," + paymentlist.get(i).getTaxowed());
                }

            }
        }
        return PropDue;
    }


    public void write(String owner, String address, char status, double taxowed, String yeardue, String eircode,String Balance) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WritePayments(owner, address, status, taxowed, yeardue, eircode,Balance);
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
