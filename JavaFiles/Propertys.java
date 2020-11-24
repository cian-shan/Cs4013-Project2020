//author:Calvin Power
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/*Program runs from year updating with each method to make sure the other classes have the updated infomation */
public class Propertys {
    private ArrayList<Property> propertylist = new ArrayList<Property>();
    private Property prop;

    public Propertys() throws FileNotFoundException {
        read();// read then make propertylist = info
    }
  //User and Admins Options
        public double gettotaltaxforaProperty(String address){
            UserActions test = new UserActions(propertylist);
            return test.gettotaltaxforaProperty(address);
  }
        public double gettotaltaxforaowner(String owner){ return 00; }

        public ArrayList<String> getPropertysForAOwner (String owner){
        refresh();
        UserActions test = new UserActions(propertylist);
        return test.PropertyForAOwner(owner); }

        public String[][] taxDueForaArea (String eircode){
        refresh();
        AdminActions test = new AdminActions(propertylist);
        return test.taxDueForaArea(eircode); }

        public void paytax(int ammount,String Owner,String Address){
        refresh();
        UserActions test = new UserActions(propertylist);
        test.paytax(ammount,Owner,Address); }

        public void addproperty(String owners,int estvalue, String location,char PPR,String yearsowned,String eircode,String address) throws FileNotFoundException {
        propertylist.add(new Property(owners,estvalue,location,PPR,yearsowned,eircode,address));
        UserActions test = new UserActions(propertylist);
        test.addproperty(owners,estvalue,location,PPR,yearsowned,eircode,address); }

        public void addpayment(String owner,String address,char status,double taxowed,String yeardue,String eircode) throws FileNotFoundException {
        Paymentlist test = new Paymentlist(propertylist);
        WriteFile write = new WriteFile();
        write.WritePayments(owner,address,status,taxowed,yeardue,eircode); }

        // System commands
   public void read(){

   }
   public void write(String owners,int estvalue, String location,char PPR,String yearsowned,String eircode,String address) throws FileNotFoundException {
        WriteFile write = new WriteFile();
        write.WriteProperty(owners,estvalue,location,PPR,yearsowned,eircode,address);
    }
   public void refresh(){

    }

}
