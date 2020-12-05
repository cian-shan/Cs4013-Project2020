//author:Calvin Power
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {

      Properties test = new Properties();
      System.out.println(Arrays.deepToString(test.QueryTaxDueForAYear("calvin","2017").toArray()));
      System.out.println(Arrays.deepToString(test.TaxDueForAProperty("37 Castlerockwoods Castleconnell limerick ireland").toArray()));
      System.out.println(Arrays.deepToString(test.taxDueForaArea("VP3 35AD")));
      System.out.println(Arrays.deepToString(test.getPropertysForAOwner("bob").toArray()));

        System.out.println(test.getCurrentyear());
        System.out.println(Arrays.deepToString(test.gettotaltaxdataforaOwner("calvin").toArray()));
        System.out.println(Arrays.deepToString(test.gettotaltaxdataforaProperty("37 Castlerockwoods Castleconnell limerick ireland").toArray()));
    }

}
