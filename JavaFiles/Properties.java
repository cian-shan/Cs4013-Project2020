//author:Calvin Power

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*Program runs from year updating with each method to make sure the other classes have the updated infomation */
public class Properties {
    private ArrayList<Property> propertylist = new ArrayList<Property>();
    private Property prop;

    public Properties() throws IOException {
        read();// read then make propertylist = info
    }

    //User and Admins Options
    public double gettotaltaxforaProperty(String address) throws IOException {
        UserActions test = new UserActions();
        return test.gettotaltaxforaProperty(address);
    }

    public double gettotaltaxforaowner(String owner) {
        return 00;
    }

    public ArrayList<String> getPropertysForAOwner(String owner) throws IOException {
        UserActions test = new UserActions();
        return test.PropertyForAOwner(owner);
    }

    public String[][] taxDueForaArea(String eircode) throws IOException {
        AdminActions test = new AdminActions();
        return test.taxDueForaArea(eircode);
    }

    public void paytax(int ammount, String Owner, String Address) throws IOException {
        UserActions test = new UserActions();
        test.paytax(ammount, Owner, Address);
    }

    public void addproperty(String owners, int estvalue, String location, char PPR, String yearsowned, String eircode, String address) throws IOException {
        propertylist.add(new Property(owners, estvalue, location, PPR, yearsowned, eircode, address));
        UserActions test = new UserActions();
        test.addproperty(owners, estvalue, location, PPR, yearsowned, eircode, address);
    }

    public void addpayment(String owner, String address, char status, double taxowed, String yeardue, String eircode) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WritePayments(owner, address, status, taxowed, yeardue, eircode);
    }

    public ArrayList<String> QueryTaxDueForAYear(String user,String YearDue) throws IOException {
        UserActions test = new UserActions();
        return  test.QueryTaxDueForAYear(user,YearDue);
    }



    // System commands

    public void read() throws IOException {
        propertylist.clear();
        ReadFile readFile = new ReadFile();
        propertylist = readFile.ReadProperties();
    }

    public void write(String owners, int estvalue, String location, char PPR, String yearsowned, String eircode, String address) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WriteProperty(owners, estvalue, location, PPR, yearsowned, eircode, address);
    }
}
