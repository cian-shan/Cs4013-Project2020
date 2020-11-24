//author:Calvin Power
import java.util.ArrayList;

public class Property{
    public String owners;
    public String Address;
    public String postcode;
    public int estValue;
    public String locationCategory;
    public char PPR; /* Y/N */
    public String yearsowned;
    public ArrayList<Tax> taxlist = new ArrayList<Tax>();
    int count = 0;

     /*setters*/
    public Property(String owners,int estvalue, String location,char PPR2,String yearsowned,String eircode,String address) {
        this.owners = owners;
        this.estValue = estvalue;
        this.Address = address;
        this.postcode = eircode;
        this.PPR = PPR2;
        this.locationCategory = location;

    }
    public void setAddress(String address){
       this.Address = address;
   }
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    public void setEstValue(int estValue){ this.estValue = estValue; }
    public void setLocationCategory(String locationCategory){
        this.locationCategory = locationCategory;
    }
    public void setPPR (char ppr){
       this.PPR = ppr;
    }
    /*getters*/
    public String getOwners(){
        return this.owners;
    }
    public String getAddress(){
        return this.Address;
    }
    public String getPostcode(){
        return this.postcode;
    }
    public int getEstValue(){
        return this.estValue;
    }
    public String getLocationCategory(){
        return this.locationCategory;
    }
    public char getPPR (){
        return this.PPR;
    }
    //tax
    public double getMarketValueTaxRate(){
        taxlist.add(new Tax(this.estValue,this.PPR,this.yearsowned,this.locationCategory));
        count++;
        return taxlist.get(count-1).MarketValueTax();
    }
    public int getLocationTax(){
        taxlist.add(new Tax(this.estValue,this.PPR,this.yearsowned,this.locationCategory));
        count++;
        return taxlist.get(count-1).LocationTax();
    }
    public double gettotaltax(){
        taxlist.add(new Tax(this.estValue,this.PPR,this.yearsowned,this.locationCategory));
        count++;
        return taxlist.get(count-1).Totaltax();
    }


}
