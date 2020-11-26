//author:Calvin Power
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class UserActions  {
    private ArrayList<Property> proplist;
    private Property prop;
    private ArrayList<Payment> paymentlist = new ArrayList<Payment>();

    public UserActions() throws IOException {
        readprop();
        readpayment();
    }
    public void addproperty(String owners,int estvalue, String location,char PPR,String yearsowned,String eircode,String address) throws FileNotFoundException {
        proplist.add(new Property(owners,estvalue,location,PPR,yearsowned,eircode,address));
        write(owners,estvalue,location,PPR,yearsowned,eircode,address);
    }

    public ArrayList<String> PropertyForAOwner (String owner){
        ArrayList<String> address = new ArrayList<String>();
        for(int i = 0; i < proplist.size();i++){
            String a = proplist.get(i).getOwners();
            String b = proplist.get(i).getAddress();
            if(a.equals(owner)){
                address.add(b);
            }
            }
      return address;
    }
    public double gettotaltaxforaProperty(String address){

        for(int i = 0; i < proplist.size();i++){
            String a = proplist.get(i).getAddress();
            if(a.equals(address)){
                return proplist.get(i).gettotaltax();
            }
        }
        return -1;
    }
    public void paytax(int ammount,String Owner,String Address) throws IOException {
        Paymentlist test = new Paymentlist();
        test.PayTax(ammount,Owner,Address);
    }
    public void write(String owners,int estvalue, String location,char PPR,String yearsowned,String eircode,String address) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WriteProperty(owners,estvalue,location,PPR,yearsowned,eircode,address);
    }
    public void readprop() throws IOException {
        ReadFile readFile = new ReadFile();
        proplist = readFile.ReadProperties();
    }
    public void readpayment() throws IOException {
        ReadFile readFile = new ReadFile();
        paymentlist = readFile.ReadPayment();
    }
    public ArrayList<String> QueryTaxDueForAYear(String user,String YearDue) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.QueryTaxDueForAYear(user,YearDue);
    }
}
