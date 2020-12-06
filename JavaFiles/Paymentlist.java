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
        for (int i = 1; i < paymentlist.size(); i++) {
            currentyear = Integer.parseInt((paymentlist.get(1)).getYeardue());
            if (paymentlist.get(i) != null) {
                int temp = Integer.parseInt(paymentlist.get(i).getYeardue());
                if (currentyear < temp) {
                    currentyear = temp;
                }
            } else {
                return currentyear;
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
