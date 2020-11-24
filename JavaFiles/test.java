//author:Calvin Power
import java.io.FileNotFoundException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws FileNotFoundException {

      Propertys test = new Propertys();
      test.addproperty("bob",268699,"City",'N',"2001-2020","VP3 35AD","37 Castlerockwoods Castleconnell limerick ireland");
      test.addproperty("charlie",268699,"City",'N',"2001-2020","VP3 35AD","35 Castlerockwoods Castleconnell limerick ireland");
      test.addproperty("charliedd",268699,"City",'N',"2001-2020","VP3 35AD","30 Castlerockwoods Castleconnell limerick ireland");
      test.addpayment("calvin","37 Castlerockwoods Castleconnell limerick ireland",'D', test.gettotaltaxforaProperty("37 Castlerockwoods Castleconnell limerick ireland"),"2017","VP3 35AD");

    }

}
