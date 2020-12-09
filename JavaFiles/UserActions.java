//author:Calvin Power
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type User actions.
 */
public class UserActions {
    private ArrayList<Property> proplist;
    private Property prop;
    private ArrayList<Payment> paymentlist = new ArrayList<Payment>();

    /**
     * Instantiates a new User actions.
     *
     * @throws IOException the io exception
     */
    public UserActions() throws IOException {
        readprop();
        readpayment();

    }

    /**
     * Addproperty.
     *
     * @param owners     the owners
     * @param estvalue   the estvalue
     * @param location   the location
     * @param PPR        the ppr
     * @param yearsowned the yearsowned
     * @param eircode    the eircode
     * @param address    the address
     * @throws FileNotFoundException the file not found exception
     */
    public void addproperty(String owners, int estvalue, String location, char PPR, String yearsowned, String eircode, String address) throws FileNotFoundException {
        proplist.add(new Property(owners, estvalue, location, PPR, yearsowned, eircode, address));
        write(owners, estvalue, location, PPR, yearsowned, eircode, address);
    }

    /**
     * Property for a owner array list.
     *
     * @param owner the owner
     * @return the array list
     */
    public ArrayList<String> PropertyForAOwner(String owner) {
        ArrayList<String> address = new ArrayList<String>();
        for (int i = 0; i < proplist.size(); i++) {
            String a = proplist.get(i).getOwners();
            String b = proplist.get(i).getAddress();
            if (a.equals(owner)) {
                address.add(b);
            }
        }
        return address;
    }

    /**
     * Gets property.
     *
     * @param address the address
     * @return the property
     * @throws IOException the io exception
     */
    public double gettotaltaxforaProperty(String address) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.gettotaltaxforaProperty(address);
    }

    /**
     * Gettotaltaxforaowner 2 double [ ].
     *
     * @param owner the owner
     * @return the double [ ]
     * @throws IOException the io exception
     */
    public double[] gettotaltaxforaowner2(String owner) throws IOException  {
        Paymentlist test = new Paymentlist();
        return test.gettotaltaxforaowner2(owner);
    }

    /**
     * Paytax.
     *
     * @param ammount the ammount
     * @param Owner   the owner
     * @param Address the address
     * @param year    the year
     * @throws IOException the io exception
     */
    public void paytax(int ammount, String Owner, String Address, int year) throws IOException {
        Paymentlist test = new Paymentlist();
        test.PayTax(ammount, Owner, Address,year);
    }

    /**
     * Query tax due for a year array list.
     *
     * @param user    the user
     * @param YearDue the year due
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<String> QueryTaxDueForAYear(String user, String YearDue) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.QueryTaxDueForAYear(user, YearDue);
    }

    /**
     * Tax due for a property array list.
     *
     * @param Address the address
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<String> TaxDueForAProperty(String Address) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.TaxDueForAProperty(Address);

    }

    /**
     * Gettotaltaxfora property 2 double [ ].
     *
     * @param address the address
     * @return the double [ ]
     * @throws IOException the io exception
     */
    public double[] gettotaltaxforaProperty2(String address)throws IOException {
        Paymentlist test = new Paymentlist();
        return  test.gettotaltaxforaProperty2(address);
    }

    /**
     * Gets .
     *
     * @param owner the owner
     * @return the
     * @throws IOException the io exception
     */
    public double gettotaltaxforaowner(String owner) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.gettotaltaxforaowner(owner);
    }

    /**
     * Write.
     *
     * @param owners     the owners
     * @param estvalue   the estvalue
     * @param location   the location
     * @param PPR        the ppr
     * @param yearsowned the yearsowned
     * @param eircode    the eircode
     * @param address    the address
     * @throws FileNotFoundException the file not found exception
     */
    public void write(String owners, int estvalue, String location, char PPR, String yearsowned, String eircode, String address) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WriteProperty(owners, estvalue, location, PPR, yearsowned, eircode, address);
    }

    /**
     * Readprop.
     *
     * @throws IOException the io exception
     */
    public void readprop() throws IOException {
        ReadFile readFile = new ReadFile();
        proplist = (ArrayList<Property>) readFile.ReadProperties().clone();
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

}
