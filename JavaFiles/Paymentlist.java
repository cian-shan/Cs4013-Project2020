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
        refresh();
    }

    public void addpayment(String owner, String address, char status, double taxowed, String yeardue, String eircode, String balance) throws FileNotFoundException {
        paymentlist.add(new Payment(owner, address, status, taxowed, yeardue, eircode, balance));
        write(owner, address, status, taxowed, yeardue, eircode, balance);
    }

    public int getCurrentyear() throws IOException {
        currentyear = Integer.parseInt((paymentlist.get(0)).getYeardue());
        for (int i = 1; i < paymentlist.size(); i++) {
                int temp = Integer.parseInt(paymentlist.get(i).getYeardue());
                if (currentyear < temp) {
                    currentyear = temp;
            }
        }
        return currentyear;
    }

    public double gettotaltaxforaProperty(String address) throws IOException {
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getAddress();
            int y0 = Integer.parseInt(paymentlist.get(i).getYeardue());
            if (a.equals(address) && y0 == getCurrentyear()) {
                return paymentlist.get(i).getBalance();
            }
        }
        return -1;
    }

    public double gettotaltaxforaowner(String Owner) throws IOException {
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getOwners();
            int y0 = Integer.parseInt(paymentlist.get(i).getYeardue());
            if (a.equals(Owner) && y0 == getCurrentyear()) {
                return paymentlist.get(i).getBalance();
            }
        }
        return -1;
    }

    // remove nulls for clean output
    public double[] gettotaltaxforaowner2(String owner) throws IOException {
        double[] taxowedar = new double[paymentlist.size()];
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getOwners();
            if (a.equals(owner)) {
                taxowedar[i] = paymentlist.get(i).getBalance();
            }
        }
        return taxowedar;
    }

    public double[] gettotaltaxforaProperty2(String address) {
        double[] taxowedar = new double[paymentlist.size()];
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getAddress();
            if (a.equals(address)) {
                taxowedar[i] = paymentlist.get(i).getBalance();
            }
        }
        return taxowedar;
    }

    public ArrayList<String> gettotaltaxdataforaOwner(String owner) {
        ArrayList<String> PropDue = new ArrayList<String>();
        for (int i = 0; i < paymentlist.size(); i++) {
            if (paymentlist.get(i).getOwners().equals(owner)) {
                PropDue.add("TaxOwed + balance + yearDue:" + paymentlist.get(i).getTaxowed() + "," + paymentlist.get(i).getBalance()+"," + paymentlist.get(i).getYeardue() + ".");
            }
        }
        return PropDue;
    }
    public ArrayList<String> gettotaltaxdataforaProperty(String address) {
        ArrayList<String> PropDue = new ArrayList<String>();
        for (int i = 0; i < paymentlist.size(); i++) {
            if (paymentlist.get(i).getAddress().equals(address)) {
                PropDue.add("TaxOwed + balance + yearDue:" + paymentlist.get(i).getTaxowed() + "," + paymentlist.get(i).getBalance()+"," + paymentlist.get(i).getYeardue() + ".");
                }
            }
        return PropDue;
        }


    public void PayTax(int ammount, String Owner, String Address,int year) throws IOException {
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getOwners();
            String b = paymentlist.get(i).getAddress();
            int yr = Integer.parseInt(paymentlist.get(i).yeardue);
            if (b.equals(Address) && year == yr) {
                paymentlist.get(i).paytax(ammount);
            }
        }
    }
    // remove nulls for clean output
    //tax due no para
    public String[][] overduetaxDueForaArea() throws IOException {
        String[][] taxDue = new String[paymentlist.size()][paymentlist.size()];
        for (int i = 0; i < paymentlist.size(); i++) {
            int yr = Integer.parseInt(paymentlist.get(i).getYeardue());
            double b = paymentlist.get(i).getTaxowed();
            String c = paymentlist.get(i).getOwners();
            if (yr != getCurrentyear()) {
                taxDue[0][i] = String.valueOf(b);
                taxDue[1][i] = c;
            }
        }
        return taxDue;
    }
    // tax due para year
    public String[][] overduetaxDueForaArea(int year) throws IOException {
        String[][] taxDue = new String[paymentlist.size()][paymentlist.size()];
        for (int i = 0; i < paymentlist.size(); i++) {
            int yr = Integer.parseInt(paymentlist.get(i).getYeardue());
            double b = paymentlist.get(i).getTaxowed();
            String c = paymentlist.get(i).getOwners();
            if (yr == year && yr!= getCurrentyear()) {
                taxDue[0][i] = String.valueOf(b);
                taxDue[1][i] = c;
            }
        }
        return taxDue;
    }
// tax due para year,eircode
    public String[][] overduetaxDueForaArea(int year,String eircode) throws IOException {
        String[][] taxDue = new String[paymentlist.size()][paymentlist.size()];
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getEircode();
            int yr = Integer.parseInt(paymentlist.get(i).getYeardue());
            a = a.substring(0, 3);
            double b = paymentlist.get(i).getTaxowed();
            String eircodeKey = eircode;
            eircodeKey = eircodeKey.substring(0, 3);
            String c = paymentlist.get(i).getOwners();
            if (a.equals(eircodeKey)&& yr == year && yr != getCurrentyear()) {
                taxDue[0][i] = String.valueOf(b);
                taxDue[1][i] = c;
            }
        }
        return taxDue;
    }
    public double totaltaxDueForaArea(String eircode) throws IOException {
        double total= 0;
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getEircode();
            int yr = Integer.parseInt(paymentlist.get(i).getYeardue());
            a = a.substring(0, 3);
            double b = paymentlist.get(i).getTaxowed();
            String eircodeKey = eircode;
            eircodeKey = eircodeKey.substring(0, 3);
            String c = paymentlist.get(i).getOwners();
            if (a.equals(eircodeKey) && yr == getCurrentyear()) {
             total = total + paymentlist.get(i).getTaxowed();
            }
        }
        return total;
    }
    public double averagetaxDueForaArea(String eircode) throws IOException {
        double total= 0;
        int count = 0;
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getEircode();
            int yr = Integer.parseInt(paymentlist.get(i).getYeardue());
            a = a.substring(0, 3);
            double b = paymentlist.get(i).getTaxowed();
            String eircodeKey = eircode;
            eircodeKey = eircodeKey.substring(0, 3);
            String c = paymentlist.get(i).getOwners();
            if (a.equals(eircodeKey) && yr == getCurrentyear()) {
                total = total + paymentlist.get(i).getTaxowed();
                count++;
            }
        }
        return total/count;
    }
    public String percentagetaxDueForaArea(String eircode) throws IOException {
        int count= 0;
        int paid = 0;
        int due =0;
        for (int i = 0; i < paymentlist.size(); i++) {
            String a = paymentlist.get(i).getEircode();
            int yr = Integer.parseInt(paymentlist.get(i).getYeardue());
            a = a.substring(0, 3);
            double b = paymentlist.get(i).getTaxowed();
            String eircodeKey = eircode;
            eircodeKey = eircodeKey.substring(0, 3);
            String c = paymentlist.get(i).getOwners();
            if (a.equals(eircodeKey) && yr == getCurrentyear() && paymentlist.get(i).status == 'P') {
                paid++;
                count++;
            }
            else {
                due++;
                count++;
            }
        }
        return "paid ammount is :"+ paid + " percentage paid for this year :" + (paid/count)*100 + "%";
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
                    PropDue.add("Address + balance:" + paymentlist.get(i).getAddress() + "," + paymentlist.get(i).getBalance());
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
    public void refresh() throws IOException {
        ReadFile readFile = new ReadFile();
        readFile.ReadPayment();
        readFile.ReadProperties();
    }
}
