//author:Calvin Power

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Properties.
 */
/*Program runs from year updating with each method to make sure the other classes have the updated infomation */
public class Properties {
    private ArrayList<Property> propertylist = new ArrayList<Property>();
    private Property prop;

    /**
     * Instantiates a new Properties.
     *
     * @throws IOException the io exception
     */
    public Properties() throws IOException {
        read();// read then make propertylist = info
    }

    /**
     * Gets propertycurrentyear.
     *
     * @param address the address
     * @return the propertycurrentyear
     * @throws IOException the io exception
     */
//User and Admins Options
    public double gettotaltaxforaPropertycurrentyear(String address) throws IOException {
        UserActions test = new UserActions();
        return test.gettotaltaxforaProperty(address);
    }

    /**
     * Gets owner.
     *
     * @param Owner the owner
     * @return the owner
     * @throws IOException the io exception
     */
// tax data
    public ArrayList<String>  gettotaltaxdataforaOwner(String Owner) throws IOException{
        AdminActions test = new AdminActions();
        return test.gettotaltaxdataforaOwner(Owner);
    }

    /**
     * Gets property.
     *
     * @param Address the address
     * @return the property
     * @throws IOException the io exception
     */
//tax data
    public ArrayList<String>  gettotaltaxdataforaProperty(String Address) throws IOException{
        AdminActions test = new AdminActions();
        return test.gettotaltaxdataforaProperty(Address);
    }

    /**
     * Gets .
     *
     * @param owner the owner
     * @return the
     * @throws IOException the io exception
     */
    public double gettotaltaxforaownercurrentyear(String owner)throws IOException {
        UserActions test = new UserActions();
        return test.gettotaltaxforaowner(owner);
    }

    /**
     * Gettotaltaxfora property 2 double [ ].
     *
     * @param address the address
     * @return the double [ ]
     * @throws IOException the io exception
     */
// all years tax owed
    public double[] gettotaltaxforaProperty2(String address) throws IOException {
        UserActions test = new UserActions();
        return test.gettotaltaxforaProperty2(address);
    }

    /**
     * Gettotaltaxforaowner 2 double [ ].
     *
     * @param owner the owner
     * @return the double [ ]
     * @throws IOException the io exception
     */
// all years tax owed
    public double[] gettotaltaxforaowner2(String owner)throws IOException  {
        UserActions test = new UserActions();
        return test.gettotaltaxforaowner2(owner);
    }

    /**
     * Gets propertys for a owner.
     *
     * @param owner the owner
     * @return the propertys for a owner
     * @throws IOException the io exception
     */
    public ArrayList<String> getPropertysForAOwner(String owner) throws IOException {
        UserActions test = new UserActions();
        return test.PropertyForAOwner(owner);
    }

    /**
     * Overduetax due fora area string [ ] [ ].
     *
     * @return the string [ ] [ ]
     * @throws IOException the io exception
     */
    public String[][] overduetaxDueForaArea() throws IOException {
        AdminActions test = new AdminActions();
        return test.overduetaxDueForaArea();
    }

    /**
     * Overduetax due fora area string [ ] [ ].
     *
     * @param year the year
     * @return the string [ ] [ ]
     * @throws IOException the io exception
     */
    public String[][] overduetaxDueForaArea(int year) throws IOException {
        AdminActions test = new AdminActions();
        return test.overduetaxDueForaArea(year);
    }

    /**
     * Overduetax due fora area string [ ] [ ].
     *
     * @param year    the year
     * @param eircode the eircode
     * @return the string [ ] [ ]
     * @throws IOException the io exception
     */
    public String[][] overduetaxDueForaArea(int year,String eircode) throws IOException {
        AdminActions test = new AdminActions();
        return test.overduetaxDueForaArea(year,eircode); }

    /**
     * Query tax due for a year array list.
     *
     * @param user    the user
     * @param YearDue the year due
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<String> QueryTaxDueForAYear(String user,String YearDue) throws IOException {
        UserActions test = new UserActions();
        return  test.QueryTaxDueForAYear(user,YearDue);
    }

    /**
     * Tax due for a property array list.
     *
     * @param Address the address
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<String> TaxDueForAProperty(String Address) throws IOException {
        UserActions test = new UserActions();
        return  test.TaxDueForAProperty(Address);
    }

    /**
     * Gets currentyear.
     *
     * @return the currentyear
     * @throws IOException the io exception
     */
    public int getCurrentyear() throws IOException{
        Paymentlist test = new Paymentlist();
        return test.getCurrentyear();
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
    public void paytax(int ammount, String Owner, String Address,int year) throws IOException {
        UserActions test = new UserActions();
        test.paytax(ammount, Owner, Address,year);
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
     * @throws IOException the io exception
     */
    public void addproperty(String owners, int estvalue, String location, char PPR, String yearsowned, String eircode, String address) throws IOException {
        propertylist.add(new Property(owners, estvalue, location, PPR, yearsowned, eircode, address));
        UserActions test = new UserActions();
        test.addproperty(owners, estvalue, location, PPR, yearsowned, eircode, address);
        read();
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
     * @throws IOException the io exception
     */
    public void addpayment(String owner, String address, char status, double taxowed, String yeardue, String eircode,String balance) throws IOException {
        WriteFile write = new WriteFile();
        write.WritePayments(owner, address, status, taxowed, yeardue, eircode,balance);
        read();
    }

    /**
     * Averagetax due fora area double.
     *
     * @param eircode the eircode
     * @return the double
     * @throws IOException the io exception
     */
    public double averagetaxDueForaArea(String eircode) throws IOException{
        AdminActions test = new AdminActions();
        return test.averagetaxDueForaArea(eircode);
    }

    /**
     * Totaltax due fora area double.
     *
     * @param eircode the eircode
     * @return the double
     * @throws IOException the io exception
     */
    public double totaltaxDueForaArea(String eircode) throws IOException{
        AdminActions test = new AdminActions();
        return test.totaltaxDueForaArea(eircode);
    }

    /**
     * Percentagetax due fora area string.
     *
     * @param eircode the eircode
     * @return the string
     * @throws IOException the io exception
     */
    public String percentagetaxDueForaArea(String eircode) throws IOException{
        AdminActions test = new AdminActions();
        return test.percentagetaxDueForaArea(eircode);
    }

    // System commands

    /**
     * Read.
     *
     * @throws IOException the io exception
     */
    public void read() throws IOException {
        propertylist.clear();
        ReadFile readFile = new ReadFile();
        propertylist = readFile.ReadProperties();
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
}
