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
    public double gettotaltaxforaPropertycurrentyear(String address) throws IOException {
        UserActions test = new UserActions();
        return test.gettotaltaxforaProperty(address);
    }
    // tax data
    public ArrayList<String>  gettotaltaxdataforaOwner(String Owner) throws IOException{
        AdminActions test = new AdminActions();
        return test.gettotaltaxdataforaOwner(Owner);
    }
    //tax data
    public ArrayList<String>  gettotaltaxdataforaProperty(String Address) throws IOException{
        AdminActions test = new AdminActions();
        return test.gettotaltaxdataforaProperty(Address);
    }

    public double gettotaltaxforaownercurrentyear(String owner)throws IOException {
        UserActions test = new UserActions();
        return test.gettotaltaxforaowner(owner);
    }
   // all years tax owed
    public double[] gettotaltaxforaProperty2(String address) throws IOException {
        UserActions test = new UserActions();
        return test.gettotaltaxforaProperty2(address);
    }
    // all years tax owed
    public double[] gettotaltaxforaowner2(String owner)throws IOException  {
        UserActions test = new UserActions();
        return test.gettotaltaxforaowner2(owner);
    }
    public ArrayList<String> getPropertysForAOwner(String owner) throws IOException {
        UserActions test = new UserActions();
        return test.PropertyForAOwner(owner);
    }
    public String[][] overduetaxDueForaArea() throws IOException {
        AdminActions test = new AdminActions();
        return test.overduetaxDueForaArea();
    }
    public String[][] overduetaxDueForaArea(int year) throws IOException {
        AdminActions test = new AdminActions();
        return test.overduetaxDueForaArea(year);
    }
    public String[][] overduetaxDueForaArea(int year,String eircode) throws IOException {
        AdminActions test = new AdminActions();
        return test.overduetaxDueForaArea(year,eircode); }

    public ArrayList<String> QueryTaxDueForAYear(String user,String YearDue) throws IOException {
        UserActions test = new UserActions();
        return  test.QueryTaxDueForAYear(user,YearDue);
    }
    public ArrayList<String> TaxDueForAProperty(String Address) throws IOException {
        UserActions test = new UserActions();
        return  test.TaxDueForAProperty(Address);
    }
    public int getCurrentyear() throws IOException{
        Paymentlist test = new Paymentlist();
        return test.getCurrentyear();
    }


    public void paytax(int ammount, String Owner, String Address,int year) throws IOException {
        UserActions test = new UserActions();
        test.paytax(ammount, Owner, Address,year);
    }

    public void addproperty(String owners, int estvalue, String location, char PPR, String yearsowned, String eircode, String address) throws IOException {
        propertylist.add(new Property(owners, estvalue, location, PPR, yearsowned, eircode, address));
        UserActions test = new UserActions();
        test.addproperty(owners, estvalue, location, PPR, yearsowned, eircode, address);
        read();
    }

    public void addpayment(String owner, String address, char status, double taxowed, String yeardue, String eircode,String balance) throws IOException {
        WriteFile write = new WriteFile();
        write.WritePayments(owner, address, status, taxowed, yeardue, eircode,balance);
        read();
    }
    public double averagetaxDueForaArea(String eircode) throws IOException{
        AdminActions test = new AdminActions();
        return test.averagetaxDueForaArea(eircode);
    }
    public double totaltaxDueForaArea(String eircode) throws IOException{
        AdminActions test = new AdminActions();
        return test.totaltaxDueForaArea(eircode);
    }
    public String percentagetaxDueForaArea(String eircode) throws IOException{
        AdminActions test = new AdminActions();
        return test.percentagetaxDueForaArea(eircode);
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
