//author:Calvin Power

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Payment.
 */
public class Payment {
    /**
     * The Owner.
     */
    String owner;
    /**
     * The Address.
     */
    String address;
    /**
     * The Balance.
     */
    double Balance;
    /**
     * The Status.
     */
    char status; //D/P (DUE OR PAID)
    /**
     * The Taxowed.
     */
    double taxowed;
    /**
     * The Yeardue.
     */
    String yeardue;
    /**
     * The Eircode.
     */
    String eircode;
    private ArrayList<Property> PropertyList = new ArrayList<Property>();

    /**
     * Instantiates a new Payment.
     *
     * @param owner   the owner
     * @param address the address
     * @param status  the status
     * @param taxowed the taxowed
     * @param yeardue the yeardue
     * @param eircode the eircode
     * @param Balance the balance
     */
    public Payment(String owner, String address, char status, double taxowed, String yeardue, String eircode,String Balance) {
        this.owner = owner;
        this.address = address;
        this.taxowed = taxowed;
        this.yeardue = yeardue;
        this.status = status;
        this.eircode = eircode;
        this.Balance =Integer.parseInt(Balance);
    }

    /**
     * Passproplist.
     *
     * @param list the list
     */
    public void passproplist(ArrayList<Property> list) {
        this.PropertyList = list;
    }

    /**
     * Paytax.
     *
     * @param ammount the ammount
     * @throws IOException the io exception
     */
    public void paytax(int ammount) throws IOException {
        this.Balance = taxowed - ammount;
        this.taxowed = Balance;
        if (Balance == 0) {
            if (Balance == 0) {
                this.status = 'P';

                String[] payment = new String[2];
                Scanner scan = new Scanner(new File("JavaFiles/Properties.csv"));
                while (scan.hasNext()) {

                    payment = scan.nextLine().split(",");
                    if (payment[0].equals(owner)) {
                        FileOutputStream fos = new FileOutputStream("Properties.csv");
                        PrintWriter pw = new PrintWriter(fos);

                        pw.print(owner + "," + address + "," + taxowed + "," + yeardue + "," + 'P' + "," + getBalance()+ "," + eircode);
                        pw.flush();
                        pw.close();
                    }
                }
            }
        }
    }


    /**
     * Gets owners.
     *
     * @return the owners
     */
    public String getOwners() {
        return this.owner;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets eircode.
     *
     * @return the eircode
     */
    public String getEircode() {
        return this.eircode;
    }

    /**
     * Gets est value.
     *
     * @return the est value
     */
    public int getEstValue() {
        return this.status;
    }

    /**
     * Gets yeardue.
     *
     * @return the yeardue
     */
    public String getYeardue() {
        return this.yeardue;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return this.Balance;
    }

    /**
     * Gets taxowed.
     *
     * @return the taxowed
     */
    public double getTaxowed() {
        return this.taxowed;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public char getStatus() {
        return this.status;
    }

}
