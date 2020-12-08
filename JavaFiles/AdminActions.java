//author:Calvin Power
import java.io.IOException;
import java.util.ArrayList;

public class AdminActions {
    private ArrayList<Property> list;


    public AdminActions() throws IOException { read();
    }

    public ArrayList<String> PropertyForAOwner(String owner) {
        ArrayList<String> address = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i).getOwners();
            String b = list.get(i).getAddress();
            if (a.equals(owner)) {
                address.add(b);
            }
        }
        return address;
    }

    public String[][] overduetaxDueForaArea() throws IOException {
        Paymentlist test = new Paymentlist();
        return test.overduetaxDueForaArea();
    }
    public String[][] overduetaxDueForaArea(int year) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.overduetaxDueForaArea(year);
    }
    public String[][] overduetaxDueForaArea(int year,String eircode) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.overduetaxDueForaArea(year,eircode);
    }
    public ArrayList<String>  gettotaltaxdataforaOwner(String Owner) throws IOException{
        Paymentlist test = new Paymentlist();
        return test.gettotaltaxdataforaOwner(Owner);
    }
    public ArrayList<String>  gettotaltaxdataforaProperty(String address) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.gettotaltaxdataforaProperty(address);
    }
    public double averagetaxDueForaArea(String eircode) throws IOException{
        Paymentlist test = new Paymentlist();
        return test.averagetaxDueForaArea(eircode);
    }
    public double totaltaxDueForaArea(String eircode) throws IOException{
        Paymentlist test = new Paymentlist();
        return test.totaltaxDueForaArea(eircode);
    }
    public String percentagetaxDueForaArea(String eircode) throws IOException{
        Paymentlist test = new Paymentlist();
        return test.percentagetaxDueForaArea(eircode);
    }


    public void read() throws IOException {
        ReadFile readFile = new ReadFile();
        list = readFile.ReadProperties();
    }
}

