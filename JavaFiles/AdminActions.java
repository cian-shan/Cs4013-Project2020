//author:Calvin Power
import java.util.ArrayList;

public class AdminActions {
    private ArrayList<Property> list;


    public AdminActions(ArrayList<Property> list2) {
        this.list = list2;
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

    public String[][] taxDueForaArea(String eircode) {
        Paymentlist test = new Paymentlist(list);
        return test.taxDueForaArea(eircode);
    }
}

