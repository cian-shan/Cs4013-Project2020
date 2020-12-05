// Author:Jack Boland
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFile {

    public ArrayList<Property> ReadProperties() throws IOException {

        ArrayList<Property> propertylist = new ArrayList<Property>();
        Scanner scan = new Scanner(new File("Property.csv"));
        String[] property = new String[10];
        while(scan.hasNext())
        {

            property = scan.nextLine().split(",");
            if (property[0].equals("Owner(s)")) {
                continue;
            }
            else {
                propertylist.add(new Property(property[0],Integer.parseInt(property[1]),property[2],property[3].charAt(0),property[4],property[5],property[6]));
            }

        }
        return propertylist;
    }

    public ArrayList<Payment> ReadPayment() throws IOException {

        ArrayList<Payment> paymentlist = new ArrayList<Payment>();
        Scanner scan = new Scanner(new File("Payments.csv"));
        String[] payment = new String[2];
        while(scan.hasNext())
        {

            payment = scan.nextLine().split(",");
            if (payment[0].equals("Owner(s)")) {
                continue;
            }
            else {
                paymentlist.add(new Payment(payment[0],payment[1],payment[2].charAt(0),Double.parseDouble(payment[3]),payment[4],payment[5],payment[6]));
            }

        }
        return paymentlist;
    }

}
