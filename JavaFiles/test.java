//author:Calvin Power

import java.io.IOException;
import java.util.Arrays;

/**
 * The type Test.
 */
public class test {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

      Properties test = new Properties();
      System.out.println(Arrays.deepToString(test.QueryTaxDueForAYear("calvin","2017").toArray()));
      System.out.println(Arrays.deepToString(test.TaxDueForAProperty("37 Castlerockwoods Castleconnell limerick ireland").toArray()));
      System.out.println(Arrays.deepToString(test.getPropertysForAOwner("bob").toArray()));

        System.out.println(test.getCurrentyear());
        System.out.println(Arrays.deepToString(test.gettotaltaxdataforaOwner("calvin").toArray()));
        System.out.println(Arrays.deepToString(test.gettotaltaxdataforaProperty("37 Castlerockwoods Castleconnell limerick ireland").toArray()));
    }

}
