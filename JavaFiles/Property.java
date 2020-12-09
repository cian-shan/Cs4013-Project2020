//author:Calvin Power
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Property.
 */
public class Property{
    /**
     * The Owners.
     */
    public String owners;
    /**
     * The Address.
     */
    public String Address;
    /**
     * The Postcode.
     */
    public String postcode;
    /**
     * The Est value.
     */
    public int estValue;
    /**
     * The Location category.
     */
    public String locationCategory;
    /**
     * The Ppr.
     */
    public char PPR; /* Y/N */
    /**
     * The Yearsowned.
     */
    public String yearsowned;
    /**
     * The Taxlist.
     */
    public ArrayList<Tax> taxlist = new ArrayList<Tax>();
    /**
     * The Count.
     */
    int count = 0;

    /**
     * Instantiates a new Property.
     *
     * @param owners     the owners
     * @param estvalue   the estvalue
     * @param location   the location
     * @param PPR2       the ppr 2
     * @param yearsowned the yearsowned
     * @param eircode    the eircode
     * @param address    the address
     */
    /*setters*/
    public Property(String owners,int estvalue, String location,char PPR2,String yearsowned,String eircode,String address) {
        this.owners = owners;
        this.estValue = estvalue;
        this.Address = address;
        this.postcode = eircode;
        this.PPR = PPR2;
        this.locationCategory = location;
    }

    /**
     * Set address.
     *
     * @param address the address
     */
    public void setAddress(String address){
       this.Address = address;
   }

    /**
     * Set postcode.
     *
     * @param postcode the postcode
     */
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }

    /**
     * Set est value.
     *
     * @param estValue the est value
     */
    public void setEstValue(int estValue){ this.estValue = estValue; }

    /**
     * Set location category.
     *
     * @param locationCategory the location category
     */
    public void setLocationCategory(String locationCategory){
        this.locationCategory = locationCategory;
    }

    /**
     * Set ppr.
     *
     * @param ppr the ppr
     */
    public void setPPR (char ppr){
       this.PPR = ppr;
    }

    /**
     * Get owners string.
     *
     * @return the string
     */
    /*getters*/
    public String getOwners(){
        return this.owners;
    }

    /**
     * Get address string.
     *
     * @return the string
     */
    public String getAddress(){
        return this.Address;
    }

    /**
     * Get postcode string.
     *
     * @return the string
     */
    public String getPostcode(){
        return this.postcode;
    }

    /**
     * Get est value int.
     *
     * @return the int
     */
    public int getEstValue(){
        return this.estValue;
    }

    /**
     * Get location category string.
     *
     * @return the string
     */
    public String getLocationCategory(){
        return this.locationCategory;
    }

    /**
     * Get ppr char.
     *
     * @return the char
     */
    public char getPPR (){
        return this.PPR;
    }

    /**
     * Get market value tax rate double.
     *
     * @return the double
     */
//tax
    public double getMarketValueTaxRate(){
        taxlist.add(new Tax(this.estValue,this.PPR,this.yearsowned,this.locationCategory));
        count++;
        return taxlist.get(count-1).MarketValueTax();
    }

    /**
     * Get location tax int.
     *
     * @return the int
     */
    public int getLocationTax(){
        taxlist.add(new Tax(this.estValue,this.PPR,this.yearsowned,this.locationCategory));
        count++;
        return taxlist.get(count-1).LocationTax();
    }

    /**
     * Gets .
     *
     * @return the
     * @throws IOException the io exception
     */
    public double gettotaltax() throws IOException {
        taxlist.add(new Tax(this.estValue,this.PPR,this.yearsowned,this.locationCategory));
        count++;
        return taxlist.get(count-1).Totaltax();
    }


}
