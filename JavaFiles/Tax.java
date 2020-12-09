//author:Calvin Power

import java.io.IOException;

/**
 * The type Tax.
 */
public class Tax {
    /**
     * The Locations.
     */
    String[] locations = {"City", "Large town", "Small town", "Village"};
    /**
     * The Rates.
     */
    int[] rates = {100,80,60,50,25};
    /**
     * The Totaltax.
     */
    double totaltax;
    /**
     * The Est value.
     */
    int estValue;
    /**
     * The Ppr.
     */
    char PPR;
    /**
     * The Reg date.
     */
    int regDate;
    /**
     * The Location.
     */
    String location;
    /**
     * The Year owned.
     */
    String yearOwned;

    /**
     * Instantiates a new Tax.
     *
     * @param estvalue   the estvalue
     * @param PPR        the ppr
     * @param yearsowned the yearsowned
     * @param location   the location
     */
    public Tax(int estvalue,char PPR,String yearsowned,String location) {
        this.estValue=estvalue;
        this.PPR = PPR;
       this.regDate = regDate;
    }

    /**
     * Market value tax double.
     *
     * @return the double
     */
    public double MarketValueTax() {
        double taxrate;
        if (estValue < 150000 ){
                taxrate = 0;
                 }
        else if (estValue >= 150000 && estValue <= 400000) {
            taxrate = 0.01;
        }
        else if (estValue <= 400001 && estValue <= 650000) {
            taxrate = 0.02;
        }
        else { taxrate = 0.04; }
        return taxrate;
    }

    /**
     * Location tax int.
     *
     * @return the int
     */
    public int LocationTax(){
    int charge = 0;
    for(int i = 0; i < locations.length; i++){
        if(locations[i].equals(location)) {
            charge = rates[i];
            break;
        }
    }
       return charge;
    }

    /**
     * Totaltax double.
     *
     * @return the double
     * @throws IOException the io exception
     */
    public double Totaltax() throws IOException {
        int yO = Integer.parseInt(yearOwned);
        Paymentlist test = new Paymentlist();
        this.totaltax = LocationTax();
        totaltax = (totaltax + ((estValue/100)*MarketValueTax()));
        if (PPR == 'N'){
            totaltax = totaltax + 100;
        }
        totaltax = totaltax + 100;
        if (test.getCurrentyear()!= yO ){
            int difference = test.getCurrentyear() - yO;
            for (int i = 0; i < difference; i++){
            totaltax = totaltax * 1.07;}
        }
        return totaltax;
    }


}

