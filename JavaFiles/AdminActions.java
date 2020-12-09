//author:Calvin Power
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Admin actions.
 */
public class AdminActions {
    private ArrayList<Property> list;


    /**
     * Instantiates a new Admin actions.
     *
     * @throws IOException the io exception
     */
    public AdminActions() throws IOException { read();
    }

    /**
     * Property for a owner array list.
     *
     * @param owner the owner
     * @return the array list
     */
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

    /**
     * Overduetax due fora area string [ ] [ ].
     *
     * @return the string [ ] [ ]
     * @throws IOException the io exception
     */
    public String[][] overduetaxDueForaArea() throws IOException {
        Paymentlist test = new Paymentlist();
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
        Paymentlist test = new Paymentlist();
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
        Paymentlist test = new Paymentlist();
        return test.overduetaxDueForaArea(year,eircode);
    }

    /**
     * Gets owner.
     *
     * @param Owner the owner
     * @return the owner
     * @throws IOException the io exception
     */
    public ArrayList<String>  gettotaltaxdataforaOwner(String Owner) throws IOException{
        Paymentlist test = new Paymentlist();
        return test.gettotaltaxdataforaOwner(Owner);
    }

    /**
     * Gets property.
     *
     * @param address the address
     * @return the property
     * @throws IOException the io exception
     */
    public ArrayList<String>  gettotaltaxdataforaProperty(String address) throws IOException {
        Paymentlist test = new Paymentlist();
        return test.gettotaltaxdataforaProperty(address);
    }

    /**
     * Averagetax due fora area double.
     *
     * @param eircode the eircode
     * @return the double
     * @throws IOException the io exception
     */
    public double averagetaxDueForaArea(String eircode) throws IOException{
        Paymentlist test = new Paymentlist();
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
        Paymentlist test = new Paymentlist();
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
        Paymentlist test = new Paymentlist();
        return test.percentagetaxDueForaArea(eircode);
    }


    /**
     * Read.
     *
     * @throws IOException the io exception
     */
    public void read() throws IOException {
        ReadFile readFile = new ReadFile();
        list = readFile.ReadProperties();
    }
}

