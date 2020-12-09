//author:Calvin Power

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Paymentlist.
 */
public class Paymentlist {

    private int currentyear;
    private ArrayList<Payment> paymentlist = new ArrayList<Payment>();
    private ArrayList<Property> PropertyList = new ArrayList<Property>();
    private Payment payment;

    /**
     * Instantiates a new Paymentlist.
     *
     * @throws IOException the io exception
     */
    public Paymentlist() throws IOException {
        readprop();
        readpayment();
        refresh();
    }

    /**
     * Addpayment.
     *
     * @param owner   the owner
     * @param address the address
     * @param status  the status
     * @param taxowed the taxowed
     * @param yeardue the yeardue
     * @param eircode the eircode
     * @param balance the balance
     * @throws FileNotFoundException the file not found exception
     */
    public void addpayment(String owner, String address, char status, double taxowed, String yeardue, String eircode, String balance) throws FileNotFoundException {
        paymentlist.add(new Payment(owner, address, status, taxowed, yeardue, eircode, balance));
        write(owner, address, status, taxowed, yeardue, eircode, balance);
    }

    /**
     * Gets currentyear.
     *
     * @return the currentyear
     * @throws IOException the io exception
     */
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

    /**
     * Gets property.
     *
     * @param address the address
     * @return the property
     * @throws IOException the io exception
     */
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

    /**
     * Gets .
     *
     * @param Owner the owner
     * @return the
     * @throws IOException the io exception
     */
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

    /**
     * Gettotaltaxforaowner 2 double [ ].
     *
     * @param owner the owner
     * @return the double [ ]
     * @throws IOException the io exception
     */
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

    /**
     * Gettotaltaxfora property 2 double [ ].
     *
     * @param address the address
     * @return the double [ ]
     */
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

    /**
     * Gets owner.
     *
     * @param owner the owner
     * @return the owner
     */
    public ArrayList<String> gettotaltaxdataforaOwner(String owner) {
        ArrayList<String> PropDue = new ArrayList<String>();
        for (int i = 0; i < paymentlist.size(); i++) {
            if (paymentlist.get(i).getOwners().equals(owner)) {
                PropDue.add("TaxOwed + balance + yearDue:" + paymentlist.get(i).getTaxowed() + "," + paymentlist.get(i).getBalance()+"," + paymentlist.get(i).getYeardue() + ".");
            }
        }
        return PropDue;
    }

    /**
     * Gets property.
     *
     * @param address the address
     * @return the property
     */
    public ArrayList<String> gettotaltaxdataforaProperty(String address) {
        ArrayList<String> PropDue = new ArrayList<String>();
        for (int i = 0; i < paymentlist.size(); i++) {
            if (paymentlist.get(i).getAddress().equals(address)) {
                PropDue.add("TaxOwed + balance + yearDue:" + paymentlist.get(i).getTaxowed() + "," + paymentlist.get(i).getBalance()+"," + paymentlist.get(i).getYeardue() + ".");
                }
            }
        return PropDue;
        }


    /**
     * Pay tax.
     *
     * @param ammount the ammount
     * @param Owner   the owner
     * @param Address the address
     * @param year    the year
     * @throws IOException the io exception
     */
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

    /**
     * Overduetax due fora area string [ ] [ ].
     *
     * @return the string [ ] [ ]
     * @throws IOException the io exception
     */
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

    /**
     * Overduetax due fora area string [ ] [ ].
     *
     * @param year the year
     * @return the string [ ] [ ]
     * @throws IOException the io exception
     */
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

    /**
     * Overduetax due fora area string [ ] [ ].
     *
     * @param year    the year
     * @param eircode the eircode
     * @return the string [ ] [ ]
     * @throws IOException the io exception
     */
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

    /**
     * Totaltax due fora area double.
     *
     * @param eircode the eircode
     * @return the double
     * @throws IOException the io exception
     */
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

    /**
     * Averagetax due fora area double.
     *
     * @param eircode the eircode
     * @return the double
     * @throws IOException the io exception
     */
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

    /**
     * Percentagetax due fora area string.
     *
     * @param eircode the eircode
     * @return the string
     * @throws IOException the io exception
     */
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

    /**
     * Tax due for a property array list.
     *
     * @param Address the address
     * @return the array list
     */
    public ArrayList<String> TaxDueForAProperty(String Address) {
        ArrayList<String> Prop = new ArrayList<String>();
        for (int i = 0; i < paymentlist.size(); i++) {
            if (paymentlist.get(i).getAddress().equals(Address)) {
                Prop.add("Address + balance:" + paymentlist.get(i).getAddress() + "," + paymentlist.get(i).getTaxowed());
            }

        }
        return Prop;
    }

    /**
     * Query tax due for a year array list.
     *
     * @param user    the user
     * @param YearDue the year due
     * @return the array list
     */
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


    /**
     * Write.
     *
     * @param owner   the owner
     * @param address the address
     * @param status  the status
     * @param taxowed the taxowed
     * @param yeardue the yeardue
     * @param eircode the eircode
     * @param Balance the balance
     * @throws FileNotFoundException the file not found exception
     */
    public void write(String owner, String address, char status, double taxowed, String yeardue, String eircode,String Balance) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WritePayments(owner, address, status, taxowed, yeardue, eircode,Balance);
    }

    /**
     * Readprop.
     *
     * @throws IOException the io exception
     */
    public void readprop() throws IOException {
        ReadFile readFile = new ReadFile();
        PropertyList = readFile.ReadProperties();
    }

    /**
     * Readpayment.
     *
     * @throws IOException the io exception
     */
    public void readpayment() throws IOException {
        ReadFile readFile = new ReadFile();
        paymentlist = readFile.ReadPayment();
    }

    /**
     * Refresh.
     *
     * @throws IOException the io exception
     */
    public void refresh() throws IOException {
        ReadFile readFile = new ReadFile();
        readFile.ReadPayment();
        readFile.ReadProperties();
    }
}
