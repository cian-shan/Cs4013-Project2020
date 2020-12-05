//author:Calvin Power
import java.io.IOException;
import java.util.ArrayList;
public class Tax {
    String[] locations = {"City", "Large town", "Small town", "Village"};
    int[] rates = {100,80,60,50,25};
    double totaltax;
    int estValue;
    char PPR;
    int regDate;
    String location;
    String yearOwned;

    public Tax(int estvalue,char PPR,String yearsowned,String location) {
        this.estValue=estvalue;
        this.PPR = PPR;
       this.regDate = regDate;
    }

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

