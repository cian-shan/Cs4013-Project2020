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

    public String[][] taxDueForaArea(String eircode) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.taxDueForaArea(eircode);
    }
    public void read() throws IOException {
        ReadFile readFile = new ReadFile();
        list = readFile.ReadProperties();
    }
}

